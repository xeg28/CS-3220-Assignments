package hw2.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;
import hw2.model.Patient;
import hw2.model.Vaccine;
import hw2.utilities.ServletUtilities;

/**
 * Servlet implementation class NewPatient
 */
@WebServlet("/NewPatient")
public class NewPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/NewPatient.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Patient> patients = ServletUtilities.getPatientsFromServletContext(getServletContext());
		List<Vaccine> vaccines = ServletUtilities.getVaccinesFromServletContext(getServletContext());
		String name = request.getParameter("patient");
		Vaccine vaccine = ServletUtilities.getVaccineByID(vaccines, Integer.parseInt(request.getParameter("vaccine")));
		vaccine.useDose();
		Date firstDose = new Date();
		
		
		Patient patient = new Patient(name, vaccine, firstDose);
		patients.add(patient);
		
		response.sendRedirect("ListPatients");
		
	}

}
