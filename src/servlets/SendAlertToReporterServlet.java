package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repo.MessageRepo;
import repo.ReportsRepo;
import entities.Message;
import entities.Report;



public class SendAlertToReporterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SendAlertToReporterServlet() {
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
		String receiver = request.getParameter("report_receiver");
		String text_for_author = request.getParameter("text_for_author");
		String text_for_reporter = request.getParameter("text_for_reporter");
		String comment_id = request.getParameter("comment_id");
		String topic_id = request.getParameter("topic_id");
		String subforum_id = request.getParameter("subforum_id");
		System.out.print(receiver+" "+ sender + " "+text_for_reporter);
		Boolean isRead = false;
		
		Message message = new Message(id,sender,receiver,text_for_reporter,isRead);
		
		MessageRepo mr = new MessageRepo();
		mr.addMesagge(message, path);
		
		ReportsRepo rp = new ReportsRepo();
		if(comment_id != null){
			rp.deleteReport(comment_id, path);
		}else if(topic_id != null){
			rp.deleteReport(topic_id, path);
			
		}else if(subforum_id != null){
			
			rp.deleteReport(subforum_id, path);
		}
		ArrayList<Report> reports;
		reports = rp.getReports(path);
		HttpSession session = request.getSession();
		ArrayList<Message> messages;
		messages = mr.getMessages(path);
		session.setAttribute("messages", messages);
		session.setAttribute("reports", reports);
		
		//RequestDispatcher rd = request.getRequestDispatcher("Comments.jsp");
		//rd.forward(request, response);
		response.sendRedirect("index.jsp");
		
	}

}
