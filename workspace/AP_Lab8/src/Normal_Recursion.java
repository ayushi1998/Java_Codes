import java.util.concurrent.ForkJoinPool;

public class Normal_Recursion {
	
	protected  Long  recurse(int n,int k) {
		
		// TODO Auto-generated method stub
	    if(n==0 || k==0 || n==k){
	    	return (long) 1;
	    }
	    Long  left =recurse(n-1,k-1);
	   Long right =recurse(n-1,k);
	    
	   
	    
		return left+right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
double start=System.currentTimeMillis();
		
		Normal_Recursion n=new Normal_Recursion();
		System.out.println(n.recurse(80,15));
	    
	    double end=System.currentTimeMillis();
	    
	    System.out.println(end-start);

	}

}
// For n>= some threshold value, this sequential approach takes time>10 minutes.