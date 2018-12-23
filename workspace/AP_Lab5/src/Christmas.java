import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
class Reader{
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


class BSTFilesBuilder {

	public void createBSTFiles(int numStudents, int numTrees) {
		Random rand = new Random();
		for (int i = 1; i <= numTrees; i++) {
		    try {
				PrintWriter w = new PrintWriter("./src/" + i + ".txt", "UTF-8");
				int type = rand.nextInt(3) + 1;
				if(type == 1) {
					w.println("Integer");
					w.println(numStudents);
					for (int j = 1; j <= numStudents; j++) {
						w.print(rand.nextInt(1000));
						w.print(" ");
					}
				}
				else if(type == 2) {
					w.println("Float");
					w.println(numStudents);
					for (int j = 1; j <= numStudents; j++) {
						w.print(rand.nextFloat()*1000);
						w.print(" ");
					}
				}
				else {
					w.println("String");
					w.println(numStudents);
					String alphabet = "abcdefghijklmnopqrstuvwxyz";
					for (int j = 1; j <= numStudents; j++) {
						int len = rand.nextInt(10)+1;
						for (int k = 0; k < len; k++)
							w.print(alphabet.charAt(rand.nextInt(alphabet.length())));
						w.print(" ");
					}
				}
				w.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}


class node<T>
{
	T node_key; // String/Integer/Float Data Type
	node<T> left;
	node<T> right;
	
	public node(T k)
	{
		this.node_key=k;   // Value
		left=null;
		right=null;
	}
	
	public node<T> setright(node<T> s)
	{
		right=s;
		return right;
	}
	
	public node<T> setleft(node<T> s)
	{
		left=s;
		return left;
	}
	
	
}

class BST<T extends Comparable <T>>
{
	
	node<T> root;
	public BST(){
		root=null;
	}
	public node<T> add(node<T> root, T k)  // Passed the root node and Value
	{
		if(root==null)
		{
			
			root=new node<T> (k);
			//System.out.println(root.node_key);
		}
		
		
		int check=k.compareTo(root.node_key);
		//System.out.println(check+"K"+k);
		if(check>0)
		{
			
			root.setright(add(root.right,k));
			//System.out.println(root.node_key);
		}
		else if(check<0)
		{
			root.setleft(add(root.left,k));
		}
		
		return root;
	}
	
	

	
	
}

class MyChristmasTree<T>
{
	private ArrayList <T> list;
	
	private int count;
	public MyChristmasTree()
	{
		setList(new ArrayList<T>());
		
		count=0;
	}
	public void insert(node<T> root)
	{
		if(root==null){
			return;
		}
		else
		{
			
		insert(root.left);
		getList().add(root.node_key);
		
		insert(root.right);
		}
	}
	
	public void addob(T k){
		list.add(k);
	}
	
	
	
	
	public T get(int i){
		return (T) getList().get(i);
	}
	
	public ArrayList<Object> getList() {
		return (ArrayList<Object>) list;
	}
	public void setList(ArrayList <T> list) {
		this.list = list;
	}
	
	
	
	
}









public class Christmas {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Reader.init(System.in); 
		BSTFilesBuilder file=new BSTFilesBuilder();
		int num_of_stud=Reader.nextInt();
		int num_files=Reader.nextInt();;
		
		//file.createBSTFiles(num_of_stud, num_files);
		
		 HashMap<Integer,ArrayList<Object>> hp=new HashMap<Integer,ArrayList<Object>>();
		
		 
		
		 
		for(int z=1;z<=num_files;z++)
	{
		
		List<String> input=Files.readAllLines(Paths.get("/Users/ayushi/Documents/workspace/AP_Lab5/src/"+z+".txt"),StandardCharsets.UTF_8);
		ListIterator listit=input.listIterator();
		System.out.println("Read file");
		int i=3;
		int cnt = 1;
		ArrayList<Object> arr = new ArrayList<Object>();
		
	  
		while(i>0)
   {
			String check=input.get(0);
			if(check.equals("Integer"))
			{
				//i.next();
				
				BST<Integer> bst=new BST<Integer>();
				MyChristmasTree<Integer> tree=new MyChristmasTree<Integer>();
			
				String s=input.get(2);
				String[] values=s.split(" ");
				int r=Integer.parseInt(values[0]);
				for(int j=0;j<num_of_stud;j++)
				{
					
					bst.root=bst.add(bst.root, Integer.parseInt(values[j]));
					
				}
				
                  tree.insert(bst.root);
				
				int st=0;
				cnt=1;
				
				for(int j=0;j<num_of_stud;j++)
				{
					
					st=st+tree.get(j);
					
					if((tree.get(j).equals(r)))
					{
						cnt=j+1;
					}
					
					
					
				}
				arr.add(st);
				if(hp.containsKey(cnt))
				{
					ArrayList a=hp.get(cnt);;
					a.add(st);
					hp.put(cnt, a);
				}
				else{
					hp.put(cnt,arr);
				}
				System.out.println(st);
			
				i=0;
			}
			if(check.equals("Float"))
			{
				
				
				BST<Float> bst=new BST<Float>();
				MyChristmasTree<Float> tree=new MyChristmasTree<Float>();
			
				String s=input.get(2);
				String[] values=s.split(" ");
				float r=Float.parseFloat(values[0]);
				for(int j=0;j<num_of_stud;j++)
				{
				
					
					bst.root=bst.add(bst.root, Float.parseFloat(values[j]));
					
				}
                tree.insert(bst.root);
                
               
                
				float st=0;
				 cnt=1;
				for(int j=0;j<num_of_stud;j++)
				{
					
					st=st+tree.get(j);
					if((tree.get(j).equals(r)))
					{
						cnt=j+1;
					}
					
					
				}

				System.out.println(st);
				arr.add(st);
				if(hp.containsKey(cnt))
				{
					ArrayList a=hp.get(cnt);;
					a.add(st);
					hp.put(cnt, a);
				}
				else{
					hp.put(cnt,arr);
				}

	
				
				i=0;
			}
			if(check.equals("String"))
			{
				System.out.println("String");
		
				BST<String> bst=new BST<String>();
				
				MyChristmasTree<String> tree=new MyChristmasTree<String>();
							
				String s=input.get(2);
				
				String[] values=s.split(" ");
				String r=values[0];
				for(int j=0;j<num_of_stud;j++)
				{
		
					bst.root=bst.add(bst.root, (values[j]));
					
				}
	
				tree.insert(bst.root);
				
				String st="";
				cnt=1;
				for(int j=0;j<num_of_stud;j++)
				{
					
					st=st+tree.get(j);
					if((tree.get(j).equals(r)))
					{
						cnt=j+1;
					}
					
					
				}
				
		       
				System.out.println(st+"String");
				arr.add(st);
				if(hp.containsKey(cnt))
				{
					ArrayList a=hp.get(cnt);;
					a.add(st);
					System.out.println(st);
					hp.put(cnt, a);
				}
				else{
					hp.put(cnt,arr);
				}
		
				
			}
			
			i=0;
			
			//System.out.println(i.next());

		
		
			
			
			

			
	}
		
		while(listit.hasNext())
		{
			Object o=listit.next();
			
			
        }
		
		
		
}
		
	
		
		PrintWriter writef=new PrintWriter("./src/answer.txt","UTF-8");
		
		int choices=0;
		
		for(int m=1;m<=num_of_stud;m++)
		{
			System.out.println(hp.containsValue(m));
			if(hp.get(m)!=null)
			{
				System.out.println("hi");
				writef.print(m+" ");
				ArrayList<Object> a=hp.get(m);
				
				for(int i=0;i<a.size();i++){
					System.out.println(m+" "+a.get(i));
					writef.print(a.get(i)+" ");
					
				}
				writef.println();
				choices=choices+1;
				
			}
			
		}
		writef.println(num_of_stud-choices);
		writef.close();
	
}
}
