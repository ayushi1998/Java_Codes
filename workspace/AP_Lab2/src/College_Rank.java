import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
class Mess
{
	private double food_avail;
	private double food_nut;
	private double hygiene ;
	private double food_delay;
	
	public Mess(double a,double b,double c,double d)
	{
		food_avail=a;
		food_nut=b;
		hygiene=c;
		food_delay=d;
		
	}

	public double getFood_avail() {
		return food_avail;
	}

	
	public double gethygeine() {
		// TODO Auto-generated method stub
		return hygiene;
	}

	public double getfood_nut() {
		// TODO Auto-generated method stub
		return food_nut;
	}

	public double getdelay() {
		// TODO Auto-generated method stub
		return food_delay;
	}
	
	

}


class Hostel{
	private double room;
	private double study;
	private double clean ;
	private double recreation;
	
	public Hostel(double a,double b,double c,double d)
	{
		room=a;
		study=b;
		clean=c;
		recreation=d;
		
	}
	
	public double getroom() {
		// TODO Auto-generated method stub
		return room;
	}
	public double getstudy() {
		// TODO Auto-generated method stub
		return study;
	}
	public double getclean() {
		// TODO Auto-generated method stub
		return clean;
	}
	public double getdrec() {
		// TODO Auto-generated method stub
		return recreation;
	}
	
}

class Library{
	private double books;
	private double digital;
	private double system ;

	
	public Library(double a,double b,double c)
	{
		books=a;
		digital=b;
		system=c;
		
		
	}
	
	public double getavg(){
		return ((books+digital+system)/3.0);
		
	}
	
}

class Academics{
	private double knowledge;
	private double domains;
	private double course;

	
	public Academics(double a,double b,double c)
	{
		knowledge=a;
		domains=b;
		course=c;
		
		
	}
	public double getval() {
		// TODO Auto-generated method stub
		return (knowledge+domains+(2*course));
	}
	
}

class Colleges{
	private String college_name;
	private Mess mess;
	private Hostel hostel;
	private Library library;
	private Academics acads;
	private char NaacGrade;
	private int grade;
	private int mr;
	private int hr;
	private int lr;
	private int ar;
	
	private double sum;
	
	private int fees;
	
	Colleges(String a,Mess m,Hostel hostel, Library l,Academics ac,String s,int f)
	{
		college_name=a;
		mess=m;
		library=l;
		this.hostel=hostel;
		acads=ac;
		NaacGrade=s.charAt(s.length()-1);
		setGrade(((int) NaacGrade)-97);
		setMr(0);
		fees=f;
		setHr(0);
		setLr(0);
		setAr(0);
		setsum(0);
		
	}
	public Mess getMess() {
		//System.out.println(mess);
		//acads.getval();
		return mess;
		
	}
	public Hostel getHostel() {
		// TODO Auto-generated method stub
		return hostel;
	}
	public Library getLib() {
		// TODO Auto-generated method stub
		return library;
	}
	public Academics getAcad() {
		// TODO Auto-generated method stub
		return acads;
	}
	public int getfees() {
		return fees;
	}
	public void setfees(int i) {
		this.fees =i;
	}
	
	public int getMr() {
		return mr;
	}
	public void setMr(int mr) {
		this.mr = mr;
	}
	
	public int getHr() {
		return hr;
	}
	public void setHr(int hr) {
		this.hr = hr;
	}
	
	public int getLr() {
		return lr;
	}
	public void setLr(int lr) {
		this.lr = lr;
	}
	
	public int getAr() {
		return ar;
	}
	public void setAr(int ar) {
		this.ar = ar;
	}
	
	public double getsum() {
		return sum;
	}
	public void setsum(double d) {
		this.sum =d;
	}
	
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getCollege_name() {
		return college_name;
	}
	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}
	

	
}

class A{
	int b;
	A(int n){
		b=n;
	}
}

public class College_Rank {
	private Colleges[] college;
	
	College_Rank(Colleges[] c)
	{
		college=c;
		
	}
	public Colleges[] getcollege(){
		return college;
	}
	
	public void mergesortmess(Colleges[] set,Colleges[]t,int lef, int rig){
		int mid;
		if(rig>lef)
		{
			mid=(rig+lef)/2;
			mergesortmess(set,t,lef,mid);
			mergesortmess(set,t,mid+1,rig);
			mergemess(set,t,lef,mid,rig);
			
			
		}
		
	}
	
	public void mergemess(Colleges[] s, Colleges[] t, int lef, int mid, int rig)
	{
		for (int i = lef; i <= rig; i++) {
			 t[i] = s[i];
			 //System.out.println(t[i].getMess());
			 }
			 int i = lef;
			 int j = mid + 1;
			 int k = lef;
			
			 while (i <= mid && j <= rig) {
				 //System.out.println(t[i].getMess().getFood_avail());
				 if (t[i].getMess().getFood_avail() == t[j].getMess().getFood_avail())
				 {
					 if(t[i].getMess().getfood_nut()== t[j].getMess().getfood_nut()){
						 if(t[i].getMess().gethygeine()== t[j].getMess().gethygeine()){
							if(t[i].getMess().getdelay()> t[j].getMess().getdelay()){
								 s[k] = t[i];
								 	i++;
								
							}else{
								 s[k] = t[j];
								 	j++;
							}
						 }
						 else if(t[i].getMess().gethygeine()< t[j].getMess().gethygeine()){
							 s[k] = t[i];
							 	i++;
						 }else{
							 s[k] = t[j];
							 	j++;
						 }
						 
					 }
					 else if(t[i].getMess().getfood_nut()< t[j].getMess().getfood_nut())
					 {
							s[k] = t[i];
						 	i++;
					 }
					 else{
						 s[k] = t[j];
						 	j++;
					 }
				 } 
				 else if(t[i].getMess().getFood_avail() < t[j].getMess().getFood_avail())
				{
					 	s[k] = t[i];
					 	i++;
				} 
				 else 
				 {
					 	s[k] = t[j];
					 	j++;
					 	
				 }
				 k++;
			 }
	
			 while (i <= mid)
			 {
				 s[k] = t[i];
				 k++;
				 i++;
			 }
			 
			 while (j <= rig) 
			 {
				 s[k] = t[j];
				 k++;
				 j++;
			 }
		}
		
	public void get_MessRank(){
		for(int i=0;i<college.length;i++){
			college[i].setMr(i+1);
		}
	}
	
	
	
	public void mergesorthostel(Colleges[] set,Colleges[]t,int lef, int rig){
		int mid;
		if(rig>lef)
		{
			mid=(rig+lef)/2;
			mergesorthostel(set,t,lef,mid);
			mergesorthostel(set,t,mid+1,rig);
			mergehostel(set,t,lef,mid,rig);
			
			
		}
		
	}
	
	public void mergehostel(Colleges[] s, Colleges[] t, int lef, int mid, int rig)
	{
		for (int i = lef; i <= rig; i++) {
			 t[i] = s[i];
			 }
			 int i = lef;
			 int j = mid + 1;
			 int k = lef;
			
			 while (i <= mid && j <= rig) {
				 if (t[i].getHostel().getroom() == t[j].getHostel().getroom())
				 {
					 if(t[i].getHostel().getstudy()== t[j].getHostel().getstudy())
					 {
						 if(t[i].getHostel().getclean()== t[j].getHostel().getclean()){
							if(t[i].getHostel().getdrec()< t[j].getHostel().getdrec()){
								 s[k] = t[i];
								 	i++;
								
							}else{
								 s[k] = t[j];
								 	j++;
							}
						 }
						 else if(t[i].getHostel().getclean()< t[j].getHostel().getclean()){
							 s[k] = t[i];
							 	i++;
						 }else{
							 s[k] = t[j];
							 	j++;
						 }
						 
					 }
					 else if(t[i].getHostel().getstudy()< t[j].getHostel().getstudy())
					 {
							s[k] = t[i];
						 	i++;
					 }
					 else{
						 s[k] = t[j];
						 	j++;
					 }
				 } 
				 else if(t[i].getHostel().getroom() < t[j].getHostel().getroom())
				{
					 	s[k] = t[i];
					 	i++;
				} 
				 else 
				 {
					 	s[k] = t[j];
					 	j++;
					 	
				 }
				 k++;
			 }
	
			 while (i <= mid)
			 {
				 s[k] = t[i];
				 k++;
				 i++;
			 }
			 
			 while (j <= rig) 
			 {
				 s[k] = t[j];
				 k++;
				 j++;
			 }
		}
		
	public void get_HostelRank(){
		for(int i=0;i<college.length;i++){
			college[i].setHr(i+1);
		}
	}
	
	
	
	
	
	
	public void mergesortlib(Colleges[] set,Colleges[]t,int lef, int rig){
		int mid;
		if(rig>lef)
		{
			mid=(rig+lef)/2;
			mergesortlib(set,t,lef,mid);
			mergesortlib(set,t,mid+1,rig);
			mergelib(set,t,lef,mid,rig);
			
			
		}
		
	}
	
	
	public void mergelib(Colleges[] s, Colleges[] t, int lef, int mid, int rig)
	{
		for (int i = lef; i <= rig; i++) {
			 t[i] = s[i];
			 }
			 int i = lef;
			 int j = mid + 1;
			 int k = lef;
			
			 while (i <= mid && j <= rig) {
				 if (t[i].getLib().getavg() < t[j].getLib().getavg())
				 
				{
					 	s[k] = t[i];
					 	i++;
				} 
				 else 
				 {
					 	s[k] = t[j];
					 	j++;
					 	
				 }
				 k++;
			 }
	
			 while (i <= mid)
			 {
				 s[k] = t[i];
				 k++;
				 i++;
			 }
			 
			 while (j <= rig) 
			 {
				 s[k] = t[j];
				 k++;
				 j++;
			 }
		}
		
	public void get_LibRank(){
		for(int i=0;i<college.length;i++){
			college[i].setLr(i+1);
		}
	}
	
	
	
	public void mergesortacad(Colleges[] set,Colleges[]t,int lef, int rig){
		int mid;
		if(rig>lef)
		{
			mid=(rig+lef)/2;
			mergesortacad(set,t,lef,mid);
			mergesortacad(set,t,mid+1,rig);
			mergeacad(set,t,lef,mid,rig);
			
			
		}
		
	}
	

		
	
	
	public void mergeacad(Colleges[] s, Colleges[] t, int lef, int mid, int rig)
	{
		for (int i = lef; i <= rig; i++) {
			 t[i] = s[i];
			 }
			 int i = lef;
			 int j = mid + 1;
			 int k = lef;
			
			 while (i <= mid && j <= rig) {
				 if (t[i].getAcad().getval() < t[j].getAcad().getval())
				
				{
					 	s[k] = t[i];
					 	i++;
				} 
				 else 
				 {
					 	s[k] = t[j];
					 	j++;
					 	
				 }
				 k++;
			 }
	
			 while (i <= mid)
			 {
				 s[k] = t[i];
				 k++;
				 i++;
			 }
			 
			 while (j <= rig) 
			 {
				 s[k] = t[j];
				 k++;
				 j++;
			 }
		}
		
	public void get_AcadRank(){
		for(int i=0;i<college.length;i++){
			college[i].setAr(i+1);
		}
	}
	
	
	public void get_CollegeRank(){
		for(int i=0;i<college.length;i++)
		{
			college[i].setsum((0.25*(college[i].getMr()+college[i].getLr())+(0.2*college[i].getHr())+(0.3*college[i].getAr())));
			
		}
	}
	
	
	public void mergesortrank(Colleges[] set,Colleges[]t,int lef, int rig){
		int mid;
		if(rig>lef)
		{
			mid=(rig+lef)/2;
			mergesortrank(set,t,lef,mid);
			mergesortrank(set,t,mid+1,rig);
			mergeRank(set,t,lef,mid,rig);
			
			
		}
		
	}
	
	public void mergeRank(Colleges[] s, Colleges[] t, int lef, int mid, int rig)
	{
		for (int i = lef; i <= rig; i++) {
			 t[i] = s[i];
			 }
			 int i = lef;
			 int j = mid + 1;
			 int k = lef;
			
			 while (i <= mid && j <= rig) {
				// System.out.println(t[i].getCollege_name()+" "+t[i].getsum());
				 if (t[i].getsum() == t[j].getsum())
				 {
					 if(t[i].getfees()==t[j].getfees())
					 {
						 if(t[i].getGrade()<t[j].getGrade()){
							 
								 s[k] = t[i];
								 	i++;
							 
						 }
						 else{
							 s[k] = t[j];
							 	j++;
							 
						 }
					 
				 }
				 else if(t[i].getfees()<t[j].getfees())
					 {
						 s[k] = t[i];
						 	i++;
					 }
					 else{
						 s[k] = t[j];
						 	j++;
					 }
				 }
				 else if(t[i].getsum() > t[j].getsum())
				{
					 	s[k] = t[i];
					 	i++;
				} 
				 else 
				 {
					 	s[k] = t[j];
					 	j++;
					 	
				 }
				 k++;
			 }
	
			 while (i <= mid)
			 {
				 s[k] = t[i];
				 k++;
				 i++;
			 }
			 
			 while (j <= rig) 
			 {
				 s[k] = t[j];
				 k++;
				 j++;
			 }
		}
	
	
	
	public void display()
	{
		for(int i=0;i<college.length;i++)
		{
			System.out.println(college[i].getCollege_name());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		
		int n=Reader.nextInt();
		
		A ob1=new A(2);
		
		A ob2=new A(2);
		System.out.println(ob1.equals(ob2));
		//Mess m1=new Mess(1,2,3,4);
		//Mess m2=new Mess(1,2,3,4);
		String m1="abn";
		String m2="abn";
		System.out.println(m1.equals(m2));
		System.out.println(m2==m1);
		Colleges[] college=new Colleges[n];
		String name;
		for(int i=0;i<n;i++)
		{
			//System.out.println(i);
			name=Reader.next();
			//System.out.println(name);
			String m=Reader.reader.readLine();
			String[] Words=m.split(" ");
			String h=Reader.reader.readLine();
			String l=Reader.reader.readLine();
			String ac=Reader.reader.readLine();
			
			String[] Words1=h.split(" ");
			String[] Words2=l.split(" ");
			String[] Words3=ac.split(" ");

			
			Mess mess=new Mess(Double.parseDouble(Words[1]), Double.parseDouble(Words[2]), Double.parseDouble(Words[3]), Double.parseDouble(Words[4]));
			Hostel hostel=new Hostel(Double.parseDouble(Words1[1]), Double.parseDouble(Words1[2]), Double.parseDouble(Words1[3]), Double.parseDouble(Words1[4]));
			Library lib=new Library(Double.parseDouble(Words2[1]), Double.parseDouble(Words2[2]), Double.parseDouble(Words2[3]));
			Academics acad=new Academics(Double.parseDouble(Words3[1]), Double.parseDouble(Words3[2]), Double.parseDouble(Words3[3]));
			String fees=Reader.reader.readLine();
			String[] Words4=fees.split(" ");
			
			String Naac=Reader.reader.readLine();
			college[i]=new Colleges(name,mess,hostel,lib,acad,Naac,(Integer.parseInt(Words4[1])));
			
			
		}
		College_Rank obj=new College_Rank(college);
		Colleges[] temp=new Colleges[n];
		obj.mergesortmess(college, temp, 0, n-1);
		obj.get_MessRank();
		obj.mergesorthostel(college, temp, 0, n-1);
		obj.get_HostelRank();
		obj.mergesortlib(college, temp, 0, n-1);
		obj.get_LibRank();

		obj.mergesortacad(college, temp, 0, n-1);
		obj.get_AcadRank();
		obj.get_CollegeRank();
		obj.mergesortrank(college, temp, 0, n-1);
		
		obj.display();
		
	}

}
