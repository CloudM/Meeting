//Karenzhu
package com.UserDao;
import java.sql.ResultSet;

import com.entity.Meeting;
public interface MeetingDao {
//add meeting	
public int AddMeeting(Meeting m);
//delete meeting
public int DeleteMeeting(Meeting m);
//search meeting with mid
public ResultSet FindMeeting(Meeting m);
//change the status of meeting
public int ReleaseMeeting(Meeting m);
//change the information of meeting
public int UpdateMeeting(Meeting m);
}
