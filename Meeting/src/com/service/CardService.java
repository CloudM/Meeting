//Dylan,2018.7.9,first build
//Dylan,2018.7.10,alter function 
//Dylan,2018.7.11,add function "C_CollectCard""CancleCollectCard"

package com.service;

import com.entity.Card;
import com.entity.User;

public interface CardService {
	public Boolean C_AddCard(Card c,User u);
	public Boolean C_DeleteCard(Card c,User u);
	public Boolean C_UpdateCard(Card c,User u);
	public Card C_FindSelfCard(User u);
	public Card C_FindOtherCard(User u);
	public Card C_SearchCard(Card c);
	public Boolean C_CollectCard(Card c,User u);
	public Boolean C_CancleCollectCard(Card c,User u);

}
