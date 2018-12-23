package lab4;



public class node1 {
    
    	node1 link;
    	int data;
    	
    	node1(int data,node1 newlink)
    	{
    		
    		this.data=data; 
    		link=newlink;
    	 }
    	node1(){
    		
    		
    		link=null;
    		
    	}
    	node1(int data){
    		this.data=data;
    		link=null;
    	}
    	
    	public node1 getLink(){
    		return link;
    	}
    	public void setLink(node1 newlink){
    		link=newlink;
    	}
    	
    	public int getData(){
    		return data;
    	}
    	

    }

