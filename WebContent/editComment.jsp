<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Comment</title>
</head>
<body>
<c:if test="${not empty user}">
<c:if test="${user.role == 'RegisteredUser' || user.role == 'Admin' || user.role == 'Moderator' }">
<form name = "editComment" method="POST" action="EditCommentServlet">

		<h2>Edit</h2>		
		
		 <textarea align = "center" name="text" cols="40" rows="5"></textarea>
		 
		<p></p>
		<input type="hidden" name="commentid" value="${commentid}"></input>
		<input type="hidden" name="topic" value="${idtopic.title}"></input>
    	<input type="hidden" name="author" value="${comment.author}"></input>
    	<input type="hidden" name="date" value="${comment.date}"></input>
		<input type="hidden" name="likes" value="${likes}"></input>
    	<input type="hidden" name="dislikes" value="${dislikes}"></input>
		<input type = "submit"  name="edit" value="Edit">
		
		
		 
		
		 
	</form>
</c:if>
</c:if>
</body>
</html>