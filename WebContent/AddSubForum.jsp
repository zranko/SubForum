<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New SubForum</title>
</head>
<body>
<c:if test="${not empty user}">
<c:if test="${user.role == 'Admin' || user.role == 'Moderator' }">
<h3 align="center">Add New SubForum</h3>

	<form name = "addSubForum" method="POST" action="AddNewSubForumServlet">
		<table align="center" >
		
		<tr>
		<td align="right">Name:</td><td><input type="text" name="name"></td> 
		</tr>
		
		<tr>
		<td align="right">Description:</td><td><input type="text" name="description"></td>
		</tr>
		
		<tr>
		<td align="right">Icon:</td><td><input type="text"	name="icon"></td>	
		</tr>
		
		<tr>
		<td align="right">Rules:</td><td>	<input type="text" name="rules"></td>
		</tr>
		
		
		<tr>
		
		<td align="right">Moderators:</td><td><select multiple name="mods">
		                                         <c:forEach items="${user_list}" var="moderators">
                                                     <option value="${moderators.username}">${moderators.username}</option>
                                                 </c:forEach>
                                              </select></td> 
		</tr>
		
		
		<tr>
		<input type="hidden" name="mainModerator" value="${user.username}"></input>
		<td colspan="2" align="center"><input type = "submit" value="Add SubForum"></td>
		</tr>
		 
		 </table>
	</form>
</c:if>
</c:if>
</body>
</html>