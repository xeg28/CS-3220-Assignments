package hw1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import hw1.model.Vaccine;
import hw1.utilities.ServletUtilities;

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
		StringBuilder html = new StringBuilder();
		
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        
        html.append("<form action='NewVaccine' method='post'>");
        html.append("<table border='1' cellpadding='5' cellspacing='2'>");
       
        html.append("<tr>");
        html.append("<th>Name</th>");
        html.append("<td><input type='text' name='name' value=''></td>");
        html.append("</tr>");
        
        html.append("<tr>");
        html.append("<th>Doses Required</th>");
        html.append("<td><select name='doses' value=''><option>1</option>"
        		+ "<option>2</option></select></td>");
        html.append("</tr>");
        
        html.append("<tr>");
        html.append("<th>Days Between Doses</th>");
        html.append("<td><input type='text' name='daysBetween' value=''></td>");
        html.append("</tr>");
        
        html.append("<tr>");
        html.append("<td colspan='2' scope='row'><button type='submit'>Add</button></td>");
        html.append("</tr></table></form>");
        
        out.println(ServletUtilities.titleWithBody("New Vaccine", html.toString()));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Vaccine> vaccines = ServletUtilities.getGuestBookEntresFromServletContext(getServletContext());
		String name = request.getParameter("name");
		Vaccine vaccine;
		
		int dosesRequired = Integer.valueOf(request.getParameter("doses"));
		
		if(dosesRequired == 1) {
			vaccine = new Vaccine(name, dosesRequired);
			vaccines.add(vaccine);
			response.sendRedirect("ListVaccines");
			return;
		}
		
		int daysBetweenDoses = Integer.valueOf(request.getParameter("daysBetween"));;
		vaccine = new Vaccine(name, dosesRequired, daysBetweenDoses);
	
		vaccines.add(vaccine);
		
		response.sendRedirect("ListVaccines");
		
	}

}
