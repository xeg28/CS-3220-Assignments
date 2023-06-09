package hw3.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hw3.model.Vaccine;

public class VaccineDbService {

    private String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu18";

    private String username = "cs3220stu18";

    private String password = "We4Mo65Oq7Mf";

    private Connection connection;

    public VaccineDbService()
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

    public List<Vaccine> getVaccines()
    {
        List<Vaccine> vaccines = new ArrayList<Vaccine>();

        try
        {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from vaccines" );
            while( rs.next() )
            {
            	Vaccine vaccine = new Vaccine();
            	vaccine.setId( rs.getInt( "id" ) );
            	vaccine.setName( rs.getString( "name" ) );
            	vaccine.setDosesRequired( rs.getInt( "dosesRequired" ) );
            	vaccine.setDaysBetweenDoses( rs.getInt( "daysBetweenDoses" ) );
            	vaccine.setTotalDosesReceived( rs.getInt( "totalDosesReceived" ) );
            	vaccine.setTotalDosesLeft( rs.getInt( "totalDosesLeft" ) );
            	vaccines.add( vaccine );
            }
            stmt.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }

        return vaccines;
    }

    public Vaccine getVaccine( int id )
    {
        Vaccine vaccine = new Vaccine();
        try
        {
            String sql = "select * from vaccines where id = ?";
            PreparedStatement pstmt = connection.prepareStatement( sql );
            pstmt.setInt( 1, id );
            ResultSet rs = pstmt.executeQuery();
            if( rs.next() )
            {
            	vaccine.setId( rs.getInt( "id" ) );
            	vaccine.setName( rs.getString( "name" ) );
            	vaccine.setDosesRequired( rs.getInt( "dosesRequired" ) );
            	vaccine.setDaysBetweenDoses( rs.getInt( "daysBetweenDoses" ) );
            	vaccine.setTotalDosesReceived( rs.getInt( "totalDosesReceived" ) );
            	vaccine.setTotalDosesLeft( rs.getInt( "totalDosesLeft" ) );
            }
            pstmt.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
        return vaccine;
    }

    public int addVaccine( String name, int dosesRequired, int daysBetweenDoses)
    {
        int id = 0;
        try
        { 
            String sql = "insert into vaccines (name, dosesRequired, daysBetweenDoses) values (?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement( sql,
                Statement.RETURN_GENERATED_KEYS );
            pstmt.setString( 1, name );
            pstmt.setInt( 2, dosesRequired );
            pstmt.setInt( 3, daysBetweenDoses );
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

    public void updateVaccine( int id, String name, int dosesRequired, int daysBetweenDoses)
    {
        try
        {
            String sql = "update vaccines set name = ?, dosesRequired = ?, daysBetweenDoses = ? where id = ?";
            PreparedStatement pstmt = connection.prepareStatement( sql );
            pstmt.setString( 1, name );
            pstmt.setInt( 2, dosesRequired );
            pstmt.setInt( 3, daysBetweenDoses );
            pstmt.setInt( 4, id );
            pstmt.executeUpdate();
            pstmt.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    }
    
    public void useDose (int id, int totalDosesLeft) {
    	 try
         {	 
    		 totalDosesLeft--;
             String sql = "update vaccines set totalDosesLeft = ? where id = ?";
             PreparedStatement pstmt = connection.prepareStatement( sql );
             pstmt.setInt( 1, totalDosesLeft );
             pstmt.setInt( 2, id );
             pstmt.executeUpdate();
             pstmt.close();
         }
         catch( SQLException e )
         {
             e.printStackTrace();
         }
    }
    
    public void addDoses(int id, int totalDosesReceived, int totalDosesLeft, int newDoses) {
        try
        {
        	totalDosesReceived += newDoses;
        	totalDosesLeft += newDoses;
            String sql = "update vaccines set totalDosesReceived = ?, totalDosesLeft = ? where id = ?";
            PreparedStatement pstmt = connection.prepareStatement( sql );
            pstmt.setInt( 1, totalDosesReceived );
            pstmt.setInt( 2, totalDosesLeft );
            pstmt.setInt( 3, id );
            pstmt.executeUpdate();
            pstmt.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    }
}
