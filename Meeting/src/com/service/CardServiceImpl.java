//Dylan,2018.7.9,first build
//Dylan,2018.7.10,alter function 

package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.UserDao.CardDao;
import com.UserDao.CardDaoImpl;
import com.entity.Card;
import com.entity.Meeting;
import com.entity.User;

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
				C.setC_mail(rs.getString(2));
				C.setC_phone(rs.getString(3));
				C.setC_picture(rs.getString(4));
				C.setC_age(rs.getString(5));
				C.setC_sex(rs.getString(6));
				C.setC_introduction(rs.getString(7));
				C.setC_position(rs.getString(9));
				C.setC_company(rs.getString(10));
				C.setC_hobby(rs.getString(11));
				}
				return C;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return C;
	}
	
	public Card C_FindOtherCard(User u) {
		Card C = new Card();
		ResultSet rs = card.FindOtherCard(u);
		if(rs!=null) {
			try {
				
				while(rs.next()) {
				C.setC_id(rs.getInt(1));
				C.setC_mail(rs.getString(2));
				C.setC_phone(rs.getString(3));
				C.setC_picture(rs.getString(4));
				C.setC_age(rs.getString(5));
				C.setC_sex(rs.getString(6));
				C.setC_introduction(rs.getString(7));
				C.setC_position(rs.getString(9));
				C.setC_company(rs.getString(10));
				C.setC_hobby(rs.getString(11));
				}
				return C;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return C;
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
