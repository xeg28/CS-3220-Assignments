package hw1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hw1.model.Vaccine;
import hw1.utilities.ServletUtilities;

/**
 * Servlet implementation class NewDoses
 */
@WebServlet("/NewDoses")
public class NewDoses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewDoses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StringBuilder html = new StringBuilder();
		
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        List<Vaccine> vaccines = ServletUtilities.getGuestBookEntresFromServletContext(getServletContext());
        Vaccine VaccineChosen;
        
        html.append("<form action='NewDoses' method='post'>");
        html.append("<table border='1' cellpadding='5' cellspacing='2'>");
       
        html.append("<tr>");
        html.append("<th>Vaccines</th>");
        html.append("<td><select name='id' value=''>");
        for(Vaccine vaccine : vaccines) {
        	html.append("<option value='"+vaccine.getId()+"'>"+vaccine.getName()+"</option>");
        }
        html.append("</select></tr>");
        
        html.append("<tr>");
        html.append("<th>Doses Received</th>");
        html.append("<td><input type='text' name='dosesReceived' value=''></td>");
        html.append("</tr>");
        
        html.append("<tr>");
        html.append("<td colspan='2' scope='row'><button type='submit'>Add</button></td>");
        html.append("</tr></table></form>");
        
        out.println(ServletUtilities.titleWithBody("New Doses", html.toString()));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Vaccine> vaccines = ServletUtilities.getGuestBookEntresFromServletContext(getServletContext());
		int id = Integer.valueOf(request.getParameter("id"));
		int doses = Integer.valueOf(request.getParameter("dosesReceived"));
		Vaccine vaccine = ServletUtilities.getVaccine(vaccines, id);
		
		vaccine.addNewDoses(doses);
		response.sendRedirect("ListVaccines");
	}

}
