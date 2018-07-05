//2018/7/4KarenZhu

package meeting.entity;

//Declarations of variables needed in the conference class
public class Meeting {
private int Mid;
private int Hostid;
private String StartTime;
private String EndTime;
private String Place;
private int Typeid;
private String Guest;
private String Describe;
private String Remarks;
private String FileAddress;

//write set() and get() functions for all variables
public int getMid() {
	return Mid;
}
public void setMid(int Mid) {
	this.Mid=Mid;
}
public int getHostid() {
	return Hostid;
}
public void setHostid(int Hostid) {
	this.Hostid=Hostid;
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
	return Place;
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
public String getFileAddress() {
	return FileAddress;
}
public void setFileAddress(String FileAddress) {
	this.FileAddress=FileAddress;
}

}
