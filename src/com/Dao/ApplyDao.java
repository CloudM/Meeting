package com.Dao;

import com.entity.Apply;

import java.sql.ResultSet;

public interface ApplyDao {
	//�������?
	public int AddApply(Apply apply);
	
	//�Ƿ�����
	public ResultSet IsApply(int uid,int mid);
	
	//��������״̬
	public int SetApplyState(Apply apply);
	public int SetApplyState(int state,int mid,int uid);
	public int DeleteApply(int mid,int uid);//delete apply 
	//select all applies of a meeting
	public ResultSet searchApply(int mid);
	public int UpdateApply(int uid, int mid);
	public ResultSet CountApply(int mid,int status);
}
