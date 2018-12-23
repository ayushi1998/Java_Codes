package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import classes.Request;
import classes.Room;
import classes.Student;
import classes.request_table;
import classes.sem_course;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Handle_requestcontroller {
	
	@FXML
	TextField sno;
	
	@FXML
	ComboBox classroom;
	
	@FXML
	ComboBox ar;
	
	@FXML
	Button confirm;
	
	@FXML
	Button back;
	public TableView<request_table> table;
	public TableColumn<request_table,String> Sno;
	public TableColumn<request_table,String> date;
	public TableColumn<request_table,String> time;
	public TableColumn<request_table,String> purpose;
	public TableColumn<request_table,String> room;
	public TableColumn<request_table,String> status;
	
	
	
	
	
	ArrayList<Request> hm=new ArrayList<Request>();
	HashMap<String,ArrayList<Room>> hm2=new HashMap<String,ArrayList<Room>>();
	
	public ArrayList<Request> deserializefile() throws ClassNotFoundException, IOException{
		 ObjectInputStream fileread=null;
		// HashMap<String,ArrayList<Room>> hm=null;
		try{
			fileread=new ObjectInputStream(new FileInputStream("RequestDatabase.txt"));
			hm=(ArrayList) fileread.readObject();
			
			//System.out.println("function");
		}
		finally{
			fileread.close();
		}
		return hm;
		
	}
	
	public HashMap<String,ArrayList<Room>> deserializefile(String fname) throws ClassNotFoundException, IOException{
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
	
	
	
	public  void initialize()
	{
		
		classroom.getItems().addAll("C01", "C02", "C03");
		ar.getItems().addAll("Yes","No");
		
		
		
		
		
	  
	}
	
	
	public void back_click(ActionEvent event) throws Exception
	{
		Stage primaryStage=(Stage) back.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("User_Admin.fxml"));
		Scene scene = new Scene(root,600,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}
	
	public void confirm_click(ActionEvent event) throws Exception
	{
		String index=sno.getText();
		int i=Integer.parseInt(index);
		String cl=classroom.getValue().toString();
		String status=ar.getValue().toString();
		
		try
		{
			
		 hm=deserializefile(); 
		 //System.out.println(hm.get("MONDAY").get(0).getTime()+"The stored time of the class in file");
		}
		catch (NullPointerException e)
		{
			hm=new ArrayList<Request>();
		}
		
		if(i>hm.size())
		{
			System.out.println("Sno out of bound");
		}
		else
		{
			Request re= hm.get(i-1);
			System.out.println(re.getRoom());
			if(status.equals("Yes"))
			{
				Student st=re.getStudent();
				System.out.println(re.getStudent()+" "+st);
				st.addConfirmedRequest(re); // Student get to know about accepted requests
				
				//deserialize booked room file and add this requested room
				try
				{

				 hm2=deserializefile("RoomBooked.txt"); //opens file with class booking on a particular day
				
				}
				catch (NullPointerException e)
				{
					hm2=new HashMap<String,ArrayList<Room>>();
				}
				
				
				Room r2=new Room(re.getRoom(),re.getFh(),re.getFm(),re.getTh(),re.getTm(),0,"Admin");
				//(hm2.get("11-14-2017")
				System.out.println( hm2.get("2017-11-14"));
				System.out.println(hm2.get( re.getDate()));
				//ArrayList<Room> ar2=hm2.get( re.getDate());
				
				ArrayList<Room> ar2;
				if(hm2.get( re.getDate())!=null) 
				{
					ar2=hm2.get( re.getDate());
					
					
				}
				else
				{
					ar2=new ArrayList<Room>();
					
				}
				
				
				ar2.add(r2);
				
				hm2.put(re.getDate(), ar2);
				
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
			else
			{ 
				hm.get(i-1).getStudent().addCancelledRequest(hm.get(i-1)); // Student get to know about cancelled requests
			}
		}
		
	}
	

}
