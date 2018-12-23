package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import classes.Room;
import classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Book_class_controller {
	@FXML 
	DatePicker date;
	
	@FXML 
	ComboBox classroom;
	
	@FXML
	TextField f_h;
	@FXML
	TextField f_m;
	@FXML
	TextField t_h;
	@FXML
	TextField t_m;
	@FXML
	TextField cap;
	@FXML
	Label status;
	@FXML
	Button back;
	
	Login_controller lc=new Login_controller();
	User u;
	
	HashMap<String,ArrayList<Room>> hm=new HashMap<String,ArrayList<Room>>();
	HashMap<String,ArrayList<Room>> hm2=new HashMap<String,ArrayList<Room>>();
	@FXML
	public  void initialize()
	{
		//weekday.getItems().addAll("Monday", "Tuesday", "Wednesday");
		classroom.getItems().addAll("C01", "C02", "C03");
		u=lc.getUser();
		//combo.setEditable(true);
	    //combo.setPromptText("Enter");
	  
	}
	
	
	public HashMap<String,ArrayList<Room>> deserializefile(String fname) throws ClassNotFoundException, IOException{
		 ObjectInputStream fileread=null;
		// HashMap<String,ArrayList<Room>> hm=null;
		try{
			fileread=new ObjectInputStream(new FileInputStream(fname));
			hm=(HashMap) fileread.readObject();
			
			System.out.println("function");
		}
		finally{
			fileread.close();
		}
		return hm;
		
	}

	public HashMap<String,ArrayList<Room>> deserializefile2(String fname) throws ClassNotFoundException, IOException{
		 ObjectInputStream fileread=null;
		// HashMap<String,ArrayList<Room>> hm=null;
		try{
			fileread=new ObjectInputStream(new FileInputStream(fname));
			hm2=(HashMap) fileread.readObject();
			
			System.out.println("function");
		}
		finally{
			fileread.close();
		}
		return hm2;
	}		
	
	
	// Create a database with class rooms booked for regular courses named as WeekdayRooms
	
	
	public void book_click(ActionEvent event) throws Exception
	{
	
		LocalDate l=date.getValue();
		String d=l.toString();
		//System.out .println(d);
		String wd=l.getDayOfWeek().name();
		String cl=classroom.getValue().toString();
		int fh=Integer.parseInt(f_h.getText());
		int fm=Integer.parseInt(f_m.getText());
		int th=Integer.parseInt(t_h.getText());
		int tm=Integer.parseInt(t_m.getText());
		int c=Integer.parseInt(cap.getText());
		String user=u.getUsertype();
		
		int flag=0;
		//checks clash with that weekday courses 
		try
		{
			
		 hm=deserializefile("WeekdayRooms.txt"); //opens file with class booking of courses
		 System.out.println(hm.get("MONDAY").get(0).getTime()+"The stored time of the class in file");
		}
		catch (NullPointerException e)
		{
			hm=new HashMap<String,ArrayList<Room>>();
		}
		Room r=new Room(cl,fh,fm,th,tm,c,user);
		ArrayList<Room> ar=hm.get(wd);
		
		if(ar==null)
			ar=new ArrayList<Room>();
		
		for(Room ro: ar)
		{
			// Check faculty
			
			 if(ro.checkClash(r)==1)
			 {
				flag=1;
				System.out.println("weekday clash");
				status.setText(ro.getTime());
				break;
			  }
			
			
			
		}
		//check clash with explicit rooms booked on that date
		try
		{

		 hm2=deserializefile2("RoomBooked.txt"); //opens file with class booking on a particular day
		
		}
		catch (NullPointerException e)
		{
			hm2=new HashMap<String,ArrayList<Room>>();
		}
		
		Room r2=new Room(cl,fh,fm,th,tm,c,user);
		ArrayList<Room> ar2=hm2.get(d);
		
		if(ar2==null)
			ar2=new ArrayList<Room>();
		
		for(Room ro: ar2)
	   {
			
			System.out.println(ro.checkClash(r)==1);
	        if(ro.checkClash(r)==1)
	        {
				
				flag=1;
				System.out.println("room clash with  faculty");
				status.setText(ro.getTime());
				break;
	         }
	
				
			
	}
		
		if(flag==0 )
		{
			status.setText("booked");
			ar2.add(r);
		}
		
		
		hm2.put(d,ar2);
		
        ObjectOutputStream UsersList=null;	
		
		try	
		{	
			UsersList=new ObjectOutputStream(new FileOutputStream("RoomBooked.txt"));	
			UsersList.writeObject(hm2);			
		}	
		finally	
		{	
			UsersList.close();	
		}	
		
		
		
		
	}
	
	public void back_click(ActionEvent event) throws Exception
	{
    
	System.out.println("hi");
	if(u.getUsertype().equals("Faculty"))
	{
		Stage primaryStage=(Stage) back.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("User_Faculty.fxml"));
		Scene scene = new Scene(root,600,400);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	else
	{
		Stage primaryStage=(Stage) back.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("User_Admin.fxml"));
		Scene scene = new Scene(root,600,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	}
	
	
	
	

}
