package hw3.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hw3.model.Patient;
import hw3.model.Vaccine;
import hw3.service.PatientDbService;
import hw3.service.VaccineDbService;

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
		VaccineDbService vaccineDbService = new VaccineDbService();
		request.setAttribute("vaccines", vaccineDbService.getVaccines());
		vaccineDbService.close();
		request.getRequestDispatcher("WEB-INF/hw3/NewPatient.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PatientDbService patientDbService = new PatientDbService();
		VaccineDbService vaccineDbService = new VaccineDbService();
		String name = request.getParameter("patient");
		int vaccineId = Integer.parseInt(request.getParameter("vaccine"));
		Date firstDose = new Date(new java.util.Date().getTime());
		Vaccine vaccine = vaccineDbService.getVaccine(vaccineId);
		
		patientDbService.addPatient(name, vaccineId, firstDose);
		
		vaccineDbService.useDose(vaccineId, vaccine.getTotalDosesLeft());
		
		patientDbService.close();
		vaccineDbService.close();
		
		response.sendRedirect("ListPatients");
		
	}

}
