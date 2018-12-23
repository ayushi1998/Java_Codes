import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

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


class Node
{
	int node_number;
	ArrayList<Integer> forwarding_table;
}


public class Link_State{
	
	
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		
		String s = Reader.next();
		String[] arr= s.split(";");
		int[] router_num_arr = new int[60];
		
		int[][] adj_matrix = new int[60][60];
		
		for(int i =0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
			int a = Integer.parseInt(arr[i].substring(0, 1));
			int b = Integer.parseInt(arr[i].substring(2, 3));
			int d = Integer.parseInt(arr[i].substring(4));
			adj_matrix [a][b]=d;
			adj_matrix [b][a]=d;
			
			router_num_arr[a]=1;
			router_num_arr[b]=1;
			
		}
		
		int cnt=0;
		for(int i=1;i<60;i++)
		{
			cnt = cnt+ router_num_arr[i];
		}
		System.out.println(cnt+"No.of routers");
		for(int i=1;i<=cnt;i++)
		{
			ArrayList<Integer> set = new ArrayList<>();
			int[] dis = new int[60];int[] parent = new int[60];
			if(router_num_arr[i]==1)
			{
				set.add(i);
				dis[i]=0;
			for(int j=1;j<60;j++)
			{
					if(i!=j)
					{
					if(adj_matrix[i][j]>0 )
					{
						dis[j]=adj_matrix[i][j]; 
						//System.out.println(j+"distance from src"+dis[j]);
						parent[j]=i;
					}
					else
					{
						dis[j]=Integer.MAX_VALUE;
						//System.out.println(j+"distance from src");
					}
					}
			}
			while(set.size()!=cnt)
			{
					
					int min=Integer.MAX_VALUE;
					int k=0;
					int v=0;
					for(k=1;k<60;k++)
					{
						if(!(set.contains(k)) && dis[k]<min )
						{
							min=dis[k];
							v=k;
						}
						
					}
					System.out.println(v+"The shortes router");
					set.add(v);
					//parent[v]=i;
					
					for(int j=1;j<60;j++)
					{
						if(!(set.contains(j))&& adj_matrix[v][j]!=0 && dis[v]+adj_matrix[v][j] <= dis[j])
						{
							//System.out.println(dis[v]+adj_matrix[v][j]+"dis[v]+adj_matrix[v][j]" +"  "+dis[j]+" dis[j]");
							//System.out.println(v+"the parent to"+j);
							dis[j] = dis[v]+adj_matrix[v][j] ;
							parent[j]=v;
							//System.out.println(parent[j]+"The arr parent");
						}
					
					}
					
					
			}
			
				for(int t=1;t<=cnt;t++)
				{
					System.out.println("For router i :" + i +" to "+t+" "+dis[t]+" "+parent[t]);
					if(i!=t)
					{
						int val=parent[t];
						int prev=val;
						while(val!=i)
						{
							prev=val;
							val=parent[val];
							
						}
						System.out.println("Fwd table value for router : "+ i + " "+ prev) ;
						
					}
					
				}
				
				
				
			}
		}
		
		

	}

}
