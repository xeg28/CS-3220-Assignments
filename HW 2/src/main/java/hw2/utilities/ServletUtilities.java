package hw2.utilities;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import hw2.model.Vaccine;
import hw2.model.Patient;
public class ServletUtilities {
	
	public static final String DOCTYPE =
			"<!DOCTYPE HTML>";
	
	public static String headWithTitle(String title) {
		return(
				DOCTYPE + "\n" +
						"<HTML>\n" +
						"<HEAD><TITLE>" + title + "</TITLE></HEAD>\n");
	}
	
	public static String titleWithBody(String title, String body) {
		return (headWithTitle(title) + "<BODY>" + body + "</BODY>\n" + "</HTML>\n");
	}
	
	
	public static Vaccine getVaccine(List<Vaccine> entries, int id){
		Vaccine entry = null;
		for( var e : entries )
            if( e.getId() == id )
            {
                entry = e;
                break;
            }
		return entry;
    }

	public static List<Vaccine> getVaccinesFromServletContext(ServletContext context){
		var obj = context.getAttribute( "vaccines" );
		if (obj == null) return new ArrayList<Vaccine>();
		try {
			return (List<Vaccine>) obj;
		}catch(Exception ex) { return new ArrayList<Vaccine>(); }
   }

	public static List<Patient> getPatientsFromServletContext(ServletContext context){
		var obj = context.getAttribute( "patients" );
		if (obj == null) return new ArrayList<Patient>();
		try {
			return (List<Patient>) obj;
		}catch(Exception ex) { return new ArrayList<Patient>(); }
   
	}
	
	public static Vaccine getVaccineByID(List<Vaccine> vaccines, int id) {
		for(Vaccine vaccine : vaccines) {
			if(vaccine.getId() == id) {
				return vaccine;
			}
		}
		return null;
	}
	
	public static Patient getPatientByID(List<Patient> patients, int id) {
		for(Patient patient : patients) {
			if(patient.getId() == id) {
				return patient;
			}
		}
		return null;
	}
	
}