<jsp:useBean id="loginDao" class="com.bank.dao.LoginDao" scope="application" />
<%
String userid=request.getParameter("userid");
boolean userExists=loginDao.authenticateUser(userid,application);
if(!userExists)
{
	%>
	<jsp:include page="/user/login-form">
	  <jsp:param value="Entered userid does not exist!" name="msg"/>
	  <jsp:param value="<%=userid%>" name="uid"/>
	</jsp:include>
	<%
	return;
}
if(!loginDao.matchPassword(request.getParameter("password")))
{
	%>
	<jsp:include page="/user/login-form">
	  <jsp:param value="Entered password is wrong!" name="msg"/>
	  <jsp:param value="<%=userid%>" name="uid"/>
	</jsp:include>
	<%
	return;
}
//After successfull login
session.setAttribute("username", loginDao.getUserName());
session.setAttribute("accountno", loginDao.getAccountNo(userid, application));
//session.setMaxInactiveInterval(10);//10 seconds
response.sendRedirect("/banking-app");
%>
