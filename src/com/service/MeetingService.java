//Karenzhu
package com.service;

import com.entity.Meeting;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
public interface MeetingService {
	public boolean SAddMeeting(Meeting m);
	public boolean SDeleteMeeting(Meeting m);
	public Meeting SFindMeeting(int mid);
	public boolean SUpdateMeeting(Meeting m);
	public boolean SReleaseMeeting(Meeting m);
	public JSONArray ShasReleasedMeeting(int userid,int status1,int status2);
}
