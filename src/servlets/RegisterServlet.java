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

import repo.UserRepo;
import entities.Message;
import entities.SubForum;
import entities.Topic;
import entities.User;
import entities.UserRole;

public class RegisterServlet extends HttpServlet {

	public RegisterServlet() {
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
		String path = getServletContext().getRealPath("");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String role = UserRole.RegisteredUser.name();
		SimpleDateFormat fmt = new SimpleDateFormat("MM-dd-yyyy HH:mm");
		Date dateNow = new Date();
		String date = fmt.format(dateNow);
	    ArrayList<SubForum> foll_subforums = new ArrayList<SubForum>();
	    ArrayList<Topic> savedtopics = new ArrayList<Topic>();
	    ArrayList<Message> savedmessages = new ArrayList<Message>();
		User user = new User(username,password,name,lastname,role,phone,email,date, foll_subforums,savedtopics,savedmessages);
		System.out.print(path);
		UserRepo ur = new UserRepo();
		ur.addUser(user, path);
		//ArrayList<User> users = ur.getUsers(path);
		HttpSession session = request.getSession();
		
		ArrayList<User> user_list = ur.getUsers(path);
	//	ArrayList<User> user_list = (ArrayList<User>) session.getAttribute("user_list");
	//    user_list.add(user);
	    session.setAttribute("user_list", user_list );
		session.setAttribute("user", user);
		
		//RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		//rd.forward(request, response);
		response.sendRedirect("index.jsp");
	}
	

}
