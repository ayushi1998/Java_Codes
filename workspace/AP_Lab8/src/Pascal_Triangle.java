import java.io.IOException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Pascal_Triangle extends RecursiveTask<Long>
{
	int n; int k;

	public Pascal_Triangle(int i, int j) {
		// TODO Auto-generated constructor stub
		n=i;
		k=j;
	}

	@Override
	protected Long compute() {
		// TODO Auto-generated method stub
	    if(n==0 || k==0 || n==k){
	    	return (long) 1;
	    }
	    Pascal_Triangle left = new Pascal_Triangle(n-1,k-1);
	    Pascal_Triangle right = new Pascal_Triangle(n-1,k);
	    
	    left.fork();
	    
		return right.compute()+left.join();
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		double start=System.currentTimeMillis();
		
		ForkJoinPool threadpool=new ForkJoinPool(3);
		Pascal_Triangle task=new Pascal_Triangle(35,15);
	    long res=threadpool.invoke(task);
	    double end=System.currentTimeMillis();
	    System.out.println(res);
	    System.out.println(end-start);

   }
}

/*ForkJoinPool threadpool=new ForkJoinPool(1);
		Pascal_Triangle task=new Pascal_Triangle(35,15);
		time=ForkJoinPool threadpool=new ForkJoinPool(1);
		t1=105039.0ms
		
		ForkJoinPool threadpool=new ForkJoinPool(2);
		Pascal_Triangle task=new Pascal_Triangle(35,15);
		t2=56076.0ms
		
		ForkJoinPool threadpool=new ForkJoinPool(3);
		Pascal_Triangle task=new Pascal_Triangle(35,15);
		t3=48843.0ms
		
		Speedup:
		I. t1/t2=1.87
		II. t1/t3=21.51
		
*/