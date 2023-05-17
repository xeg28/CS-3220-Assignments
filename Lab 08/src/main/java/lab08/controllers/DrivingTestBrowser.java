package lab08.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Scanner;

import lab08.models.Question;

/**
 * Servlet implementation class DrivingTestBrowser
 */
@WebServlet(urlPatterns = "/DrivingTestBrowser", loadOnStartup = 1)
public class DrivingTestBrowser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DrivingTestBrowser() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
    	
		String path = getServletContext().getRealPath("/WEB-INF/DrivingTest.txt");
    	Scanner in;
		try {
			in = new Scanner(new File(path));
	    	int counter = 0;
	    	Question question = new Question();
	    	ArrayList<Question> questions = new ArrayList<>();
	    	while(in.hasNextLine()) {   		
	    		switch(counter) {
	    			case 0: question.setDescription(in.nextLine());
	    					break;
	    			case 1: question.setAnswerA(in.nextLine());
	    					break;
	    			case 2: question.setAnswerB(in.nextLine());
	    					break;
	    			case 3: question.setAnswerC(in.nextLine());
	    					break;
	    			case 4: question.setCorrectAnswer(Integer.parseInt(in.nextLine()));
	    					questions.add(question);
	    					break;
	    			case 5: in.nextLine();
	    					counter = 0;
	    					question = new Question();
	    					continue;
	    		}
	    		counter++;
	    	}
	    	getServletContext().setAttribute( "questions" , questions);
	    	
	    	in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int index = (request.getSession().getAttribute("index") == null) ? 0 : 
								(int)request.getSession().getAttribute("index"); 
		request.getSession().setAttribute("index", index + 1);
		ArrayList<Question> questions = (ArrayList<Question>)getServletContext().getAttribute("questions");
		if(index == questions.size()-1) {
			request.getSession().setAttribute("index", 0);
		}


		request.setAttribute("index", index);
		request.getRequestDispatcher("/WEB-INF/QuestionView.jsp")
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
