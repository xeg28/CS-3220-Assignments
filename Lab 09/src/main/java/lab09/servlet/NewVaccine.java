package lab09.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import lab09.model.Vaccine;
import lab09.utilities.ServletUtilities;

/**
 * Servlet implementation class NewVaccine
 */
@WebServlet("/NewVaccine")
public class NewVaccine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewVaccine() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.getRequestDispatcher("/WEB-INF/NewVaccine.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Vaccine> vaccines = ServletUtilities.getGuestBookEntresFromServletContext(getServletContext());
		String name = request.getParameter("name");
		Vaccine vaccine;
		
		int dosesRequired = Integer.valueOf(request.getParameter("doses"));
		
		if(dosesRequired == 1) {
			vaccine = new Vaccine(name, dosesRequired);
			vaccines.add(vaccine);
			response.sendRedirect("ListVaccines");
			return;
		}
		
		int daysBetweenDoses = Integer.valueOf(request.getParameter("daysBetween"));;
		vaccine = new Vaccine(name, dosesRequired, daysBetweenDoses);
	
		vaccines.add(vaccine);
		
		response.sendRedirect("ListVaccines");
		
	}

}
