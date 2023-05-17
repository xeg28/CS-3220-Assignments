package hw2.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import hw2.model.Vaccine;
import hw2.utilities.ServletUtilities;

/**
 * Servlet implementation class NewVaccine
 */
@WebServlet("/EditVaccine")
public class EditVaccine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditVaccine() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Vaccine> vaccines = ServletUtilities.getVaccinesFromServletContext(getServletContext());

		Vaccine vaccine = ServletUtilities.getVaccine(vaccines, Integer.valueOf(request.getParameter("id")));
		
        request.setAttribute("vaccine", vaccine);
        request.getRequestDispatcher("/WEB-INF/EditVaccine.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Vaccine> vaccines = ServletUtilities.getVaccinesFromServletContext(getServletContext());
		String name = request.getParameter("name");
		Vaccine vaccine = ServletUtilities.getVaccine(vaccines, Integer.valueOf(request.getParameter("id")));
		
		int dosesRequired = Integer.valueOf(request.getParameter("doses"));
		
		if(dosesRequired == 1) {
			vaccine.setName(name);
			vaccine.setDosesRequired(dosesRequired);
			vaccine.setDaysBetweenDoses(0);
			response.sendRedirect("ListVaccines");
			return;
		}
		
		int daysBetweenDoses = Integer.valueOf(request.getParameter("daysBetween"));;
		vaccine.setName(name);
		vaccine.setDosesRequired(dosesRequired);
		vaccine.setDaysBetweenDoses(daysBetweenDoses);
	
		
		response.sendRedirect("ListVaccines");
		
	}

}
