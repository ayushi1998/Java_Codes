import java.io.IOException;

import java.io.BufferedReader;
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

class node {
    
	node link;
	String data;
	
	
	public node(String data,node newlink)
	{
		
		this.data=data; 
		link=newlink;
	 }
	
	public node()
	{
		
		
		link=null;
		
	}
	
	public node(String data)
	{
		this.data=data;
		link=null;
	}
	
	public node getLink()
	{
		return link;
	}
	
	public void setLink(node newlink)
	{
		link=newlink;
	}
	
	public String getData()
	{
		return data;
	}
	

}


class stack
{                           // A node top to keep a track of first element.
	node top;
	                             
	public stack()           // A class stack to store characters other than digits.
	{
		top=new node();				
	}
	
	
	public String pop()
	{
		String b;           // Function pop() is used to pop out the first element in the stack.

          b=top.getData();
	      top=top.link;
	      
		  return(b);
		  

		
		
	}
	
	public void push(String v)
	{
		node value=new node(v,null);   // To push elements is the stack.
		
		
		value.setLink(top);
		top=value;

	}
	
	
		
	
}


public class Expression    // This class is meant to make a stack.
{
	stack values;
	
	public Expression()           
	{
		values=new stack();
    }
	
	
	

	

	
	
	
	
	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);
		int n=Reader.nextInt();
		Expression obj=new Expression();

		for(int i=0;i<n;i++)
		{
			String a=Reader.next();
			char[] check=a.toCharArray();
			boolean isDig = Character.isDigit(check[0]);
			
			if(isDig)            // we check the input simultaneously and the following algorithm is implemented:
				                 // 1. If its a digit: Return it to the answer.
				                 // 2. If its + or -:  Check if there is "*"  / "/" : then pop that element. Else just push it.
				                 // 3. If its "*"  / "/" : Then push it in stack.
				                 // 4. If its "(": push it in stack.
				                 // 5. If its ")": Keep popping elements of the stack.And then pop the "(".
			{

				System.out.print(a+" ");
				
			}
			
			else
			{
				if((obj.values.top.link==null)){
					obj.values.push(a);
				}
				
			 else if(a.equals("+") || a.equals("-"))
				{
					
					
					while((obj.values.top.getData().equals("*") || obj.values.top.getData().equals("/")) && obj.values.top.link!=null)
					{
						
						System.out.print(obj.values.pop()+" ");
						if(obj.values.top.link==null){
							break;
						}
						
					}

					obj.values.push(a);
					
				}
				
				else if(a.equals("*") || a.equals("/"))
				{
					
					{
						obj.values.push(a);
					}
					
				}
				
				else if(a.equals("("))
				{

					obj.values.push(a);
				}
				
				else if(a.equals(")"))
				{
					
					while(!(obj.values.top.getData().equals("(")) && (obj.values.top!=null))
					{
						
						System.out.print(obj.values.pop()+ " ");
						if(obj.values.top.link==null)
						{
							break;
						}
					   
					   
					   
					}
					
					           obj.values.pop();
					          
					
				}
				
				
				
				
				
					
				}
			
			}
		
		while(obj.values.top.link!=null  )
		{
			System.out.print(obj.values.pop()+" ");
		
		}

		
	}
	
	} 