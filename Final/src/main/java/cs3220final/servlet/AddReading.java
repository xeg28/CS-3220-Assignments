package cs3220final.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220final.dbservice.ReadingDbService;
import cs3220final.dbservice.UserDbService;
import cs3220final.model.User;

/**
 * Servlet implementation class AddReading
 */
@WebServlet("/AddReading")
public class AddReading extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReading() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userId = Integer.valueOf(request.getParameter("userId"));
		int systolic = Integer.valueOf(request.getParameter("systolic"));
		int diastolic = Integer.valueOf(request.getParameter("diastolic"));
		
		ReadingDbService readingDbService = new ReadingDbService();
		UserDbService userDbService = new UserDbService();
		
		readingDbService.addReading(userId, systolic, diastolic);
		request.getSession().setAttribute("userId", userId);
		
		response.sendRedirect("ListReadings");
		
		
	}

}
