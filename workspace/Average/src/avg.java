

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class avg {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
         Reader.init(System.in);
         int sum=0;
         float av;
         
         
        	 int n=Reader.nextInt();
        	 int [] arr= new int[n]; 
        	 int i=0;
        	 for(int k=0;k<n;k++){
        		 int ht=Reader.nextInt();
        		 arr[i++]= ht;
        		 sum+=ht;
        		 
        		 
        	 }
        	 int cnt=0;
        	 av=sum/n;
        	 for(int j=0;j<n;j++){
        		 if (arr[j]>av){
        			 cnt+=1;
        		 }
        	 }
        	 System.out.println(cnt);
        	 
        	 
         
         }
       
	}




	
	