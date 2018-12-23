package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class admin_controller 
{
	@FXML
	Button view;
	@FXML
	Button add;
	@FXML
	Button cancel;
	@FXML
	Button check;
	@FXML
	Button logout;
	
	@FXML
	Label username;
	
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
		Pane root= FXMLLoader.load(getClass().getResource("BookClass.fxml"));
		Scene scene = new Scene(root,600,400);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//pane.getChildren().setAll(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		System.out.println("hello");
	}
	
	
	public void cancel_click(ActionEvent event) throws Exception
	{
		Stage primaryStage=(Stage) cancel.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("CancelRoom.fxml"));
		Scene scene = new Scene(root,600,400);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//pane.getChildren().setAll(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		System.out.println("hello");
	}
	
	public void check_click(ActionEvent event) throws Exception
	{
		Stage primaryStage=(Stage) check.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("Handle_request.fxml"));
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
