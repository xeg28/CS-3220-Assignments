package hw2.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hw2.model.Patient;
import hw2.model.Vaccine;
import hw2.utilities.ServletUtilities;

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
		List<Patient> patients = ServletUtilities.getPatientsFromServletContext(getServletContext());
		int patientID = Integer.parseInt(request.getParameter("id"));
		Date secondDose = new Date();
		
		Patient patient = ServletUtilities.getPatientByID(patients, patientID);
		
		patient.setSecondDose(secondDose);
		patient.getVaccine().useDose();
		
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
