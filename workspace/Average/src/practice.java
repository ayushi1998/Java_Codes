
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice {
	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int t=Reader.nextInt();
		for(int i=0;i<t;i++){
			String s1=Reader.next();
			String s2=Reader.next();
			
			int[] arr1=new int[26];
			int[] arr2=new int[26];
			for(int j=0; j<s1.length(); j++){
				arr1[((int) s1.charAt(j))-97]+=1;
				arr2[((int) s2.charAt(j))-97]+=1;
			}
			char t1;
			for(int k=0;k<26;k++){
				int min=arr1[k];
				
				if(min>arr2[k]){
					min=arr2[k];
				}for(i=0;i<min;i++){
					
					t1=(char)((k+97));
					System.out.print(t1);
				}
				}
			}
			
		}
		
				
		
	}

