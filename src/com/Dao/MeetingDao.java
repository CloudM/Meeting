//Karenzhu
package com.Dao;
import java.sql.ResultSet;

import com.entity.Meeting;
public interface MeetingDao {
//add meeting	
public int AddMeeting(Meeting m);
//delete meeting
public int DeleteMeeting(Meeting m);
//search meeting with mid
public ResultSet FindMeeting(int mid);
//change the status of meeting
public int ReleaseMeeting(int mid);
//change the information of meeting
public int UpdateMeeting(Meeting m,int mid);
//find out all meetings with different status
public ResultSet hasReleasedMeeting(int userid, int status1,int status2);
//find out all meetings
public ResultSet allMeetings();
//find meeting with applyer
public ResultSet applyedMeeting(int uid,int stateid);
}
