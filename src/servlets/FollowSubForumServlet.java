package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import repo.SavedTopicRepo;
import repo.SubForumRepo;
import repo.UserRepo;
import entities.SubForum;
import entities.Topic;
import entities.User;

public class FollowSubForumServlet extends HttpServlet {
	
	

	public FollowSubForumServlet() {
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	       HttpSession session = request.getSession();
	 	  // String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
	       String path = getServletContext().getRealPath("");
	       String subforum_name = request.getParameter("subforum");
	       User user = (User) session.getAttribute("user");
	       SubForumRepo sfr = new SubForumRepo();
	       
		   ArrayList<SubForum> subforums = sfr.getSubForums(path);
			 for (int i = 0; i < subforums.size(); i++) {
					if(subforums.get(i).getName().equals(subforum_name)){
						SubForum subforum = subforums.get(i);
	                     user.getFollowedSubForumsList().add(subforum);
	                     UserRepo ur = new UserRepo();
	                     ur.editUser(user, path);
	                   
	        
			            ArrayList<SubForum> subs_subforums;
			            subs_subforums = user.getFollowedSubForumsList();
			            session.setAttribute("subs_subforums", subs_subforums);
			            //RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			            //rd.forward(request, response);
			            response.sendRedirect("index.jsp");
	       
					}
			 }
		
		
	}

}
