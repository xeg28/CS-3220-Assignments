package cs3220final.dbservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cs3220final.model.User;

public class UserDbService {

    private String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu18";

    private String username = "cs3220stu18";

    private String password = "We4Mo65Oq7Mf";

    private Connection connection;

    public UserDbService()
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

    public List<User> getUsers()
    {
        List<User> users = new ArrayList<User>();

        try
        {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from users" );
            while( rs.next() )
            {
            	User user = new User();
            	user.setId( rs.getInt( "id" ) );
            	user.setName( rs.getString( "name" ) );
 
            	users.add( user );
            }
            stmt.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }

        return users;
    }

    public User getUser( int id )
    {
        User user = new User();
        try
        {
            String sql = "select * from users where id = ?";
            PreparedStatement pstmt = connection.prepareStatement( sql );
            pstmt.setInt( 1, id );
            ResultSet rs = pstmt.executeQuery();
            if( rs.next() )
            {
            	user.setId( rs.getInt( "id" ) );
            	user.setName( rs.getString( "name" ) );
            }
            pstmt.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
        return user;
    }



}
