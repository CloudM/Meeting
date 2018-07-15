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
        // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();                    // 参数配置
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证

        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(props);
        session.setDebug(true);                                 // 设置为debug模式, 可以查看详细的发送 log

        // 3. 创建一封邮件
        MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount, letter);
        
        // 4. 根据 Session 获取邮件传输对象
        Transport transport = session.getTransport();
        
        // 5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
        transport.connect(myEmailAccount, myEmailPassword);
        
        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(message, message.getAllRecipients());
        
        // 7. 关闭连接
        transport.close();
    }
    public void sendEmail(String myEmail, String myPassword, String receiveMail, String letter, String filePath) throws Exception {
        String myEmailSMTPHost = "smtp.163.com";
    	String myEmailAccount = myEmail;
    	String myEmailPassword = myPassword;
    	String receiveMailAccount = receiveMail;
        // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();                    // 参数配置
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证

        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(props);
        session.setDebug(true);                                 // 设置为debug模式, 可以查看详细的发送 log

        // 3. 创建一封邮件（带附件）
        MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount, letter, filePath);
        
        // 4. 根据 Session 获取邮件传输对象
        Transport transport = session.getTransport();
        
        // 5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
        transport.connect(myEmailAccount, myEmailPassword);
        
        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(message, message.getAllRecipients());
        
        // 7. 关闭连接
        transport.close();
    }
    private MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail, String letter) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人
        message.setFrom(new InternetAddress(sendMail, "CloudM", "UTF-8"));

        // 3. To: 收件人
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "尊敬的用户", "UTF-8"));

        // 4. Subject: 邮件主题
        message.setSubject("验证码信息", "UTF-8");

        // 5. Content: 邮件正文（可以使用html标签）
        message.setContent(letter, "text/html;charset=UTF-8");

        // 6. 设置发件时间
        message.setSentDate(new Date());

        // 7. 保存设置
        message.saveChanges();

        return message;
    }
    private MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail, String letter, String filePath) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人
        message.setFrom(new InternetAddress(sendMail, "CloudM", "UTF-8"));

        // 3. To: 收件人
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "尊敬的用户", "UTF-8"));

        // 4. Subject: 邮件主题
        message.setSubject("二维码信息", "UTF-8");

        // 5. Content: 邮件正文（可以使用html标签）
        //message.setContent(letter, "text/html;charset=UTF-8");
        
        // 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
        Multipart multipart = new MimeMultipart();
        // 添加邮件正文
        BodyPart contentBodyPart = new MimeBodyPart();
        // 邮件内容
        contentBodyPart.setContent(letter, "text/html;charset=UTF-8");
        multipart.addBodyPart(contentBodyPart);
        // 添加附件
        if (filePath != null && !"".equals(filePath)) {
            BodyPart attachmentBodyPart = new MimeBodyPart();
            // 根据附件路径获取文件,
            FileDataSource dataSource = new FileDataSource(filePath);
            attachmentBodyPart.setDataHandler(new DataHandler(dataSource));
            //MimeUtility.encodeWord可以避免文件名乱码
            attachmentBodyPart.setFileName(MimeUtility.encodeWord(dataSource.getFile().getName()));
            multipart.addBodyPart(attachmentBodyPart);
        }
        // 邮件的文本内容
        message.setContent(multipart);

        // 6. 设置发件时间
        message.setSentDate(new Date());

        // 7. 保存设置
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