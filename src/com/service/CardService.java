//Dylan,2018.7.9,first build
//Dylan,2018.7.10,alter function 
//Dylan,2018.7.11,add function "C_CollectCard""CancleCollectCard"

package com.service;

import java.util.List;

import com.entity.Card;
import com.entity.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface CardService {
	public Boolean C_AddCard(Card c,User u);
	public Boolean C_DeleteCard(Card c,User u);
	public Boolean C_UpdateCard(Card c,User u);
	public Card C_FindSelfCard(User u);
	public JSONArray C_FindOtherCard(User u,JSONObject card_json);
	public Card C_SearchCard(Card c);
	public Boolean C_CollectCard(Card c,User u);
	public Boolean C_CancleCollectCard(Card c,User u);

}
