package com.bank.listener;

import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BankListener implements ServletContextListener 
{
	private Statement st;
	private Connection cn;
	private ServletContext application;
	@Override
	public void contextInitialized(ServletContextEvent evt) 
	{
		try
		{
			application=evt.getServletContext();
			Class.forName("com.mysql.cj.jdbc.Driver");
		    cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp4?createDatabaseIfNotExist=true", "root", "mysql");
		    st=cn.createStatement();
		    createTables();
		    createUserAndAccountStatemenets();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
	}
	private void createTables()throws Exception
	{
		st.execute("create table if not exists users(userid varchar(30) primary key,password varchar(30),firstname varchar(20),lastname varchar(20),phone varchar(20),email varchar(40),address varchar(50),dob varchar(20))");
	    st.execute("create table if not exists accounts(accountno int primary key auto_increment,userid varchar(30),amount int default 0)auto_increment=12390010");
	}
	private void createUserAndAccountStatemenets()throws Exception
	{
		PreparedStatement psSaveUser=cn.prepareStatement("insert into users values(?,?,?,?,?,?,?,?)");
		application.setAttribute("saveUser", psSaveUser);
		PreparedStatement psSaveAccount=cn.prepareStatement("insert into accounts(userid) values(?)");
		application.setAttribute("saveAccount", psSaveAccount);
		PreparedStatement psGetAccount=cn.prepareStatement("select accountno from accounts where userid=?");
		application.setAttribute("getAccount", psGetAccount);
		PreparedStatement psSelectUser=cn.prepareStatement("select * from users where userid=?");
		application.setAttribute("selectUser", psSelectUser);
		PreparedStatement psSelectAccount=cn.prepareStatement("select accountno from accounts where userid=?");
		application.setAttribute("selectAccount", psSelectAccount);
	}
}
