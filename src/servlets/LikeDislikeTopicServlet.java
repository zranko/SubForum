package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repo.CommentsRepo;
import repo.TopicRepo;
import entities.Comment;
import entities.Topic;



public class LikeDislikeTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LikeDislikeTopicServlet() {
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
		String like1 = request.getParameter("like");
		String dislike1 = request.getParameter("dislike");
		int like = Integer.parseInt(like1);
		int dislike = Integer.parseInt(dislike1);
		String name = request.getParameter("name");
		if(request.getParameter("likeTopicButton") != null){
			TopicRepo tr = new TopicRepo();
			ArrayList<Topic> topics = tr.getTopics(path);
			for (int i = 0; i < topics.size(); i++) {
				if(topics.get(i).getTitle().equals(name)){
					Topic topic = topics.get(i);
					topic.setPositiveVotes(like+1);
					tr.editTopic(topic,path);
					
					topics = tr.getTopics(path);
				    session.setAttribute("topics",topics);
					//RequestDispatcher rd = request.getRequestDispatcher("Comments.jsp");
					//rd.forward(request, response);
				    response.sendRedirect("Topics.jsp");
				    return;
		}
		
	 }
	}else if(request.getParameter("dislikeTopicButton") != null){
		
		TopicRepo tr = new TopicRepo();
		ArrayList<Topic> topics = tr.getTopics(path);
		for (int i = 0; i < topics.size(); i++) {
			if(topics.get(i).getTitle().equals(name)){
				Topic topic = topics.get(i);
				topic.setNegativeVotes(dislike+1);
				tr.editTopic(topic,path);
				
				topics = tr.getTopics(path);
			    session.setAttribute("topics",topics);
				//RequestDispatcher rd = request.getRequestDispatcher("Comments.jsp");
				//rd.forward(request, response);
			    response.sendRedirect("Topics.jsp");
			    return;
	}
	
 }
	    
}
		
	}

}
