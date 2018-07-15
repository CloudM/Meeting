package com.Dao;

import com.entity.Apply;

import java.sql.ResultSet;

public interface ApplyDao {
	//�������
	public int AddApply(Apply apply);
	
	//�Ƿ�����
	public ResultSet IsApply(Apply apply);
	
	//��������״̬
	public int SetApplyState(Apply apply);
}
