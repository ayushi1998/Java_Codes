package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import classes.Faculty;
import classes.Student;
import classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Login_controller {
 
	
	@FXML
	TextField email;
	
	
	@FXML
	PasswordField password;
	
	@FXML
	Button submit;
	
	
	HashMap<String,User> usermap=new HashMap<String,User>();
	public static User u;
	/* 1. Taking inputs form the user.
	 * 2.Deserialize file
	 * 3. Direct to the User Page accordingly
	 */
	//ComboBox 
	
	public HashMap<String,User> deserialize_user() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		
		ObjectInputStream fileread=null;
		HashMap<String,User> hm=null;
		try{
			fileread=new ObjectInputStream(new FileInputStream("User.txt"));
			hm=(HashMap) fileread.readObject();
			usermap=hm;
			
		}
		finally{
			fileread.close();
		}
		return hm;
	}
	public Student getStudent()
	{
		System.out.println("called"+ u.getUsertype());
		return (Student)u;
	}
	
	public User getUser()
	{
		return u;
	}
	public void submit_click(ActionEvent event) throws Exception
	{
		/* 1. Taking inputs form the user.
		 * 2.User object
		 * 
		 * Email se validate karo
		 * HashMap store karna hoga
		 */ 
		
		
		String Email=email.getText();  
		//Validate if email exists/correct
		Alert alert = new Alert(AlertType.WARNING, 
                "File already exists. Do you want to override?", 
                ButtonType.YES, ButtonType.NO);

Optional<ButtonType> result = alert.showAndWait();
		


	    String Password=password.getText();
	  //Validate the Password  
	    
	   usermap=deserialize_user();
	    
	    
	    u=usermap.get(Email);
	    System.out.println(u.getUsertype());
	    if(u.getUsertype().equals("Faculty"))
	    {
	    	
	    	Stage primaryStage=(Stage) submit.getScene().getWindow()  ;
			Pane root= FXMLLoader.load(getClass().getResource("User_Faculty.fxml"));
			Scene scene = new Scene(root,600,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//pane.getChildren().setAll(root);
			primaryStage.setScene(scene);
			primaryStage.show();
	    }
	    else if(u.getUsertype().equals("Student"))
	    {
	    	
	    	Stage primaryStage=(Stage) submit.getScene().getWindow()  ;
			Pane root= FXMLLoader.load(getClass().getResource("User_Student.fxml"));
			Scene scene = new Scene(root,600,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//pane.getChildren().setAll(root);
			primaryStage.setScene(scene);
			primaryStage.show();
	    	
	    }
	    else
	    {
	    	Stage primaryStage=(Stage) submit.getScene().getWindow()  ;
			Pane root= FXMLLoader.load(getClass().getResource("User_Admin.fxml"));
			Scene scene = new Scene(root,600,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//pane.getChildren().setAll(root);
			primaryStage.setScene(scene);
			primaryStage.show();
	    	
	    }
	    
	    
	    
	    
	    
	
	
	
	}
		  
	
	
	
	
	
	
		
		
	
	
	
	
}
