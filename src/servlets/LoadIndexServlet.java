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

import entities.Comment;
import entities.Message;
import entities.Report;
import entities.SubForum;
import entities.Topic;
import entities.User;
import repo.CommentsRepo;

import repo.MessageRepo;
import repo.ReportsRepo;
import repo.SavedTopicRepo;
import repo.SubForumRepo;
import repo.TopicRepo;
import repo.UserRepo;


public class LoadIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        //String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
    	String path = getServletContext().getRealPath("");
		SubForumRepo sfr = new SubForumRepo();
		TopicRepo tr = new TopicRepo();
		CommentsRepo cr = new CommentsRepo();
		MessageRepo mr = new MessageRepo();
		UserRepo ur = new UserRepo();
		ReportsRepo rr = new ReportsRepo();
		HttpSession session = request.getSession();
		
		ArrayList<User> user_list = ur.getUsers(path);
		session.setAttribute("user_list", user_list);
		
		ArrayList<SubForum> subforums = sfr.getSubForums(path);
		session.setAttribute("subforums",subforums);
		
		
		ArrayList<Topic> topics = tr.getTopics(path);
		session.setAttribute("topics",topics);
		
		ArrayList<Comment> comments = cr.getComments(path);
		session.setAttribute("comments",comments);
		
		ArrayList<Message> messages = mr.getMessages(path);
		session.setAttribute("messages",messages);
		
		ArrayList<Report> reports = rr.getReports(path);
		session.setAttribute("reports",reports);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
		
		SubForumRepo sfr = new SubForumRepo();
		TopicRepo tr = new TopicRepo();
		CommentsRepo cr = new CommentsRepo();
		
		HttpSession session = request.getSession();
		
		ArrayList<SubForum> subforums = sfr.getSubForums(path);
		session.setAttribute("subforums",subforums);
		
		ArrayList<Topic> topics = tr.getTopics(path);
		session.setAttribute("topics",topics);
		
		ArrayList<Comment> comments = cr.getComments(path);
		session.setAttribute("comments",comments);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
		
		*/
		
		
		
		
	}

}
