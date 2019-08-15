package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repo.SubForumRepo;
import repo.TopicRepo;
import entities.SubForum;
import entities.Topic;

public class AddNewTopicServlet extends HttpServlet {

	public AddNewTopicServlet() {
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	     String topic = request.getParameter("subforum");
	     String author = request.getParameter("author");
		 request.setAttribute("subforumid", topic);
		 request.setAttribute("authorid", author );
		 RequestDispatcher rd = request.getRequestDispatcher("addTopic.jsp");
	     rd.forward(request, response);
		 
		 
		 
		 
		 
		 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = getServletContext().getRealPath("");
		//String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
		String subforum = request.getParameter("subforum");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String type = request.getParameter("type");
		SimpleDateFormat fmt = new SimpleDateFormat("MM-dd-yyyy HH:mm");
		Date dateNow = new Date();
		String date = fmt.format(dateNow);
		String content = request.getParameter("content");
		int negativeVotes = 0;
		int positiveVotes = 0;
		boolean t=false;
		TopicRepo tr = new TopicRepo();
		
			
	
		
		
		
        Topic topic = new Topic(subforum, title, type, author,date, content,positiveVotes, negativeVotes);
		
		
		tr.addTopic(topic, path);
	
		HttpSession session = request.getSession();
		ArrayList<Topic> topics;
		topics = tr.getTopics(path);
		session.setAttribute("topics", topics);
	//	RequestDispatcher rd = request.getRequestDispatcher("Topics.jsp");
	//	rd.forward(request, response);
		response.sendRedirect("Topics.jsp");
		
		
	}
	
	

}
