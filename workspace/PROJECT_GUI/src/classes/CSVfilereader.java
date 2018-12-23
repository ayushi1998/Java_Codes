package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVfilereader {
	
	public static List<Course> c;

	public static void main(String[] args)throws IOException {
		//c = readCourseFromCSV("csv.txt");
		c = new ArrayList<Course>();
		Path pathtofile = Paths.get("csv.txt");

		try  {
			File fi=new File("csv.txt");
			FileReader f=new FileReader(fi);
			BufferedReader br = new BufferedReader(f);
			String line = br.readLine();
			//line=br.readLine();
			while (line != null) {
				//String[] s1 = line.split(",");
				//System.out.println(s1[0]);
				String[] s2 = line.split(",");
				Course course = new Course(s2[0], s2[1], s2[2], s2[3], s2[4], s2[5], s2[6], s2[7], s2[8], s2[9],
						s2[10], s2[11], s2[12], s2[13], s2[14]);
				c.add(course);
				line = br.readLine();
				
			}
			f.close();
		}
		finally
		{
			
		}
		
		 ObjectOutputStream UsersList=null;	
			
			try	
			{	
				UsersList=new ObjectOutputStream(new FileOutputStream("AllCourses.txt"));	
				UsersList.writeObject(c);			
			}	
			finally	
			{	
				UsersList.close();	
			}	
			
		
		for (Course b : c) {
			System.out.println(b.postcond);
		}

	}
	
	
/*
	public static List<Course> readCourseFromCSV(String file) throws IOException {
		List<Course> c = new ArrayList<Course>();
		Path pathtofile = Paths.get(file);

		try  {
			File fi=new File("csv.txt");
			FileReader f=new FileReader(fi);
			BufferedReader br = new BufferedReader(f);
			String line = br.readLine();
			//line=br.readLine();
			while (line != null) {
				//String[] s1 = line.split(",");
				//System.out.println(s1[0]);
				String[] s2 = line.split(",");
				Course course = new Course(s2[0], s2[1], s2[2], s2[3], s2[4], s2[5], s2[6], s2[7], s2[8], s2[9],
						s2[10], s2[11], s2[12], s2[13], s2[14]);
				c.add(course);
				line = br.readLine();
				
			}
			f.close();
		}
		finally
		{
			
		}
		return c;

	}
	
*/
}
