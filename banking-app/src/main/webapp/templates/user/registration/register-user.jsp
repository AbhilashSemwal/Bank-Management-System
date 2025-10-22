<%@ include file="../user-header.jsp" %>
<jsp:useBean id="registrationDao" class="com.bank.dao.RegistrationDao" scope="application" />
<html>
<body class="bg-light text-center">
   <%
   //JDBC code to save user details into users table
   registrationDao.saveUser(request, application);
   //JDBC code to save account details into accounts table
   registrationDao.saveAccount(request, application);
   //JDBC code to get account no from accounts table
   int accountno=registrationDao.getAccount(request, application);
   %>
   <div class="bg-image">
	<div class="container py-5">
		<div class="card mx-auto shadow" style="max-width: 50%;">
			<div class="card-body">
				<p class="fs-2" class="card-title">You have been registered successfully</p>
				<p class="card-text display-6 text-success">Your account number is <span id="accountno"><%=accountno%></span></p>
				<a class='btn btn-primary' href="login">Click here to login</a>
			</div>
		</div>
	</div>
    </div> 	
	<%@ include file="../../reusable-code/footer.jsp" %>
</body>
</html>
