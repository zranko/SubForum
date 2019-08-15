<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Topic</title>
</head>
<body>
<c:if test="${not empty user}">
<c:if test="${user.role == 'RegisteredUser' || user.role == 'Admin' || user.role == 'Moderator' }">
<h2>Add New Topic</h2>

	<form align="center" name = "addTopic" method="POST" action="AddNewTopicServlet" >
		<table title="Add New Topic" align="center" >
		
		<tr>
		<td align="right">Title:  </td><td><input	type="text" name="title"></br></td>
		</tr>
		
		<tr>
		<td align="right">Type:  </td><td><input type="text"	name="type">	</br>	</td>	
		</tr>
		
		<tr>
		<td align="right">Content:	 </td><td>	<input type="text" name="content"> </br></td>
		</tr>
		<input type="hidden" name="subforum" value="${subforumid}"></input>
		<input type="hidden" name="author" value="${authorid}"></input>
		<td colspan="2" align="left"><input type = "submit" value="Add New topic"></td>
		 </tr>
		
		 
		 </table>
	</form>
</c:if>
</c:if>
</body>
</html>