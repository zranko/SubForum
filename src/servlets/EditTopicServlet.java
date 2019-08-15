package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repo.TopicRepo;
import entities.Topic;

public class EditTopicServlet extends HttpServlet {

	public EditTopicServlet() {
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String subforum = request.getParameter("subforum");
	     String author = request.getParameter("author");
	     String topic = request.getParameter("topic");
	     String date = request.getParameter("date");
		 request.setAttribute("topic", topic);
		 request.setAttribute("author", author );
		 request.setAttribute("subforum", subforum);
		 request.setAttribute("date", date);
		 RequestDispatcher rd = request.getRequestDispatcher("editTopic.jsp");
	     rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path = getServletContext().getRealPath("");
		//String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
		String subforum = request.getParameter("subforum");
		String title = request.getParameter("topic");
		String author = request.getParameter("author");
		String type = request.getParameter("type");
		String date = request.getParameter("date");
		String content = request.getParameter("content");
		int negativeVotes = 0;
		int positiveVotes = 0;
		
		Topic topic = new Topic(subforum, title, type, author,date, content,positiveVotes, negativeVotes);
		
		TopicRepo tr = new TopicRepo();
		tr.editTopic(topic, path);
		
	
		HttpSession session = request.getSession();
		ArrayList<Topic> topics;
		topics = tr.getTopics(path);
		session.setAttribute("topics", topics);
	//	RequestDispatcher rd = request.getRequestDispatcher("Topics.jsp");
	//	rd.forward(request, response);
		response.sendRedirect("Topics.jsp");
		
		    
		
	}

}
