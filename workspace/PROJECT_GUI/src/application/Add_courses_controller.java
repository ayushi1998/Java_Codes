package application;

import classes.sem_course;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;









public class Add_courses_controller {
	@FXML 
	Button back;
	@FXML 
	Button search;
	@FXML 
	Button register;
	@FXML 
	TextField searchbar;
	@FXML 
	TextField sno;
	@FXML
	ScrollBar scroll;

	public TableView<sem_course> table;
	public TableColumn<sem_course,String> Sno;
	public TableColumn<sem_course,String> course;
	public TableColumn<sem_course,String> credits;
	public TableColumn<sem_course,String> pc;
	
	
	


	
	
	 ObservableList<sem_course> data = FXCollections.observableArrayList();
	 
	  
	  
	  @FXML
	  public void initialize() 
	  {
		  
	     // ObservableList<sem_course> data = FXCollections.observableArrayList();
		  sem_course  meh = new sem_course("1", "DM", "4", "ehshdfbhbcsdanbjsbdbjsadjjsajhdbhidbfuasfubaysdfuasufyusdyufbsyu");
			data.add(meh);
	      
			Sno.setCellValueFactory(new PropertyValueFactory<sem_course,String>("sn"));
			course.setCellValueFactory(new PropertyValueFactory<sem_course,String>("cours"));
			credits.setCellValueFactory(new PropertyValueFactory<sem_course,String>("credit"));
			pc.setCellValueFactory(new PropertyValueFactory<sem_course,String>("p"));
			
			
			 table.setItems(data);
			 
			
			//table.getColumns().addAll(Sno,course, credits,pc);
	  }
	  
	  public void search_click(ActionEvent event) throws Exception
	  {
		 //sno.setCellFactory(new PropertyValueFactory<sem_course,String>(sno));
		 
		
		  
		
		  
		  
		  
		  
		  
		  
	  }
	  public void register_course(ActionEvent event) throws Exception
	  {
		 //sno.setCellFactory(new PropertyValueFactory<sem_course,String>(sno));
		 
		  
		  /*sno.setCellFactory(new PropertyValueFactory<sem_course,String>("sno"));
		 course.setCellFactory(new PropertyValueFactory<sem_course,String>("course"));
		 credits.setCellFactory(new PropertyValueFactory<sem_course,String>("credits"));
		 pc.setCellFactory(new PropertyValueFactory<sem_course,String>("pc"));
		
		 table.setItems(data);
		 */
		  
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
		System.out.println("hello");
	}
	
	
	
	
	
}
