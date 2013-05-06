<%-- 
    Document   : index
    Created on : 05-03-2013, 12:51:27
    Author     : Else Larsen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="style.css" />
        <title>Stalkr Sign-up</title>
    </head>
    <body>
		<%
			if (request.getParameter("userName") == null)
			{
		%>
		<h1>Please fill out the form below</h1>
		<form name="SignUp" action="index.jsp" method="GET">
			<label for="username">Username: </label> <input type="text" name="userName" /><br />
			<label for="password">Password: </label> <input type="password" name="password" /><br />
			<label for="repeatPassword">Repeat Password: </label> <input type="password" name="repeatPassword" /><br />
			<label for="email">E-Mail: </label> <input type="text" name="email" /><br />
			<label for="firstName">First Name: </label> <input type="text" name="firstName" /><br />
			<label for="lastName">Last Name: </label> <input type="text" name="lastName"> </input><br />
			<label for="submit"> </label> <input type="submit" class="submit" name="submit" value="Sign Up" /><br />
		</form>
		<%
			}
			else 
			{
				
			}
		%>
    </body>
</html>
