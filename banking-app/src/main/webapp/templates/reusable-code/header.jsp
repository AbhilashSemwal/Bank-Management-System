<%
if(session.getAttribute("username")==null)
{
	response.sendRedirect("/banking-app/user/login-form");
	return;
}
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank Home Page</title>
    <link href="/banking-app/resources/CSS/bootstrap.min.css" rel="stylesheet">
    <link href="/banking-app/resources/CSS/bank.css" rel="stylesheet">
    <script type="text/javascript" src="/banking-app/resources/JS/bootstrap.bundle.min.js"></script>
</head>
<div class="header">
	<div class="row">
		<div class='col-3'>
			<span class='fs-5 text-info'>Savings Account</span><br> <span
				class='fs-6'><%=session.getAttribute("accountno")%></span>
		</div>
		<div class='col-3'>
			<p class='fs-3'>Janta Bank</p>
		</div>
		<div class='col-3'>
			<span class='fs-5 text-info'>Your Name</span><br> <span
				class='fs-6'><%=session.getAttribute("username")%></span>
		</div>
		<div class='col-3'>
			<a href="user/logout.do" class='fs-6 text-info'>Logout</a>
		</div>
	</div>
</div>