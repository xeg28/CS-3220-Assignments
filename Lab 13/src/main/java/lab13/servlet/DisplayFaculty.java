package lab13.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab13.model.Department;
import lab13.service.DepartmentDbService;

@WebServlet(urlPatterns = "/DisplayFaculty", loadOnStartup = 1)
public class DisplayFaculty extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public DisplayFaculty()
    {
        super();
    }


    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	DepartmentDbService departmentDbService = new DepartmentDbService();
    	request.setAttribute("departments", departmentDbService.getDepartments());
    	departmentDbService.close();
        request.getRequestDispatcher( "/WEB-INF/lab13/DisplayFaculty.jsp" )
            .forward( request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        doGet( request, response );
    }

}