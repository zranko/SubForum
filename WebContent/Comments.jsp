<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/subforum.css">
<title>Comments</title>
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


<h2>${idtopic.title}</h2>
   <table border="1" >
		<tr bgcolor="lightgrey">
			<th>Author</th>
			<th>Comment</th>
			<th>Likes</th>
			<th>Dislikes</th>
			<th>Edited</th>		
		</tr>
	<c:forEach items="${comments}" var="comment">
	  <c:if test="${ idtopic.title == comment.topic && comment.parent == 0 }">
		<tr>
			
			<td align="center">${comment.author}<br> ${comment.date} <br>
			<c:if test="${not empty user}">
            <c:if test="${user.role == 'RegisteredUser' || user.role == 'Moderator' || user.role == 'Admin'  }">
			<form name="sendMessage" method = "GET" action="AddNewMessageServlet">
    			<input type="submit" name="openButton" value="Send Message"></input>
    			<input type="hidden" name="receiver" value="${comment.author}"></input>
    			<input type="hidden" name="sender" value="${user.username}"></input>
                </form> </c:if>
		    </c:if></td>
			
			<td align="center"><textarea readonly>${comment.text}</textarea></td>
			<td align="center">${comment.positiveVotes}</td>
			<td align="center">${comment.negativeVotes}</td>
			<td align="center">${comment.edited}</td>
            
  			
  			<c:if test="${not empty user}">
            <c:if test="${user.username == comment.author || user.role == 'Moderator' || user.role == 'Admin'  }">
			<td>
			
			<form name="deleteComment" method ="POST" action="DeleteCommentServlet">
    			<input type="submit" name="openButton" value="Delete"></input>
    			<input type="hidden" name="id" value="${comment.id}"></input>
    			<input type="hidden" name="author" value="${comment.author}"></input>
    			
            </form>
  			</td>
  			</c:if>
  			</c:if>
  			<c:if test="${not empty user}">
            <c:if test="${user.username == comment.author || user.role == 'Moderator' || user.role == 'Admin'  }">
  			<td>
  			
  			<form name="addComment" method = "POST" action="EditCommentServlet">
    			<input type="submit" name="editButton" value="Edit"></input>
    			<input type="hidden" name="commentid" value="${comment.id}"></input>
    			<input type="hidden" name="topic" value="${idtopic.title}"></input>
    			<input type="hidden" name="author" value="${comment.author}"></input>
    			<input type="hidden" name="date" value="${comment.date}"></input>
    			<input type="hidden" name="likes" value="${comment.positiveVotes}"></input>
    			<input type="hidden" name="dislikes" value="${comment.negativeVotes}"></input>
    			
            </form>
  			</td>
  			</c:if>
  			</c:if>
  			</tr>
  			<c:if test="${not empty user}">
  			<c:if test="${user.role == 'RegisteredUser' || user.role == 'Moderator' || user.role == 'Admin'  }">
  			<tr>   
  			      <th colspan = "6" > <form align ="left" name="reportComment" method ="GET" action="SendReportServlet"> 
  			              <input class="reportButton" type="submit" name="reportCommentButton" value="Report"></input>
  			              <input type="hidden" name="name" value="${comment.id}"></input>
  			              <input type="hidden" name="author" value="${comment.author}"></input>
  			              <input type="hidden" name="reporter" value="${user.username}"></input>
  			           </form>
  			           
  			           
  			           
  			           <form name="likeComment" method ="POST" action="LikeDislikeCommentServlet"> 
  			                  <input type="hidden" name="like" value="${comment.positiveVotes}"></input>
    			              <input type="hidden" name="dislike" value="${comment.negativeVotes}"></input>   
    			              <input type="hidden" name="commentid" value="${comment.id}"></input>       
  			                 <input class="likeButton" type="submit" name="likeButton" value="Like"></input>
  			              
  			           </form>
  			           <form  name="dislikeComment" method ="POST" action="LikeDislikeCommentServlet"> 
  			                  <input type="hidden" name="like" value="${comment.positiveVotes}"></input>
    			              <input type="hidden" name="dislike" value="${comment.negativeVotes}"></input>   
    			              <input type="hidden" name="commentid" value="${comment.id}"></input>       
  			                 <input class="dislikeButton" type="submit" name="dislikeButton" value="Dislike"></input>
  			              
  			           </form>
  			           <form align = "right" name="replyComment" method ="GET" action="ReplyCommentServlet"> 
  			                  <input type="hidden" name="topic" value="${idtopic.title}"></input>
    			              <input type="hidden" name="author" value="${user.username}"></input>   
    			              <input type="hidden" name="parentid" value="${comment.id}"></input>       
  			                 <input class="replyButton" type="submit" name="replyButton" value="Reply"></input>
  			              
  			           </form>
  			           </th>
  			 </tr>
  			 </c:if>
  		     </c:if>
	     
  			 <%-- 
  			 <tr>
  			 <c:forEach items="${comments}" var="parentcomm">
  			 <c:if test="${parentcomm.parent != 0}">
  			   <c:if test="${parentcomm.parent eq comment.id}">
  			     <tr><td><textarea readonly cols="50" rows="5">${parentcomm.text}</textarea><br></td></tr>
  			  
  			  
  			  
  			    </c:if>
  			  
  			 
  			 </c:if>
  			 </c:forEach>
  		</tr>
  			 --%>
  			 
  			  <tr><td colspan="6" align="right">
  			<c:forEach items="${comments}" var="parentcomm">
  			 <c:if test="${parentcomm.parent != 0}">
  			   <c:if test="${parentcomm.parent eq comment.id}">
	  	 	 <table class = "replyTable" border="1">
			  
				<tr>
				
				<td align="center">${parentcomm.author}<br> ${parentcomm.date} <br>
				<c:if test="${not empty user}">
				<c:if test="${user.role == 'RegisteredUser' || user.role == 'Moderator' || user.role == 'Admin'  }">	
				    <form name="sendMessage" method = "GET" action="AddNewMessageServlet">
	    			<input type="submit" name="openButton" value="Send Message"></input>
	    			<input type="hidden" name="receiver" value="${parentcomm.author}"></input>
	    			<input type="hidden" name="sender" value="${user.username}"></input>
	                </form> </c:if></c:if> </td>
				
				<td align="center"><textarea readonly>${parentcomm.text}</textarea></td>
				<td align="center">${parentcomm.positiveVotes}</td>
				<td align="center">${parentcomm.negativeVotes}</td>
				<td align="center">${parentcomm.edited}</td>
            
		  			
		  			
		         </tr>
		  		 
		  		 
		  		 <c:if test="${not empty user}">
  			<c:if test="${user.role == 'RegisteredUser' || user.role == 'Moderator' || user.role == 'Admin'  }">
  			<tr>   
  			      <th colspan = "6" > <form align ="left" name="reportComment" method ="GET" action="SendReportServlet"> 
  			              <input class="reportButton" type="submit" name="reportCommentButton" value="Report"></input>
  			              <input type="hidden" name="name" value="${parentcomm.id}"></input>
  			              <input type="hidden" name="author" value="${parentcomm.author}"></input>
  			              <input type="hidden" name="reporter" value="${user.username}"></input>
  			           </form>
  			           
  			           
  			           
  			           <form name="likeComment" method ="POST" action="LikeDislikeCommentServlet"> 
  			                  <input type="hidden" name="like" value="${parentcomm.positiveVotes}"></input>
    			              <input type="hidden" name="dislike" value="${parentcomm.negativeVotes}"></input>   
    			              <input type="hidden" name="commentid" value="${parentcomm.id}"></input>       
  			                 <input class="likeButton" type="submit" name="likeButton" value="Like"></input>
  			              
  			           </form>
  			           <form  name="dislikeComment" method ="POST" action="LikeDislikeCommentServlet"> 
  			                  <input type="hidden" name="like" value="${parentcomm.positiveVotes}"></input>
    			              <input type="hidden" name="dislike" value="${parentcomm.negativeVotes}"></input>   
    			              <input type="hidden" name="commentid" value="${parentcomm.id}"></input>       
  			                 <input class="dislikeButton" type="submit" name="dislikeButton" value="Dislike"></input>
  			              
  			           </form>
  			           <form align = "right" name="replyComment" method ="GET" action="ReplyCommentServlet"> 
  			                  <input type="hidden" name="topic" value="${idtopic.title}"></input>
    			              <input type="hidden" name="author" value="${user.username}"></input>   
    			              <input type="hidden" name="parentid" value="${parentcomm.id}"></input>       
  			                 <input class="replyButton" type="submit" name="replyButton" value="Reply"></input>
  			              
  			           </form>
  			           </th>
  			 </tr>
  			 </c:if>
  		     </c:if>
		  		  
		  	</table>
		  	</c:if>
  	      </c:if>
  	      </c:forEach>
		   
	  </td></tr>
	
  		
  	  </c:if>
   </c:forEach> 
	 
</table>
<c:if test="${not empty user}">
<c:if test="${user.role == 'RegisteredUser' || user.role == 'Moderator' || user.role == 'Admin'  }">
<form name="addComment" method = "GET" action="AddNewCommentServlet">
    			<input type="submit" name="openButton" value="Add New Comment"></input>
    			<input type="hidden" name="topic" value="${idtopic.title}"></input>
    			<input type="hidden" name="author" value="${user.username}"></input>
</form>
</c:if>
</c:if>


</body>
</html>