/*Ayushi Srivastava 2016025
 * 
 * ReadMe 
 * 
 * All answers function call have been commented
 * 
 * Assumption of sample set to be of size 5.
 * 
 * Stream set is having numbers from 1 to 10000.
 * 
 * 
 * 
 * 
 * 
 */














import java.util.Random;

public class Sample_Data {

	
	int[] s= new int[5]; // The size of sample array is not user input driven.. As the 2(d) required 5 as the sampling size. I have assumed the same.
	// It is defined in class scope and hence accessible to all functions in it.
	
	
	// Answer 2(a)
	// Generating the Stream of data : Storing in the array that is returned in function.
	int[] getNextStream(int n)
	{
		int[] arr=new int[n];
		Random rand = new Random();
		System.out.println("The Stream array is : ");
		for(int i=0;i<n;i++)
		{
			int  num = rand.nextInt(10000) + 1;   // The random number can be generated : 1 to 10000 to avoid duplicacy.
			
			System.out.print(num+" ");
			arr[i]=num;
		}
		System.out.println();
		return arr;
		
	}
	
	
	// Answer 2(b)
	
	
	void updateSample(int StreamItem, int itemNumber)
	{
		if(itemNumber<= s.length)   // If itemNumber less than size of sample ; include the element.
		{
			s[itemNumber-1]=StreamItem;
		}
		else
		{
			double num =Math.random();
			
			if( num <= (double)(s.length/(double)itemNumber) )  // Else a comparison with random number for the probability 
			{
				Random rand = new Random();
				int  random_index = rand.nextInt(s.length) ;  // Any index chosen at random ; ensuring uniform probability for any index to be chosen
				s[random_index] = StreamItem;
				
			}
			
		}
		
		
		
	}
	
	
	// Answer 2(c)
	
	void sample(int n)
	{
		int[] stream= getNextStream(n);
		
		for (int i=0; i<n ; i++ )
		{
			updateSample(stream[i],i+1);
		}
		
	}
	
	
	// Answer 2(d)
	
	int[] freq_sampling(int N,int[] stream)
	{
		int[] count_freq=new int[10000];
		for(int i=0;i<N;i++)
		{
			for (int j=0; j<stream.length ; j++ )
			{
				updateSample(stream[j],j+1);
			}
			
			for(int j=0;j<5;j++)
			{
				count_freq[s[j]]+=1;
			}
			
			
		}
		
		return count_freq;
	}
	
	
	void display_sample()
	{
		for(int i=0;i<5;i++)
		{
			System.out.print(s[i]+" ");
		}
	System.out.println();
	
	}
	
	void display_freq(int[] a)
	{
		for(int i=0;i<10000;i++)
		{
			if(a[i]!=0)
			{
				
				System.out.println("Sample Data : " + i + "  " + "Frequency : " + a[i]);
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sample_Data obj=new Sample_Data();
		// ANSWER 1 
		//obj.getNextStream(20);
		
		// ANSWER 2 : s=5 , 2 test cases below
		//obj.updateSample(2,3);obj.display_sample();
		//obj.updateSample(99,15); obj.display_sample();
		
		
		// ANSWER 3
		 //obj.sample(20);System.out.println("Sample array");obj.display_sample();
		
		
		
		// ANSWER 4
		 int[] Stream=obj.getNextStream(20);
		 
		 //N=100
		 System.out.println("N=100");
		 int[] get_freq_array=obj.freq_sampling(100,Stream);obj.display_freq(get_freq_array);
		 System.out.println();
		
		 //N=500
		 System.out.println("N=500");
		 int[] get_freq_array2=obj.freq_sampling(500,Stream);obj.display_freq(get_freq_array2);
		 System.out.println();
		
		 //N=1000
		 System.out.println("N=1000");
		 int[] get_freq_array3=obj.freq_sampling(1000,Stream);obj.display_freq(get_freq_array3);
		 System.out.println();
		
		 //N=10000
		 System.out.println("N=10000");
		 int[] get_freq_array4=obj.freq_sampling(10000,Stream);obj.display_freq(get_freq_array4);
		 
		 
		 
		

		
	}

}
