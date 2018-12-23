package Test;
/*	Junit testcase	class-1	*/	
import	org.junit.Test;

import MusicTest.*;

import	static	org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
public class Test1 
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
	
	
	public static ArrayList<Songs> Add(String f,ArrayList<Songs> a,Songs s) throws	IOException
	{
		
	
		
		a.add(s);
		
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
		
		return a;
		
	}
	
	
	
	
	
	@Test
	public void TestAdd() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		
		ArrayList<Songs> result=new ArrayList<Songs>();
		Songs	s1	=	new	Songs("Promises","Demi",10);
		Songs s2= new Songs("Roar","Katty",20);
		Songs s3= new Songs("Faded","Alan",30);
		Songs s4=new Songs("Titanium","Lavato",600);
		result.add(s1);
		result.add(s2);
		result.add(s3);
		result.add(s4);
		
		
		MakingFile("English.txt");
		ArrayList<Songs> arr=deserialize1("English.txt");
		
		// ADDING A SONG
		Songs Eng=new Songs("Titanium","Lavato",600);
		arr=Add("English.txt",arr,Eng);
	
		for(int i=0;i<arr.size();i++)
		{
			assertEquals(result.get(i),arr.get(i));
		}
	
	}

}
