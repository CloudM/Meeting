package com.UserDao;

import com.entity.Apply;

import java.sql.ResultSet;

public interface ApplyDao {
	//Ìí¼ÓÉêÇë
	public int AddApply(Apply apply);
	
	//ÊÇ·ñÉêÇë
	public ResultSet IsApply(Apply apply);
	
	//ÉèÖÃÉêÇë×´Ì¬
	public int SetApplyState(Apply apply);
}
