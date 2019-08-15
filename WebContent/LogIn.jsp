<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log In</title>
</head>
<body>
<h3>Login</h3>
     <form  name="login" method="post"  action="LoginServlet" >
   		<p>Username:</p><input type="text" align="center" name="username"></br>
  		<p >Password:</p><input type="password"  name="password"> </br>
  		<input type="submit"  value="Login"></br>
		
  		<p><a href="Register.jsp">Sign Up</a></p>
	</form> 

</body>
</html>