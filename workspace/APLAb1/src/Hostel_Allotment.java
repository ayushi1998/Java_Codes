import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



/** Class for buffered reading int and double values */
class Reader{
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}
// This is the Student Class that stores all the attributes of a student.

class Student
{
	private String name;
	private String rollno;
	private String prog;
	private int distance;
	private static int  track;
	private int index;
	Student(String Name, String RollNo, String Prog, int Dis)
	{
		name=Name;
		rollno=RollNo;
		prog=Prog;
		distance=Dis;
		this.track=this.track+1;
		index=track;
	}
	
	public int GetDistance()
	{
		return distance;
	}
	public void string(){
		System.out.println(name+" "+rollno+" "+prog+" "+(distance));
	}

	public int getindex() {
		return index;
	}

	public void setTrack(int track) {
		this.track = track;
	}
	
	
}
// Class Used for Sorting Distances

public class Hostel_Allotment {

	

	
	public void bubblesort(Student[] arr,int num)
	{
		for(int i=0;i<num-1;i++)
		{
			for(int j=0;j<num-i-1;j++){
				if(arr[j+1].GetDistance()>arr[j].GetDistance())
				{
				
					Student temp=arr[j+1];
					
					arr[j+1]=arr[j];
					arr[j]=temp;
					
				}
				
				
			}
		}
		
	}
	public void indexsort(Student[] arr,int num)
	{
		for(int i=0;i<num-1;i++)
		{
			
			for(int j=0;j<num-i-1;j++){

				if(arr[j+1].getindex()<arr[j].getindex())
				{
					
					
					Student temp=arr[j+1];
					
					arr[j+1]=arr[j];
					arr[j]=temp;
					
				}
				
				
			}
		}
		
	}

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		Reader.init(System.in);
		
		int applicants=Reader.nextInt();
		int rooms_avail=Reader.nextInt();
		
		Student[] set=new Student[applicants];
		
		Student[] phdset=new Student[applicants];
		Student[] pgset=new Student[applicants];
		Student[] ugset=new Student[applicants];
		
		
		int count_phd=0;
		int count_pg=0;
		int count_ug=0;
		
		for(int i=0;i<applicants;i++)
		{
			String input=Reader.reader.readLine();
			String[] Words=input.split(" ");
			
			Student info=new Student(Words[0],Words[1],Words[2],Integer.parseInt(Words[3]));
			set[i]=info;
		
			if(Words[2].equals("PG"))
			{
				
				pgset[count_pg]=set[i];
				//System.out.println(pgset[count_pg].getTrack());
				count_pg+=1;
				
			}
			else if(Words[2].equals("PhD"))
			{
				phdset[count_phd]=set[i];
				count_phd+=1;
			}
			else if(Words[2].equals("UG"))
			{
				ugset[count_ug]=set[i];
				count_ug+=1;
			}
			
		}
		
		// Sorting the Allotments 
		Hostel_Allotment obj=new Hostel_Allotment();
		
		obj.bubblesort(pgset, count_pg);
		obj.bubblesort(phdset, count_phd);
		obj.bubblesort(ugset, count_ug);
		
		
		
		
		
		int m=rooms_avail/2;
		int phd_rooms=rooms_avail-m;
		Student[] pg_allot=new Student[m];
		Student[] phd_allot=new Student[rooms_avail-m];
	
		int counter;
		int t=0;
		int z=0;
		int p=0;
		if(m<=count_pg){
		 while(z<m)
		{
		
			pg_allot[z]=pgset[z];

			z=z+1;
		}
		
		}
		else
		{
			while(z<count_pg){
				pg_allot[z]=pgset[z];
				
				z=z+1;
			}
			p=0;
	
			while(z!=pg_allot.length){
				pg_allot[z]=ugset[p];

				p=p+1;
				z=z+1;
			}
		}
		z=0;
		
		if(phd_allot.length<=count_phd){
			 while(z<phd_allot.length)
			{
				phd_allot[z]=phdset[z];
				
				z=z+1;
			}
			
			}
			else
			{
				while(z<count_phd){
					phd_allot[z]=phdset[z];
				
					z=z+1;
					
				}
		
				while(z!=phd_allot.length){
					phd_allot[z]=ugset[p];
					p=p+1;
					z=z+1;
				}
			}
		
		// This Part of the Program is basically for printing out the list in order.
		
		
	    int i=0;
		
		Student[] finalarr=new Student[applicants];
		int a=0;
		
		while(a<m && pg_allot[a]!=null){
			finalarr[a]=pg_allot[a];
			
			a=a+1;
		}
		int b=0;
		while(b<phd_allot.length && phd_allot[b]!=null){
			finalarr[a]=phd_allot[b];
			a=a+1;
			b=b+1;
		}
		
		obj.indexsort(finalarr,a);
		
		for(i=0;i<a;i++){
			finalarr[i].string();
		}

	}

}
