



import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
class CourseCSV {
	String coption;  //   Mandatory / Elective
	String cname;
	String ccode;
	String instr;
	String credits;
	String acro;
	String mon_slot;
	String tue_slot;
	String wed_slot;
	String thu_slot;
	String fri_slot;
	String tut_slot;
	String lab_slot;
	String precond;
	String postcond;
	
	public CourseCSV(String a,String b, String c,String d,String e, String f,String g,String h,String i,String j,String k,String l,String m,String n,String o)
	{
		coption=a;
		cname=b;
		ccode=c;
		instr=d;
		credits=e;
		acro=f;
		mon_slot=g;
		tue_slot=h;
		wed_slot=i;
		thu_slot=j;
		fri_slot=k;
	    tut_slot=l;
		lab_slot=m;
		precond=n;
		postcond=o;
	}
	
}
public class CSVfilereader {
 
	public static void main(String args) throws IOException 
	{
		List<CourseCSV> c = readCourseFromCSV("csv.txt"); 
		for(CourseCSV b:c)
		{
			System.out.println(b.toString());
		}
		
}
	
	public static List<CourseCSV> readCourseFromCSV(String file) throws IOException
	{
		List<CourseCSV> c=new ArrayList<>();
		Path pathtofile=Paths.get(file);
		
		try(BufferedReader br= Files.newBufferedReader(pathtofile,StandardCharsets.US_ASCII)){
			String line=br.readLine();
			while(line!=null)
			{
				String[] s1=line.split(" \" ");
				String[] s2=s1[0].split(",");
				CourseCSV course= new CourseCSV(s2[0],s2[1],s2[2],s2[3],s2[4],s2[5],s2[6],s2[7],s2[8],s2[9],s2[10],s2[11],s2[12],s1[1],s1[3]);
				c.add(course);
				line=br.readLine();
			}
			
		}
		return c;
		
	}
}

