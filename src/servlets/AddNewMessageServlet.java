package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repo.MessageRepo;
import entities.Message;
import entities.SubForum;

public class AddNewMessageServlet extends HttpServlet {

	public AddNewMessageServlet() {
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String receiver = request.getParameter("receiver");
		 String sender = request.getParameter("sender");
		 System.out.print(receiver+" "+ sender);
		 request.setAttribute("receiver", receiver);
		 request.setAttribute("sender", sender);
		 RequestDispatcher rd = request.getRequestDispatcher("sendMessage.jsp");
	     rd.forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = getServletContext().getRealPath("");
		//String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
		Random rand = new Random();
		int  id = rand.nextInt(5000) + 1;
		String sender = request.getParameter("sender");
		String receiver = request.getParameter("receiver");
		String text = request.getParameter("text");
		System.out.print(receiver+" "+ sender + " "+text);
		Boolean isRead = false;
		
		Message message = new Message(id,sender,receiver,text,isRead);
		
		MessageRepo mr = new MessageRepo();
		mr.addMesagge(message, path);
	
		HttpSession session = request.getSession();
		ArrayList<Message> messages;
		messages = mr.getMessages(path);
		session.setAttribute("messages", messages);
		//RequestDispatcher rd = request.getRequestDispatcher("Comments.jsp");
		//rd.forward(request, response);
		response.sendRedirect("Comments.jsp");
	
	}

	
}
