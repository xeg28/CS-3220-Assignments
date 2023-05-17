package lab13.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab13.model.Department;
import lab13.service.DepartmentDbService;

@WebServlet("/AddDepartment")
public class AddDepartment extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AddDepartment()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        request.getRequestDispatcher( "/WEB-INF/lab13/AddDepartment.jsp" )
            .forward( request, response );;
    }

    @SuppressWarnings("unchecked")
    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	DepartmentDbService departmentDbService = new DepartmentDbService();
    	String name = request.getParameter("name");
    	departmentDbService.addDepartment(name);
        
    	departmentDbService.close();
        response.sendRedirect( "DisplayFaculty" );
    }

}