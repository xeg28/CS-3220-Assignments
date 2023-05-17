package hw3.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hw3.model.Patient;
import hw3.service.PatientDbService;

/**
 * Servlet implementation class ListPatients
 */
@WebServlet(urlPatterns = "/ListPatients", loadOnStartup = 1)
public class ListPatients extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPatients() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PatientDbService patientDbService = new PatientDbService();
		request.setAttribute("patients", patientDbService.getPatients());
		patientDbService.close();
		request.getRequestDispatcher("/WEB-INF/hw3/ListPatients.jsp")
		.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
