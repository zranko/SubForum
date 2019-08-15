package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repo.SavedTopicRepo;
import repo.TopicRepo;
import repo.UserRepo;
import entities.Topic;
import entities.User;



public class DeleteSavedTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DeleteSavedTopicServlet() {
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
	       String topic_title = request.getParameter("title");
	       User user = (User) session.getAttribute("user");
	    //   user.getSavedTopicsList().add(topic);
	   //    SavedTopicRepo str = new SavedTopicRepo();
	 //      str.addSavedTopic(topic, path);
	       TopicRepo tr = new TopicRepo();
	      
	       
		   //ArrayList<Topic> topics = tr.getTopics(path);
	       ArrayList<Topic> saved_topics;
           saved_topics = user.getSavedTopicsList();
           for (int i = 0; i < saved_topics.size(); i++) {
					if(saved_topics.get(i).getTitle().equals(topic_title)){
						 
	                     user.getSavedTopicsList().remove(saved_topics.get(i));
	                     UserRepo ur = new UserRepo();
	                     ur.editUser(user, path);
	                     ArrayList<Topic> saved_topic;
	                     saved_topic = user.getSavedTopicsList();
		               	 session.setAttribute("stopics", saved_topic);
			             RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		                 rd.forward(request, response);
		               	 //response.sendRedirect("index.jsp");
					}
			 }
		
		
	}

}
