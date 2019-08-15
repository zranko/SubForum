<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/subforum.css">
<title>Search</title>
</head>
<body>
<p style="text-align:center;"><a href="index.jsp" >Index</a></p>
<c:if test="${not empty user}">
<p align = "left" class="status" >Status: ${user.role}</p>
</c:if>

<br>
<c:if test="${not empty user}">
<p class = "username">User:${user.username}<a href="LogoutServlet" type="button">Logout </a> </p>
</c:if>





<a class = "login" href="LogIn.jsp"> Log in </a>
  <br>

<a class = "register" href="Register.jsp"> Register</a>
<br>





<c:if test="${not empty user}">
<c:if test="${user.role == 'RegisteredUser' || user.role == 'Admin' || user.role == 'Moderator' }">
<form name = "search" method="GET" action="SearchServlet">

		<h2>Search</h2>		
		
		 <input align="center" input type="text" name="search_value"></br>

		<input type = "submit" value="Search">
	
		 
	</form>
	
	<h2 align = "center">SubForums</h2>
   <table border="1">
		<tr>
		    <th width="10%">Icon</th>
			<th width="40%">Name</th>
			<th width="20%">Description</th>
			<th width="20%">Rules</th>
			<th width="10%">Moderator</th>			
		</tr>
	<c:if test = "${not empty search_value }">
	<c:forEach items="${subforums}" var="subforum">
	 <c:if test="${fn:containsIgnoreCase(subforum.name, search_value) || fn:containsIgnoreCase(subforum.description, search_value) || fn:containsIgnoreCase(subforum.mainModerator, search_value)}">
	    <tr>
	        <td align="center">${subforum.icon}</td>
			<td align="center"><a style="float: left;"href="OpenSubForumServlet?subforum=${subforum.name}">${subforum.name}</a></td>
			<td align="center">${subforum.description}</td>
			
			<td align="center">${subforum.rules}</td>
			
			<td align="center"><c:forEach items="${subforum.moderators}" var="moderator">${moderator} </c:forEach><br></td>
			
			<td>
			 <form name="followSubForum" method ="POST" action="FollowSubForumServlet">
    			<input type="submit" name="openButton" value="Subscribe"></input>
    			<input type="hidden" name="subforum" value="${subforum.name}"></input>
  			</form>
			</td>
			<%-- 
			<td>
			<form name="openSubForum" method ="POST" action="OpenSubForumServlet">
    			<input type="submit" name="openButton" value="Open"></input>
    			<input type="hidden" name="subforum" value="${subforum.name}"></input>
  			</form>
  			<td>
  			--%>
  			<form name="deleteSubForum" method ="POST" action="DeleteSubForumServlet">
    			 <input type="submit" name="openButton" value="Delete"></input>
    			
    			<input type="hidden" name="name" value="${subforum.name}"></input>
    			
    			
            </form>
            </td>
  			
		</tr>	
		</c:if>
	</c:forEach>
	</c:if>
  </table>
  
  
  <h2 align = "center">Topics</h2>
<table border="1">
		<tr>
			
			<th width="50%">Title</th>
			<th width="10%">Type</th>
			
			<th width="30%">Content</th>
			<th width="10%">Likes</th>
			<th width="10%">Dislikes</th>	
		</tr>
	<c:if test = "${not empty search_value }">
	<c:forEach items="${topics}" var="topics">
	  <c:if test="${fn:containsIgnoreCase(topics.title, search_value) || fn:containsIgnoreCase(topics.content, search_value) || fn:containsIgnoreCase(topics.author, search_value)}">
		<tr>
			
			<td align="center"><a style="float: left;"href="OpenTopicServlet?title=${topics.title}">${topics.title}</a><br>
			                     Created on: ${topics.date} by ${topics.author} </td>
			<td align="center">${topics.type}</td>
			
			<td align="center">${topics.content}</td>
			<td align="center">${topics.positiveVotes}</td>
			<td align="center">${topics.negativeVotes}</td>
			<%-- 
			<td>
			<form name="openTopic" method = "POST" action="OpenTopicServlet">
    			<input type="submit" name="openButton" value="Open"></input>
    			<input type="hidden" name="title" value="${topics.title}"></input>
  			</form>
  			</td>
  			--%>
  			<td>
			<form name="saveTopic" method="POST" action="SaveTopicServlet">
    			<input type="submit" name="saveTopicButton" value="Save Topic"></input>
    			<input type="hidden" name="topic" value="${topics.title}"></input>	
  			</form>
  			</td>
  			
  			<td>
			<form name="deleteTopic" method ="GET" action="DeleteTopicServlet">
    			<input type="submit" name="openButton" value="Delete"></input>
    			<input type="hidden" name="title" value="${topics.title}"></input>
            </form>
  			</td>
  			<td>
			<form name="editTopic" method ="GET" action="EditTopicServlet">
    			<input type="submit" name="editTopicButton" value="Edit"></input>
    			<input type="hidden" name="subforum" value="${topics.subforum}"></input>
    			<input type="hidden" name="topic" value="${topics.title}"></input>
    			<input type="hidden" name="author" value="${topics.author}"></input>
    			<input type="hidden" name="date" value="${topics.date}"></input>
    			
    			
  			</form>
  			</td>
  			</tr>
  			<tr>
  			  <th colspan = "6" > <form align ="left" name="reportTopic" method ="GET" action="SendReportServlet"> 
  			              <input type="submit" name="reportTopicButton" value="Report"></input>
  			              <input type="hidden" name="name" value="${topics.title}"></input>
  			              <input type="hidden" name="author" value="${topics.author}"></input>
  			              <input type="hidden" name="reporter" value="${user.username}"></input>
  			           </form>
  			           </th>
  			</tr>
  			
		
		</c:if>
	
	</c:forEach>
	</c:if>
</table>
<h2 align = "center">Users</h2>
   <table border="1">
		<tr bgcolor="lightgrey">
		    <th width="40%">Username</th>
			
		</tr>
	<c:forEach items="${user_list}" var="search_user">
	 <c:if test="${search_value == search_user.username }">
	    <tr>
	        <td align="center">${search_user.username}</td>
			
			 
			<td width="40%">
			  <form name="sendMessage" method = "GET" action="AddNewMessageServlet">
    			<input type="submit" name="openButton" value="Send Message"></input>
    			<input type="hidden" name="receiver" value="${search_user.username}"></input>
    			<input type="hidden" name="sender" value="${user.username}"></input>
              </form>
  			</td>
  			
  			
		</tr>	
		</c:if>
	</c:forEach>
  </table>
 </c:if>
 </c:if>
	
</body>
</html>