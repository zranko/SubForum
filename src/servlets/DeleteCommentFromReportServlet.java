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

import repo.CommentsRepo;
import repo.SubForumRepo;
import repo.TopicRepo;
import entities.Comment;
import entities.SubForum;
import entities.Topic;


public class DeleteCommentFromReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteCommentFromReportServlet() {
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
		String comment_id = request.getParameter("comment_id");
		String topic_id = request.getParameter("topic_id");
		String subforum_id = request.getParameter("subforum_id");
		String sender = request.getParameter("sender");
		String receiver = request.getParameter("receiver");
		String report_receiver = request.getParameter("report_receiver");
		String text_for_author = request.getParameter("text_for_author");
		String text_for_reporter = request.getParameter("text_for_reporter");
		
		
	
		//System.out.print(report_receiver+" "+ sender + " "+text);
		if(comment_id != ""){
		CommentsRepo cr = new CommentsRepo();
		int comm_id = Integer.parseInt(comment_id);
		cr.deleteComment(comm_id, path);
		
		
		ArrayList<Comment> comments;
		comments = cr.getComments(path);
		session.setAttribute("comments", comments);
		}
		if(topic_id != ""){
			TopicRepo tr = new TopicRepo();
			
			tr.deleteTopic(topic_id, path);
			
			
			ArrayList<Topic> topics;
			topics = tr.getTopics(path);
			session.setAttribute("topics", topics);
			}
		if(subforum_id != ""){
			SubForumRepo sfr = new SubForumRepo();
			
			sfr.deleteSubForum(subforum_id, path);
			
			
			ArrayList<SubForum> subforums;
			subforums = sfr.getSubForums(path);
			session.setAttribute("subforums", subforums);
			}
		request.setAttribute("sender", sender);
		request.setAttribute("receiver", receiver);
		request.setAttribute("report_receiver", report_receiver);
		request.setAttribute("text_for_author", text_for_author);
		request.setAttribute("text_for_reporter", text_for_reporter);
		request.setAttribute("comment_id", comment_id);
		request.setAttribute("topic_id", topic_id);
		request.setAttribute("subforum_id", subforum_id);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("SendAlertToAuthorServlet");
		rd.forward(request, response);
	}

}
