import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Ayushi Srivastava 2016025
// class Reader{
   /* static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */

public class choc_recur {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		int t=Reader.nextInt();
		
		int n=Reader.nextInt();
		
		long arr[]=new long[100002];
		long sarr[]=new long[100002];
		arr[0]=0;
		sarr[0]=0;
		long mod=1000000007;
		for(int i=1;i<arr.length;i++)
		{
			if(i<n)
			{
				arr[i]=1;
			}
			else if(i==n)
			{
				arr[i]=2;
			}
			else
			{
				arr[i]=(arr[i-1]%mod+arr[i-n]%mod)%mod;
			}
			sarr[i]=(arr[i]%mod+sarr[i-1]%mod)%mod;
			//System.out.println("after"+sarr[i]);
		}
		
		//System.out.println(arr[3]+" "+arr[2]);
		for(int i=0;i<t;i++)
		{
			int p=Reader.nextInt();
			int q=Reader.nextInt();
			System.out.println((sarr[q]-sarr[p-1]+mod)%mod);
			
			
			
			
		}
		
		

	}

}
