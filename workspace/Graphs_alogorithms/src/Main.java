import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;



public class Main {
	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int n=Reader.nextInt();
		int[] cost=new int[n];
		int[] workr=new int[n];
		for(int i=0;i<n;i++)
		{
			cost[i]=Reader.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			workr[i]=Reader.nextInt();
		}
		HashMap<Integer,ArrayList<Integer>> hm=new HashMap<Integer,ArrayList<Integer>>();
		ArrayList<Integer> ar1=new ArrayList<Integer>();
		ArrayList<Integer> ar2=new ArrayList<Integer>();
		ArrayList<Integer> ar3=new ArrayList<Integer>();
		hm.put(1,ar1);
		hm.put(2,ar2);
		hm.put(3,ar3);
		for(int i=0;i<n;i++)
		{
			hm.get(workr[i]).add(cost[i]);
		}
		if(hm.get(1).size()!=0 && hm.get(3).size()==0)
		{
			Collections.sort(hm.get(1));
			Collections.sort(hm.get(2));
			System.out.println(hm.get(1).get(0)+hm.get(2).get(0));
			
		}
		else if(hm.get(1).size()==0&& hm.get(3).size()!=0)
		{
			Collections.sort(hm.get(3));
			System.out.println(hm.get(3).get(0));
		}

		
		//System.out.println(hm.get(1));
		else{
			Collections.sort(hm.get(3));
			Collections.sort(hm.get(1));
			if(hm.get(2).size()!=0)
			{
				Collections.sort(hm.get(2));
				if(hm.get(1).get(0)+hm.get(2).get(0)<hm.get(3).get(0))
				{
					System.out.println(hm.get(1).get(0)+hm.get(2).get(0));
					
				}
					
				else
				{
					System.out.println(hm.get(3).get(0));
				
				
				}
				
			}
			else
			{
				System.out.println(hm.get(3).get(0));
			}
			
		
		
		}
		
}
}

