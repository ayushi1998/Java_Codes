package lab;

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
	node left;
	node right;
	int freq;
	

	public node( int frequency)
	{
		left=null;
		right=null;
		//this.data=data;
		freq=frequency;
		
	}
	
	public int getfreq()
	{
		return freq;
	}
	
}

class heap
{
	//int[] minheap;
	int size;
	node[] minheap;
	public heap(int count,node[] a) //pass the node array too!
	{
		minheap=a;
		size=count;
		
	}
	
	public void heapify(int i)
	
	{
		int min=i;node temp;
		int l=(2*i)+1;
		int r=(2*i)+2;
		//System.out.println(l+" "+r);
		//System.out.println(minheap[min].freq+"position");
		if((l<=size) && (minheap[min].freq>minheap[l].freq) )
		{
			min=l;
		}
		
		if((r<=size) && (minheap[min].freq>minheap[r].freq))
		{
			min=r;
		}
		
		if(min!=i)
		{
			temp=minheap[i];
			minheap[i]=minheap[min];
			minheap[min]=temp;
			
			heapify(min);
		}
		
	}
		public void show(){
			for(int i=0;i<=size;i++){
				System.out.print(minheap[i].freq);
			}
			
		
		}
	}
	

class heapfunctions{
	double sum;
	heap heapy;
	int capacity;
	public heapfunctions(int n,node[] a)
	{
		
		heapy=new heap(n,a);
		capacity=n;
		sum=0;
	}
	
	public void buildheap()
	{
		for(int i=(capacity-1)/2;i>=0;i--)
		{
			//System.out.println();
			
			heapy.heapify(i);
		}
	}
	
	public node extractmin()
	{
		node data;
		data=heapy.minheap[0];
		//System.out.println(capacity+"before left gets printed");
		heapy.minheap[0]=heapy.minheap[capacity];
		capacity=capacity-1;
		heapy.size=heapy.size-1;
		heapy.heapify(0);
		return data;
	}
	
	
	
	public void htroottoleaf(node root,double pathlen)

	{
		if(root==null)
		{
			return; //do nothing
		}
		
		
		pathlen=pathlen+1;
		if((root.left==null) &&(root.right==null))
		{
			
			sum=sum+(root.freq*(pathlen-1));
			
		}
		
		else
		{
			htroottoleaf(root.left,pathlen);
			htroottoleaf(root.right,pathlen);
		}
		
		
		
		
	}
	
 
   public void insert(node root)
   {
	  // System.out.println(root.left.freq+"VFGHJKKOOOOOO");
	   capacity=capacity+1;
	   int i=capacity;
	  // System.out.println("SIZE OF THE TREE AFTER INSERT"+capacity);
	   while(i>0 && (root.freq<=heapy.minheap[(i-1)/2].freq))
	   {
		   
		   
		   heapy.minheap[i]=heapy.minheap[(i-1)/2];
		   i=(i-1)/2;
		   
		   
	   }
	   
	   heapy.minheap[i]=root;
	    heapy.size=capacity;
	  // System.out.println(heapy.minheap[capacity].freq+"this is at position"+capacity);
	
	   
   }
	
	
	
	
}
	
	




public class Compression {
	heapfunctions h;
	
	public Compression(int n,node[] a){
		h=new heapfunctions(n,a);
		
	}
	
	
	public node huffmantree()
	{
		node leftl;node rightl;
		while(h.capacity!=0){
			
		 leftl=h.extractmin();
		
		 rightl=h.extractmin();
		//System.out.println(rightl.freq+"right"+"SIZE OF THE TREE at deletion"+h.capacity);
		node top=new node(leftl.freq+rightl.freq);
		top.left=leftl;
		//System.out.println(top.left.freq+"left"+"SIZE OF THE TREE at deletion"+h.capacity);
		top.right=rightl;
		
		h.insert(top);
		}
		
		
		return h.extractmin();
		
	}
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Reader.init(System.in); 
		int c=Reader.nextInt();
		int r=Reader.nextInt();
		int[][] arr=new int[r][c];
		int max=0;
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				arr[i][j]=Reader.nextInt();
				if(arr[i][j]>=max)
				{
					max=arr[i][j];
				}

			}
		}
		int[] heaparr=new int[max+1];  //  This array contains the frequency of each number corresponding to its index.
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				heaparr[arr[i][j]]=heaparr[arr[i][j]]+1;
				
				
				
			}
		}
		int cnt=0;
		for(int k=0;k<max+1;k++){
			if(heaparr[k]!=0){
				cnt=cnt+1;
			}
			
		}
		//System.out.print(cnt);
		int j=0;
		//int[] heap=new int[cnt];
		
		
		
		node[] heap1=new node[cnt];     //node array..  :)
		for(int k=0;k<max+1;k++)
		{
			if(heaparr[k]!=0){
				node newnode=new node(heaparr[k]);
				heap1[j]=newnode;
				j++;
						
			}
			
		}
		
		
		int[] heaparr2=new int[26];
		for(int i=0;i<max+1;i++)
		{
			heaparr2[i/10]=heaparr2[i/10]+heaparr[i];
		}

		
		
		heaparr2[24]=heaparr2[24]+heaparr2[25];
	    int cn=0;
	    for(int i=0;i<25;i++)
		{
	    	if(heaparr2[i]!=0){
	    		//System.out.println(heaparr2[i]);
				cn=cn+1;
			}
			
		}
	    
	    
	    int z=0;
		//int[] heap=new int[cnt];
		
		
	    node[] heap2=new node[cn];
		
		for(int k=0;k<25;k++)
		{
			if(heaparr2[k]!=0){
				node newnode=new node(heaparr2[k]);
				heap2[z]=newnode;
				z++;
						
			}
			
		}
		
		
		/*
		for(int z=0;z<heap2.length-1;z++){
			
			System.out.print(heap2[z].getfreq());
		}
		*/
		
		Compression obj=new Compression(cnt-1,heap1);
		
		obj.h.buildheap();  //  THe minheap
		
		
		//obj.h.heapy.show();
		
		
		node tree=obj.huffmantree();
		//obj.show(tree);
		
		//System.out.println(tree.freq+"frequency");
		obj.h.htroottoleaf(tree,0);
		//System.out.print(obj.h.sum);
		
	
		
        Compression obj1=new Compression(cn-1,heap2);
		
		obj1.h.buildheap();  //  THe minheap
		
		
		//obj1.h.heapy.show();
		
		
		node tree1=obj1.huffmantree();
		//obj1.show(tree1);
		
		//System.out.println(tree1.freq+"frequency");
		obj1.h.htroottoleaf(tree1,0);
		//System.out.print(obj1.h.sum);
		
		if(obj.h.sum==0)
		{
			obj.h.sum=tree.freq;
			
		}
		if(obj1.h.sum==0)
		{
			obj1.h.sum=tree1.freq;
		}
		
		double num=Math.round(((r*c*8.0)/obj.h.sum)*10);
		int newnum=(int) (num);
		double num1=Math.round(((r*c*8.0)/obj1.h.sum)*10);
		int newnum1=(int) (num1);
		
		
		System.out.println(newnum/10.0);
		System.out.println(newnum1/10.0);
		

	}

}
