package application;
	
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import classes.Room;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main  extends Application implements Serializable  {
	
	static Stage stage;
	@Override
	public void start(Stage primaryStage) {
		try {
			stage=primaryStage;
			//BorderPane root = new BorderPane();
			Parent root= FXMLLoader.load(getClass().getResource("Sign_Up.fxml"));
			Scene scene = new Scene(root,600,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	static HashMap<String,ArrayList<Room>> hm2=new HashMap<String,ArrayList<Room>>();
	
	public static void main(String[] args) throws Exception{
		
		 ObjectOutputStream UsersList=null;	
		 Room r=new Room("C01",12,00,14,00,55," ");
		 ArrayList<Room> ar=new ArrayList<Room>();
		 ar.add(r);
		 hm2.put("MONDAY", ar);
			
			try	
			{	
				UsersList=new ObjectOutputStream(new FileOutputStream("WeekdayRooms.txt"));	
				UsersList.writeObject(hm2);			
			}	
			finally	
			{	
				UsersList.close();	
			}	
			
		launch(args);
	}
}
