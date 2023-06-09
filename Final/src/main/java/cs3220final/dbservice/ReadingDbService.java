package cs3220final.dbservice;

import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cs3220final.model.User;
import cs3220final.model.Reading;

public class ReadingDbService {

    private String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu18";

    private String username = "cs3220stu18";

    private String password = "We4Mo65Oq7Mf";

    private Connection connection;

    public ReadingDbService()
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

    public List<Reading> getReadings(int id)
    {
        List<Reading> readings = new ArrayList<Reading>();
        UserDbService userDbService = new UserDbService();

        try
        {
        	String sql = "select * from readings where user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement( sql );
            pstmt.setInt( 1, id );
            ResultSet rs = pstmt.executeQuery();
            while( rs.next() )
            {
            	Reading reading = new Reading();
            	reading.setId( rs.getInt( "id" ) );
            	reading.setUser( userDbService.getUser(id));
            	reading.setSystolic(rs.getInt("systolic"));
            	reading.setDiastolic(rs.getInt("diastolic"));
            	reading.setReadingTime(rs.getTimestamp("reading_time"));
 
            	readings.add( reading );
            }
            pstmt.close();
            userDbService.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }

        return readings;
    }

    public Reading getReading( int id )
    {
    	Reading reading = new Reading();
        try
        {
        	UserDbService userDbService = new UserDbService();
            String sql = "select * from readings where id = ?";
            PreparedStatement pstmt = connection.prepareStatement( sql );
            pstmt.setInt( 1, id );
            ResultSet rs = pstmt.executeQuery();
            if( rs.next() )
            {
            	reading.setId( rs.getInt( "id" ) );
            	reading.setUser( userDbService.getUser(rs.getInt("user_id")) );
            	reading.setSystolic(rs.getInt("systolic"));
            	reading.setDiastolic(rs.getInt("diastolic"));
            	reading.setReadingTime(rs.getTimestamp("reading_time"));
            }
            pstmt.close();
            userDbService.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
        
        return reading;
    }

    
    public int addReading(int userId, int systolic, int diastolic)
    {
        int id = 0;
        try
        { 
            String sql = "insert into readings (user_id, systolic, diastolic, reading_time) values (?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement( sql,
                Statement.RETURN_GENERATED_KEYS );
            pstmt.setInt( 1, userId );
            pstmt.setInt( 2, systolic );
            pstmt.setInt( 3, diastolic );
            pstmt.setTimestamp( 4, new Timestamp(System.currentTimeMillis()));
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
