package com.yzb.util.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.InitializingBean;

public class JavaMailClient implements InitializingBean
{
	private String mailHost;
	private String mailTransportProtocol;
	private String mailSmtpAuth;
	private boolean mailDebug;
	
	private String mailUserName;
	private String mailPassword;
	
	private Session session;
	
	@Override
	public void afterPropertiesSet() throws Exception
	{
		Properties prop = new Properties();
		prop.setProperty("mail.host", mailHost);
		prop.setProperty("mail.transport.protocol", mailTransportProtocol);
		prop.setProperty("mail.smtp.auth", mailSmtpAuth);
		
		session = Session.getInstance(prop);
		session.setDebug(mailDebug);
	}
	
	public void sendSimpleMail(String to, String subject, String content) throws MessagingException
	{
		MimeMessage message = new MimeMessage (session);
		message.setFrom(mailUserName);
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject(subject);
		message.setContent(content, "text/html;charset=UTF-8");
		
		Transport ts = session.getTransport();
		ts.connect(mailHost, mailUserName, mailPassword);
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
	}
	
	public String getMailHost()
	{
		return mailHost;
	}
	public void setMailHost(String mailHost)
	{
		this.mailHost = mailHost;
	}
	public String getMailTransportProtocol()
	{
		return mailTransportProtocol;
	}
	public void setMailTransportProtocol(String mailTransportProtocol)
	{
		this.mailTransportProtocol = mailTransportProtocol;
	}
	public String getMailSmtpAuth()
	{
		return mailSmtpAuth;
	}
	public void setMailSmtpAuth(String mailSmtpAuth)
	{
		this.mailSmtpAuth = mailSmtpAuth;
	}
	public String getMailUserName()
	{
		return mailUserName;
	}
	public void setMailUserName(String mailUserName)
	{
		this.mailUserName = mailUserName;
	}
	public String getMailPassword()
	{
		return mailPassword;
	}
	public void setMailPassword(String mailPassword)
	{
		this.mailPassword = mailPassword;
	}

	public boolean getMailDebug()
	{
		return mailDebug;
	}

	public void setMailDebug(boolean mailDebug)
	{
		this.mailDebug = mailDebug;
	}
}
