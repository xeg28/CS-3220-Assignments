package lab13.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lab13.model.Department;
import lab13.service.FacultyDbService;

public class DepartmentDbService {

    private String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu18";

    private String username = "cs3220stu18";

    private String password = "We4Mo65Oq7Mf";

    private Connection connection;

    public DepartmentDbService()
    {
        try
        {
            connection = DriverManager.getConnection( url, username, password );
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    }

    public void close()
    {
        if( connection != null )
        {
            try
            {
                connection.close();
            }
            catch( SQLException e )
            {
                e.printStackTrace();
            }
        }
    }

    public List<Department> getDepartments()
    {
        List<Department> departments = new ArrayList<Department>();

        try
        {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from departments" );
            FacultyDbService facultyService = new FacultyDbService();
            while( rs.next() )
            {
            	Department department = new Department();
            	int id = rs.getInt( "id" );
                department.setId( id );
                department.setName( rs.getString( "name" ) );
                department.setFaculty( facultyService.getFacultiesByIds(getDepartmentFacultyIds(id)) );
                departments.add(department);
            }
            stmt.close();
            facultyService.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }

        return departments;
    }

    public List<Integer> getDepartmentFacultyIds( int id )
    {
        List<Integer> departmentFacultyIds = new ArrayList<Integer>();
        try
        {
            String sql = "select facultyId from departments_faculty where departmentId = ?";
            PreparedStatement pstmt = connection.prepareStatement( sql );
            pstmt.setInt( 1, id );
            ResultSet rs = pstmt.executeQuery();
            while( rs.next() )
            {
                departmentFacultyIds.add( rs.getInt( "facultyId" ) );
            
            }
            pstmt.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
        return departmentFacultyIds;
    }

    public int addDepartment( String name)
    {
        int id = 0;
        try
        {
            String sql = "insert into departments (name) values (?)";
            PreparedStatement pstmt = connection.prepareStatement( sql,
                Statement.RETURN_GENERATED_KEYS );
            pstmt.setString( 1, name );
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if( rs.next() ) id = rs.getInt( 1 );
            pstmt.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
        return id;
    }
}
