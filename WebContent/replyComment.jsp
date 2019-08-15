<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reply</title>
</head>
<body>
<c:if test="${not empty user}">
<c:if test="${user.role == 'RegisteredUser' || user.role == 'Admin' || user.role == 'Moderator' }">
<form name = "replyComment" method="POST" action="ReplyCommentServlet">

		<h2>New comment</h2>		
		
		 <textarea name="text" cols="40" rows="5"></textarea>
		 
		<p></p>
		<input type="hidden" name="topic" value="${idtopic}"></input>
		<input type="hidden" name="author" value="${comm_authorid}"></input>
		<input type="hidden" name="parentid" value="${parentid}"></input>
		<input type = "submit" value="Reply">
		
		
		 
		
		 
	</form>
</c:if>
</c:if>
</body>
</html>