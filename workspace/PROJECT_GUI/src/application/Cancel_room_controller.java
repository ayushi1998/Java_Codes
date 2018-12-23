package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

public class Cancel_room_controller {
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
	
	@FXML
	public  void initialize()
	{
		//weekday.getItems().addAll("Monday", "Tuesday", "Wednesday");
		classroom.getItems().addAll("C01", "C02", "C03");
		u=lc.getUser();
		
		//combo.setEditable(true);
	    //combo.setPromptText("Enter");
	  
	}
	
	
	public HashMap<String,ArrayList<Room>> deserializefile() throws ClassNotFoundException, IOException{
		 ObjectInputStream fileread=null;
		// HashMap<String,ArrayList<Room>> hm=null;
		try{
			fileread=new ObjectInputStream(new FileInputStream("RoomBooked.txt"));
			hm=(HashMap) fileread.readObject();
			
			System.out.println("function");
		}
		finally{
			fileread.close();
		}
		return hm;
		
	}
	
	
	//1. Null point handle
	//2. Print label
	//3. Serialize 
	
	// assuming at least one room is booked.
	public void cancel_click(ActionEvent event) throws Exception
	{
		//String wd=weekday.getValue().toString();
		LocalDate l=date.getValue();
		String d=l.toString();
		String cl=classroom.getValue().toString();
		int fh=Integer.parseInt(f_h.getText());
		int fm=Integer.parseInt(f_m.getText());
		int th=Integer.parseInt(t_h.getText());
		int tm=Integer.parseInt(t_m.getText());
		
		int c=0;
		String user=u.getUsertype();
		
		int flag=0;
		try
		{

		HashMap<String,ArrayList<Room>> hm=deserializefile();
		
		}
		catch (NullPointerException e)
		{
			hm=new HashMap<String,ArrayList<Room>>();
		}
		
		Room r=new Room(cl,fh,fm,th,tm,c,user);
		ArrayList<Room> ar=hm.get(d);
		for(Room ro: ar)
		{
           if(ro.getUsertype().equals(r.getUsertype()))
           {
        	       if(ro.checkSlot(r)==1)
       			   {
       				ar.remove(ro);
       				status.setText("Cancelled");
       				break;
       			    }
        	   
           }
           else{
        	   status.setText("Booked by other User");
           }
			
			
		}
			
		hm.put(d, ar);
		
		
		
		
        ObjectOutputStream UsersList=null;	
		
		try	
		{	
			UsersList=new ObjectOutputStream(new FileOutputStream("RoomBooked.txt"));	
			UsersList.writeObject(hm);	
					
		}	
		finally	
		{	
			UsersList.close();	
		}	
	
		
		
		
		
		
		
	}
	public void back_click(ActionEvent event) throws Exception
	{
    
	
	if(u.getUsertype().equals("Faculty"))
	{
		Stage primaryStage=(Stage) back.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("User_Faculty.fxml"));
		Scene scene = new Scene(root,600,400);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	else{
		Stage primaryStage=(Stage) back.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("User_Admin.fxml"));
		Scene scene = new Scene(root,600,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	
	
	

}
}
