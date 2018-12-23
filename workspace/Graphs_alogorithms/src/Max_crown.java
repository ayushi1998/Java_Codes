import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Max_crown {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		int t=Reader.nextInt();
		for(int i=0;i<t;i++)
		{
			int time=Reader.nextInt();
			int x=Reader.nextInt();
			int[] inaug=new int[x];
			for(int j=0;j<x;j++)
			{
				inaug[j]=Reader.nextInt();
			}
			
			int start=0;
			int end=0;
			int[] arr=new int[x];
			
			arr[0]=0;
			for(int j=1;j<x;j++)
			{
				int cnt=0;
				
				if((inaug[j]-inaug[start])<time)
				{
					cnt=cnt+1;
					end=j;
					arr[j]=start; 
				}
				else
				{
					start=start+1;
					
					arr[j]=start;
					
				}
				
			}
			int max=0;
			for(int j=0;j<x;j++)
			{
				if(max<(j-arr[j]))
				{
					max=j-arr[j];
					start=arr[j];
					end=j;
					
				}
			}
			System.out.println(max+1+" "+inaug[start]+" "+inaug[end]);
			
			
		}

	}

}
