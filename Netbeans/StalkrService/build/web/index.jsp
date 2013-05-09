<%@page import="java.util.regex.Matcher"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="dk.iensenfirippu.jrpg.stalkr.UserMapper"%>
<%@page import="dk.iensenfirippu.jrpg.stalkrlib.User"%>
<%@page import="dk.iensenfirippu.jrpg.stalkrlib.Tools"%>
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
			int invalid = 0;
			String validhtml = "<div class=\"valid\">&nbsp;</div>";
			String invalidhtml = "<div class=\"invalid\">&nbsp;</div>";
			String username = "";
			String password = "";
			String email = "";
			String firstname = "";
			String lastname = "";
			if (request.getParameter("username") != null) { username = request.getParameter("username"); }
			if (request.getParameter("password") != null) { password = request.getParameter("password"); }
			if (request.getParameter("email") != null) { email = request.getParameter("email"); }
			if (request.getParameter("firstname") != null) { firstname = request.getParameter("firstname"); }
			if (request.getParameter("lastname") != null) { lastname = request.getParameter("lastname"); }
			String valid_username = "";
			String valid_password = "";
			String valid_email = "";
			String valid_firstname = "";
			String valid_lastname = "";

			Pattern pat_username = Pattern.compile("^[A-Za-z0-9]{5,}$");
			Pattern pat_password = Pattern.compile("^[A-Za-z0-9\\ ]+$");
			Pattern pat_email = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+(?:\\.[A-Za-z]{2,4}){1,2}$");
			Pattern pat_name = Pattern.compile("^[A-Za-z\\ ]+$");

			if (request.getParameter("username") != null)
			{
				Matcher matcher = pat_username.matcher(username);
				if (!matcher.matches()) { invalid++; valid_username = invalidhtml; } else { valid_username = validhtml; }
				matcher = pat_password.matcher(password);
				if (!matcher.matches()) { invalid++; valid_password = invalidhtml; }
				else if (!password.equals(request.getParameter("repeatPassword"))) { invalid++; valid_password = invalidhtml; }
				else { valid_password = validhtml; }
				matcher = pat_email.matcher(email);
				if (!matcher.matches()){ invalid++; valid_email = invalidhtml; } else { valid_email = validhtml; }
				matcher = pat_name.matcher(firstname);
				if (!matcher.matches()){ invalid++; valid_firstname = invalidhtml; } else { valid_firstname = validhtml; }
				matcher = pat_name.matcher(lastname);
				if (!matcher.matches()){ invalid++; valid_lastname = invalidhtml; } else { valid_lastname = validhtml; }
			}

			if (request.getParameter("username") == null || invalid > 0)
			{
		%>
		<h1>Please fill out the form below</h1>
		<form name="SignUp" action="index.jsp" method="get">
		<label for="username">Username: </label> <input type="text" name="username" value="<%=username%>" /> <%=valid_username%><br />
		<label for="password">Password: </label> <input type="password" name="password" /> <%=valid_password%><br />
		<label for="repeatPassword">Repeat Password: </label> <input type="password" name="repeatPassword" /><br />
		<label for="email">E-Mail: </label> <input type="text" name="email" value="<%=email%>" /> <%=valid_email%><br />
		<label for="firstName">First Name: </label> <input type="text" name="firstname" value="<%=firstname%>" /> <%=valid_firstname%><br />
		<label for="lastName">Last Name: </label> <input type="text" name="lastname" value="<%=lastname%>" /> <%=valid_lastname%><br />
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

				String methodresult = UserMapper.adminSaveUser("SIGNUPSCRIPT", "BecuzFukU2", Tools.UserToString(user, true));
		%>
		<h1>Your user has been created successfully!</h1><div style="display: none;"><%=methodresult%></div>
		<%
			}
		%>
    </body>
</html>
