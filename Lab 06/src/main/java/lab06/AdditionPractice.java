package lab06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * Servlet implementation class AdditionPractice
 */
@WebServlet("/AdditionPractice")
public class AdditionPractice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdditionPractice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Random rand = new Random();
		PrintWriter out = response.getWriter();
		StringBuilder html = new StringBuilder();
		int number1 = rand.nextInt(10);
		int number2 = rand.nextInt(10);
		
		html.append( "<form action='AdditionPractice' method='post'>" );
		html.append( "" + number1 + " + " + number2 + " = <input type='text' name='userAnswer' value=''> ");
		html.append( "<input type='hidden' name='number1' value='"+ number1 +"'>");
		html.append( "<input type='hidden' name='number2' value='"+ number2 +"'>");
		html.append( "<button type='submit'>Submit</button></form>");
		 
		out.println( ServletUtilities.titleWithBody("AdditionPractice", html.toString()) );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		StringBuilder html = new StringBuilder();
		int number1 = Integer.parseInt(request.getParameter("number1"));
		int number2 = Integer.parseInt(request.getParameter("number2"));
		int userAnswer = Integer.parseInt(request.getParameter("userAnswer"));
		int answer = number1 + number2;
		
		html.append( "" + number1 + " + " + number2 + " = " + answer + "<br>");
		html.append( "Your answer " + userAnswer + " is " +  
				    ((userAnswer == answer) ? " correct.<br>" : " incorrect.<br>"));
		html.append( "<a href='AdditionPractice'>Try Again</a>");
		 
		out.println( ServletUtilities.titleWithBody("AdditionPractice", html.toString()));
		
	}
	
}
