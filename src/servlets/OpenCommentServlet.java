package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class OpenCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OpenCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	/*	String topic_title = request.getParameter("topic");
	    String path = "C:/Users/Ranko/Desktop/WebProgramiranje/web-forum";
		//HttpSession session = request.getSession();
		request.setAttribute("idtopic", topic_title);
		RequestDispatcher rd = request.getRequestDispatcher("Comments.jsp");
	    rd.forward(request, response);
		*/
	}

}
