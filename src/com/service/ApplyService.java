package com.service;

import com.entity.Apply;

import net.sf.json.JSONArray;

public interface ApplyService {
	public boolean ShandleApply(Apply apply);
	public boolean SAddApply(Apply apply);
	public Apply SIsApply(int uid,int mid);
	public boolean SSetApplyState(Apply apply);
	public boolean SSetApplyState(int state,int mid,int uid);
	public boolean SDeleteApply(int mid,int uid);
	public boolean SUpdateApply(int uid,int mid);
	public JSONArray SsearchApply(int mid);
	public int SCountApply(int mid,int status);
}