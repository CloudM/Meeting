package com.service;

import com.entity.Apply;

public interface ApplyService {
	public boolean ShandleApply(Apply apply);
	public boolean SAddApply(Apply apply);
	public Apply SIsApply(Apply apply);
	public boolean SSetApplyState(Apply apply);
}