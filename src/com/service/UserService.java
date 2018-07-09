package com.service;

import com.entity.User;

public interface UserService {
	public void sendEmail(String myEmail, String myPassword, String receiveMail, String letter) throws Exception;
	public boolean SdoDelete(int id);
	public boolean SdoLogin(User u);
	public boolean SdoRegister(User u);
	public boolean ShaveRegister(String email);
	public boolean SResetUser(User u);
	public User SgetUser(int i);
}
