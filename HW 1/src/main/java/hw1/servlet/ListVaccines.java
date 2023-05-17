package hw1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
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
 * Servlet implementation class ListVaccines
 */
@WebServlet(urlPatterns = "/ListVaccines", loadOnStartup = 1)
public class ListVaccines extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListVaccines() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		List<Vaccine> vaccines = new ArrayList<>();
		getServletContext().setAttribute( "vaccines" , vaccines );
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StringBuilder html = new StringBuilder();
		List<Vaccine> vaccines = ServletUtilities.getGuestBookEntresFromServletContext(getServletContext());
		
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        
        html.append("<p><a href = NewVaccine>New Vaccine</a> | ");
        html.append("<a href = NewDoses>New Doses</a></p>");
        
        html.append("<table border='1' cellpadding='5' cellspacing='2'>");
        html.append("<thead>");
        html.append("<tr>");
        html.append("<th>Vaccine</th>");
        html.append("<th>Doses Required</th>");
        html.append("<th>Days Between Doses</th>");
        html.append("<th>Total Doses Received</th>");
        html.append("<th>Total Doses Left</th>");
        html.append("<th>&nbsp;</th>");
        html.append("</tr>");
        html.append("</thead>");
        
        html.append("<tbody>");
        for(Vaccine vaccine : vaccines) {
        	 html.append("<tr>");
        	 html.append("<td>"+ vaccine.getName()+"</td>");
        	 html.append("<td>"+ vaccine.getDosesRequired()+"</td>");
        	 html.append("<td>"+ ((vaccine.getDosesRequired() == 1) ? "" : vaccine.getDaysBetweenDoses())+"</td>");
        	 html.append("<td>"+ vaccine.getTotalDosesReceived()+"</td>");
        	 html.append("<td>"+ vaccine.getTotalDosesLeft()+"</td>");
        	 html.append("<td><a href='EditVaccine?id="+vaccine.getId()+"'>Edit</a></td>");
        	 html.append("</tr>");
        }
        
        html.append("</tbody>");
        html.append("</table>");
        
        out.println(ServletUtilities.titleWithBody("Vaccine List", html.toString()));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
