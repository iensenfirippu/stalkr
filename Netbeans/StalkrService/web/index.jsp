<%@page import="easj.jrpg.stalkrlib.Tools"%>
<%@page import="java.util.regex.Matcher"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="easj.jrpg.mappers.UserMapper"%>
<%@page import="easj.jrpg.stalkrlib.User"%>
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
			String username = "";
			String password = "";
			String email = "";
			String firstname = "";
			String lastname = "";
			if (request.getParameter("userName") != null) { username = request.getParameter("userName"); }
			if (request.getParameter("password") != null) { password = request.getParameter("password"); }
			if (request.getParameter("email") != null) { email = request.getParameter("email"); }
			if (request.getParameter("firstName") != null) { firstname = request.getParameter("firstName"); }
			if (request.getParameter("lastName") != null) { lastname = request.getParameter("lastName"); }
			String valid_username = "";
			String valid_password = "";
			String valid_email = "";
			String valid_firstname = "";
			String valid_lastname = "";
			
			Pattern pat_username = Pattern.compile("^[A-Za-z0-9]{5,}$");
			Pattern pat_password = Pattern.compile("^[A-Za-z0-9\\ ]+$");
			Pattern pat_email = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+(?:\\.[A-Za-z]{2,4}){1,2}$");
			Pattern pat_name = Pattern.compile("^[A-Za-z\\ ]+$");
			
			Matcher matcher = pat_username.matcher(username);
			if (!matcher.matches()) { valid_username = "invalid"; }
			matcher = pat_password.matcher(password);
			if (!matcher.matches()) { valid_password = "invalid"; }
			else if (!password.equals(request.getParameter("repeatPassword"))) { valid_password = "invalid"; }
			matcher = pat_email.matcher(email);
			if (!matcher.matches()){ valid_email = "invalid"; }
			matcher = pat_name.matcher(firstname);
			if (!matcher.matches()){ valid_firstname = "invalid"; }
			matcher = pat_name.matcher(lastname);
			if (!matcher.matches()){ valid_lastname = "invalid"; }
			
			if (!valid_username.equals("") || !valid_password.equals("") || !valid_email.equals("") ||
				!valid_firstname.equals("") || !valid_lastname.equals("")) 
			{
		%>
		<h1>Please fill out the form below</h1>
		<form name="SignUp" action="index.jsp" method="get">
			<label for="username">Username: </label> <input type="text" name="userName" value="sdvsd" /> <div class="valid">&nbsp;</div><br />
			<label for="password">Password: </label> <input type="password" name="password" /> <div class="invalid">&nbsp;</div><br />
			<label for="repeatPassword">Repeat Password: </label> <input type="password" name="repeatPassword" /><br />
			<label for="email">E-Mail: </label> <input type="text" name="email" value="sdv" /> <div class="invalid">&nbsp;</div><br />
			<label for="firstName">First Name: </label> <input type="text" name="firstName" value="sdv" /> <div class="valid">&nbsp;</div><br />
			<label for="lastName">Last Name: </label> <input type="text" name="lastName" value="dsvsd" /> <div class="valid">&nbsp;</div><br />
			<label for="submit"> </label> <input type="submit" class="submit" name="submit" value="Sign Up" /><br />
		</form>
		<%
			}
			else
			{
				User user = new User();

				user.setUsername(username);
				user.setPassword(password);
				user.setEmail(email);
				user.setFirstName(firstname);
				user.setLastName(lastname);

				UserMapper.adminSaveUser("SIGNUPSCRIPT", "BecuzFukU2", Tools.UserToString(user, true));
		%>
		<h1>Your user has been created successfully!</h1>
		<%
			}
		%>
    </body>
</html>
