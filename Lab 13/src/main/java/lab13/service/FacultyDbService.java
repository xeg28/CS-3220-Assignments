package lab13.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lab13.model.Faculty;

public class FacultyDbService {

    private String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu18";

    private String username = "cs3220stu18";

    private String password = "We4Mo65Oq7Mf";

    private Connection connection;

    public FacultyDbService()
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

    public List<Faculty> getFacultiesByIds(List<Integer> ids)
    {
        List<Faculty> faculties = new ArrayList<Faculty>();
        
        for(int id : ids)
        {
        	Faculty faculty = this.getFaculty(id);
        	faculties.add(faculty);
        }
        
        return faculties;
    }

    public Faculty getFaculty( int id )
    {
    	Faculty faculty = new Faculty();
        try
        {
            String sql = "select * from faculty where id = ?";
            PreparedStatement pstmt = connection.prepareStatement( sql );
            pstmt.setInt( 1, id );
            ResultSet rs = pstmt.executeQuery();
            if( rs.next() )
            {
            	faculty.setId( rs.getInt( "id" ) );
            	faculty.setName( rs.getString( "name" ) );
            	faculty.setChair( rs.getBoolean( "isChair" ) );
            }
            pstmt.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
        return faculty;
    }

    public int addFaculty( String name, boolean isChair, int departmentId )
    {
        int id = 0;
        try
        {
            String sql = "insert into faculty (name, isChair) values (?, ?)";
            PreparedStatement pstmt = connection.prepareStatement( sql,
                Statement.RETURN_GENERATED_KEYS );
            pstmt.setString( 1, name );
            pstmt.setBoolean( 2, isChair );
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if( rs.next() ) id = rs.getInt( 1 );
            pstmt.close();
            addDepartmentsFaculty(id, departmentId);
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
        return id;
    }
    
    public int addDepartmentsFaculty(int facultyId, int departmentId) {
    	int id = 0;
        try
        {
            String sql = "insert into departments_faculty (departmentId, facultyId) values (?, ?)";
            PreparedStatement pstmt = connection.prepareStatement( sql,
                Statement.RETURN_GENERATED_KEYS );
            pstmt.setInt( 1, departmentId);
            pstmt.setInt( 2, facultyId );
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
