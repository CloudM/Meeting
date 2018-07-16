package com.DBbase;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBDao {
	private static String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/meetings";
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
	
	public int Card_Transaction(String sql_1,Object[] obs_1,String sql_2,Object[] obs_2) {
		int row_1=0;
		int row_2=0;
		String id = null;
		getConnection();
		PreparedStatement pstmt_1 = null;
		PreparedStatement pstmt_2 = null;
		PreparedStatement pstmt_3 = null;
		try {
			//Manual submit transaction 
			conn.setAutoCommit(false);
			pstmt_1 = conn.prepareStatement(sql_1);
			pstmt_2 = conn.prepareStatement(sql_2);
			pstmt_3 = conn.prepareStatement("SELECT @@IDENTITY");
			
			//add object to sql_1 
			if(obs_1!=null&&obs_1.length>0){
				for(int i=0;i<obs_1.length;i++){
					pstmt_1.setObject(i+1, obs_1[i]);
				}
			}
			
			//add object to sql_2
			if(obs_2!=null&&obs_2.length>0){
				for(int i=0;i<obs_2.length;i++){
					pstmt_2.setObject(i+1, obs_2[i]);
				}
			}
			
			row_1= pstmt_1.executeUpdate();
			
			//get foreign key table ID
			ResultSet rs= pstmt_3.executeQuery();
			while(rs.next()) {id = rs.getString(1);}
			pstmt_2.setObject(2,id);
			
			row_2= pstmt_2.executeUpdate();
			
			conn.commit();//commit transaction
		} catch (Exception e) {
			try {
				conn.rollback();
				}catch (Exception a) {
				System.out.println("回滚失败");
			}
			e.printStackTrace();
		}
		return (row_1 * row_2);
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


