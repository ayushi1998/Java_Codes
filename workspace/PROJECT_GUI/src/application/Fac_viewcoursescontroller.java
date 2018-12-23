package application;
import classes.Fac_viewCourses;
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


public class Fac_viewcoursescontroller {


		@FXML 
		Button back;
		
		Login_controller lc=new Login_controller();
		User v=lc.getUser();
		Student s;
		public TableView<Fac_viewCourses > table;
		public TableColumn<Fac_viewCourses ,String> man;
		public TableColumn<Fac_viewCourses ,String> course;
		public TableColumn<Fac_viewCourses ,String> code;
		public TableColumn<Fac_viewCourses ,String> credits;
		
		
		 ObservableList<sem_course> data = FXCollections.observableArrayList();
		 
		  
		  
		  @FXML
		  public void initialize() 
		  {
	            man.setCellValueFactory(new PropertyValueFactory<Fac_viewCourses ,String>("man"));
				course.setCellValueFactory(new PropertyValueFactory<Fac_viewCourses ,String>("course"));
				code.setCellValueFactory(new PropertyValueFactory<Fac_viewCourses ,String>("code"));
				credits.setCellValueFactory(new PropertyValueFactory<Fac_viewCourses ,String>("credits"));
          }
		
		
		
		
		
		public void back_click(ActionEvent event) throws Exception
		{
			
			Stage primaryStage=(Stage) back.getScene().getWindow()  ;
			Pane root= FXMLLoader.load(getClass().getResource("User_Faculty.fxml"));
			Scene scene = new Scene(root,600,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//pane.getChildren().setAll(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			System.out.println(v.getUsertype());
		}
		

	
}
