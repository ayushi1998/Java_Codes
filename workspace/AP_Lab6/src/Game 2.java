import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
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

/*
 * 1. If no exceptions print “No exception” <coordinates popped (x y)> .
  2. If popped value not a coordinate, “NonCoordinateException: Not a coordinate
Exception ” < Value popped >.
    3. If Stack gets empty “ StackEmptyException: Stack Empty exception ”.
  4. If the knights new coordinate overlap with other knights coordinates
“ OverlapException: Knights Overlap Exception ” < Name of the other knight >
 5. If queen is found “ QueenFoundException: Queen has been Found. Abort! ”
 * 
 * 
 */


class NonCoordinateException extends Exception	
{	
	public	NonCoordinateException (String	message)	
	{	
					super(message);	
	}	
}

class StackEmptyException 	extends	Exception	
{	
	public	StackEmptyException(String	message)	
	{	
					super(message);	
	}	
}

class OverlapException	extends	Exception	
{	
	public	OverlapException(String	message)	
	{	
					super(message);	
	}	
}

class QueenFoundException	extends	Exception	
{	
	public	QueenFoundException(String	message)	
	{	
					super(message);	
	}	
}








class pt
{
	double x;
	double y;
	
	pt(double x,double y)
	{
		this.x=x;
		this.y=y;
	}
}
class Knight implements Comparator<Knight>
{
	String name;
	int x;
	int y;
	Stack<Object> box;
	pt p;
	int flag=0;
	Knight(String a,int x,int y,Stack<Object> s,pt point)
	{
		name=a;
		this.x=x;
		this.y=y;
		box=s;
		this.p=point;
	}
	
	public void Remove() throws  NonCoordinateException, StackEmptyException ,OverlapException
	{
		if(box.size()<=0){
			throw new StackEmptyException(" StackEmptyException: Stack Empty exception .");
		}
		else{
		Object obj=box.pop();
		
		//System.out.println( obj instanceof pt);
		if(obj instanceof pt)
		{
			// Coordinate popped
			pt obj1 =(pt) obj;
			
		
			this.x=(int) obj1.x;
			this.y=(int) obj1.y;
			flag=1;
			//System.out.println(this.x+"NEW");
			
			
		}
		
		else
		{
			throw new NonCoordinateException("NonCoordinateException: Not a coordinateException"+obj);
		}
		
	
	}	
	}
	
	public void rem(int x1,int y1) throws QueenFoundException
	{
		if(this.x==x1 && this.y==y1)
		{
			throw new QueenFoundException("QeenFoundException: Queen has been Found. Abort! ");
		}
	}
	@Override
	public int compare(Knight k1, Knight k2) {
		// TODO Auto-generated method stub
		if(k1.name.compareTo(k2.name)>0){
			return 1;
			
	}
		else{
			return -1;
		}
		
	}

	
	
	
	
	
	
	
}


class array implements Comparator<Knight>
{
	@Override
	public int compare(Knight an1, Knight an2) 
	{
		if(an1.name.compareTo(an2.name)>0){
			return 1;
			
	}
		else{
			return -1;
		}
	}
}



public class Game {
	public static void main(String[] args) throws IOException , NonCoordinateException, StackEmptyException, OverlapException,QueenFoundException{
		// TODO Auto-generated method stub
		Reader.init(System.in); 
		
		System.out.println("The number of knights -");
		int n=Reader.nextInt();
		
		System.out.println("The total number of iterations -");
		int iter=Reader.nextInt();
		System.out.println("Coordinates of queen x and y -");
		int queen_x=Reader.nextInt();
		int queen_y=Reader.nextInt();
		//Comparator<Knight> compare=new array();
		ArrayList<Knight> arr=new ArrayList<Knight>();
	
		// INPUT FILES
		
		for(int z=1;z<=n;z++)
		{
		List<String> input=Files.readAllLines(Paths.get("/Users/ayushi/Documents/workspace/AP_Lab6/src/"+z+".txt"),StandardCharsets.UTF_8);
		ListIterator listit=input.listIterator();
		
		
		
		//Point is a string split krkr daalo.
		String wrd=input.get(1);
		String[] value=wrd.split(" ");
		
		//add the knight object
		pt p=new pt(Integer.parseInt(value[0]),Integer.parseInt(value[1]));
		Stack<Object> s=new Stack<Object>();
		Knight knight=new Knight(input.get(0),Integer.parseInt(value[0]),Integer.parseInt(value[1]),s,p);
		
		//read for stack
		int m=Integer.parseInt(input.get(2));
		
		for(int j=0;j<m;j++)
		{
			String val=input.get(3+j);
		
			String[] v=val.split(" ");
			
			if(v[0].equals("Integer"))
			{
				s.push(Integer.parseInt(v[1]));
				//System.out.println(s.pop()+"Int");
			//	s.push(Integer.parseInt(v[1]));
			}
			
			else if(v[0].equals("String"))
			{
				s.push((v[1]));
			}
			
			else if(v[0].equals("Coordinate"))
			{
				int x=Integer.parseInt(v[1]);
				int y=Integer.parseInt(v[2]);
				pt point=new pt(x,y);
				s.push(point);
				//pt o=(pt) s.pop();
				//System.out.println(o.x+" "+o.y+"point");
				//s.push(point);
			}
			else
			{
				s.push(Float.parseFloat((v[1])));
			}
			
			
		}//finished stack.
				
	
		arr.add(knight);
	
		while(listit.hasNext())
		{
			Object ob=(listit.next());
		}
	}
		
		
		//ArrayList sort
		
		Collections.sort(arr,new array());
		
		
		
		PrintWriter writef=new PrintWriter("./src/answer.txt","UTF-8");
		
		//Iterations 
		int l=0;
		int cnt=n;
		while(l<iter && arr.size()>0)
		{
			//int k=0;
			cnt=arr.size();
			for(int k=0;k<arr.size();k++)
			{
				try
				{
					
				
				Knight kni=(Knight) arr.get(k);
				
				writef.println(l+1+" "+kni.name+" "+kni.x+" "+kni.y);
				
				System.out.println(l+1+" "+kni.name+" "+kni.x+" "+kni.y);
				kni.Remove();
				
				kni.rem(queen_x, queen_y);
				//k=k+1;
				for(int h=0;h<arr.size();h++)
				{
					Knight o=(Knight) arr.get(h);
					//System.out.println(h+" "+k);
					if(h!=k)
					{
						
						if(o.x==kni.x && o.y==kni.y)
						{
							arr.remove(o);
							kni.flag=0;
							//writef.println("OverlapException: Knights Overlap Exception "+ o.name );
							throw new OverlapException("OverlapException: Knights Overlap Exception "+ o.name);
						}
						
					}
					
				}
				if(kni.flag==1){
					writef.println("No Exception:Coordinates popped "+ (int)kni.x+ " "+(int)kni.y );
					System.out.println("No Exception:Coordinates popped "+ (int)kni.x+ " "+(int)kni.y);
				}
			     }
				
				
				catch(NonCoordinateException e)
				{
					writef.println(e.getMessage());
					System.out.println(e.getMessage());	
				}
				
				catch(StackEmptyException	e)
				{
					Knight kni=(Knight) arr.get(k);
					arr.remove(kni);
					writef.println(e.getMessage());
					System.out.println(e.getMessage());	
					cnt=cnt-1;
					
				}
				
				catch (OverlapException e)
				{
					writef.println(e.getMessage());
					System.out.println(e.getMessage());
					cnt=cnt-1;
					
				}
				
				catch (QueenFoundException e)
				{
					writef.println(e.getMessage());
					System.out.println(e.getMessage());
					cnt=-1;
					break;
					
				}
				
				
				
				
			}
			if(cnt==-1){
				break;
			}
			l=l+1;
		}
		
		
		writef.close();
		
		
		
		
		
		
		
		
		
		
	}

}
