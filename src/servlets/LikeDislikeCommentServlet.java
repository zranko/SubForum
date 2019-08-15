package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Comment;
import entities.User;
import repo.CommentsRepo;



public class LikeDislikeCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LikeDislikeCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		//String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
		String path = getServletContext().getRealPath("");
		String like1 = request.getParameter("like");
		String dislike1 = request.getParameter("dislike");
		int like = Integer.parseInt(like1);
		int dislike = Integer.parseInt(dislike1);
		String id1 = request.getParameter("commentid");
		int id = Integer.parseInt(id1);
		if(request.getParameter("likeButton") != null){
			CommentsRepo cr = new CommentsRepo();
			ArrayList<Comment> comments = cr.getComments(path);
			like = like+1;
			for (int i = 0; i < comments.size(); i++) {
				if(comments.get(i).getId() == id){
					Comment comment = comments.get(i);
					comment.setPositiveVotes(like);
					cr.editComment(id, comment, path);
					
				    comments = cr.getComments(path);
				    session.setAttribute("comments",comments);
					//RequestDispatcher rd = request.getRequestDispatcher("Comments.jsp");
					//rd.forward(request, response);
				    response.sendRedirect("Comments.jsp");
				    return;
		}
		
	 }
	}else if(request.getParameter("dislikeButton") != null){
		
			CommentsRepo cr = new CommentsRepo();
			dislike = dislike+1;
			ArrayList<Comment> comments = cr.getComments(path);
			for (int i = 0; i < comments.size(); i++) {
				if(comments.get(i).getId() == id){
					Comment comment = comments.get(i);
					comment.setNegativeVotes(dislike);
					cr.editComment(id, comment, path);
					
				    comments = cr.getComments(path);
				    session.setAttribute("comments",comments);
					//RequestDispatcher rd = request.getRequestDispatcher("Comments.jsp");
					//rd.forward(request, response);
				    response.sendRedirect("Comments.jsp");
				    return;
		}
		
	 }
		    
	}
	}
	
}
