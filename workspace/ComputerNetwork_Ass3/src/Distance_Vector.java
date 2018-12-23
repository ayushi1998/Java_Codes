import java.io.IOException;

public class Distance_Vector {
	
	
	
	void run_algo1(int cnt ,int[][] adj_matrix,int[][] prev_matrix,int[][] current_matrix ,int[][] fwd_table)
	{
		int flag_sum=9;
		for(int r=1;r<=cnt;r++)
		{
			for(int c=1;c<=cnt;c++)
			{
				prev_matrix[r][c]=adj_matrix[r][c];
				if(r!=c)
					current_matrix[r][c]=9000;

			}
		}
	
		int iter1=0;
		while(flag_sum!=0) // Condition for Convergence
		{
			iter1++;
			flag_sum=0;
			for(int i=1;i<=cnt;i++)
			{
			
					for(int j=1;j<=cnt;j++)
					{
						//Work on current matrix using prevmatrix
							// Neighbours from original matrix
							int via=0;
							for(int k=1;k<=cnt;k++)
							{	
								if( adj_matrix[i][k]!=9000 && adj_matrix[i][k]!=0  && prev_matrix[k][j]!=9000 && current_matrix[i][j]>adj_matrix[i][k]+prev_matrix[k][j])
								{
									//Chose minimum distance
									current_matrix[i][j]=adj_matrix[i][k]+prev_matrix[k][j];
									fwd_table[i][j]=k;
									via = k;
									
								}
							}
							if(current_matrix[i][j]!=prev_matrix[i][j])
								flag_sum=1;
							
						
						
					}
					for(int r=1;r<cnt+1;r++)
					{
						for(int c=1;c<cnt+1;c++)
						{
							if(r!=i)
							{
								System.out.println("For router "+ r+ "distance from "+c +"th router"+prev_matrix[r][c]);
							}
							else
								System.out.println("For router "+ r+ "distance from "+c +"th router"+current_matrix[r][c]);
							
						}
					}
					
					
				
	
			}
			System.out.println("Iteration "+ iter1);
			//Update prev_matrix
			for(int r=1;r<=cnt;r++)
			{
				for(int c=1;c<=cnt;c++)
				{
					prev_matrix[r][c]=current_matrix[r][c];
					

				}
			}
			
			for(int r=0;r<=cnt;r++)
			{
				for(int c=0;c<=cnt;c++)
				{
					if(r!=c)
					current_matrix[r][c]=9000;
					else
						current_matrix[r][c]=0;
				}
			}
		}
		
		for(int r=1;r<=cnt;r++)
		{
			for(int c=1;c<=cnt;c++)
			{
				System.out.println("fwd table "+fwd_table[r][c]);
				

			}
		}
		
		
		
		

	}
	
	
	
	void run_algo_normal_update(int cnt ,int[][] adj_matrix,int[][] prev_matrix,int[][] current_matrix,int[][] fwd_table)
	{
		for(int r=1;r<=cnt;r++)
		{
			for(int c=1;c<=cnt;c++)
			{
				if(r!=c)
					current_matrix[r][c]=9000;
			
			}
		}
		
		int flag_sum=2;
		
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

							int via=0;
							for(int k=1;k<=cnt;k++)
							{
					
								if( adj_matrix[i][k]!=9000)
									
								{
									

									if(adj_matrix[i][k]!=0 &&  prev_matrix[k][j]!=9000  && (adj_matrix[i][k]+prev_matrix[k][j]<current_matrix[i][j]))
									{
										
										current_matrix[i][j]=adj_matrix[i][k]+prev_matrix[k][j];
										via=k;
										fwd_table[i][j]=via;
									}
								
								}
								
							}
							
							
							System.out.println("From router "+i +"to router "+j+ "in distance "+current_matrix[i][j]);
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
					if(r!=c)
					current_matrix[r][c]=9000;
					else
						current_matrix[r][c]=0;
				}
			}
			
			iter++;
			System.out.println(iter+"No. of iterations");
		}


	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		
		String s = Reader.next();
		String[] arr= s.split(";");
		int[] router_num_arr = new int[51];
		
		int[][] adj_matrix = new int[51][51];
		
		for(int i=1;i<50+1;i++)
		{
			for(int j=1;j<50+1;j++)
			{
				if(i!=j)
				{
					if(adj_matrix[i][j]==0)
						adj_matrix[i][j]=9000;
				}
			}
		}
		int[] flag= new int[51];
		for(int i =0;i<arr.length;i++)
		{

			int a = Integer.parseInt(arr[i].substring(0, 1));
			int b = Integer.parseInt(arr[i].substring(2, 3));
			int d = Integer.parseInt(arr[i].substring(4));
		
			if( d<adj_matrix [a][b])
			{
			adj_matrix [a][b]=d;
			adj_matrix [b][a]=d;
			
			}
			
			router_num_arr[a]=1;
			router_num_arr[b]=1;
			System.out.println(a+" "+b);
			flag[a]=1;flag[b]=1;
			
		}
	
		int cnt=0;
		int flag_sum=0;
		
		for(int i=1;i<51;i++)
		{
			System.out.println(i + " " +router_num_arr[i]);
			cnt = cnt+ router_num_arr[i];
			System.out.println(cnt);
			
		}
		
		
		System.out.println(cnt+"No.of routers");
		
		int[][] fwd_table=new int[cnt+1][cnt+1];
		
		
		
		int[][] prev_matrix=new int[cnt+1][cnt+1];
		int[][] current_matrix=new int[cnt+1][cnt+1];
		
		
		Distance_Vector disv = new Distance_Vector();
		
		disv.run_algo1(cnt,adj_matrix,prev_matrix,current_matrix,fwd_table);
		
		while(true)
		{
			System.out.println("Enter link cost change for 0/1 : 0 - normal 1/poisoned ");
			int v= Reader.nextInt();
			if(v==0)
			{
				s = Reader.next();
				int a = Integer.parseInt(s.substring(0, 1));
				int b = Integer.parseInt(s.substring(2, 3));
				int d = Integer.parseInt(s.substring(4));
				adj_matrix [a][b]=d;
				adj_matrix [b][a]=d;
				disv.run_algo_normal_update(cnt,adj_matrix,prev_matrix,current_matrix,fwd_table);
			}
			else if(v==1)
			{
				s = Reader.next();
				int a = Integer.parseInt(s.substring(0, 1));
				int b = Integer.parseInt(s.substring(2, 3));
				int d = Integer.parseInt(s.substring(4));
				adj_matrix [a][b]=d;
				adj_matrix [b][a]=d;
				
				int src=cnt-a-b+1;
				if(fwd_table[src][b]==a)
					fwd_table[src][b]=9000;
				disv.run_algo1(cnt,adj_matrix,prev_matrix,current_matrix,fwd_table);
			}
		}
		
		
		
		

		

		
		
	
	
		
	}
	

}
