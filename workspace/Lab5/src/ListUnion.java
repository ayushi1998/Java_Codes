
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

class node {
    
	node link;
	int data;
	int comp=0;
	
	node(int data,node newlink)
	{
		
		this.data=data; 
		link=newlink;
	 }
	node(){
		
		data=0;
		link=null;
		
	}
	node(int data){
		this.data=data;
		link=null;
	}
	
	public node getLink(){
		return link;
	}
	public void setLink(node newlink){
		link=newlink;
	}
	
	public int getData(){
		return data;
	}
	

}





public class ListUnion {
	
	node header;
    int cnt;
    int comp;
   
    	
    
    public ListUnion(int m)
    {
    	header=new node();
    	cnt=m;
    	
    }
    
    
    public ListUnion compare(ListUnion a,ListUnion b)
   {
        comp=0;                                    //no. of comparisons.
    	ListUnion newlist=new ListUnion(a.cnt+b.cnt);
    	node listcurrent=newlist.header;              //header pointer for newlist.
    	node curr1=a.header;
    	node curr2=b.header;
  
    	
    		while((curr1.link!=null)&& (curr2.link!=null)){
    			
    			if(curr1.link.getData()>curr2.link.getData())
    			{
    				
    				node element=new node(curr2.link.getData());
    				listcurrent.setLink(element);
    				curr2=curr2.link;
    				listcurrent=listcurrent.link;
    				newlist.comp++;
    				
    			}
    			else
    			{
    				node element=new node(curr1.link.getData());
    				listcurrent.setLink(element);
    				curr1=curr1.link;
    				listcurrent=listcurrent.link;
    				newlist.comp++;
    			}
    		}
    		     if(curr2.link!=null)
    		    	 
    		    	 
    		     {   while((curr2.link!=null)){
    		    	 
    		     
    		    	node element=new node(curr2.link.getData());
     				listcurrent.setLink(element);
     				curr2=curr2.link;
     				listcurrent=listcurrent.link;
    		    	 
    		     }
    		     }
    		     if(curr1.link!=null)
    		     {   while((curr1.link!=null)){
    		    	node element=new node(curr1.link.getData());
     				listcurrent.setLink(element);
     				curr1=curr1.link;
     				listcurrent=listcurrent.link;
    		    	 
    		     }
    		     }
    		 
    		 
    	
    	
    	
    	
    	return newlist;
    	
    }
    
    public void display()
    {
    	//this method is used for displaying the elements of the list.
    	node start=header;
    	
    	while(start.link!=null){
    		
    		System.out.print(start.link.getData()+" ");
    		start=start.link;
    		
    	}
    	System.out.println();
    }
    
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Reader.init(System.in);
	     int x=Reader.nextInt();
	     int y=Reader.nextInt();
	     ListUnion obj1=new ListUnion(x);
	     ListUnion obj2=new ListUnion(y);
	     node curr1=obj1.header;
	     node curr2=obj2.header;
	     
	     for(int i=0;i<x;i++)
	     {
	    	 int n=Reader.nextInt();
	    	 node element=new node(n);
	    	 curr1.setLink(element);
	    	 curr1=curr1.link; 
	     }
	     for(int j=0;j<y;j++)
	     {
	    	 int n=Reader.nextInt();
	    	 node element=new node(n);
	    	 curr2.setLink(element);
	    	 curr2=curr2.link; 
	     }
	     
	    
	    
	     ListUnion z=obj1.compare(obj1,obj2);
	     z.display();
	     System.out.println(z.comp);
	     
	}
}

