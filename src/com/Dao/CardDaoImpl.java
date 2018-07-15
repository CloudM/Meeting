//Dylan,2018.7.9,first build,add function "AddCard""DeleteCard""UpdateCard"
//Dylan,2018.7.10,alter function "AddCard""UpdateCard"
//Dylan,2018.7.11,add function "FindSelfCard""FindOtherCard""SearchCard""CollectCard""CancleCollectCard"

package com.Dao;

import java.sql.ResultSet;
import com.DBbase.DBDao;
import com.entity.Card;
import com.entity.User;


public class CardDaoImpl extends DBDao implements CardDao {
	//add card,insert into table Card and UserCard in the meantime
	public int AddCard(Card c,User u){
		String sql_1 = "insert into card value(?,?,?,?,?,?,?,?,?,?,?)";
		String sql_2 = "insert into UserCard value(?,?,3)";
		Object[] obs_1 = {c.getC_id(),c.getC_username(),c.getC_mail(),
						c.getC_phone(),c.getC_picture(),c.getC_age(),
						c.getC_sex(),c.getC_introduction(),c.getC_position(),
						c.getC_company(),c.getC_hobby()};
		Object[] obs_2 = {u.getUid()};
		return Card_Transaction(sql_1, obs_1,sql_2,obs_2);
	}
	
	//delete card,delete table Card by CardID
	public int DeleteCard(Card c,User u) {
		String sql = "delete from usercard where UserID = ? and CardStateID = 3";
		Object[] obs = {u.getUid()};
		return ExecuteUpdate(sql, obs);
	}
	
	//update card,update table Card by table UserCard
	public int UpdateCard(Card c,User u) {
		String sql = "update Card set UserName=?,Email=?,Phone=?,"
									+ "UserPicture=?,Age=?,Sex=?,Introduction=?,"
									+ "Position=?,Company=?,Hobby=? "
									+ "where CardID = (select CardID from UserCard where userid = ? and CardStateID = 3)";
		Object[] obs = {c.getC_username(),c.getC_mail(),
				c.getC_phone(),c.getC_picture(),c.getC_age(),
				c.getC_sex(),c.getC_introduction(),c.getC_position(),
				c.getC_company(),c.getC_hobby(),u.getUid()};
		return ExecuteUpdate(sql, obs); 
	}
	
	//query your card by table UserCard
	public ResultSet FindSelfCard(User u){
		String sql = "select * from Card where CardID = (select CardID from UserCard where userid = ? and CardStateID = 3)";
		//String sql = "select * from Card where CardID =?";
		Object[]  obs = {u.getUid()};
		return ExecuteQuery(sql,obs);
		}
	
	//query collected card,select from table Card by table UserCard 
	public ResultSet FindOtherCard(User u) {
		String sql = "select * from Card where CardID in (select CardID from UserCard where userid = ? and CardStateID = 2)";
		Object[] obs = {u.getUid()};
		return ExecuteQuery(sql, obs);
	}
	
	//search card,search table Card by "UserName" or "company"
	public ResultSet SearchCard(Card c) {
		String sql = "select * from Card where username like ? or company like ? ";
		Object[] obs = {1};
		return ExecuteQuery(sql, obs);
	}
	
	//collect other card,insert into UserCard
	public int CollectCard(Card c,User u){
		String sql = "insert into UserCard value(?,?,2)";
		Object[] obs = {u.getUid(),c.getC_id()};
		return ExecuteUpdate(sql, obs);  
	}
	
	public int CancleCollectCard(Card c,User u) {
		String sql = "update UserCard set CardStateID = 1 where UserID = ? and CardID = ? and CardStateID = 2";
		Object[] obs = {u.getUid(),c.getC_id()};
		return ExecuteUpdate(sql, obs);  
	}
}
