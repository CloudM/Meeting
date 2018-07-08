//KarenZhu
package meeting.service;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

import meeting.dao.MeetingDao;
import meeting.dao.MeetingDaoImpl;
import meeting.entity.Meeting;
public class MeetingServiceImpl implements MeetingService{
	MeetingDao dao = new MeetingDaoImpl();
//turn the result of addmeeting to boolean
	public boolean SAddMeeting(Meeting m) {
		if (dao.AddMeeting(m)>0) {
			return true;
		}
		else {
			return false;
		}
	}
//turn the result of deletemeeting to boolean
	public boolean SDeleteMeeting(Meeting m) {
	if (dao.DeleteMeeting(m)>0) {
		return true;
	}
	else {
		return false;
	}
	}
//assign the result of findmeeting to entity Meeting
	public Meeting SFindMeeting(Meeting m) {
		Meeting M=new Meeting();
		if(dao.FindMeeting(m)!=null) {
			try {
				M.setMid(dao.FindMeeting(m).getInt(1));
				M.setHostid(dao.FindMeeting(m).getInt(2));
				M.setStartTime(dao.FindMeeting(m).getString(3));
				M.setEndTime(dao.FindMeeting(m).getString(4));
				M.setPlace(dao.FindMeeting(m).getString(5));
				M.setTypeid(dao.FindMeeting(m).getInt(6));
				M.setDescribe(dao.FindMeeting(m).getString(7));
				M.setRemarks(dao.FindMeeting(m).getString(8));
				M.setFileAddress(dao.FindMeeting(m).getString(9));
				return M;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return M;
	}

}
