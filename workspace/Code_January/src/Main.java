import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;



public class Main {
	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int t=Reader.nextInt();
		for(int i=0;i<t;i++)
		{
			int n=Reader.nextInt();
			long h=Reader.nextLong();
			long[] arr=new long[n];
			long[] arr1=new long[n];
			for(int j=0;j<n;j++)
			{
				arr[j]=Reader.nextLong();
				arr1[j]=-1;
			}
			Arrays.sort(arr);
			long start=1; long end=arr[n-1];
			long mid=0;
			long pred=0;
			while(start<=end)
			{
				
				mid=(start+end)/2;		
				long cnt=0;
				for(int k=0;k<n;k++)
				{
					if(arr[k]%mid==0)
					{
						cnt=cnt+(arr[k]/mid);
					}
					else
					{
						cnt=cnt+(arr[k]/mid)+1;
					}	
				}
				
				if(cnt<=h)
				{
					pred=mid;	
					end=mid-1;
				}
				else
				{
					start=mid+1;
				}
				
			}

			System.out.println(pred);
			
		}
		
 }

}