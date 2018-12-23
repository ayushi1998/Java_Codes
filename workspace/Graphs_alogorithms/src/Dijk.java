import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import javafx.util.Pair;


class node implements Comparable{
    
	
	int x;
	int y;
	
	
	node(int x,int y)
	{
		
		this.x=x; 
		this.y=y;
		
	 }
	public int getx(){
		return (x);
	}
	public int gety(){
		return (y);
	}

	@Override
	public int compareTo(Object o) 
	{
		// TODO Auto-generated method stub
		node n=(node) o;
		return this.y - n.y;
	}
	

}
class list
{
	LinkedList< Pair<Integer, Integer> >[] adj;
	
	public list(int n)
	{
		adj=(LinkedList<Pair<Integer,Integer>>[])new LinkedList[n];
		 for(int i=0;i<n;i++)
		 {
			 adj[i]=new LinkedList<>();
		 }
	}
	
	 public void edge(int u,int v)
	 {
		 adj[u].add(new Pair<>(v,-1));
	 }
	 
	 public void listshow()
	 {
		 int i=0;
		 for (LinkedList< Pair<Integer, Integer> > list : adj) 
		 {
	            System.out.print("adjacencyList[" + i + "] -> ");
	              
	            for (Pair<Integer, Integer> edge : list) {
	                System.out.print(edge.getKey() + "(" + edge.getValue() + ")");
	            }
	              
	            i=i+1;
	            System.out.println();
	        }
	 }
	 
	
	
}



public class Dijk {
	
	PriorityQueue<Pair<Integer, Integer>> p;
	
	PriorityQueue<node> q;
	
	list l;
	
	 int[] dist;
	 
	 public Dijk(list l)
	 {
		 p=new PriorityQueue<Pair<Integer, Integer>>();
		 q=new PriorityQueue<node>();
		 this.l=l;
		 dist=new int[l.adj.length];
	 }
	 
	 
	 void algo()
	 {
		 int src=1;
		 Pair<Integer, Integer> u=new Pair<>(1,0);
		 Pair<Integer, Integer> u1=new Pair<>(0,4);
		// p.add(u);
		 //p.add(u1);
		
		 node sr=new node(src,0);
		 node sr1=new node(src,-1);
		 q.add(sr);
		 q.add(sr1);	 
	
		
	 }
	 
	
	 
	
	 
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 Reader.init(System.in);
		 
		 int level=Reader.nextInt();
		 int lifts=Reader.nextInt();
		 
		 list a=new list(lifts);
		 
		 for(int i=0;i<lifts;i++)
		 {
			 a.edge(Reader.nextInt(), Reader.nextInt());
		 }
		 a.listshow();
		 
		 Dijk d=new Dijk(a);
		 d.algo();
		 System.out.println(d.q.remove().y);
		 //System.out.println(d.p.remove());

	}

}
