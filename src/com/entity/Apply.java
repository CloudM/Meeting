package com.entity;

public class Apply {
	private int ApplyFormID;
	private int MeetingID;
	private int UserID;
	private String Note;
	private String ApplyTime;
	private String CheckTime;
	//1�������ύ��δ����2����ͨ����3����δͨ��,4��ʾ��ȡ��,meiyou4
	private int ApplyState;
	public int getApplyFormID() {
		return ApplyFormID;
	}
	public void setApplyFormID(int applyFormID) {
		ApplyFormID = applyFormID;
	}
	public int getMeetingID() {
		return MeetingID;
	}
	public void setMeetingID(int meetingID) {
		MeetingID = meetingID;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public String getNote() {
		return Note;
	}
	public void setNote(String note) {
		Note = note;
	}
	public int getApplyState() {
		return ApplyState;
	}
	public void setApplyState(int applyState) {
		ApplyState = applyState;
	}
	
	public String getApplyTime() {
		return ApplyTime;
	}
	public void setApplyTime(String ApplyTime) {
		Note = ApplyTime;
	}
	public String getCheckTime() {
		return CheckTime;
	}
	public void setCheckTime(String CheckTime) {
		Note = CheckTime;
	}
}
