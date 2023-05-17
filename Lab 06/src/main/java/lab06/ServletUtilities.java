package lab06;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

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
	
}
