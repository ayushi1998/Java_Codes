package lab4;

import java.io.IOException;

public class splitlist {
	node header;
	public splitlist(){
		header=new node();
	}
	
	public splitlist list(){
		node a=null;
		node b=null;
		int cnt=0;
		node current= header.link;
		while(current!=null)
		{
			cnt++;
			current=current.link;
			
		}
		current=header.link;
		for (int i=0; i<(cnt/2);i++){
			a.setLink(current);
			current=current.link;
			a=a.link;
			
		}
		return a;
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
	     int m=Reader.nextInt();
	     splitlist obj=new splitlist();
	     
	     int q=Reader.nextInt();
	     node curr=obj.header;
	     
	     for(int i=0;i<m;i++){
	    	 int n=Reader.nextInt();
	    	 node element=new node(n);
	    	 curr.setLink(element);
	    	 curr=curr.link;
	    	 
	    	 
	     }

	}

}
