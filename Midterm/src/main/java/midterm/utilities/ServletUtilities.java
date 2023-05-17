package midterm.utilities;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import midterm.model.Request;

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
	
	
	public static Request getRequest(List<Request> entries, int id){
		Request entry = null;
		for( var e : entries )
            if( e.getId() == id )
            {
                entry = e;
                break;
            }
		return entry;
    }

	public static List<Request> getRequestsFromServletContext(ServletContext context){
		var obj = context.getAttribute( "requests" );
		if (obj == null) return new ArrayList<Request>();
		try {
			return (List<Request>) obj;
		}catch(Exception ex) { return new ArrayList<Request>(); }
   }

}