package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.SubForum;
import repo.SubForumRepo;

public class DeleteSubForumServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String path = getServletContext().getRealPath("");
		//String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
		String name = request.getParameter("name");
		
		SubForumRepo sfr = new SubForumRepo();
		sfr.deleteSubForum(name, path);
		
		HttpSession session = request.getSession();
		ArrayList<SubForum> subforums;
		subforums = sfr.getSubForums(path);
		session.setAttribute("subforums", subforums);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
	}

	public DeleteSubForumServlet() {
		// TODO Auto-generated constructor stub
	}

}
