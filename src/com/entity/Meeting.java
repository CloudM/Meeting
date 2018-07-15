//2018/7/4KarenZhu

package com.entity;

//Declarations of variables needed in the conference class
public class Meeting {
private int mid;
private String Mname;
private int Userid;
private String Host;
private String StartTime;
private String EndTime;
private String Place;
private int Typeid;
private String Guest;
private String Describe;
private String Remarks;
private String SetTime;
private int MeetingStatus;

//write set() and get() functions for all variables
public int getMid() {
	return mid;
}
public void setMid(int Mid) {
	this.mid=Mid;
}
public String getMname() {
	return Mname;
}
public void setMname(String Mname) {
	this.Mname=Mname;
}
public int getUserid() {
	return Userid;
}
public void setUserid(int Userid) {
	this.Userid=Userid;
}
public String getStartTime() {
	return StartTime;
}
public void setStartTime(String StartTime) {
	this. StartTime=StartTime;
}
public String getEndTime() {
	return EndTime;
}
public void setEndTime(String EndTime) {
	this.EndTime=EndTime;
}
public String getPlace() {
	return Place;
}
public void setPlace(String Place) {
	this.Place=Place;
}
public int getTypeid() {
	return Typeid;
}
public void setTypeid(int Typeid) {
	this.Typeid=Typeid;
}
public String getGuest() {
	return Guest;
}
public void setGuest(String Guest) {
	this.Guest=Guest;
}
public String getDescribe() {
	return Describe;
}
public void setDescribe(String Describe) {
	this.Describe=Describe;
}
public String getRemarks() {
	return Remarks;
}
public void setRemarks(String Remarks) {
	this.Remarks=Remarks;
}
public String getSetTime() {
	return SetTime;
}
public void setSetTime(String SetTime) {
	this.SetTime=SetTime;
}
public String getHost() {
	return Host;
}
public void setHost(String Host) {
	this.Host=Host;
}
public int getMeetingStatus() {
	return MeetingStatus;
}
public void setMeetingStatus(int MeetingStatus) {
	this.MeetingStatus=MeetingStatus;
}

}
