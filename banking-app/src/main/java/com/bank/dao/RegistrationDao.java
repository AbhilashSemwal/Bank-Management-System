package com.bank.dao;

import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class RegistrationDao 
{
	public void saveUser(HttpServletRequest req,ServletContext app)
	{
		try
		{
			PreparedStatement ps=(PreparedStatement)app.getAttribute("saveUser");
			ps.setString(1, req.getParameter("userid"));
			ps.setString(2, req.getParameter("password"));
			ps.setString(3, req.getParameter("firstname"));
			ps.setString(4, req.getParameter("lastname"));
			ps.setString(5, req.getParameter("phone"));
			ps.setString(6, req.getParameter("email"));
			ps.setString(7, req.getParameter("address"));
			ps.setString(8, req.getParameter("dob"));
			ps.executeUpdate();
		}
		catch (Exception ex) 
		{
			System.out.println(ex);
		}
	}
	public void saveAccount(HttpServletRequest req,ServletContext app)
	{
		try
		{
			PreparedStatement ps=(PreparedStatement)app.getAttribute("saveAccount");
			ps.setString(1, req.getParameter("userid"));
			ps.executeUpdate();
		}
		catch (Exception ex) 
		{
			System.out.println(ex);
		}
	}
	public int getAccount(HttpServletRequest req,ServletContext app)
	{
		int accountno=0;
		try
		{
			PreparedStatement ps=(PreparedStatement)app.getAttribute("getAccount");
			ps.setString(1, req.getParameter("userid"));
			ResultSet rst=ps.executeQuery();
			rst.next();
			accountno=rst.getInt(1);
		}
		catch (Exception ex) 
		{
			System.out.println(ex);
		}
		return accountno;
	}
}
