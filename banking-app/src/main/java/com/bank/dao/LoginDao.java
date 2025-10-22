package com.bank.dao;

import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class LoginDao 
{
	private String dbPassword;
	private String name;
	public boolean authenticateUser(String userid,ServletContext app)
	{
		try
		{
			PreparedStatement ps=(PreparedStatement)app.getAttribute("selectUser");
			ps.setString(1, userid);
			ResultSet rst=ps.executeQuery();
			if(rst.next())
			{
				dbPassword=rst.getString(2);
				name=rst.getString("firstname")+" "+rst.getString("lastname");
				return true;
			}
		}
		catch (Exception ex) 
		{
			System.out.println(ex);
		}
		return false;
	}
	public boolean matchPassword(String frmPassword)
	{
		return frmPassword.equals(dbPassword);
	}
	public String getUserName()
	{
		return name;
	}
	public int getAccountNo(String userid,ServletContext app)
	{
		try
		{
			PreparedStatement ps=(PreparedStatement)app.getAttribute("selectAccount");
			ps.setString(1, userid);
			ResultSet rst=ps.executeQuery();
			rst.next();
			return rst.getInt(1);
		}
		catch (Exception ex) 
		{
			System.out.println(ex);
		}
		return 0;
	}
}
