package midterm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import midterm.model.Request;
import midterm.utilities.ServletUtilities;

/**
 * Servlet implementation class UpdateStatus
 */
@WebServlet("/UpdateStatus")
public class UpdateStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String status = request.getParameter("status");
		List<Request> requests = ServletUtilities.getRequestsFromServletContext(getServletContext());
		Request currRequest = ServletUtilities.getRequest(requests, Integer.parseInt(request.getParameter("id")));
		
		if(status != null) {
			currRequest.setStatus(status);
			response.sendRedirect("ListRequests");
			return;
		}
		
		request.setAttribute("request", currRequest);
		request.getRequestDispatcher("/WEB-INF/UpdateStatus.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		String status = "Assigned";
		String assignedTo = request.getParameter("technician");
		List<Request> requests = ServletUtilities.getRequestsFromServletContext(getServletContext());
		Request currRequest = ServletUtilities.getRequest(requests, Integer.parseInt(request.getParameter("id")));
		
		currRequest.setStatus(status);
		currRequest.setAssignedTo(assignedTo);
		
		response.sendRedirect("ListRequests");
	}

}
