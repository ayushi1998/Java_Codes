import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class knapsnack {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		 int v=Reader.nextInt();
		 int wt=Reader.nextInt();
		 // Arrey weight and value
		 int[] val=new int[v+1];
		 int[] weight=new int[v+1];
		 
		 int[] mark=new int[v+1];

		 for(int i=1;i<v+1;i++)
		 {
			 val[i]=Reader.nextInt();
		 }
		 for(int i=1;i<v+1;i++)
		 {
			 weight[i]=Reader.nextInt();
		 }
		 
		 int[][] k=new int[v+1][wt+1];
		 
		 for(int i=0;i<=v;i++)
		 {
			 for(int j=0;j<=wt;j++)
			 {
				 if(i==0 || j==0)
				 {
					 k[i][j]=0;
				 }
				 else if(weight[i-1]>j)
				 {
					 k[i][j]=k[i-1][j];
				 }
				 else
				 {
					 if(k[i-1][j]>(val[i-1]+k[i-1][j-weight[i-1]]))
							 {
						 		k[i][j]=k[i-1][j];
							 }
					 else
					 {
						 k[i][j]=val[i-1]+k[i-1][j-weight[i-1]];
					 }
				 }
			 }
		 }
		 
		 System.out.println(k[v][wt]);
		 //Marking the indices of knapsnack values.
		 
		 int i=v;
		 int j=wt;
		 
		 while(i>0 && j>0)
		 {
			 if(k[i][j]!=k[i-1][j])
			 {
				 mark[i]=1;
				 i=i-1;
				 j=j-weight[i];
			 }
			 else
			 {
				 i=i-1;
			 }
			 
			 
		 }
		 
		 
		 
		 
		
		
		
	}

}
