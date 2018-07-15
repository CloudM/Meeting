//Dylan,2018.7.9,first build
//Dylan,2018.7.10,alter function 

package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.Dao.CardDao;
import com.Dao.CardDaoImpl;
import com.entity.Card;
import com.entity.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class CardServiceImpl implements CardService {
	CardDao card = new CardDaoImpl();
	
	public Boolean C_AddCard(Card c,User u){
		if(card.AddCard(c,u)>0) {return true;}
		else {return false;}
	}
	
	public Boolean C_DeleteCard(Card c,User u){
		if(card.DeleteCard(c,u)>0) {return true;}
		else {return false;}
	}
	
	public Boolean C_UpdateCard(Card c,User u){
		if(card.UpdateCard(c,u)>0) {return true;}
		else {return false;}
	}
	
	public Card C_FindSelfCard(User u) {
		Card C = new Card();
		ResultSet rs = card.FindSelfCard(u);
		if(rs!=null) {
			try {
				while(rs.next()) {
				C.setC_id(rs.getInt(1));
				C.setC_username(rs.getString(2));
				C.setC_mail(rs.getString(3));
				C.setC_phone(rs.getString(4));
				C.setC_picture(rs.getString(5));
				C.setC_age(rs.getString(6));
				C.setC_sex(rs.getString(7));
				C.setC_introduction(rs.getString(8));
				C.setC_position(rs.getString(9));
				C.setC_company(rs.getString(10));
				C.setC_hobby(rs.getString(11));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return C;
	}
	
	public JSONArray C_FindOtherCard(User u,JSONObject card_json) {
		JSONArray cardlist_json = new JSONArray();
		
		ResultSet rs = card.FindOtherCard(u);
		if(rs!=null) {
			try {
				while(rs.next()) {
					card_json.put("cardid",rs.getInt(1));
					card_json.put("username",rs.getString(2));
					card_json.put("email",rs.getString(3));
					card_json.put("phone",rs.getString(4));
					card_json.put("userpicture",rs.getString(5));
					card_json.put("age",rs.getString(6));
					card_json.put("sex",rs.getString(7));
					card_json.put("introduction",rs.getString(8));
					card_json.put("position",rs.getString(9));
					card_json.put("company",rs.getString(10));
					card_json.put("hobby",rs.getString(11));
					cardlist_json.add(card_json);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cardlist_json;
	}
	
	public Card C_SearchCard(Card c) {
		Card C = new Card();
		if(card.SearchCard(c)!=null) {
			try {
				C.setC_id(card.SearchCard(c).getInt(1));
				C.setC_mail(card.SearchCard(c).getString(2));
				C.setC_phone(card.SearchCard(c).getString(3));
				C.setC_picture(card.SearchCard(c).getString(4));
				C.setC_age(card.SearchCard(c).getString(5));
				C.setC_sex(card.SearchCard(c).getString(6));
				C.setC_introduction(card.SearchCard(c).getString(7));
				C.setC_position(card.SearchCard(c).getString(9));
				C.setC_company(card.SearchCard(c).getString(10));
				C.setC_hobby(card.SearchCard(c).getString(11));
				return C;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return C;
	}
	
	public Boolean C_CollectCard(Card c,User u) {
		if(card.CollectCard(c,u)>0){return true;}
		else {return false;}
	}
	
	public Boolean C_CancleCollectCard(Card c,User u) {
		if(card.CancleCollectCard(c,u)>0) {return true;}
		else {return false;}
	}
}
