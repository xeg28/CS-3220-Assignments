package lab09.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab09.model.Vaccine;
import lab09.utilities.ServletUtilities;

/**
 * Servlet implementation class NewDoses
 */
@WebServlet("/NewDoses")
public class NewDoses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewDoses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/NewDoses.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Vaccine> vaccines = ServletUtilities.getGuestBookEntresFromServletContext(getServletContext());
		int id = Integer.valueOf(request.getParameter("id"));
		int doses = Integer.valueOf(request.getParameter("dosesReceived"));
		Vaccine vaccine = ServletUtilities.getVaccine(vaccines, id);
		
		vaccine.addNewDoses(doses);
		response.sendRedirect("ListVaccines");
	}

}
