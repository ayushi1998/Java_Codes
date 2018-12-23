import java.io.IOException;

public class Distance_Vector {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		
		String s = Reader.next();
		String[] arr= s.split(";");
		int[] router_num_arr = new int[51];
		
		int[][] adj_matrix = new int[51][51];
		int[] flag= new int[51];
		for(int i =0;i<arr.length;i++)
		{

			int a = Integer.parseInt(arr[i].substring(0, 1));
			int b = Integer.parseInt(arr[i].substring(2, 3));
			int d = Integer.parseInt(arr[i].substring(4));
			adj_matrix [a][b]=d;
			adj_matrix [b][a]=d;
			
			router_num_arr[a]=1;
			router_num_arr[b]=1;
			flag[a]=1;flag[b]=1;
			
		}
		

		int cnt=0;
		int flag_sum=0;
		
		for(int i=1;i<51;i++)
		{
			cnt = cnt+ router_num_arr[i];
			if(i!=1)
			{
				flag_sum=flag_sum+router_num_arr[i];
				//System.out.println("FLAG _SUM FIRST" + flag_sum);
			}
		}
		System.out.println(cnt+"No.of routers");
		
		for(int i=1;i<cnt+1;i++)
		{
			for(int j=1;j<cnt+1;j++)
			{
				if(i!=j)
				{
					if(adj_matrix[i][j]==0)
						adj_matrix[i][j]=9000;
				}
			}
		}
		
		int[][] prev_matrix=new int[51][51];
		int[][] current_matrix=new int[51][51];
		for(int r=1;r<=cnt;r++)
		{
			for(int c=1;c<=cnt;c++)
			{
				prev_matrix[r][c]=adj_matrix[r][c];
				current_matrix[r][c]=adj_matrix[r][c];

			}
		}

		while(flag_sum!=0) // Condition for Convergence
		{
			
			for(int i=1;i<=cnt;i++)
			{
				if(router_num_arr[i]==1)
				{
					int[] dis=new int[cnt+1];
					long sum_prev=0;
					dis=prev_matrix[i].clone();
					for(int t=1;t<=cnt;t++)
					{
						sum_prev=sum_prev+dis[t];
					}
					for(int j=1;j<=cnt;j++)
					{
						//Work on current matrix using prevmatrix
							// Neighbours from original matrix
							int min = 9000;
							int f=0;
							for(int k=1;k<=cnt;k++)
							{
								
								if( adj_matrix[i][k]!=9000)
								{
									//Chose minimum distance
									int value = dis[k]+prev_matrix[k][j];
									if(min>value)
									{
										min=value;
	
									}
									
								}
							}
							
						dis[j]=min;
						System.out.println("For router "+ i+ "distance from "+j +"th router"+dis[j]);
						
						
					}
					for(int r=1;r<cnt+1;r++)
					{
						for(int c=1;c<cnt+1;c++)
						{
							if(r!=i)
							{
								System.out.println("For router "+ r+ "distance from "+c +"th router"+prev_matrix[r][c]);
							}
							
						}
					}
					long sum_curr=0;
					
					for(int t=1;t<=cnt;t++)
					{
						sum_curr=sum_curr+dis[t];
					}
					System.out.println("This is diff "+ (sum_curr-sum_prev));
					
					if(sum_curr-sum_prev!=0)
					{
						
						flag_sum=1;
					}
					else
						flag_sum=0;

					current_matrix[i]=dis.clone();
					
					
				}
	
			}
			
			//Update prev_matrix
			for(int r=1;r<=cnt;r++)
			{
				for(int c=1;c<=cnt;c++)
				{
					prev_matrix[r][c]=current_matrix[r][c];
					

				}
			}
			//Update flag value
			
			System.out.println(flag_sum+"is flag_sum");
		}
		
		int[][] fwd_table=new int[51][51];
		
		System.out.println("Enter link cost change");
		s= Reader.next();
		int a = Integer.parseInt(s.substring(0, 1));
		int b = Integer.parseInt(s.substring(2, 3));
		int d = Integer.parseInt(s.substring(4));
		
		
		adj_matrix[a][b]=d;
		adj_matrix[b][a]=d;
		
		
		//adj_matrix=current_matrix.clone();
		System.out.println("link cost change" + d);
		

		for(int r=1;r<=cnt;r++)
		{
			for(int c=1;c<=cnt;c++)
			{
				current_matrix[r][c]=9000;
				System.out.println("The value of prev_matrix"+prev_matrix[r][c]);
				System.out.println("The value of adj_matrix"+adj_matrix[r][c]);
				

			}
		}
		
		flag_sum=2;
		
		int iter=0;
		while(flag_sum!=0) // Condition for Convergence
		{
			flag_sum=0;
			for(int i=1;i<=cnt;i++)
			{
				for(int j=1;j<=cnt;j++)
					{
						//Work on current matrix using prevmatrix
							// Neighbours from original matrix
							int min = 9000;
							int f=0;
							int via=0;
							for(int k=1;k<=cnt;k++)
							{
								if(i==j)
								{
									current_matrix[i][j]=0;
								}
								else if( adj_matrix[i][k]!=9000)
									
								{
									
									System.out.println("The sum value "+(adj_matrix[i][k]+prev_matrix[k][j]));
									if(adj_matrix[i][k]!=0 && (adj_matrix[i][k]+prev_matrix[k][j]<current_matrix[i][j]))
									{
										System.out.println("Updating curr " + current_matrix[i][j]);
										current_matrix[i][j]=adj_matrix[i][k]+prev_matrix[k][j];
										via=k;
									}
								
								}
								
							}
							
							fwd_table[i][j]=via;
							
							if(current_matrix[i][j]!=prev_matrix[i][j])
							{
								flag_sum=1;
							}
					
					}
					
					for(int r=1;r<=cnt;r++)
					{
						for(int c=1;c<=cnt;c++)
						{
							System.out.println("Updated i"+ i + " "+current_matrix[r][c]);
						}
					}
			}
			
			//Update prev_matrix
	
			for(int r=1;r<=cnt;r++)
			{
				for(int c=1;c<=cnt;c++)
				{
					prev_matrix[r][c]=current_matrix[r][c];
					

				}
			}
			//Update flag value
			
			System.out.println(flag_sum+"is flag_sum");
			for(int r=0;r<=cnt;r++)
			{
				for(int c=0;c<=cnt;c++)
				{
					current_matrix[r][c]=9000;
					
				}
			}
			
			iter++;
			System.out.println(iter+"No. of iterations");
		}

	}
	
	
	
	
	

}
