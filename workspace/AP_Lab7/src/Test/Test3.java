package Test;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.junit.Test;

import MusicTest.Songs;

public class Test3 
{

	public void MakingFile(String f) throws IOException
	{
		Songs	s1	=	new	Songs("Promises","Demi",10);
		Songs s2= new Songs("Roar","Katty",20);
		Songs s3= new Songs("Faded","Alan",30);
		ArrayList<Songs> a=new ArrayList<Songs>();
		a.add(s1);
		a.add(s2);
		a.add(s3);
		ObjectOutputStream outfile	=	null;	
		try	
		{	
				outfile	=new ObjectOutputStream(new FileOutputStream(f));	
				 outfile.writeObject(a);	
					
		}	
		finally	
		{	
				outfile.close();	
		}	
	}
	
	public static ArrayList<Songs> deserialize1(String f) throws IOException, ClassNotFoundException {
		
		ArrayList<Songs> a;
		ObjectInputStream in=null;
		try{
			int c=3;
			
				in=new ObjectInputStream(new FileInputStream(f));
				a=(ArrayList<Songs>) in.readObject();
	
		}finally{
			in.close();
		}
		return a;
	}
	public static Songs Search(String f,ArrayList<Songs> a,String s) throws	IOException
	{
		int i=0;
		int flag=0;
		Songs song=null;
		while(i<a.size()){
			//System.out.println(a.get(i));
			if(a.get(i).getName().equals(s))
			{
				flag=1;
				song=a.get(i);
				//System.out.println(a.get(i));
			}
			i=i+1;
		}
		if(flag==0){
			System.out.println("Error: No name");
		}
		ObjectOutputStream outfile	=	null;	
		try	
		{	
				outfile	=	new	ObjectOutputStream	(	
											new FileOutputStream(f));	
					outfile.writeObject(a);	
					
		}	
		finally	
		{	
				outfile.close();	
		}	
		return(song);
		
	}


	
	@Test	
	public void TestSearch() throws IOException, ClassNotFoundException 
	{
		
		ArrayList<Songs> result=new ArrayList<Songs>();
		Songs	s1	=	new	Songs("Promises","Demi",10);
		Songs s2= new Songs("Roar","Katty",20);
		Songs s3= new Songs("Faded","Alan",30);
		//Songs s4=new Songs("Titanium","Lavato",600);
		result.add(s1);
		result.add(s2);
		result.add(s3);
		//result.add(s4);
		
		
		MakingFile("English.txt");
		ArrayList<Songs> arr=deserialize1("English.txt");
		
		// Searching A SONG
		
		Songs Name=Search("English.txt",arr,"Promises");
	
		
			assertEquals(s1,Name);
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
