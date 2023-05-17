package hw3.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import hw3.model.Patient;

public class PatientDbService {

    private String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu18";

    private String username = "cs3220stu18";

    private String password = "We4Mo65Oq7Mf";

    private Connection connection;

    public PatientDbService()
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

    public List<Patient> getPatients()
    {
        List<Patient> patients = new ArrayList<Patient>();

        try
        {
        	VaccineDbService vaccineDbService = new VaccineDbService();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from patients" );
            while( rs.next() )
            {
                Patient patient = new Patient();
                patient.setId( rs.getInt( "id" ) );
                patient.setName( rs.getString( "name" ) );
                patient.setVaccine( vaccineDbService.getVaccine( rs.getInt( "vaccineId" ) ) );
                patient.setFirstDose( rs.getDate("firstDoseDate") );
                patient.setSecondDose( rs.getDate("secondDoseDate") );
                patients.add( patient );
            }
            stmt.close();
            vaccineDbService.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }

        return patients;
    }

    public Patient getPatient( int id )
    {
        Patient patient = new Patient();
        try
        {
        	VaccineDbService vaccineDbService = new VaccineDbService();
            String sql = "select * from patients where id = ?";
            PreparedStatement pstmt = connection.prepareStatement( sql );
            pstmt.setInt( 1, id );
            ResultSet rs = pstmt.executeQuery();
            if( rs.next() )
            {
            	patient.setId( rs.getInt( "id" ) );
                patient.setName( rs.getString( "name" ) );
                patient.setVaccine( vaccineDbService.getVaccine( rs.getInt( "vaccineId" ) ) );
                patient.setFirstDose( rs.getDate("firstDoseDate") );
                patient.setSecondDose( rs.getDate("secondDoseDate") );
            }
            pstmt.close();
            vaccineDbService.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
        return patient;
    }

    public int addPatient( String name, int vaccineId, Date firstDoseDate)
    {
        int id = 0;
        try
        {
            String sql = "insert into patients (name, vaccineId, firstDoseDate) values (?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement( sql,
                Statement.RETURN_GENERATED_KEYS );
            pstmt.setString( 1, name );
            pstmt.setInt( 2, vaccineId);
            pstmt.setDate(3, firstDoseDate);
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

    public void updatePatient( int id, Date secondDoseDate)
    {
        try
        {
            String sql = "update patients set secondDoseDate = ? where id = ?";
            PreparedStatement pstmt = connection.prepareStatement( sql );
            pstmt.setDate( 1, secondDoseDate );
            pstmt.setInt( 2, id );
            pstmt.executeUpdate();
            pstmt.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    }
}
