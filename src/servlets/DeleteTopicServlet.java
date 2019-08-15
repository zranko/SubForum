package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Topic;
import repo.TopicRepo;

public class DeleteTopicServlet extends HttpServlet {

	public DeleteTopicServlet() {
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
		String title = request.getParameter("title");
		String path = getServletContext().getRealPath("");
		
		TopicRepo tr = new TopicRepo();
		tr.deleteTopic(title, path);
		
		HttpSession session = request.getSession();
		ArrayList<Topic> topics;
		topics = tr.getTopics(path);
		session.setAttribute("topics", topics);
		RequestDispatcher rd = request.getRequestDispatcher("Topics.jsp");
		rd.forward(request, response);
		//response.sendRedirect("Topics.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
		String title = request.getParameter("title");
		//String path = getServletContext().getRealPath("");
		
		TopicRepo tr = new TopicRepo();
		tr.deleteTopic(title, path);
		
		HttpSession session = request.getSession();
		ArrayList<Topic> topics;
		topics = tr.getTopics(path);
		session.setAttribute("topics", topics);
		RequestDispatcher rd = request.getRequestDispatcher("Topics.jsp");
		rd.forward(request, response);
		//response.sendRedirect("Topics.jsp");
		**/
	}

}
