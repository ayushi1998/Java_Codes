

	
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;


	
	





	public class LabUnion1 {
		
		LabUnion1 header;
	    int data;
	    int comp;
	    LabUnion1 link;
	    	
	    
	    public LabUnion1()
	    {
	    	header=null;
	    	data=0;
	    	
	    }
	    
	    LabUnion1(int data)
	    {
    		this.data=data;
    		link=null;
    	}
	    
	    public int getData(){
    		return data;
    	}
	    public LabUnion1 getLink(){
    		return link;
    	}
	    
	    public void setLink(LabUnion1 newlink){
    		link=newlink;
    	}
	    public LabUnion1 MergeSort(LabUnion1 a,LabUnion1 b)
	    { 
	    	comp=0;                                    //no. of comparisons.
	    	LabUnion1 newlist=new LabUnion1();
	    	LabUnion1 listcurrent=newlist.header; 
	    	LabUnion1 curr1=a;
	    	LabUnion1 curr2=b;
	    	while((curr1!=null) && (curr2!=null))
	       {
	    		if(curr1.getData()<curr2.getData()){
	    			LabUnion1 element=new LabUnion1(curr1.getData());
	    			listcurrent.setLink(element);
	    			listcurrent=listcurrent.link;
	    			comp++;
	    		}
	    		else
	    		{
	    			
		    			LabUnion1 element=new LabUnion1(curr2.getData());
		    			listcurrent.setLink(element);
		    			listcurrent=listcurrent.link;
		    			comp++;
	    		}
	    		
	    	}
	    	
	    	if(curr1.link!=null){
	    		
	    	}
	    	if(curr2.link!=null){
	    		
	    	}
	    	
	    	
	    	
	       
			return newlist;
}
	    
	    public void display()
	    {
	     LabUnion1 start=header.link;
	     while(start!=null){
	    	 System.out.print(start.getData()+" ");
	    	 start=start.link;
	     }
	     System.out.println();
	    	
	    	
	    }
	    
	    
	    public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			
			Reader.init(System.in);
		     int x=Reader.nextInt();
		     int y=Reader.nextInt();
		     LabUnion1 obj1=new LabUnion1();
		     LabUnion1 obj2=new LabUnion1();
		     LabUnion1 curr1=obj1.header;
		     LabUnion1 curr2=obj2.header;
		     System.out.println(curr1.getLink());
		     for(int i=0;i<x;i++)
		     {
		    	 int n=Reader.nextInt();
		    	 System.out.println(1);
		    	 LabUnion1 element=new LabUnion1(n);
		    	 curr1.setLink(element);
		    	 curr1=curr1.link; 
		     }
		     for(int j=0;j<y;j++)
		     {
		    	 int n=Reader.nextInt();
		    	 LabUnion1 element=new LabUnion1(n);
		    	 curr2.setLink(element);
		    	 curr2=curr2.link; 
		     }
		     
		    
		    
		     LabUnion1 z=obj1.MergeSort(obj1,obj2);
		     obj1.display();
		    System.out.println(z.comp);
		     
		}

		
	    
	}
	
	
	
