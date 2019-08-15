package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Message;
import entities.SubForum;
import entities.Topic;
import entities.User;
import repo.MessageRepo;
import repo.SavedTopicRepo;
import repo.UserRepo;


public class LoginServlet extends HttpServlet {
	
       
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
		String path = getServletContext().getRealPath("");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		UserRepo ur = new UserRepo();
		
		MessageRepo mr = new MessageRepo();
		HttpSession session = request.getSession();
		
		ArrayList<User> list_users = ur.getUsers(path);
		for (int i = 0; i < list_users.size(); i++) {
			if(list_users.get(i).getUsername().equals(username)){
				if(list_users.get(i).getPassword().equals(password)){
				User user = list_users.get(i);
				ArrayList<SubForum> subs_subforums = user.getFollowedSubForumsList();
				session.setAttribute("subs_subforums", subs_subforums);
				
				ArrayList<Topic> stopics = user.getSavedTopicsList();
				session.setAttribute("stopics", stopics);
				
				ArrayList<Message> saved_messages = user.getSavedMessagesList();
				session.setAttribute("saved_messages", saved_messages);
				
				session.setAttribute("user", user);
				//RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				//rd.forward(request, response);
				response.sendRedirect("index.jsp");
			    return;
		
		
		
		
	     }else {
	    	 response.sendRedirect("LogIn.jsp");
	    	 return;
	     }
		
			
			
			
			
			}
			}
		
	}

}
