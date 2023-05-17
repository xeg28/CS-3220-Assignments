package hw3.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import hw3.model.Vaccine;
import hw3.service.VaccineDbService;
import hw3.utilities.ServletUtilities;

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
		VaccineDbService vaccineDbService = new VaccineDbService();
		

		Vaccine vaccine = vaccineDbService.getVaccine(Integer.valueOf(request.getParameter("id")));
		
        request.setAttribute("vaccine", vaccine);
        vaccineDbService.close();
        request.getRequestDispatcher("/WEB-INF/hw3/EditVaccine.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VaccineDbService vaccineDbService = new VaccineDbService();
		String name = request.getParameter("name");
		int id = Integer.valueOf(request.getParameter("id"));
		
		int dosesRequired = Integer.valueOf(request.getParameter("doses"));
		
		int daysBetweenDoses = (dosesRequired == 1) ? 0 : Integer.valueOf(request.getParameter("daysBetween"));
		
		vaccineDbService.updateVaccine(id, name, dosesRequired, daysBetweenDoses);
		vaccineDbService.close();
		
		response.sendRedirect("ListVaccines");
		
	}

}
