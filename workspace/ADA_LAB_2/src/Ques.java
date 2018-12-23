import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.sun.javafx.collections.MappingChange.Map;

import javafx.util.Pair;

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

	 static long nextLong() throws IOException{
		// TODO Auto-generated method stub
		return Long.parseLong( next() );
	}
}

class node {
    
	node link;
	int x;
	int y;
	
	
	node(int x,int y,node newlink)
	{
		
		this.x=x; 
		this.y=y;
		link=newlink;
	 }
	node(){
		
		
		link=null;
		
	}
	node(int x,int y){
		this.x=x; 
		this.y=y;
		link=null;
	}
	
	public node getLink(){
		return link;
	}
	public void setLink(node newlink){
		link=newlink;
	}
	
	
	public int getx(){
		return (x);
	}
	public int gety(){
		return (y);
	}
	

}

class queue{
	node rear;
	node front;
	public queue(){
		rear=new node();
		front=new node();
	}
	
	public boolean isEmpty()
	{
		if(rear.link==null)
		{
			return true;
		}
		return false;
		
	}
	
	public void Enqueue(node n)
	{
		node newnode=new node(n.getx(),n.gety());
		if(rear.link==null)
		{
			
			front.link=newnode;
			
			
		}
		else
		{
		
		rear.link.setLink(newnode);
		
		}
		rear.link=newnode;
		
	}
	public node Dequeue()
	{
		node dq=new node(front.link.getx(),front.link.gety());
		//System.out.println(front.link.getx()+ " "+ front.link.gety()+"dq");
		front=front.link;
		if(front.link==null)
		{
			rear.link=null;
		}
		
		return dq;
		
	}	
}






public class Ques 
{
	int r;
	int c;
	int[][] adj_matrix;   // Values aagayi
	queue q;
	
	

	Map<Integer,Map< Integer,Integer > > m=new HashMap<Integer,Map< Integer,Integer > >;
	PriorityQueue<Map<Integer,Map<Integer,Integer> > p =new PriorityQueue<Map<Integer,Map<Integer,Integer > >();
	
	
	
	int mind(int dist[],int[][] set)
	{
		
		
	}
	
	
	void dijkshtra()
	{
		node s=new node(0,0);
		node d=new node(r-1,c-1);
		
		
		p.add(adj_matrix[0][0]);
		
	    //Distance of array = -1
		
		while(!p.isEmpty())
		{
			
			int c=p.remove();
			//traversing through vetrices above,right,below,left
			
			
			
			
			
			
			
		}
		
		
		
		
	}
	
	
	
	
	public static void main(String[] args) throws IOException 
	{
		Reader.init(System.in); 
		int t=Reader.nextInt();
		
		
		for(int i=0;i<t;i++)
		{
			int r=Reader.nextInt();
			int c=Reader.nextInt();
			
			int[][] adj_matrix=new int[r][c];
			for(int j=0;j<r;j++)
			{
				for(int k=0;k<c;k++)
				{
					adj_matrix[j][k]=Reader.nextInt();
				}
				
			}
			
			
			
			
		}
		
	}
	
	
	

}
