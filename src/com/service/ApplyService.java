package com.service;

import com.entity.Apply;

public interface ApplyService {
	public boolean ShandleApply(Apply apply);
	public boolean SAddApply(Apply apply);
	public Apply SIsApply(int uid,int mid);
	public boolean SSetApplyState(Apply apply);
	public boolean SSetApplyState(int state,int mid,int uid);
	public boolean SDeleteApply(int mid,int uid);
}