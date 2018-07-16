package com.service;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.Dao.UserDao;
import com.Dao.UserDaoImpl;
import com.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

public class UserServiceImpl implements UserService {
	
	UserDao dao= new UserDaoImpl();
	
    public void sendEmail(String myEmail, String myPassword, String receiveMail, String letter) throws Exception {
        String myEmailSMTPHost = "smtp.163.com";
    	String myEmailAccount = myEmail;
    	String myEmailPassword = myPassword;
    	String receiveMailAccount = receiveMail;
        // 1. ������������, ���������ʼ��������Ĳ�������
        Properties props = new Properties();                    // ��������
        props.setProperty("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // �����˵������ SMTP ��������ַ
        props.setProperty("mail.smtp.auth", "true");            // ��Ҫ������֤

        // 2. �������ô����Ự����, ���ں��ʼ�����������
        Session session = Session.getInstance(props);
        session.setDebug(true);                                 // ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log

        // 3. ����һ���ʼ�
        MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount, letter);
        
        // 4. ���� Session ��ȡ�ʼ��������
        Transport transport = session.getTransport();
        
        // 5. ʹ�� �����˺� �� ���� �����ʼ�������, ������֤����������� message �еķ���������һ��, ���򱨴�
        transport.connect(myEmailAccount, myEmailPassword);
        
        // 6. �����ʼ�, �������е��ռ���ַ, message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
        transport.sendMessage(message, message.getAllRecipients());
        
        // 7. �ر�����
        transport.close();
    }
    public void sendEmail(String myEmail, String myPassword, String receiveMail, String letter, String filePath) throws Exception {
        String myEmailSMTPHost = "smtp.163.com";
    	String myEmailAccount = myEmail;
    	String myEmailPassword = myPassword;
    	String receiveMailAccount = receiveMail;
        // 1. ������������, ���������ʼ��������Ĳ�������
        Properties props = new Properties();                    // ��������
        props.setProperty("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // �����˵������ SMTP ��������ַ
        props.setProperty("mail.smtp.auth", "true");            // ��Ҫ������֤

        // 2. �������ô����Ự����, ���ں��ʼ�����������
        Session session = Session.getInstance(props);
        session.setDebug(true);                                 // ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log

        // 3. ����һ���ʼ�����������
        MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount, letter, filePath);
        
        // 4. ���� Session ��ȡ�ʼ��������
        Transport transport = session.getTransport();
        
        // 5. ʹ�� �����˺� �� ���� �����ʼ�������, ������֤����������� message �еķ���������һ��, ���򱨴�
        transport.connect(myEmailAccount, myEmailPassword);
        
        // 6. �����ʼ�, �������е��ռ���ַ, message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
        transport.sendMessage(message, message.getAllRecipients());
        
        // 7. �ر�����
        transport.close();
    }
    private MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail, String letter) throws Exception {
        // 1. ����һ���ʼ�
        MimeMessage message = new MimeMessage(session);

        // 2. From: ������
        message.setFrom(new InternetAddress(sendMail, "CloudM", "UTF-8"));

        // 3. To: �ռ���
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "�𾴵��û�", "UTF-8"));

        // 4. Subject: �ʼ�����
        message.setSubject("��֤����Ϣ", "UTF-8");

        // 5. Content: �ʼ����ģ�����ʹ��html��ǩ��
        message.setContent(letter, "text/html;charset=UTF-8");

        // 6. ���÷���ʱ��
        message.setSentDate(new Date());

        // 7. ��������
        message.saveChanges();

        return message;
    }
    private MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail, String letter, String filePath) throws Exception {
        // 1. ����һ���ʼ�
        MimeMessage message = new MimeMessage(session);

        // 2. From: ������
        message.setFrom(new InternetAddress(sendMail, "CloudM", "UTF-8"));

        // 3. To: �ռ���
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "�𾴵��û�", "UTF-8"));

        // 4. Subject: �ʼ�����
        message.setSubject("��ά����Ϣ", "UTF-8");

        // 5. Content: �ʼ����ģ�����ʹ��html��ǩ��
        //message.setContent(letter, "text/html;charset=UTF-8");
        
        // ��multipart����������ʼ��ĸ����������ݣ������ı����ݺ͸���
        Multipart multipart = new MimeMultipart();
        // ����ʼ�����
        BodyPart contentBodyPart = new MimeBodyPart();
        // �ʼ�����
        contentBodyPart.setContent(letter, "text/html;charset=UTF-8");
        multipart.addBodyPart(contentBodyPart);
        // ��Ӹ���
        if (filePath != null && !"".equals(filePath)) {
            BodyPart attachmentBodyPart = new MimeBodyPart();
            // ���ݸ���·����ȡ�ļ�,
            FileDataSource dataSource = new FileDataSource(filePath);
            attachmentBodyPart.setDataHandler(new DataHandler(dataSource));
            //MimeUtility.encodeWord���Ա����ļ�������
            attachmentBodyPart.setFileName(MimeUtility.encodeWord(dataSource.getFile().getName()));
            multipart.addBodyPart(attachmentBodyPart);
        }
        // �ʼ����ı�����
        message.setContent(multipart);

        // 6. ���÷���ʱ��
        message.setSentDate(new Date());

        // 7. ��������
        message.saveChanges();

        return message;
    }
	
	public boolean SdoDelete(User u) {
		if(dao.doDelete(u) > 0){
			return true;
		}
		return false;
	}
	
	public boolean SdoLogin(User u) {
		boolean isSuccessful = false;
		try {
			ResultSet rs = dao.getUser(u.getUEmail());
			if(rs != null) {
				rs.next();
				if(rs.getString("Password").equals(u.getUpwd())) {
					isSuccessful = true;
				} else {
					isSuccessful = false;
				}
			} else {
				isSuccessful = false;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isSuccessful;
	}
	
	public boolean SdoRegister(User u) {
		if(dao.doRegister(u) > 0){
			return true; 
		}
		return false;
	}
	
	public boolean ShaveRegister(String email) {
		boolean isRegister = false;
		try {
			ResultSet rs = dao.getUser(email);
			if(rs == null) {
				isRegister = false;
			} else if(rs.next()) {
				isRegister = true;
			} else {
				isRegister = false;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isRegister;
	}
	
	public boolean SResetUser(User u) {
		if(dao.resetUser(u) > 0) {
			return true;
		}
		return false;
	}
	
	public User SgetUser(int uid) {
		User u = new User();
		try {
			ResultSet rs = dao.getUser(uid);
			if(rs != null) {
				while(rs.next()) {
					u.setUid(rs.getInt(1));
					u.setUname(rs.getString(2));
					u.setUpwd(rs.getString(3));
					u.setUEmail(rs.getString(4));
					u.setSecCode(rs.getInt(5));
					u.setSex(rs.getString(9));
					u.setPhotoUrl(rs.getString(10));
					u.setPhoneNumber(rs.getString(11));
					u.setJob(rs.getString(12));
					u.setCity(rs.getString(13));
					u.setHobby(rs.getString(14));
					u.setBirthday(rs.getString(15));
					u.setMotto(rs.getString(16));
				}
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public User SgetUserByEmail(String Email) {
		User u = new User();
		try {
			ResultSet rs = dao.getUser(Email);
			if(rs != null) {
				while(rs.next()) {
					u.setUid(rs.getInt(1));
					u.setUname(rs.getString(2));
					u.setUpwd(rs.getString(3));
					u.setUEmail(rs.getString(4));
					u.setSecCode(rs.getInt(5));
					u.setSex(rs.getString(9));
					u.setPhotoUrl(rs.getString(10));
					u.setPhoneNumber(rs.getString(11));
					u.setJob(rs.getString(12));
					u.setCity(rs.getString(13));
					u.setHobby(rs.getString(14));
					u.setBirthday(rs.getString(15));
					u.setMotto(rs.getString(16));
				}
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public boolean SLogin(User u) {
		if(dao.SetUserState(u, 1) > 0) {
			return true;
		}
		return false;
	}
	
	public boolean SLogout(User u) {
		if(dao.SetUserState(u, 0) > 0) {
			return true;
		}
		return false;
	}
	
	public boolean SIsSecCode(User u) {
		boolean isSuccessful = false;
		try {
			ResultSet rs = dao.getUser(u.getUEmail());
			if(rs != null) {
				rs.next();
				if(Integer.parseInt(rs.getString("Token")) == u.getSecCode()) {
					isSuccessful = true;
				} else {
					isSuccessful = false;
				}
			} else {
				isSuccessful = false;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isSuccessful;
	}
	
	public boolean SIsRegister(User u) {
		boolean isSuccessful = false;
		try {
			ResultSet rs = dao.getUser(u.getUEmail());
			if(rs != null) {
				rs.next();
				if(Integer.parseInt(rs.getString("UserState")) == 100) {
					isSuccessful = false;
				} else {
					isSuccessful = true;
				}
			} else {
				isSuccessful = false;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isSuccessful;
	}
	
	public boolean SSetRegistTime(User u) {
		if(dao.SetRegistTime(u) > 0) {
			return true;
		}
		return false;
	}
}