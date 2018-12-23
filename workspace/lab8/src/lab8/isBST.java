package lab8;
import java.io.IOException;

import java.io.BufferedReader;
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
	node leftlink;
	node rightlink;
	int data;

  public node(int data)
  {
	  this.data=data;
	  leftlink=rightlink=null;
  }
  public node()
  {
	  
	  leftlink=rightlink=null;
  }
   
  public int getdata(){
	  return data;
  }
  
  
}

public class isBST {
	node treenode;
	int prein=0;
	
	public isBST(){
		node treenode=new node();
	}
	
	public node btree(int[] prearr, int[] inarr, int instart, int inend)
	{
		
		
		if(instart>inend)
		return null;
		
		node treenode=new node(prearr[prein]);
		//System.out.println(prein);
		prein=prein+1;
		
		
		if(instart==inend)
		{
			
			
			return treenode;
		}
		
		
		int index= find( inarr,treenode.getdata(),instart,inend);
		
		
	   treenode.leftlink=btree(prearr,inarr,instart,index-1);
	   //System.out.println(treenode.leftlink.getdata());
	   treenode.rightlink=btree(prearr,inarr,index+1,inend);
	 //  System.out.println(treenode.rightlink.getdata());
	   return treenode;
		
	}
	
	public int find(int[] a,int val,int i1,int i2)
	{
		for(int i=i1 ; i<=i2;i++)
		{
			if(a[i]==val)
			{
				return i;
			}
		}
		return 0;
	}
	
	public void postdisplay(node root)
	{
		
		if(root != null)
			
		{	
			postdisplay(root.leftlink);
			postdisplay(root.rightlink);
			System.out.print(root.getdata()+" ");
		}	
		
	}
	
	
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		int n=Reader.nextInt();
		int[] prearr=new int[n];
		for(int i=0;i<n;i++)
		{
			prearr[i]=Reader.nextInt();
		}
		int[] inarr=new int[n];
		for(int i=0;i<n;i++)
		{
			inarr[i]=Reader.nextInt();
		}
		
		
		isBST obj=new isBST();
		node showroot=obj.btree(prearr, inarr, 0, n-1);
	
		
		obj.postdisplay(showroot);
		

		int flag=0;
		for(int i=0;i<n-1;i++)
		{
			if(inarr[i]>inarr[i+1]){
				flag=1;
				break;
			}
			
		}
		System.out.println();
		if(flag==1)
		{
			System.out.print("NO");
		}
		else{
			System.out.print("YES");
		}
		
		
	
		

	}

}
