package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import classes.Request;
import classes.Room;
import classes.Student;
import classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Request_room_controller {
	@FXML 
	DatePicker date;
	
	@FXML 
	ComboBox classroom;
	@FXML 
	TextField purpose;
	@FXML
	TextField f_h;
	@FXML
	TextField f_m;
	@FXML
	TextField t_h;
	@FXML
	TextField t_m;
	
	@FXML 
	Button back;
	@FXML 
	Button submit;
	
	Login_controller lc=new Login_controller();
	
	User v;
	Student s;
	ArrayList<Request> arr=new ArrayList<Request>();
	
	@FXML
	public  void initialize()
	{
		//weekday.getItems().addAll("Monday", "Tuesday", "Wednesday","Thursday","Friday");
		classroom.getItems().addAll("C01", "C02", "C03","C11","C12","C13","C21","C22","C23");
		//System.out.println(lc.getUser().getClass());
		if(lc.getUser() instanceof Student)
		{
			System.out.println("hi");
			s=(Student) lc.getUser();
		}
		/* 
		v=lc.getUser();
		String name=v.getUsername();
		String p=v.getPassword();
		String email=v.getEmail();
		
		s=new Student(name,email,p,v.getUsertype());
		  */  
		//combo.setEditable(true);
	    //combo.setPromptText("Enter");
	  
	}
	
	public ArrayList<Request> deserializefile() throws ClassNotFoundException, IOException{
		 ObjectInputStream fileread=null;
		// HashMap<String,ArrayList<Room>> hm=null;
		try{
			fileread=new ObjectInputStream(new FileInputStream("RequestDatabase.txt"));
			arr=(ArrayList) fileread.readObject();
			
			System.out.println("function");
		}
		finally{
			fileread.close();
		}
		return arr;
		
	}
	
	public void submit_click(ActionEvent event) throws Exception
	{
		LocalDate l=date.getValue();
		String d=l.toString();
		//System.out .println(d);
		//String wd=l.getDayOfWeek().name();
		String cl=classroom.getValue().toString();
		int fh=Integer.parseInt(f_h.getText());
		int fm=Integer.parseInt(f_m.getText());
		int th=Integer.parseInt(t_h.getText());
		int tm=Integer.parseInt(t_m.getText());
		String p=purpose.getText();
		
		
		
		try
		{
			
		 arr=deserializefile(); 
		 //System.out.println(hm.get("MONDAY").get(0).getTime()+"The stored time of the class in file");
		}
		catch (NullPointerException e)
		{
			arr=new ArrayList<Request>();
		}
		
		Request re=new Request(d,fh,fm,th,tm,p,cl,s);
		System.out.println(s+" "+"Request se"+re.getStudent());
		arr.add(re);
		//v.disp();
		ObjectOutputStream UsersList=null;	
		
		try	
		{	
			UsersList=new ObjectOutputStream(new FileOutputStream("RequestDatabase.txt"));	
			UsersList.writeObject(arr);			
		}	
		finally	
		{	
			UsersList.close();	
		}	
		
	}
	
	public void back_click(ActionEvent event) throws Exception
	{
		Stage primaryStage=(Stage) back.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("User_Student.fxml"));
		Scene scene = new Scene(root,600,400);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//pane.getChildren().setAll(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//System.out.println(v.getUsertype());
	}
	
	
	
	
	
}
