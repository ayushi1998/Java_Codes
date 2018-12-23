package classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Student extends User implements Serializable {
	
	ArrayList<Course> clist= new ArrayList<Course>();
	ArrayList<Request> accepted=new ArrayList<Request>();
	ArrayList<Request> cancelled=new ArrayList<Request>();

	public Student(String name, String email, String password, String usertype) 
	{
		super(name, email, password, usertype);
		
	}
	

	public void disp()
	{
		System.out.println("obj made");
	}
	public void addConfirmedRequest(Request r)
	{
		accepted.add(r);
	}
	
	public void addCancelledRequest(Request r)
	{
		cancelled.add(r);
	}
	
	
	
}
