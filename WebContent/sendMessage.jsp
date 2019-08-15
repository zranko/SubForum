<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Send Message</title>
</head>
<body>
<c:if test="${not empty user}">
<c:if test="${user.role == 'RegisteredUser' || user.role == 'Admin' || user.role == 'Moderator' }">
<form align = "center" name = "addMessage" method="POST" action="AddNewMessageServlet">

		<h2>Send Message</h2>		
		
		 <textarea name="text" cols="50" rows="5"></textarea>
		 
		<p></p>
		<input type="hidden" name="receiver" value="${receiver}"></input>
		<input type="hidden" name="sender" value="${sender}"></input>
		<input type = "submit" value="Send">
		
		
		 
		
		 
	</form>
	</c:if>
	</c:if>
</body>
</html>