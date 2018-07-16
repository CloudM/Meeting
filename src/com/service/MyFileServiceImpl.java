package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Dao.MyFileDao;
import com.Dao.MyFileDaoImpl;
import com.entity.MyFile;

public class MyFileServiceImpl implements MyFileService{
	
	MyFileDao dao= new MyFileDaoImpl();

	public boolean SAddFile(MyFile mf) {
		if(dao.AddFile(mf) > 0){
			return true;
		}
		return false;
	}

	public boolean SDeleteFile(MyFile mf) {
		if(dao.DeleteFile(mf) > 0){
			return true;
		}
		return false;
	}

	public boolean SChangeFile(MyFile mf) {
		if(dao.ChangeFile(mf) > 0){
			return true;
		}
		return false;
	}

	public MyFile SGetFile(MyFile mf) {
		MyFile myFile = new MyFile();
		try {
			ResultSet rs = dao.GetFile(mf);
			if(rs != null) {
				while(rs.next()) {
					myFile.setResourceID(Integer.parseInt(rs.getString(1)));
					myFile.setMeetingID(Integer.parseInt(rs.getString(2)));
					myFile.setResourceName(rs.getString(3));
					myFile.setUserID(Integer.parseInt(rs.getString(4)));
				}
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myFile;
	}

	
	public List<String> SGetFileList1(int meetingID) {
		List<String> list = new ArrayList<String>();
		try {
			ResultSet rs = dao.GetFileList(meetingID);
			if(rs != null) {
				while(rs.next()) {
					list.add(rs.getString("ResourceName"));
				}
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<String> SGetFileList2(int meetingID) {
		List<String> list = new ArrayList<String>();
		try {
			ResultSet rs = dao.GetFileList(meetingID);
			if(rs != null) {
				while(rs.next()) {
					list.add(rs.getString("ResourceID"));
				}
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean SIsFileExist(MyFile mf) {
		boolean isExist = false;
		try {
			ResultSet rs = dao.GetFile2(mf);
			if(rs == null) {
				isExist = false;
			} else if(rs.next()) {
				isExist = true;
			} else {
				isExist = false;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isExist;
	}
}
