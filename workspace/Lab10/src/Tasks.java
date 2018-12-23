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
class node
{
	node link;
	
	int data;
	
    
	public node(){
		link=null;
		data=0;
	}
	
	public node(int d)
	{
		link=null;
		data=d;
		
	}
	
	public node getlink()
	{
		return link;
	}
	public void setlink(node newlink)
	{
		link=newlink;
		
	}
	
	public void insertatbeg(node adj,node n)
	{
		
		System.out.println("yo");
		node next=adj;
		if(next==null)
		{
			
			adj.setlink(n);
		}
		else
		{
			adj.setlink(n);
			n.setlink(next);
			
			
		}
		
		
		
		
		
		
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
		
		node newnode=new node(n.data);
		if(rear.link==null)
		{
			
			front.link=newnode;
			
			
		}
		else
		{
		
		rear.link.setlink(newnode);
		
		}
		rear.link=newnode;
		
	}
	public node Dequeue()
	{
		node dq=new node(front.link.data);
		//System.out.println(front.link.getx()+ " "+ front.link.gety()+"dq");
		front=front.link;
		if(front.link==null)
		{
			rear.link=null;
		}
		
		return dq;
		
	}	
}
class Graph{
	int size;
	int[][] adj;
	int[] indeg;
	node[] vertices;
	int[] vis;
	int count;
	
	public Graph(int n, int[][] a, int[] i, node[] v,int[] vis,int c){
	
		size=n;
		indeg=i;
		adj=a;
		vertices=v;
		this.vis=vis;
		count=c;
	}
	

	
	
	
	
}



public class Tasks {
	Graph g;
	queue q;
	
	public  Tasks(int n, int[][] a, int[] i, node[] v, int[] vis, int c){
		q=new queue();
		g=new Graph( n,  a,  i,  v, vis, c);
	}
	
	public int TopoSort(){
		int counter=0;
		int v;int w;
		int[] toporder=new int[g.size+1];
		for(v=1;v<g.size+1;v++){
			if((g.indeg[v]==0) && (g.vis[v]!=0)){
				//System.out.println(g.vertices[v].data);
				q.Enqueue(g.vertices[v]);
			}
			
		}
		
		while(!q.isEmpty())
		{
			v=q.Dequeue().data;
			//System.out.println(v);
			//System.out.println(counter+"before");
			toporder[v]=counter++;
			//System.out.println(v);
			//System.out.println(counter+"after");
			for(w=1;w<g.size+1;w++){
				   if(g.adj[v][w]==1){
					   System.out.println(g.indeg[w]+" "+"for"+v+"neeighbour"+w);
					if(--g.indeg[w]==0){
						
						q.Enqueue(g.vertices[w]);
					}
				
				   }
			}
			
			
		}
		
		if(counter!=g.count){
			return(-1);
		}
		return 0;
		
	}
	
	
	
	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		
		Reader.init(System.in); 
		int N=Reader.nextInt();
		int d=Reader.nextInt();
		
		int[][] adjmatrix=new int[N+1][N+1];
		int[] visited=new int[N+1];
		//int vis=0;
		for(int i=0;i<d;i++)
		{
			    int r=Reader.nextInt();
			    int c=Reader.nextInt();
				adjmatrix[r][c]=1;
			    visited[r]=1;visited[c]=1;
			    // flagged all the visited nodes.
				
			
		}
		node[] vertices=new node[N+1];
		int[] indegree=new int[N+1];
		int[] indeg=new int[N+1];
		for(int i=1;i<N+1;i++)
		{
			for(int j=1;j<N+1;j++)
			{
				
				if(adjmatrix[j][i]==1)
				{
					indegree[i]++;
					indeg[i]++;
				}
			}
			
		}
	int count=0;	
	for(int i=1;i<N+1;i++){
		if(visited[i]!=0)
		{
			count=count+1;
		vertices[i]=new node(i);
		System.out.println(vertices[i].data);
		}
		
	}
	
	Tasks obj=new Tasks(N,adjmatrix,indegree,vertices,visited,count);
	int cycle=obj.TopoSort();
	//System.out.println(cycle);
	if(cycle==0){
		for(int i=1;i<N+1;i++)
		{
			//System.out.print(indeg[i]+" ");
			if(indeg[i]==0 && visited[i]!=0)
			System.out.print(i+" ");
		}
		
	}
	else{
		System.out.println(cycle);
	}
	
		
		
 }
}
