<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
</head>

<body>

<form align="center" name = "registration" method="POST" action="RegisterServlet" align="center"">
		<table title="Enter registration data" align="center" >
		
		<tr>
		<td align="right">Username: </td><td><input type="text" name="username"> </br></td> 
		</tr>
		
		<tr>
		<td align="right">Password:  </td><td><input	type="password" name="password"></br></td>
		</tr>
		
		<tr>
		<td align="right">Name:  </td><td><input type="text"	name="name">	</br>	</td>	
		</tr>
		
		<tr>
		<td align="right">Last Name:	 </td><td>	<input type="text" name="lastname"> </br></td>
		</tr>
		
		<tr>
		<td align="right">Phone number:  </td><td> <input type="text" name="phone"> </br> </td>
		</tr>
		
		
		<tr>
		<td align="right">Email:  </td><td><input type="text"	name="email"> </br></td>
		</tr>
		
		
		<tr>
		
		<td colspan="2" align="left"><input type = "submit" value="Registration"></td>
		 </tr>
		 
		 </table>
	</form>

</body>
</html>