//Karenzhu
package meeting.dao;
import java.sql.ResultSet;

import meeting.entity.Meeting;
public interface MeetingDao {
//add meeting	
public int AddMeeting(Meeting m);
//delete meeting
public int DeleteMeeting(Meeting m);
//search meeting with mid
public ResultSet FindMeeting(Meeting m);

}
