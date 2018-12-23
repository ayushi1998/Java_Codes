package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

import classes.User;

public class Test implements Serializable{
	static ArrayList<User> userlist=new ArrayList<User>();
	public static ArrayList<User>  deserializefile() throws ClassNotFoundException, IOException{
		 ObjectInputStream fileread=null;
		 ArrayList<User> array=null;
		try{
			fileread=new ObjectInputStream(new FileInputStream("User.txt"));
			array=(ArrayList<User>) fileread.readObject();
			userlist=array;
		}
		finally{
			fileread.close();
		}
		return array;
	}
	
	public	static	void	main(String[]	args)	
						throws	IOException,ClassNotFoundException {
		ArrayList<User> u=deserializefile();
		System.out.println(u.get(1));
		
	}
		
		

	}
