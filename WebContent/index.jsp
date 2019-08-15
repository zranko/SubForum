<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/subforum.css">
<title>Forum</title>
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



<c:if test="${not empty user}">
<c:if test="${user.role == 'RegisteredUser' || user.role == 'Moderator' || user.role == 'Admin'  }">
<h4>Messages</h4>
   <table border="1">
		<tr>
			<th width="20%">Sender</th>
			<th width="20%">Receiver</th>
			<th width="50%">Text</th>			
		</tr>
	<c:forEach items="${messages}" var="message">
	   <c:if test="${user.username == message.receiver}">
		<tr>
			<td align="center">${message.sender}</td>
			<td align="center">${message.receiver}</td>
			<td align="center">${message.text}</td>
			<td>
			<form method = "GET" action="AddNewMessageServlet">
    			<input type="submit" name="reply" value="Reply"></input>
    			<input type="hidden" name="sender" value="${user.username}"></input>
    			<input type="hidden" name="recevier" value="${message.sender}"></input>
  			</form>
  			</td>
  			<c:if test="${not empty user}">
  			<c:if test="${user.role == 'RegisteredUser' ||user.role == 'Admin' || user.role == 'Moderator' }">
  			<td>
  			<form method ="GET" action="DeleteMessageServlet">
    			 <input type="submit" name="openButton" value="Delete"></input>
    			
    			<input type="hidden" name="id" value="${message.id}"></input>
    			
    			
            </form>
            </td>
            </c:if>
            </c:if>
            <c:if test="${not empty user}">
  			<c:if test="${user.role == 'RegisteredUser' || user.role == 'Admin' || user.role == 'Moderator' }">
  			<td>
  			<form method ="POST" action="SaveMessageServlet">
    			 <input type="submit" name="openButton" value="Save"></input>
    			
    			<input type="hidden" name="id" value="${message.id}"></input>
    			
    			
            </form>
            </td>
            </c:if>
            </c:if>
  			
  			
		</tr>
		</c:if>
	</c:forEach>
  </table>
</c:if>
</c:if>
    
<h2 align = "center">SubForums</h2>
   <table border="1">
		<tr bgcolor="lightgrey">
		    <th width="10%">Icon</th>
			<th width="40%">Name</th>
			<th width="20%">Description</th>
			<th width="20%">Rules</th>
			<th width="10%">Moderator</th>			
		</tr>
	<c:forEach items="${subforums}" var="subforum">
	    <tr>
	        <td align="center">${subforum.icon}</td>
			<td><a style="float: left;"href="OpenSubForumServlet?subforum=${subforum.name}">${subforum.name}</a></td>
			<td align="center">${subforum.description}</td>
			
			<td align="center">${subforum.rules}</td>
			
			<td align="center">${subforum.mainModerator}<br><c:forEach items="${subforum.moderators}" var="moderator">${moderator} </c:forEach><br></td>
			<c:if test="${not empty user}">
			<c:if test="${user.role == 'RegisteredUser' || user.role == 'Moderator' || user.role == 'Admin' }">
			<td>
			 <form method ="POST" action="FollowSubForumServlet">
    			<input type="submit" name="openButton" value="Subscribe"></input>
    			<input type="hidden" name="subforum" value="${subforum.name}"></input>
  			</form>
			</td>
			</c:if>
			</c:if>
			<%-- 
			<td>
			<form method ="POST" action="OpenSubForumServlet">
    			<input type="submit" name="openButton" value="Open"></input>
    			<input type="hidden" name="subforum" value="${subforum.name}"></input>
  			</form>
  			</td>
  			--%>
  			<c:if test="${not empty user}">
  			<c:if test="${user.role == 'Admin' || user.role == 'Moderator' }">
  			<td>
  			<form method ="POST" action="DeleteSubForumServlet">
    			 <input type="submit" name="openButton" value="Delete"></input>
    			
    			<input type="hidden" name="name" value="${subforum.name}"></input>
    			
    			
            </form>
            </td>
            </c:if>
            </c:if>
            
  			
		</tr>
		<c:if test="${not empty user}">
  		<c:if test="${user.role == 'RegisteredUser' || user.role == 'Moderator' || user.role == 'Admin'  }"> 	
		<tr>
            <th colspan = "6" >
                        <form align ="left" name="reportSubForum" method ="GET" action="SendReportServlet"> 
  			              <input type="submit" name="reportSubForumButton" value="Report"></input>
  			              <input type="hidden" name="subforum" value="${subforum.name}"></input>
  			              <input type="hidden" name="author" value="${subforum.mainModerator}"></input>
  			              <input type="hidden" name="reporter" value="${user.username}"></input>
  			           </form>
  			           
            </th>
            </tr>
            </c:if>
            </c:if>
	</c:forEach>
  </table>
<c:if test="${not empty user}">
<c:if test="${user.role == 'Admin' || user.role == 'Moderator'  }">
<form  method ="POST" action="AddSubForum.jsp">
    			<input type="submit" name="openButton" value="Add SubForum"></input>
</form>
</c:if>
</c:if>
<c:if test="${not empty user}">
<c:if test="${user.role == 'RegisteredUser' || user.role == 'Admin' || user.role == 'Moderator' }">
<h2 align = "center">Subscribed SubForums</h2>
  <table border="1">
		<tr bgcolor="lightgrey">
			<th width="10%">Icon</th>
			<th width="40%">Name</th>
			<th width="20%">Description</th>
			<th width="20%">Rules</th>
			<th width="10%">Moderator</th>			
		</tr>
	<c:forEach items="${subs_subforums}" var="ssf">
		<tr>
			<td align="center">${ssf.icon}</td>
			<td align="center"><a style="float: left;"href="OpenSubForumServlet?subforum=${ssf.name}">${ssf.name}</a></td>
			<td align="center">${ssf.description}</td>
			<td align="center">${ssf.rules}</td>
			<td align="center">${ssf.mainModerator}<br><c:forEach items="${ssf.moderators}" var="moderator">${moderator} </c:forEach><br></td>
			<%-- 
			<td>
			<form  method ="POST" action="OpenSubForumServlet">
    			<input type="submit" name="openButton" value="Open"></input>
    			<input type="hidden" name="subforum" value="${ssf.name}"></input>
  			</form>
  			</td>
  			--%>
  			<td>
				<form method ="POST" action="UnsubscribeSubForumServlet">
    			 <input type="submit" name="openButton" value="Delete"></input>
    			
    			<input type="hidden" name="subforum" value="${ssf.name}"></input>
    			
    			
            </form>
  			</td>
  			
  			
		</tr>
	
	</c:forEach>
  </table>
</c:if>
</c:if>

<c:if test="${not empty user}">
<c:if test="${user.role == 'RegisteredUser' || user.role == 'Admin' || user.role == 'Moderator' }">
<h2 align = "center">Saved Topics</h2>
  <table border="1">
		<tr bgcolor="lightgrey">
			
			<th width="50%">Title</th>
			<th width="10%">Type</th>	
			<th width="30%">Content</th>
			<th width="10%">Likes</th>
			<th width="10%">Dislikes</th>
		</tr>
	<c:forEach items="${stopics}" var="stopic">
	    
		<tr>
			
			<td align="center"><a style="float: left;"href="OpenTopicServlet?title=${stopic.title}">${stopic.title}</a><br>
			                     Created on: ${stopic.date} by ${stopic.author} </td>
			<td align="center">${stopic.type}</td>
			
			<td align="center">${stopic.content}</td>
			<td align="center">${stopic.positiveVotes}</td>
			<td align="center">${stopic.negativeVotes}</td>
			<%--
			<td>
			<form name="openTopic" method = "POST" action="OpenTopicServlet">
    			<input type="submit" name="openButton" value="Open"></input>
    			<input type="hidden" name="title" value="${stopic.title}"></input>
  			</form>
  			</td>
  			 --%>
  			<td>
  			<form method ="POST" action="DeleteSavedTopicServlet">
    			<input type="submit" name="openButton" value="Delete"></input>
    			<input type="hidden" name="title" value="${stopic.title}"></input>
            </form>
  			</td>
  			
		</tr>
		
	</c:forEach>
  </table>
</c:if>
</c:if>
<c:if test="${not empty user}">
<c:if test="${user.role == 'RegisteredUser' || user.role == 'Admin' || user.role == 'Moderator' }">
<h2 align = "center">Saved Messages</h2>
  <table border="1">
		<tr bgcolor="lightgrey">
			<th width="20%">Sender</th>
			<th width="20%">Content</th>			
		</tr>
	<c:forEach items="${saved_messages}" var="saved_messages">
		<tr>
			<td align="center">${saved_messages.sender}</td>
			<td align="center">${saved_messages.text}</td>
			
		</tr>
	</c:forEach>
  </table>
</c:if>
</c:if>
<c:if test="${not empty user}">
<c:if test="${user.role == 'Admin' }">
<form  method="POST" action="ChangeUserServlet">
		
		
		<p align="left">All users: <select name="user">
		                                         <c:forEach items="${user_list}" var="alluser">
                                                   <option value="${alluser.username}">${alluser.username}</option>
                                                 </c:forEach>
                                              </select> </p>
		
		
		
		
		        <input align="left" name="add" type = "submit" value="Add Moderator"> 
		        <input align="left"name="remove" type = "submit" value="Remove Moderator">
		 
		 
	</form>
</c:if>
</c:if>
<c:if test="${not empty user}">
<c:if test="${user.role == 'Admin' || user.role == 'Moderator' }">
<h2 align = "center">Reports</h2>
   <table border="1">
		<tr bgcolor="lightgrey">
		    <th width="10%">ID</th>
			<th width="40%">Text</th>
			<th width="20%">Author</th>
			<th width="20%">Reporter</th>
			<th width="10%">Date</th>			
		</tr>
	<c:forEach items="${reports}" var="report">
	    <tr>
	        <td align="center">${report.comment_id} ${report.topic_id} ${report.subforum_id}</td>
			<td align="center">${report.text}</td>
			<td align="center">${report.author_id}</td>
			<td align="center">${report.reporter_id}</td>
			
			<td align="center">${report.date}</td>
			
			
			
			<td>
			 <form  method ="POST" action="SendAlertToReporterServlet">
    			<input type="submit" name="openButton" value="Ignore"></input>
    			<input type="hidden" name="comment_id" value="${report.comment_id}"></input>
    			<input type="hidden" name="topic_id" value="${report.topic_id}"></input>
    			<input type="hidden" name="subforum_id" value="${report.subforum_id}"></input>
    			<input type="hidden" name="receiver" value="${report.author_id}"></input>
    			<input type="hidden" name="report_receiver" value="${report.reporter_id}"></input>
    			<input type="hidden" name="sender" value="${user.username}"></input>
    		
    			<input type="hidden" name="text_for_reporter" value="Report ignored"></input>
  			</form>
			</td>
			<td>
			<form  method ="POST" action="SendAlertToAuthorServlet">
    			<input type="submit" name="openButton" value="Warn"></input>
    			<input type="hidden" name="comment_id" value="${report.comment_id}"></input>
    			<input type="hidden" name="topic_id" value="${report.topic_id}"></input>
    			<input type="hidden" name="subforum_id" value="${report.subforum_id}"></input>
    			<input type="hidden" name="receiver" value="${report.author_id}"></input>
    			<input type="hidden" name="report_receiver" value="${report.reporter_id}"></input>
    			<input type="hidden" name="sender" value="${user.username}"></input>
    			<input type="hidden" name="text_for_author" value="You have received warning "></input>
    			<input type="hidden" name="text_for_reporter" value="Author received warning"></input>
  			</form>
  			<td>
  			<form  method ="POST" action="DeleteCommentFromReportServlet">
    			<input type="submit" name="openButton" value="Delete"></input>
    			<input type="hidden" name="comment_id" value="${report.comment_id}"></input>
    			<input type="hidden" name="topic_id" value="${report.topic_id}"></input>
    			<input type="hidden" name="subforum_id" value="${report.subforum_id}"></input>
    			<input type="hidden" name="receiver" value="${report.author_id}"></input>
    			<input type="hidden" name="report_receiver" value="${report.reporter_id}"></input>
    			<input type="hidden" name="sender" value="${user.username}"></input>
    			<input type="hidden" name="text_for_author" value="Your entity is deleted"></input>
    			<input type="hidden" name="text_for_reporter" value="Reported entity deleted"></input>
            </form>
            
            </td>
  		    
		</tr>	
	</c:forEach>
  </table>
</c:if>
</c:if>
</body>
</html>