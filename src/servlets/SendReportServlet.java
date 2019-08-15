package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repo.ReportsRepo;
import entities.Report;
import entities.Topic;


public class SendReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SendReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
		if(request.getParameter("reportCommentButton") != null){
			String repcomment_id = request.getParameter("name");
			String author = request.getParameter("author");
			String reporter = request.getParameter("reporter");
			request.setAttribute("repcomment_id", repcomment_id);
			request.setAttribute("author", author);
			request.setAttribute("reporter", reporter);
			RequestDispatcher rd = request.getRequestDispatcher("sendReport.jsp");
		    rd.forward(request, response);
		}
		if(request.getParameter("reportTopicButton") != null){
			String reptopic_id = request.getParameter("name");
			String author = request.getParameter("author");
			String reporter = request.getParameter("reporter");
			request.setAttribute("reptopic_id", reptopic_id);
			request.setAttribute("author", author);
			request.setAttribute("reporter", reporter);
			RequestDispatcher rd = request.getRequestDispatcher("sendReport.jsp");
		    rd.forward(request, response);
		}
		if(request.getParameter("reportSubForumButton") != null){
			String repsubforum_id = request.getParameter("subforum");
			String author = request.getParameter("author");
			String reporter = request.getParameter("reporter");
			request.setAttribute("repsubforum_id", repsubforum_id);
			request.setAttribute("author", author);
			request.setAttribute("reporter", reporter);
			RequestDispatcher rd = request.getRequestDispatcher("sendReport.jsp");
		    rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
		    String path = getServletContext().getRealPath("");
		    String repcomment_id = request.getParameter("repcomment_id");
		    String reptopic_id = request.getParameter("reptopic_id");
		    String repsubforum_id = request.getParameter("repsubforum_id");
			String author = request.getParameter("author");
			String reporter = request.getParameter("reporter");
			String text = request.getParameter("text");
			SimpleDateFormat fmt = new SimpleDateFormat("MM-dd-yyyy HH:mm");
			Date dateNow = new Date();
			String date = fmt.format(dateNow);
			String subforum_id = "";
		    
			Report report = new Report(repsubforum_id, reptopic_id,repcomment_id, text, date, author,reporter );
		
			ReportsRepo rr =  new ReportsRepo();
			rr.addReport(report, path);
			
			HttpSession session = request.getSession();
			ArrayList<Report> reports;
			reports = rr.getReports(path);
			session.setAttribute("reports", reports);
			response.sendRedirect("Topics.jsp");
	}

}
