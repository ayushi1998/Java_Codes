import java.io.*;
import java.util.Arrays;
import java.util.List;

public class AP_lab2 implements Serializable{
	  private int var1 = 10;
	  private Inner n=new Inner();
	  
	  
	  
	  public void print(){
		  System.out.println("Var1="+ var1+ "and Var2="+ n.var2);
	  }
	  
	  
	  private class Inner implements Serializable{
		  private int var2=20;
		  
	  }

  public static void main(String[] args) throws IOException , ClassNotFoundException 
  {
	  ObjectOutputStream out=null;
	  ObjectInputStream in=null;
	  try{
		  out= new ObjectOutputStream(new FileOutputStream("out.txt"));
		  out.writeObject(new AP_lab2());
		  in=new ObjectInputStream(new FileInputStream("out.txt"));
		  AP_lab2 obj=(AP_lab2) in.readObject();
		  obj.print();
		  
	  }
	  finally{
		  out.close();
		  in.close();
	  }
   

  }
}
