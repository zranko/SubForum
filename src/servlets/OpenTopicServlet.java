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

import entities.Topic;
import repo.TopicRepo;






public class OpenTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OpenTopicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String topic_title = request.getParameter("title");
	    //String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
		String path = getServletContext().getRealPath("");
	    TopicRepo tr = new TopicRepo();
		ArrayList<Topic> topics = tr.getTopics(path);
		HttpSession session = request.getSession();
		 for (int i = 0; i < topics.size(); i++) {
				if(topics.get(i).getTitle().equals(topic_title)){
				   Topic topic = topics.get(i);
		           
		           session.setAttribute("idtopic", topic);
		          //response.sendRedirect("Comments.jsp");
		         // return;
		          RequestDispatcher rd = request.getRequestDispatcher("Comments.jsp");
				  rd.forward(request, response);
				}
	    
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String topic_title = request.getParameter("title");
		String path = getServletContext().getRealPath("");
	    //String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
	    TopicRepo tr = new TopicRepo();
		ArrayList<Topic> topics = tr.getTopics(path);
		HttpSession session = request.getSession();
		 for (int i = 0; i < topics.size(); i++) {
				if(topics.get(i).getTitle().equals(topic_title)){
				   Topic topic = topics.get(i);
		           
		           session.setAttribute("idtopic", topic);
		          //response.sendRedirect("Comments.jsp");
		         // return;
		          RequestDispatcher rd = request.getRequestDispatcher("Comments.jsp");
				  rd.forward(request, response);
				}
	    
		}
		
		
	 }
		 
	

}
