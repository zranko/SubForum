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

import repo.SubForumRepo;
import entities.SubForum;


public class OpenSubForumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OpenSubForumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String subforum_name = request.getParameter("subforum");
		// String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
		String path = getServletContext().getRealPath("");
		 SubForumRepo sfr = new SubForumRepo();
		 ArrayList<SubForum> subforums = sfr.getSubForums(path);
		 HttpSession session = request.getSession();
		 for (int i = 0; i < subforums.size(); i++) {
				if(subforums.get(i).getName().equals(subforum_name)){
					SubForum subforum = subforums.get(i);
					
					session.setAttribute("idsubforum", subforum);
					//RequestDispatcher rd = request.getRequestDispatcher("Topics.jsp");
				    //rd.forward(request, response);
					response.sendRedirect("Topics.jsp");
				}
		 }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		String subforum_name = request.getParameter("subforum");
		 String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
		 SubForumRepo sfr = new SubForumRepo();
		 ArrayList<SubForum> subforums = sfr.getSubForums(path);
		 HttpSession session = request.getSession();
		 for (int i = 0; i < subforums.size(); i++) {
				if(subforums.get(i).getName().equals(subforum_name)){
					SubForum subforum = subforums.get(i);
					
					session.setAttribute("idsubforum", subforum);
					RequestDispatcher rd = request.getRequestDispatcher("Topics.jsp");
				    rd.forward(request, response);
				}
		 }
	
	**/
	}

}
