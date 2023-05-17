package hw2.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hw2.model.Patient;
import hw2.model.Vaccine;

/**
 * Servlet implementation class ManagementChoice
 */
@WebServlet(urlPatterns ="/ManagementChoice", loadOnStartup = 1)
public class ManagementChoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagementChoice() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		List<Vaccine> vaccines = new ArrayList<>();
		getServletContext().setAttribute( "vaccines" , vaccines );

		List<Patient> patients = new ArrayList<>();
		getServletContext().setAttribute( "patients" , patients );
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/ManagementChoice.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
