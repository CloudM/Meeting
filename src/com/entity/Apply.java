package com.entity;

public class Apply {
	private int ApplyFormID = 0;
	private int MeetingID = 0;
	private int UserID = 0;
	private String Note = null;
	//1�������ύ��δ����2����ͨ����3����δͨ��,4��ʾ��ȡ��
	private int ApplyState = 1;
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
}
