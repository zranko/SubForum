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
import entities.Message;
import entities.Topic;



public class DeleteMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id1 = request.getParameter("id");
		int id = Integer.parseInt(id1);
		String path = getServletContext().getRealPath("");
		
		MessageRepo tr = new MessageRepo();
		tr.deleteMessage(id, path);
		
		HttpSession session = request.getSession();
		ArrayList<Message> messages;
		messages = tr.getMessages(path);
		session.setAttribute("messages", messages);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
