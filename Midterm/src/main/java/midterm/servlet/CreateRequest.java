package midterm.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import midterm.model.Request;
import midterm.utilities.ServletUtilities;

/**
 * Servlet implementation class CreateRequest
 */
@WebServlet("/CreateRequest")
public class CreateRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/CreateRequest.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Request> requests = ServletUtilities.getRequestsFromServletContext(getServletContext());
		Date scheduledTime = new Date();
		String scheduledFor = request.getParameter("name");
		String department = request.getParameter("department");
		String status = "created";
		String reason = request.getParameter("description");
		
		Request newRequest = new Request(scheduledTime, scheduledFor, department, status, reason);
		
		requests.add(newRequest);
		
		response.sendRedirect("ListRequests");
	}

}
