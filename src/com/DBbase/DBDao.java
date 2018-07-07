package com.DBbase;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import com.sun.crypto.provider.RC2Cipher;
//
public class DBDao {
	private static String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/test";
	private String user = "root";
	private String pwd="zhukuang081105";
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void getConnection(){
		try {
			conn= DriverManager.getConnection(url,user,pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet ExecuteQuery(String sql,Object[] obs) {
		rs = null;
		getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			if(obs!=null&&obs.length>0){
				for(int i=0;i<obs.length;i++){
					pstmt.setObject(i+1, obs[i]);
				}
			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public int ExecuteUpdate(String sql,Object[] obs){
		int row=0;
		getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			if(obs!=null&&obs.length>0){
				for(int i=0;i<obs.length;i++){
					pstmt.setObject(i+1, obs[i]);
				}
			}
			row= pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}
	
	private void free(){
		try {
			if(rs != null) {
			    rs.close();
			    rs = null;
		    }
			if(pstmt != null) {
			    pstmt.close();
			    pstmt = null;
		    }
			if(conn != null) {
			    conn.close();
			    conn = null;
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


