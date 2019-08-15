<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/subforum.css">
<title>Topics</title>
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
<a class = "search" href="Search.jsp"> Search</a>
</c:if>




<h2>Topics</h2>
<table border="1">
		<tr bgcolor="lightgrey">
			
			<th width="50%">Title</th>
			<th width="10%">Type</th>
			
			<th width="30%">Content</th>
			<th width="10%">Likes</th>
			<th width="10%">Dislikes</th>
				
		</tr>
	<c:forEach items="${topics}" var="topics">
	  <c:if test="${idsubforum.name == topics.subforum}">
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
  			<c:if test="${not empty user}">
  			<c:if test="${user.role == 'RegisteredUser' || user.role == 'Moderator' || user.role == 'Admin'  }">
  			<td>
			<form name="saveTopic" method="POST" action="SaveTopicServlet">
    			<input type="submit" name="saveTopicButton" value="Save Topic"></input>
    			<input type="hidden" name="topic" value="${topics.title}"></input>	
  			</form>
  			</td>
  			</c:if>
  			</c:if>
  			<c:if test="${not empty user}">
  			<c:if test="${user.username == topics.author || user.role == 'Moderator' || user.role == 'Admin'  }">
  			<td>
			<form name="deleteTopic" method ="GET" action="DeleteTopicServlet">
    			<input type="submit" name="openButton" value="Delete"></input>
    			<input type="hidden" name="title" value="${topics.title}"></input>
            </form>
  			</td>
  			</c:if>
  			</c:if>
  			<c:if test="${not empty user}">
  			<c:if test="${user.username == topics.author || user.role == 'Moderator' || user.role == 'Admin'  }">
  			<td>
			<form name="editTopic" method ="GET" action="EditTopicServlet">
    			<input type="submit" name="editTopicButton" value="Edit"></input>
    			<input type="hidden" name="subforum" value="${topics.subforum}"></input>
    			<input type="hidden" name="topic" value="${topics.title}"></input>
    			<input type="hidden" name="author" value="${topics.author}"></input>
    			<input type="hidden" name="date" value="${topics.date}"></input>
    			
    			
  			</form>
  			</td>
  			</c:if>
  			</c:if>
  			
  			<tr>
  			  <th colspan = "6" >
  			  <c:if test="${not empty user}">
  			  <c:if test="${user.role == 'RegisteredUser' || user.role == 'Moderator' || user.role == 'Admin'  }"> 
                        <form align ="left" name="reportTopic" method ="GET" action="SendReportServlet"> 
  			              <input type="submit" name="reportTopicButton" value="Report"></input>
  			              <input type="hidden" name="name" value="${topics.title}"></input>
  			              <input type="hidden" name="author" value="${topics.author}"></input>
  			              <input type="hidden" name="reporter" value="${user.username}"></input>
  			           </form>
  			           
  			           <form  method ="POST" action="LikeDislikeTopicServlet"> 
  			                  <input type="hidden" name="like" value="${topics.positiveVotes}"></input>
    			              <input type="hidden" name="dislike" value="${topics.negativeVotes}"></input>   
    			              <input type="hidden" name="name" value="${topics.title}"></input>    
  			                 <input class="likeTopicButton" type="submit" name="likeTopicButton" value="Like"></input>
  			              
  			           </form>
  			           <form   method ="POST" action="LikeDislikeTopicServlet"> 
  			                  <input type="hidden" name="like" value="${topics.positiveVotes}"></input>
    			              <input type="hidden" name="dislike" value="${topics.negativeVotes}"></input>   
    			               <input type="hidden" name="name" value="${topics.title}"></input>       
  			                 <input class="dislikeTopicButton" type="submit" name="dislikeTopicButton" value="Dislike"></input>
  			              
  			           </form>
  			           </c:if>
  			           </c:if>
  			        </th>
  			
  			
		</tr>
		</c:if>
	</c:forEach>
</table>
<c:if test="${not empty user}">
<c:if test="${user.role == 'RegisteredUser' || user.role == 'Moderator' || user.role == 'Admin' }">
<form name="addNewtopic" method = "GET" action="AddNewTopicServlet">
    			<input type="submit" name="openButton" value="Add New Topic"></input>
    			<input type="hidden" name="subforum" value="${idsubforum.name}"></input>
    			<input type="hidden" name="author" value="${user.username}"></input>
</form>
</c:if>
</c:if>


</body>
</html>