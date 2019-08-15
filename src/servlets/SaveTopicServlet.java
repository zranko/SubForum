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
import repo.TopicRepo;
import repo.UserRepo;
import entities.SubForum;
import entities.Topic;
import entities.User;

public class SaveTopicServlet extends HttpServlet {
	
	public SaveTopicServlet() {
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 //  String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
		   String path = getServletContext().getRealPath("");
	       String topic_title =  request.getParameter("topic");
	       User user = (User) session.getAttribute("user");
	    //   user.getSavedTopicsList().add(topic);
	   //    SavedTopicRepo str = new SavedTopicRepo();
	 //      str.addSavedTopic(topic, path);
	       TopicRepo tr = new TopicRepo();
	      
	       
		   ArrayList<Topic> topics = tr.getTopics(path);
			 for (int i = 0; i < topics.size(); i++) {
					if(topics.get(i).getTitle().equals(topic_title)){
						 Topic topic = topics.get(i);
	                     user.getSavedTopicsList().add(topic);
	                     UserRepo ur = new UserRepo();
	                     ur.editUser(user, path);
	                     ArrayList<Topic> saved_topics;
	                     saved_topics = user.getSavedTopicsList();
		               	 session.setAttribute("stopics", saved_topics);
			             RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		               	 rd.forward(request, response);
		               //	 response.sendRedirect("index.jsp");
					}
			 }
	       
		
	}

	

}
