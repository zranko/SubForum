package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Comment;
import repo.CommentsRepo;

public class DeleteCommentServlet extends HttpServlet {

	public DeleteCommentServlet() {
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = getServletContext().getRealPath("");
		//String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
		String id1 = request.getParameter("id");
		int id = Integer.parseInt(id1);
		
		CommentsRepo cr = new CommentsRepo();
		
		cr.deleteComment(id, path);
		
		HttpSession session = request.getSession();
		ArrayList<Comment> comments;
		comments = cr.getComments(path);
		session.setAttribute("comments", comments);
		RequestDispatcher rd = request.getRequestDispatcher("Comments.jsp");
		rd.forward(request, response);
		
		//response.sendRedirect("comments");
		
		
	}

}
