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
}
