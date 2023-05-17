package lab13.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab13.model.Department;
import lab13.model.Faculty;
import lab13.service.DepartmentDbService;
import lab13.service.FacultyDbService;

@WebServlet("/AddFaculty")
public class AddFaculty extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AddFaculty()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	DepartmentDbService departmentDbService = new DepartmentDbService();
    	request.setAttribute("departments", departmentDbService.getDepartments());
    	departmentDbService.close();
        request.getRequestDispatcher( "/WEB-INF/lab13/AddFaculty.jsp" )
            .forward( request, response );
    }

    @SuppressWarnings("unchecked")
    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	FacultyDbService facultyDbService = new FacultyDbService();
        int departmentId = Integer.valueOf(request.getParameter( "department" ));
        String name = request.getParameter( "faculty" );
        Boolean isChair = false;
        if( request.getParameter( "chair" ) != null ) isChair = true;
        
        facultyDbService.addFaculty(name, isChair, departmentId);
        facultyDbService.close();
        response.sendRedirect( "DisplayFaculty" );
    }

}