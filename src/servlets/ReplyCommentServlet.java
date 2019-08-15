package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repo.CommentsRepo;
import entities.Comment;


public class ReplyCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReplyCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String topic = request.getParameter("topic");
		 String author = request.getParameter("author");
		 String parentid = request.getParameter("parentid");
		 request.setAttribute("comm_authorid", author);
		 request.setAttribute("idtopic", topic);
		 request.setAttribute("parentid", parentid);
		 RequestDispatcher rd = request.getRequestDispatcher("replyComment.jsp");
	     rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
		String path = getServletContext().getRealPath("");
		Random rand = new Random();
		int  id = rand.nextInt(5000) + 1;
		String topic = request.getParameter("topic");
		String author = request.getParameter("author");
		SimpleDateFormat fmt = new SimpleDateFormat("MM-dd-yyyy HH:mm");
		Date dateNow = new Date();
		String date = fmt.format(dateNow);
		//String parent1 = request.getParameter("parent");
		//int parent = Integer.parseInt(parent1);
		String parentid = request.getParameter("parentid");
		int parent = Integer.parseInt(parentid);
		String text = request.getParameter("text");
		int positiveVotes = 0;
		int negativeVotes = 0;
		boolean edited = false;
		
		Comment comment = new Comment(id,topic,author,date,parent,text,positiveVotes,negativeVotes,edited);
		
		CommentsRepo cr = new CommentsRepo();
		cr.addComment(comment,path);
		
		
		HttpSession session = request.getSession();
		ArrayList<Comment> comments;
		comments = cr.getComments(path);
		session.setAttribute("comments", comments);
		//RequestDispatcher rd = request.getRequestDispatcher("Comments.jsp");
		//rd.forward(request, response);
		response.sendRedirect("Comments.jsp");
	}

}
