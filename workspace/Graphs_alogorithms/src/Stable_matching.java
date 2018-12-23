import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class mark
{
	int val;
	int m=0;
	
	mark()
	{
	}
	
}

public class Stable_matching {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Reader.init(System.in);
		int t=Reader.nextInt();
		for(int i=0;i<t;i++)
		{
			int n=Reader.nextInt();
			//Pairing information
			int[] girls=new int[n+1];
			int[] boys=new int[n+1]; // 1/-1
			
			
			// Marked boys from 1 to n as -1
			for(int j=1;j<=n;j++)
			{
				boys[j]=-1;
				girls[j]=-1;
			}
				
			
			int[][] pref=new int[2*n][n+1];
			
			for(int r=0;r<2*n;r++)
			{
				int val=0;
				 val=Reader.nextInt();
				 for(int c=1;c<=n;c++ )
				{
					 if(r<n)
					 {
						 pref[val-1][0]=val;
						 pref[val-1][c]=Reader.nextInt();
					 }
					 else
					  {
						 pref[val+n-1][0]=val;
						 pref[val+n-1][c]=Reader.nextInt();	
					  }
			     }
			}
			//System.out.println(pref[1][0]);
				
				 for(int r=0;r<2*n;r++)
					{
						 for(int c=0;c<=n;c++ )
							{
							 System.out.print(pref[r][c]);
							}
						 System.out.println();
					}
			
			
			int count=n;  // No. of men free
			int k;
			while(count>0)
			{
				
				
				for(k=1;k<n+1;k++)  // boy value from 1 to n
				{
					if(boys[k]==-1)
					{
						System.out.println(k+"kk");
						break;
					}
				}
				//System.out.println("count"+ count);
				
				// We get the kth index at which man is free therefor value of man =k
				
					for(int z=1;z<=n;z++)
					{
						int w=pref[n+k-1][z]; 	
			        if(boys[k]==-1)
			        {
							w=pref[n+k-1][z];  // value of women=index;	
							System.out.println(w+"women");
							if(girls[w]==-1 )
							{	
								girls[w]=k;
								System.out.println(girls[w]+"value at k in firls");
								boys[k]=1;
								count=count-1;	
							}
			        }
					else
					{
								System.out.println("gggd");
								int curr=girls[w];
								// The women is w stored in the 2D matrix as w-1 index
								for(int a=1;a<=n;a++)
								{
									System.out.println("women"+w+" "+"man avail"+pref[w-1][a]+"curr"+" "+curr);
									if(pref[w-1][a]!=curr)
									{
										girls[w]=k;
										boys[k]=1;
										boys[curr]=-1;
										break;
									}
									else
									{
										break;
									}
								}
								
								
								
							}
							
						
					
					
				}

				
			}
			
			for(int b=1;b<=n;b++)
			{
				System.out.println(b+" "+girls[b]);
			}
				
				
				
				
				
				
			}
			
			
			
			
		}

	}


