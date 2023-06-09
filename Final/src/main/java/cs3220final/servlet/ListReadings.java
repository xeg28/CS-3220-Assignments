package cs3220final.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220final.model.Reading;
import cs3220final.model.User;
import cs3220final.dbservice.ReadingDbService;
import cs3220final.dbservice.UserDbService;

/**
 * Servlet implementation class ListReadings
 */
@WebServlet("/ListReadings")
public class ListReadings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListReadings() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ReadingDbService readingDbService = new ReadingDbService();
		UserDbService userDbService = new UserDbService();
		
		int userId = (request.getParameter("user") == null) ? (Integer)request.getSession().getAttribute("userId")
				: Integer.valueOf(request.getParameter("user"));
		User user = userDbService.getUser(userId);
		List<Reading> readings = readingDbService.getReadings(userId);
		request.setAttribute("readings", readings);
		request.setAttribute("user", user);
		readingDbService.close();
		userDbService.close();
		request.getRequestDispatcher("/WEB-INF/final/ListReadings.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
