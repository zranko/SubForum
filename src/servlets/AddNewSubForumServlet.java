package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
import entities.User;


public class AddNewSubForumServlet extends HttpServlet {

	public AddNewSubForumServlet() {
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = getServletContext().getRealPath("");
		//String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String rules = request.getParameter("rules");
		String icon = request.getParameter("icon");
		System.out.print(path);
		//User user = (User)request.getSession().getAttribute("user");

		//String mainModerator = user.getUsername();
		String user = request.getParameter("user");
		String mainModerator = request.getParameter("mainModerator");
		
		String[] moderators = request.getParameterValues("mods");
		
		
		
		SubForum subforum = new SubForum(name,description,rules,icon,mainModerator,moderators);
		SubForumRepo sfr = new SubForumRepo();
		sfr.addSubForum(subforum, path);
		
		HttpSession session = request.getSession();
		ArrayList<SubForum> subforums;
		subforums = sfr.getSubForums(path);
		System.out.print(subforums);
		session.setAttribute("subforums", subforums);
		//RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		//rd.forward(request, response);
		response.sendRedirect("index.jsp");
	}
	
}
