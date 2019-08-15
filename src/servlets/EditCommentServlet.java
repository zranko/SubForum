package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repo.CommentsRepo;
import entities.Comment;

public class EditCommentServlet extends HttpServlet {

	public EditCommentServlet() {
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 String commentid = request.getParameter("commentid");
		 String topic = request.getParameter("topic");
		 String author = request.getParameter("author");
		 String date = request.getParameter("date");
		 request.setAttribute("commentid", commentid);
		 request.setAttribute("topic", topic);
		 request.setAttribute("author", author);
		 request.setAttribute("date", date);
		 RequestDispatcher rd = request.getRequestDispatcher("editComment.jsp");
	     rd.forward(request, response);
		**/
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getParameter("editButton") != null){
			 String commentid = request.getParameter("commentid");
			 String topic = request.getParameter("topic");
			 String author = request.getParameter("author");
			 String date = request.getParameter("date");
			 String likes = request.getParameter("likes");
			 String dislikes= request.getParameter("dislikes");
			 request.setAttribute("commentid", commentid);
			 request.setAttribute("topic", topic);
			 request.setAttribute("author", author);
			 request.setAttribute("date", date);
			 request.setAttribute("likes", likes);
			 request.setAttribute("dislikes", dislikes);
			 
			 RequestDispatcher rd = request.getRequestDispatcher("editComment.jsp");
		     rd.forward(request, response);
			
			
		}else if(request.getParameter("edit") != null){
		//String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
			String path = getServletContext().getRealPath("");
		String id1 = request.getParameter("commentid");
		int id = Integer.parseInt(id1);
		String topic = request.getParameter("topic");
		String author = request.getParameter("author");
		String date = request.getParameter("date");
		String likes = request.getParameter("likes");
		String dislikes= request.getParameter("dislikes");
		//String parent1 = request.getParameter("parent");
		//int parent = Integer.parseInt(parent1);
		int parent = 0;
		String text = request.getParameter("text");
		int positiveVotes = Integer.parseInt(likes);
		int negativeVotes = Integer.parseInt(dislikes);
		boolean edited = true;
		
		Comment comment = new Comment(id,topic,author,date,parent,text,positiveVotes,negativeVotes,edited);
		
		CommentsRepo cr = new CommentsRepo();
		cr.editComment(id,comment,path);
		
		
		HttpSession session = request.getSession();
		ArrayList<Comment> comments;
		comments = cr.getComments(path);
		session.setAttribute("comments", comments);
		RequestDispatcher rd = request.getRequestDispatcher("Comments.jsp");
		rd.forward(request, response);
		//response.sendRedirect("Comments.jsp");
		
		}
		
		
	}
	

}
