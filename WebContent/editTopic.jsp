<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Topic</title>
</head>
<body>
<h2>Edit Topic</h2>
<c:if test="${not empty user}">
<c:if test="${user.role == 'RegisteredUser' || user.role == 'Admin' || user.role == 'Moderator' }">
	<form name = "editTopic" method="POST" action="EditTopicServlet" >
		<table title="Add New Topic" align="center" >
		
		
		<tr>
		<td align="right">Type:  </td><td><input type="text"	name="type">	</br>	</td>	
		</tr>
		
		<tr>
		<td align="right">Content:	 </td><td>	<input type="text" name="content"> </br></td>
		</tr>
		<td>
		        <input type="hidden" name="subforum" value="${subforum}"></input>
    			<input type="hidden" name="topic" value="${topic}"></input>
    			<input type="hidden" name="author" value="${author}"></input>
    			<input type="hidden" name="date" value="${date}"></input>
		<td colspan="2" align="left"><input type = "submit" value="Edit"></td>
		 </tr>
		
		 
		 </table>
	</form>
</c:if>
</c:if>
</body>
</html>