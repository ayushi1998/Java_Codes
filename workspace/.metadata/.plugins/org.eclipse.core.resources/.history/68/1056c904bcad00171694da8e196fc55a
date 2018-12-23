package MusicTest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;
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




public class MusicApp {

	
		// TODO Auto-generated method stub

	
	
		public	static	void	serializeFile(String f)		throws	IOException	
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
		

		
		public static ArrayList<Songs> Delete(String f,ArrayList<Songs> a,String s) throws	IOException{
			int i=0;
			int flag=0;
			while(i<a.size()){
				//System.out.println(a.get(i));
				if(a.get(i).getName().equals(s))
				{
					flag=1;
					a.remove(a.get(i));
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

	
		
public static void main(String[] args)throws	IOException	, ClassNotFoundException 
{
	
	// 1. To make a directory and files to be put in it(Playlists)
	
	Reader.init(System.in); 
		
	System.out.println("Enter the name of the PlayList");
	String file=Reader.next();

	serializeFile(file);

	// 2. To deserialize the asked Playlist and read it.
	//deserialize1(file);
	ArrayList<Songs> array=deserialize1(file);
	System.out.println("Number of songs in the list "+array.size());
	
	int c=0;
while(true)
{	
System.out.println("1.Add");
System.out.println("2.Delete");
System.out.println("3.Search");	
System.out.println("4.Show");
System.out.println("5.Back to Menu");
System.out.println("6.Exit");
int n=Reader.nextInt();
if(n==1)
{
	System.out.println("Enter Details");
	String songname=Reader.next();
	String sname=Reader.next();
	int time=Reader.nextInt();
	Songs s=new Songs(songname,sname,time);
	array=Add(file,array,s);
	System.out.println("Number of songs in the list "+array.size());
}
if(n==2)
{
	String songname=Reader.next();
	array=Delete(file,array,songname);
	
	System.out.println("Number of songs in the list "+array.size());
	
}

if(n==3)
{
	
	String songname=Reader.next();
	Songs song=Search(file,array,songname);
	System.out.println(song);
	
	
	
}
if(n==4)
{
	//NO SONG SITUATION
	if(array.size()>0){
	for(int i=0;i<array.size();i++){
		System.out.println(array.get(i));
	}
	}else{
		System.out.println("No Song Exists");
	}
}
if(n==5)
{
	System.out.println("Enter the name of the PlayList");
	String file1=Reader.next();

	serializeFile(file1);

	// 2. To deserialize the asked Playlist and read it.
	//deserialize1(file);
	array=deserialize1(file1);
	System.out.println("Number of songs in the list "+array.size());
	
	
	
}
if(n==6){
	break;
}




}



}
}
