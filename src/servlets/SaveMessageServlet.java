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

import repo.MessageRepo;
import repo.TopicRepo;
import repo.UserRepo;
import entities.Message;
import entities.Topic;
import entities.User;



public class SaveMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SaveMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session = request.getSession();
		 //  String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
		   String path = getServletContext().getRealPath("");
	       String message_id =  request.getParameter("id");
	       int id = Integer.parseInt(message_id);
	       User user = (User) session.getAttribute("user");
	   
	       MessageRepo mr = new MessageRepo();
	      
	       
		   ArrayList<Message> messages = mr.getMessages(path);
			 for (int i = 0; i < messages.size(); i++) {
					if(messages.get(i).getId() == id){
						Message message = messages.get(i);
	                     user.getSavedMessagesList().add(message);
	                     UserRepo ur = new UserRepo();
	                     ur.editUser(user, path);
	                     ArrayList<Message> saved_messages;
	                     saved_messages = user.getSavedMessagesList();
		               	 session.setAttribute("saved_messages", saved_messages);
			             //RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		               	// rd.forward(request, response);
		               	 response.sendRedirect("index.jsp");
					}
			 }
	       
		
	}

}
