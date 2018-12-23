package application;

import classes.Student;
import classes.User;
import classes.sem_course;
import classes.view_courses;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class View_courses_controller 
{
	@FXML 
	Button back;
	
	Login_controller lc=new Login_controller();
	User v=lc.getUser();
	Student s;
	public TableView<view_courses> table;
	public TableColumn<view_courses,String> man;
	public TableColumn<view_courses,String> course;
	public TableColumn<view_courses,String> code;
	public TableColumn<view_courses,String> ins;
	public TableColumn<view_courses,String> credits;
	
	
	 ObservableList<sem_course> data = FXCollections.observableArrayList();
	 
	  
	  
	  @FXML
	  public void initialize() 
	  {
		  
	     // ObservableList<sem_course> data = FXCollections.observableArrayList();
		  
	      
			man.setCellValueFactory(new PropertyValueFactory<view_courses,String>("man"));
			course.setCellValueFactory(new PropertyValueFactory<view_courses,String>("course"));
			code.setCellValueFactory(new PropertyValueFactory<view_courses,String>("code"));
			ins.setCellValueFactory(new PropertyValueFactory<view_courses,String>("ins"));
			credits.setCellValueFactory(new PropertyValueFactory<view_courses,String>("credits"));
			
			
			
	
	
	
	
	
	
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
		System.out.println(v.getUsertype());
	}
	

}
