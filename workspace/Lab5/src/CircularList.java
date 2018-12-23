import java.io.IOException;




class nod{
    
	nod link;
	int data;
	
	nod(int data,nod newlink)
	{
		
		this.data=data; 
		link=newlink;
	 }
	nod(){
		
		data=0;
		link=null;
		
	}
	nod(int data){
		this.data=data;
		link=null;
	}
	
	public nod getLink(){
		return link;
	}
	public void setLink(nod newlink){
		link=newlink;
	}
	
	public int getData(){
		return data;
	}
	

}






public class CircularList 
{
	nod header;
	nod rear;
	int cnt;
    
	public CircularList(int m){
		nod header=new nod();
		nod rear=new nod();
		cnt=m;
			
	}
	
	public void insert(int a)
	{
		
		
	}
	
	
	/*public void print(){
		node start=header.link;
		while(start!=rear)
		{
			System.out.println(start.getData());
		}
	}  */

public static void main(String[] args) throws IOException {
	// TODO Auto-generated method stub
	
	 Reader.init(System.in);
     int x=Reader.nextInt();
     
     CircularList obj1=new CircularList(x);
     
     
     System.out.println(obj1);
     System.out.println(obj1.header);
     
     nod temp=obj1.header;
     nod newnode=new nod(5);
     temp.setLink(newnode);
     System.out.println(newnode.getData());
     temp=temp.link;
     obj1.rear.setLink(obj1.header);
   /*  for(int i=0;i<x;i++)
     {
    	 
    	 int n=Reader.nextInt();
    	 
    	 nod newnode=new nod(n);
 		
 		if(obj1.cnt==1)
 		{
 			obj1.header=newnode;
 			obj1.rear=newnode;			
 		}
 		else
 		{   
 			
 			temp=temp.link;
 			obj1.rear=temp;
 		}
 		obj1.rear.setLink(obj1.header);
    	 
    	 
     }  */

    
    
     
}
}