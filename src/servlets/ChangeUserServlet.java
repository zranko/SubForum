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

import entities.User;
import repo.UserRepo;



public class ChangeUserServlet extends HttpServlet {
	
    
    public ChangeUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
		String path = getServletContext().getRealPath("");
		HttpSession session = request.getSession();
		String username = request.getParameter("user");
		UserRepo ur = new UserRepo();
		ArrayList<User> list_users = ur.getUsers(path);
		if(request.getParameter("add") != null){
			
			
			for (int i = 0; i < list_users.size(); i++) {
				if(list_users.get(i).getUsername().equals(username)){
					User user = list_users.get(i);
					user.setRole("Moderator");
					ur.editUser(user, path);
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
			}
	  	}else if(request.getParameter("delete") != null){
			
			
			for (int k = 0; k < list_users.size(); k++) {
				if(list_users.get(k).getUsername().equals(username)){
					User user = list_users.get(k);
					user.setRole("RegisteredUser");
					ur.editUser(user, path);
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
			
		}
	}
	  	}

}
}
