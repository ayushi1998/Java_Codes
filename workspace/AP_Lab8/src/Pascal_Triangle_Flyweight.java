import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Pascal_Triangle_Flyweight extends RecursiveTask<Long>{

	private  int  n;
	private int  k;
	private static volatile  HashMap<String,Pascal_Triangle_Flyweight> value=new HashMap<String,Pascal_Triangle_Flyweight>();
	private Pascal_Triangle_Flyweight(int n, int k)
	{
		this.n=n;
		this.k=k;
		
	}
	
	public static synchronized Pascal_Triangle_Flyweight getValue(int n, int k){
		String s=n+" "+k;
		if(!(value.containsKey(s))){
			value.put(s, new Pascal_Triangle_Flyweight(n,k));
		}
		
		return value.get(s);
		
	}
	@Override
	protected  Long  compute() {
		// TODO Auto-generated method stub
	    if(n==0 || k==0 || n==k){
	    	return (long) 1;
	    }
	    Pascal_Triangle_Flyweight left =Pascal_Triangle_Flyweight.getValue(n-1,k-1);
	    Pascal_Triangle_Flyweight right =Pascal_Triangle_Flyweight.getValue(n-1,k);
	    
	    left.fork();
	    
		return right.compute()+left.join();
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		double start=System.currentTimeMillis();
		
		ForkJoinPool threadpool=new ForkJoinPool(2);
		Pascal_Triangle_Flyweight task= new Pascal_Triangle_Flyweight(35,15);
	    long res=threadpool.invoke(task);
	    double end=System.currentTimeMillis();
	    
	    System.out.println(res);
	    System.out.println(end-start);

   }
	
	
	
	
	
}
/*Pascal_Triangle_Flyweight task= new Pascal_Triangle_Flyweight(35,15);
 * t1'=27ms
 * t2'=26ms
 * t3'=18ms
 * 
 * t1/t1'=3890
 * t2/t2'=2156
 * t3/t3'=2713
 * 
 */
 
