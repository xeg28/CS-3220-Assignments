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
import hw3.utilities.ServletUtilities;

/**
 * Servlet implementation class ReceiveSecondDose
 */
@WebServlet("/ReceiveSecondDose")
public class ReceiveSecondDose extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiveSecondDose() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PatientDbService patientDbService = new PatientDbService();
		VaccineDbService vaccineDbService = new VaccineDbService();
		int patientID = Integer.parseInt(request.getParameter("id"));
		
		Date secondDose = new Date(new java.util.Date().getTime());
		Patient patient = patientDbService.getPatient(patientID);
		
		patientDbService.updatePatient(patientID, secondDose);
		vaccineDbService.useDose(patient.getVaccine().getId(), patient.getVaccine().getTotalDosesLeft());
		
		patientDbService.close();
		vaccineDbService.close();
		
		response.sendRedirect("ListPatients");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
