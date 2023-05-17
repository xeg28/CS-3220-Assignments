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

		request.getRequestDispatcher("/WEB-INF/hw3/NewVaccine.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VaccineDbService vaccineDbService = new VaccineDbService();
		String name = request.getParameter("name");
		Vaccine vaccine;
		
		int dosesRequired = Integer.valueOf(request.getParameter("doses"));
		int daysBetweenDoses = (dosesRequired == 1) ?  0 : Integer.valueOf(request.getParameter("daysBetween"));
		vaccineDbService.addVaccine(name, dosesRequired, daysBetweenDoses);
		
		response.sendRedirect("ListVaccines");
		
	}

}
