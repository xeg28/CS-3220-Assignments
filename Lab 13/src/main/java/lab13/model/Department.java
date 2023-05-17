package lab13.model;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;
    private int id;
    private List<Faculty> faculty;

    public Department()
    {
        faculty = new ArrayList<Faculty>();
    }

    public Department( String name )
    {
        this();
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public List<Faculty> getFaculty()
    {
        return faculty;
    }

    public void setFaculty( List<Faculty> faculty )
    {
        this.faculty = faculty;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public int getId() {
    	return this.id;
    }

}