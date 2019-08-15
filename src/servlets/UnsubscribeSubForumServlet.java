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

import repo.TopicRepo;
import repo.UserRepo;
import entities.SubForum;
import entities.Topic;
import entities.User;



public class UnsubscribeSubForumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UnsubscribeSubForumServlet() {
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
	       String subforum = request.getParameter("subforum");
	       User user = (User) session.getAttribute("user");
	  
	       TopicRepo tr = new TopicRepo();
	      
	       
		   //ArrayList<Topic> topics = tr.getTopics(path);
	       ArrayList<SubForum> subs_subforums;
	       subs_subforums = user.getFollowedSubForumsList();
         for (int i = 0; i < subs_subforums.size(); i++) {
					if(subs_subforums.get(i).getName().equals(subforum)){
						 
	                     user.getFollowedSubForumsList().remove(subs_subforums.get(i));
	                     UserRepo ur = new UserRepo();
	                     ur.editUser(user, path);
	                     ArrayList<SubForum> subs_subforum;
	                     subs_subforum = user.getFollowedSubForumsList();
		               	 session.setAttribute("subs_subforums", subs_subforum);
			             //RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		                // rd.forward(request, response);
		               	 response.sendRedirect("index.jsp");
					}
			 }
		
	}

}
