//Karenzhu

package com.UserDao;

import java.sql.ResultSet;

import com.DBbase.DBDao;

import com.entity.Meeting;
public class MeetingDaoImpl extends DBDao implements  MeetingDao{
	//add meeting with sql statement realization
	//return row number
    public int AddMeeting(Meeting m) {
    	String sql="insert into meeting values(null,?,?,?,?,?,?,null,?,?,?,now(),?,?)";
		 Object[] obs={m.getTypeid(),m.getUserid(),m.getMeetingStatus(),m.getStartTime(),m.getEndTime(),m.getPlace(),m.getGuest(),m.getDescribe(),m.getRemarks(),m.getMname(),m.getHost()};
		return ExecuteUpdate(sql, obs);
    }
    //delete meeting according to mid with sql statement realization
    //return row number
	public int DeleteMeeting(Meeting m) {
		String sql="delete from meeting where Mid=?";
		Object[] obs = {m.getMid()};
		return ExecuteUpdate(sql, obs);
	}
	//search meeting according to mid with sql statement realization
	//return resultset
	public ResultSet FindMeeting(Meeting m){
		
		String sql="select * from meeting where Mid=?";
		Object[]  obs= {m.getMid()};
		return ExecuteQuery(sql,obs);
		
		}
	//update meeting to change the status of meeting
	//return row number
	public int ReleaseMeeting(Meeting m) {
		String sql="update meeting set MeetingStateID = ? where MeetingID=?";
		Object[] obs= {1,m.getMid()};
		return ExecuteUpdate(sql,obs);

	}
	//update meeting to change the information of meeting
    //return resultset
	public int UpdateMeeting(Meeting m) {
		String sql="update meeting set MeetingTypeID=?,StartTime=?,Place=?,MainGuest=?,MeetingIntroduction=?,Note=?,MeetingName=?,Host=?";
		Object[] obs={m.getTypeid(),m.getStartTime(),m.getPlace(),m.getGuest(),m.getDescribe(),m.getRemarks(),m.getMname(),m.getHost()};
		return ExecuteUpdate(sql, obs);
	
	}
	
	
}
