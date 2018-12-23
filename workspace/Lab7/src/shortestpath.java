import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
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
public class shortestpath {
	int[][] arr;
	int size;
	int xs ; int ys;int xd;int yd;
	queue q;
	
	public shortestpath( int xs,int ys,int xd,int yd,int n)
	{
		
		 q=new queue();
		 this.xs=xs;
		 this.ys=ys;
		 this.xd=xd;
		 this.yd=yd;
		 size=n;
		 arr= new int[n][n];
	}
    
	public void path()
	{
		
		int[][] darr=new int[size][size];
		
		node source=new node(xs,ys);
		node dest=new node(xd,yd);
		
	
    int cnt=0;
	q.Enqueue(source);
	
	while(!q.isEmpty())
	{
		
		node check=q.Dequeue();
		//System.out.println(check.getx()+" "+ check.gety());
		
		
		arr[check.getx()][check.gety()]=-1;
		if( ((check.getx()-1)>=0) && (arr[check.getx()-1][check.gety()]==1 ))
		{
			//System.out.println("up");
			arr[check.getx()-1][check.gety()]=-1;
			
			darr[check.getx()-1][check.gety()]=darr[check.getx()][check.gety()]+1;
			node up=new node(check.getx()-1,check.gety());
			
			//System.out.println(check.getx()-1+" "+ check.gety());
			q.Enqueue(up);
			if((check.getx()-1==dest.getx()) && (check.gety()==dest.gety()))
			{
				cnt=darr[dest.getx()][dest.gety()];
				
				break;
			}
			
			
			
				
		}
		
		
		if( ((check.getx()+1)<=size-1) && (arr[check.getx()+1][check.gety()]==1) )
		{
			//System.out.println("down");
			arr[check.getx()+1][check.gety()]=-1;
			darr[check.getx()+1][check.gety()]=darr[check.getx()][check.gety()]+1;
			node down=new node(check.getx()+1,check.gety());
			
			//System.out.println((check.getx()+1)+" "+ check.gety());
			//System.out.println(darr[check.getx()+1][check.gety()]);
		
			
			q.Enqueue(down);
			
			if(((check.getx()+1)==dest.getx()) && (check.gety()==dest.gety()))
			{
				cnt=darr[dest.getx()][dest.gety()];
				
				break;
				
			}
			
			
		}
		
		
		if( ((check.gety()-1)>=0) && (arr[check.getx()][check.gety()-1]==1) )
		{
			
			arr[check.getx()][check.gety()-1]=-1;
			
			node left=new node(check.getx(),check.gety()-1);
			darr[check.getx()][check.gety()-1]=darr[check.getx()][check.gety()]+1;
			q.Enqueue(left);
			
			if((check.getx()==dest.getx()) && (check.gety()-1==dest.gety()))
			{
				cnt=darr[dest.getx()][dest.gety()];
				
				break;
				
			}
			
			
		}
		
		
		if(((check.gety()+1)<=(size-1)) && (arr[check.getx()][check.gety()+1]==1) )
		{
			arr[check.getx()][check.gety()+1]=-1;
			
			node right=new node(check.getx(),check.gety()+1);
			darr[check.getx()][check.gety()+1]=darr[check.getx()][check.gety()]+1;
			
			
			
			q.Enqueue(right);
		
			if((check.getx()==dest.getx()) && (check.gety()+1==dest.gety()))
			{
				cnt=darr[dest.getx()][dest.gety()];
				break;
				
			}
			
			
		}
		
	}
	
	//System.out.println(cnt);
	int i=xd;
	int j= yd;
	String[] a=new String[cnt+1];
	a[0]=(source.gety()+" "+source.getx());
	a[cnt]=(dest.gety()+" "+dest.getx());
	
	for(int k=cnt-1;k>0;k--)
	{
		//System.out.println(k);
		
	if( (i-1)>=0 && darr[i-1][j]==(k) )
	{   
		
		node sp= new node(i-1,j);
		a[k]=(sp.gety()+" "+sp.getx());
		i=i-1;
		
		
	}
	else if( ((i+1)<=(size-1)) && darr[i+1][j]==(k) )
	{
        node sp= new node(i+1,j);
        a[k]=(sp.gety()+" "+sp.getx());
        i=i+1;
       
	}
	else if( (j-1)>=0 && darr[i][j-1]==(k) )
	{
       node sp= new node(i,j-1);
       
       a[k]=(sp.gety()+" "+sp.getx());
       j=j-1;
	
	}
	else if( ((j+1)<=(size-1)) && darr[i][j+1]==(k) )
	{
        node sp= new node(i,j+1);
        a[k]=(sp.gety()+" "+sp.getx());
        j=j+1;

	}
	
	}
	
	for(int b=0;b<a.length;b++)
	{
	System.out.println(a[b]);
	}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		/*int n=Reader.nextInt();
		int ys=Reader.nextInt();
		int xs=Reader.nextInt();
		int yd=Reader.nextInt();
		int xd=Reader.nextInt();
		
		shortestpath obj=new shortestpath(xs,ys,xd,yd,n);
		
		for(int i=0;i<n;i++)    // MAtrix Making
		{
			for(int j=0;j<n;j++)
			{
				obj.arr[i][j]=Reader.nextInt();
				
			}
		}
		//obj.path();  */
	for(int k=1;k<=1000;k++){
		System.out.print(k+" ");
	}

	}

}
//System.out.println(s);
		double x;double l;
		double[] dkbk=new double[n];
		x=(Math.ceil((s/m)));
		double sum=0;
		
		double ck;double bk;double dk;
		int cnt=0;
		for(int j=0;j<n;j++)
		{
			ck=Math.ceil(arr[j]/x);
			sum=sum+ck;
			if((int)ck>1){
				
				if(arr[j]%((int) x)==0)
				{
					dk=x;
					bk=(arr[j]/x)-1;
				}else
				{
					bk=Math.floor(arr[j]/x);
					dk=arr[j]%((int) x);
				}
				dkbk[j]=Math.ceil(dk/bk);
				
				
				
				
				
			}
			else{
				cnt=cnt+1;
			}
			
			
			
			
		}
		Arrays.sort(dkbk);
		//System.out.println(sum);
		
		
		if(sum==m){
			System.out.println((int)x);
		}
		else{
			System.out.println((int)(x+dkbk[(int)sum-m-1+cnt]));
		}
		
		

		
