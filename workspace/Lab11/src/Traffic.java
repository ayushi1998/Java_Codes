import java.io.BufferedReader;
import java.io.IOException;
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

class Set{
	int size;
	int[] set;
	public Set(int c)
	{
		size=c+1;
		set=new int[c+1];
		
		
	}
	public void makeset()
	{
		for(int i=1;i<size;i++)
		{
			
			set[i]=i;
			//System.out.println(set[i]);

		}

	}
	
	public int find(int x)
	{
		if(!(x>0 && x<size))
		{
			return -1;
		}
		if(set[x]==x){
			return x;
		}
		else
		{
			return find(set[x]);
			
		}
		//return x;
		
	}
	
	public void union(int x1,int x2)
	{
		if(find(x1)==find(x2)){
			return;
			
		}
		if(!((x1>=0 && x1<size) && (x2>=0 && x2<size)))
		{
			return;

		}
		int y=find(x1);
		int z=find(x2);
		set[y]=z;
		
	}
	
	
}

public class Traffic {
	
	Set s;
	int[][] sorted;
	int[][] reqset;
	int newsize;
	
	int u;
	int v;
	public Traffic(int c,int n,int[][] e, int u, int v)
	{
		
		this.u=u;
		this.v=v;
		s=new Set(c);
		sorted=e;
		reqset=new int[n][3];
		newsize=n;
	}
	public void mergesort(int[][] set,int[][]t,int lef, int rig){
		int mid;
		if(rig>lef)
		{
			mid=(rig+lef)/2;
			mergesort(set,t,lef,mid);
			mergesort(set,t,mid+1,rig);
			merge(set,t,lef,mid,rig);
			
			
		}
		
	}
	
	public void merge(int[][] s, int[][] t, int lef, int mid, int rig)
	{
		for (int i = lef; i <= rig; i++) {
			 t[i] = s[i];
			 }
			 int i = lef;
			 int j = mid + 1;
			 int k = lef;
			
			 while (i <= mid && j <= rig) {
				 if (t[i][2] <= t[j][2]) 
				 {
					 	s[k] = t[i];
					 	i++;} 
				 else 
				 {
					 	s[k] = t[j];
					 	j++;
					 	
				 }
				 k++;
			 }
	
			 while (i <= mid)
			 {
				 s[k] = t[i];
				 k++;
				 i++;
			 }
			 
			 while (j <= rig) 
			 {
				 s[k] = t[j];
				 k++;
				 j++;
			 }
		}
		
	
	
	
	
	public void MST()
	{
		
		s.makeset();
		//s.union(sorted[][0], sorted[][1]);
		
		for(int i=0;i<newsize;i++){
			
			if((sorted[i][0]==u) &&(sorted[i][1]==v)){
				s.union(sorted[i][0], sorted[i][1]);
				reqset[i]=sorted[i];
				break;
			}
		}
		for(int i=0;i<newsize;i++){
			
			//System.out.println((sorted[i][0])+" "+(sorted[i][1]));
			//System.out.println(s.find(sorted[2][0])+" "+s.find(sorted[2][1]));
			if(s.find(sorted[i][0]) != (s.find(sorted[i][1]))){
				//System.out.println((sorted[i][0])+" "+(sorted[i][1]));
				s.union(sorted[i][0], sorted[i][1]);
				//System.out.println(s.find(sorted[i][0])+" "+s.find(sorted[i][1]));
				reqset[i]=sorted[i];
				
			}
			
			
		}
		
	}
	
	public void sum(){
		int sum=0;
		for(int i=0;i<newsize;i++)
		{
			if(reqset[i][0]!=0)
			{
				sum=sum+reqset[i][2];
				//System.out.println(reqset[i][2]);
			}
			
		}
		System.out.println(sum);
	}

	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		
		
		int c=Reader.nextInt();
		int r=Reader.nextInt();
		int[][] edges=new int[r][3];
		
		for(int i=0;i<r;i++)
		{
			edges[i][0]=Reader.nextInt();
			edges[i][1]=Reader.nextInt();
			edges[i][2]=Reader.nextInt();
			//System.out.println(i+" "+r);
		}
		
		
		int busyroadu=Reader.nextInt();
		int busyroadv=Reader.nextInt();
	    // System.out.println(edges[0][3]);
		
	/*for(int k=r-1;k>=0;k--){
		
		for(int j=0;j<=k-1;j++)
				{

					if((edges[j][2]>edges[j+1][2]))
					{
						int[] temp=edges[j];
						edges[j]=edges[j+1];
						edges[j+1]=temp;
						
				}
			}
		}*/
		
		
		
		
		//Arrays.sort(edges);
	
	Traffic obj=new Traffic(c,r,edges,busyroadu,busyroadv);
	int [][] temp=new int[r][3];
	obj.mergesort(edges,temp,0,r-1);
	
	obj.MST();
	obj.sum();
		
	    
		
}
}