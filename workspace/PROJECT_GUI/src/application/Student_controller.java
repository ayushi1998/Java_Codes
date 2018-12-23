package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Student_controller {
	@FXML
	Button view;
	@FXML
	Button add;
	@FXML
	Button courses;
	@FXML
	Button schedule;
	@FXML
	Button logout;
	@FXML
	Button request;
	
	public void view_click(ActionEvent event) throws Exception
	{
		Stage primaryStage=(Stage) view.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("View_Room.fxml"));
		Scene scene = new Scene(root,600,400);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//pane.getChildren().setAll(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		System.out.println("hello");
	}
	
	public void add_click(ActionEvent event) throws Exception
	{
		Stage primaryStage=(Stage) add.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("Add_Courses.fxml"));
		Scene scene = new Scene(root,600,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//pane.getChildren().setAll(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		System.out.println("hello");
	}
	
	
	public void courses_click(ActionEvent event) throws Exception
	{
		Stage primaryStage=(Stage) courses.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("ViewCourses.fxml"));
		Scene scene = new Scene(root,600,400);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//pane.getChildren().setAll(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		System.out.println("hello");
	}
	
	public void schedule_click(ActionEvent event) throws Exception
	{
		Stage primaryStage=(Stage) schedule.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("View_Schedule.fxml"));
		Scene scene = new Scene(root,600,400);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//pane.getChildren().setAll(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		System.out.println("hello");
	}
	public void request_click(ActionEvent event) throws Exception
	{
		Stage primaryStage=(Stage) request.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("RequestRoom.fxml"));
		Scene scene = new Scene(root,600,400);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//pane.getChildren().setAll(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		System.out.println("hello");
	}
	
	public void logout_clicked(ActionEvent event) throws Exception
	{
		Stage primaryStage=(Stage) logout.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scene = new Scene(root,600,400);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//pane.getChildren().setAll(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		System.out.println("hello");
	}
	
	
	
	
}
