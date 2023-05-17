package lab09.utilities;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import lab09.model.Vaccine;

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

	public static List<Vaccine> getGuestBookEntresFromServletContext(ServletContext context){
		var obj = context.getAttribute( "vaccines" );
		if (obj == null) return new ArrayList<Vaccine>();
		try {
			return (List<Vaccine>) obj;
		}catch(Exception ex) { return new ArrayList<Vaccine>(); }
   }

}