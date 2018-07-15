//Dylan,2018.7.9,first build
//Dylan,2018.7.10,add method "CollectCard"

package com.Dao;

import java.sql.ResultSet;

import com.entity.Card;
import com.entity.User;


public interface CardDao {
	public int AddCard(Card c,User u);//create card
	public int DeleteCard(Card c,User u);//delete card 
	public int UpdateCard(Card c,User u);//alter card
	public ResultSet FindSelfCard(User u);//query your card
	public ResultSet FindOtherCard(User u);//query collected card
	public ResultSet SearchCard(Card c);//search other card
	public int CollectCard(Card c,User u);//collect card
	public int CancleCollectCard(Card c,User u);//not collect card 
}
