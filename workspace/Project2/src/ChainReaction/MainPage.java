package ChainReaction;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * This class is the MainPage of the game.
 * It holds several fields like 2 ComboBoxes, 2 integers for number of players and grid option.
 * It contains an array of Players and an instance of Game
 * @author Surabhi, Raghav
 * @version
 * @since
 * 
 */
public class MainPage extends Application implements Initializable
{
	static Player players[];
	static Game2 game;
	static Stage ps;
	@FXML private ComboBox<String> comboBox1;
	@FXML private ComboBox<String> comboBox2;
	static int num_players=2;
	static int grid_size=1;
	static String temp="2 Player Game";
	static String temp1="9 x 6 Grid";

	@Override
	public void initialize(URL url, ResourceBundle rb)
	{
		comboBox1.setPromptText(temp);
		comboBox2.setPromptText(temp1);
		comboBox1.getItems().addAll("2 Player Game","3 Player Game","4 Player Game","5 Player Game","6 Player Game","7 Player Game","8 Player Game");
		comboBox2.getItems().addAll("9 x 6 Grid","15 x 10 Grid");
	}


	public MainPage()
	{
		
	}

	public MainPage(Player[] p,Game2 game)
	{
		players=p;
		this.game=game;
	}

	@Override
	public void start(Stage primaryStage) throws IOException
	{
		ps=primaryStage;
		comboBox1=new ComboBox<String>();
		comboBox2=new ComboBox<String>();

		if(game.finished==true)
		{
			Parent root=FXMLLoader.load(getClass().getResource("MainPage.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		}

		else
		{
			Parent root=FXMLLoader.load(getClass().getResource("MainPage2.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
	}


	/**
	 * This method sets the number of Players based on the option chosen from dropdown ComboBox
	 */
	public void selectnumplayers()
	{
		temp=comboBox1.getValue();
		num_players=Integer.parseInt(comboBox1.getValue().toString().substring(0,1));
	}


	/**
	 * This method sets the grid size chosen based on the option chosen from dropdown ComboBox 
	 */
	public void selectgridsize()
	{
		temp1=comboBox2.getValue();
		if(comboBox2.getValue().toString().equals("9 x 6 Grid"))
			grid_size=1;
		else
			grid_size=2;
	}
	

	/**
	 * This method is called when play button is clicked
	 * It initializes the Game instance and calls play() method on it
	 * @throws Exception
	 */
	public void StartGame() throws Exception
	{
		game=new Game2(players,num_players,grid_size,ps);
		game.play();
	}

	
	/**
	 * This method is called when Resume button is clicked
	 * It stores the data of the game by deserialization and creates instance of reverse game data to retrieve the grid
	 * @throws Exception
	 */
	public void ResumeGame() throws Exception
	{
		Gamedata gamedata=App.deserialize();
		Game2.UltuGameData ultugameData = game.new UltuGameData(gamedata.array, gamedata.count, gamedata.g, gamedata.grid_size,gamedata.tiles,ps,gamedata.num_players);
	}

	/**
	 * This method is called when Player Setting option is clicked
	 * It creates new Settings and calls start method
	 * @throws Exception
	 */
	public void GoToSettings() throws Exception
	{
		Settings settings = new Settings(players,ps,this);
		settings.start(ps);
	}

	
	/**
	 * This method loads the MainPage with or without Resume button based on previous game result
	 * @throws Exception
	 */
	public void display() throws Exception
	{
		if(game.finished==true)
		{
			Parent root=FXMLLoader.load(getClass().getResource("MainPage.fxml"));
			Scene scene = new Scene(root);
			ps.setScene(scene);
			ps.show();
		}

		else
		{
			Parent root=FXMLLoader.load(getClass().getResource("MainPage2.fxml"));
			Scene scene = new Scene(root);
			ps.setScene(scene);
			ps.show();
		}
	}
}
