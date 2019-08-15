package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repo.MessageRepo;
import entities.Message;


public class SendAlertToAuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SendAlertToAuthorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = getServletContext().getRealPath("");
		//String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
		Random rand = new Random();
		int  id = rand.nextInt(5000) + 1;
		String sender = request.getParameter("sender");
		String receiver = request.getParameter("receiver");
		String report_receiver = request.getParameter("report_receiver");
		String text_for_author = request.getParameter("text_for_author");
		String text_for_reporter = request.getParameter("text_for_reporter");
		String comment_id = request.getParameter("comment_id");
		String topic_id = request.getParameter("topic_id");
		String subforum_id = request.getParameter("subforum_id");
		System.out.print(report_receiver+" "+ sender + " "+text_for_author);
		Boolean isRead = false;
		
		Message message = new Message(id,sender,receiver,text_for_author,isRead);
		
		MessageRepo mr = new MessageRepo();
		mr.addMesagge(message, path);
	
		HttpSession session = request.getSession();
		ArrayList<Message> messages;
		messages = mr.getMessages(path);
		session.setAttribute("messages", messages);
		request.setAttribute("sender", sender);
		request.setAttribute("report_receiver", report_receiver);
		request.setAttribute("text_for_author", text_for_author);
		request.setAttribute("text_for_reporter", text_for_reporter);
		request.setAttribute("comment_id", comment_id);
		request.setAttribute("topic_id", topic_id);
		request.setAttribute("subforum_id", subforum_id);
		
		RequestDispatcher rd = request.getRequestDispatcher("SendAlertToReporterServlet");
		rd.forward(request, response);
		//response.sendRedirect("index.jsp");
		
	}

}
