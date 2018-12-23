package javahw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dship {
	public static void main(String[] args) throws IOException {
		Reader1.init(System.in);
		int t=Reader1.nextInt();
		for(int i=0;i<t;i++){
			String s1=Reader1.next();
			String s2=Reader1.next();
			int[] arr1=new int[26];
			int[] arr2=new int[26];
			for(int j=0; j<s1.length(); j++){
				arr1[((int) s1.charAt(j))-97]+=1;
				
			}for(int k=0; k<s2.length(); k++){
				arr2[((int) s2.charAt(k))-97]+=1;
			}
			int flag=0;
			for(int z=0;z<26;z++){
				if(!(arr1[z]+arr2[z]==0)){
					if(arr1[z]==arr2[z]){
						flag=flag+arr1[z];
					}
				}
			}
			if(flag==s1.length()){
				System.out.println("No");
			}else{
				System.out.println("Yes");
			}
			

}
	}
}
class Reader1 {
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
}
