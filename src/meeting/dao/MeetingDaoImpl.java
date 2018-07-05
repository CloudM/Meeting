//Karenzhu

package meeting.dao;

import java.sql.ResultSet;

import meeting.comm.DBDao;

import meeting.entity.Meeting;
public class MeetingDaoImpl extends DBDao implements  MeetingDao{
	//add meeting with sql statement realization
	//return row number
    public int AddMeeting(Meeting m) {
    	String sql="insert into meetings values(null,?,?,?,?,?,)";
		 Object[] obs={m.getMid(),m.getHostid(),m.getStartTime(),m.getEndTime(),m.getPlace(),m.getTypeid(),m.getGuest(),m.getDescribe(),m.getRemarks(),m.getFileAddress()};
		return ExecuteUpdate(sql, obs);
    }
    //delete meeting according to mid with sql statement realization
    //return row number
	public int DeleteMeeting(Meeting m) {
		String sql="delete from meetings where Mid=?";
		Object[] obs = {m.getMid()};
		return ExecuteUpdate(sql, obs);
	}
	//search meeting according to mid with sql statement realization
	//return resultset
	public ResultSet FindMeeting(Meeting m){
		
		String sql="select * from meetings where Mid=?";
		Object[]  obs= {m.getMid()};
		return ExecuteQuery(sql,obs);
		
		}
	
	
}
