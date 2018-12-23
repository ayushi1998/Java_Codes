package lab4;
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




public class MyLinkedlist {
    node header;
    int cnt;
    
   
    	
    
    public MyLinkedlist(int m)
    {
    	header=new node();
    	cnt=m;
    	
    }
    
    public void addtoList(int v)
    //This method will insert the element v at the beginning of the list.
    {
    	node nptr=new node(v,null);
    	node temp= header.link;
    	nptr.setLink(temp); 
    	header.link=nptr;
    	cnt++;
    }
    public void delete()
    {
    	//this method pops out the element from the beginning of the list.
    	node ptr = header.getLink();
    	
    	  header = ptr;
    	  cnt--;
    
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
    public void compare(MyLinkedlist l)
    {
    	//this method is used for comparing the 2 lists.
    	int flag=0;
    	node ptr1=header.link;
    	node ptr2=l.header.link;
    	
    	while((ptr1!=null && ptr2!=null)){
    		if(ptr1.getData()!=ptr2.getData()){
    			ptr1=ptr1.link;
    		}else{
    			  while( flag<=l.cnt && (ptr1!=null && ptr2!=null))
    			  {
    				  
    				  if((ptr1.getData()==ptr2.getData())){
    					 
    				  flag++;
    				  ptr1=ptr1.link;
    				  ptr2=ptr2.link;}
    				  else{
    					  flag=0;
    					  ptr2=l.header.link;
    					  break;
    				  }
    				  
    			  }
    			  
    		}
    		
    	}
    	if(flag==l.cnt){
    		System.out.println(1);
    		
    	}else{
    		System.out.println(0);
    	}
		
    	
   }

    
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
	     Reader.init(System.in);
	     int m=Reader.nextInt();
	     MyLinkedlist obj=new MyLinkedlist(m);
	     
	     int q=Reader.nextInt();
	     node curr=obj.header;
	     System.out.println(curr.getLink());
	     
	     for(int i=0;i<m;i++){
	    	 int n=Reader.nextInt();
	    	 node element=new node(n);
	    	 curr.setLink(element);
	    	 curr=curr.link;
	    	 
	    	 
	     }
	     while(q-->0){
	    	 int ask=Reader.nextInt();
	    	 if(ask==1){
	    		 int askval=Reader.nextInt();
	    		 obj.addtoList(askval);
	    	 }else if(ask==2){
	    		 obj.delete();
	    	 }else if(ask==3){
	    		 obj.display();
	    	 }else if(ask==4){
	    		 int k=Reader.nextInt();
	    		 MyLinkedlist obj1=new MyLinkedlist(k);
	    		 node curr1=obj1.header;
	    	     for(int i=0;i<k;i++){
	    	    	 int y=Reader.nextInt();
	    	    	 node ele=new node(y);
	    	    	 curr1.setLink(ele);
	    	    	 curr1=curr1.link;
	    	    	 
	    	     }
	    	     
	    	     if(obj.cnt<=obj1.cnt){
	    	    	 obj1.compare(obj);
	    	     }
	    	    	 else{
	    	    		 System.out.println(0);
	    	    	 }
	    	    	
	    	    	 
	    	     }
	    	     
	    		 
	    	 }
	     }
}
	


