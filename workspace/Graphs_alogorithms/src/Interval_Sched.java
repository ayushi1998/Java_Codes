import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
//Ayushi Srivastava
//2016025

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

	 static long nextLong() throws IOException{
		// TODO Auto-generated method stub
		return Long.parseLong( next() );
	}
}
class Pair
{
	Integer start;
	Integer end;
	
	Pair(int s,int e)
	{
		start=s;
		end=e;
	}
	
	
}

public class Interval_Sched {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		int t=Reader.nextInt();
		for(int i=0;i<t;i++)
		{
			int n=Reader.nextInt();	
			Pair[] arr=new Pair[n];
			for(int j=0;j<n;j++)
			{
				int s=Reader.nextInt();
				int e=Reader.nextInt();
				Pair p=new Pair(s,e);
				//arr.add(p);
				arr[j]=p;
			}
			Arrays.sort(arr,new Comparator<Pair>(){
				@Override
				public int compare(Pair p1,Pair p2)
				{
					return p1.end.compareTo(p2.end);
				}
				
			});
			int cnt=0;
			Pair ptr=arr[0];
			for(int j=1;j<n;j++)
			{
				if(arr[j].start>=ptr.end)
				{
					ptr=arr[j];
					cnt++;
				}
				//System.out.println(arr[j].start+" "+arr[j].end);
				
			}
			
			System.out.println(cnt+1);
		}

	}

}
