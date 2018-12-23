import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;
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





class Creature
{
	protected String name;
	protected double power;
	protected double health;
	protected double cost;
	protected double asset;
	private String type;
	protected int number;
	Creature(double d, double e, double f, double g){
		this.cost=d;
		this.asset=e;
		this.health=g;
		this.power=f;
	}
	
	public double getcost(){
		return cost;
	}
	
	public void setType(String t){
		this.type=t;
	}
	
	
	
	public String getType() {
		return type;
	}
	
	public void fight(Creature f){
		
		
		
		Random num=new Random();
		int val=num.nextInt((int) (this.power+1));
		number=val;
		this.health=this.health-val;		
		
	}
	
}
//Each Constructor will have those pre-defined values.
class humans extends Creature
{
	
	//Creature h;
  
	humans(double d, double e, double f, double g){
		super(d,e,f,g);
	}
	
	
	public void display(humans h){
		System.out.println(h.power);
	}
	
	
	
	
	
	
}
class dragons extends Creature
{
	dragons(double d, double e, double f, double g){
		super(d,e,f,g);
	}
	
	
	@Override
	public void fight(Creature f)
	{
		super.fight(f);
		Random num=new Random();
		int val=num.nextInt(101);
		if(val<=15){
			f.health=f.health-25;
		}
		
		
	}
	
	
	
}
class daemons extends Creature
{
	daemons(double d, double e, double f, double g){
		super(d,e,f,g);
	}
	
	
	public void fight(Creature f)
	{
		super.fight(f);
		Random num=new Random();
		int val=num.nextInt(101);
		if(val<=50){
			f.health=f.health-this.number;
		}
		
		
	}
	
	
}
class wolves extends Creature
{
	wolves(double d, double e, double f, double g){
		super(d,e,f,g);
	}
	
	
	
}
class ice_dragon extends dragons
{
	ice_dragon(double d, double e, double f, double g){
		super(d,e,f,g);
}
	
	public void fight(Creature f)
	{
		super.fight(f);
		
		Random num=new Random();
		int val=num.nextInt(101);
		
		if(val<=5){
			this.fight(f);
		}
		
		
	}
	
	
	
}
class fire_dragon extends dragons
{
	fire_dragon(double d, double e, double f, double g)
	{
		super(d,e,f,g);
	}
	public void fight(Creature f)
	{
		super.fight(f);
	}
	
	
}












class team_good 
{
	private double moneyg;
	
	HashMap<String,Creature> tg=new HashMap();
	
	team_good(double mon){
		moneyg=mon;
	}
	
	public void add(String name,Creature c)
	{
		
	  tg.put(name, c);	
	}
	public double getmoney()
	{
		return moneyg;
	}
	public void setmoney(double m)
	{
		moneyg=m;
	}
	public Creature getcreature(String n){
		Creature c=tg.get(n);
		return c;
	}
	public void remove(Creature fighter1)
	{
		tg.remove(fighter1);
	}
	public int size(){
		return tg.size();
	}
	
}
class team_bad
{
	private double moneyb;
	
	HashMap<String,Creature> tb=new HashMap();
	
	team_bad(double mon){
		moneyb=mon;
	}
	
	public void add(String name,Creature c)
	{
		
	  tb.put(name, c);	
	  
	}
	public double getmoney(){
		return moneyb;
	}
	public void setmoney(double m){
		moneyb=m;
	}
	public void remove(Creature n)
	{
		tb.remove(n);
	}
	public Creature getcreature(String n){
		Creature c=tb.get(n);
		return c;
	}
	
	public int size(){
		return tb.size();
	}
	
}




public class Fantasy_Game {
	private humans human;
	
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		System.out.println("Enter Team Good’s total money");
		double gm=Reader.nextInt();
		System.out.println("Enter Team Bad’s total money");
		double bm=Reader.nextInt();
		
	
		System.out.println("Enter cost, asset , power and health for Human (space-separated) -");
		double a =Reader.nextDouble();
		double b =Reader.nextDouble();
		double c =Reader.nextDouble();
		double e =Reader.nextDouble();
		
		humans h=new humans(a,b,c,e);
		
		
		
		
		System.out.println("Enter cost, asset , power and health for Fire-Dragon(space-separated) -");
		
		double j =Reader.nextDouble();
		double k =Reader.nextDouble();
		double l =Reader.nextDouble();
		double m =Reader.nextDouble();
		
		
		
		
		fire_dragon f=new fire_dragon(j,k,l,m);
		
		
		System.out.println("Enter cost, asset , power and health for Ice-Dragon (space-separated) -");
		double n =Reader.nextDouble();
		double o =Reader.nextDouble();
		double p =Reader.nextDouble();
		double q =Reader.nextDouble();
		
		
		
		
		ice_dragon i=new ice_dragon(n,o,p,q);
		
		System.out.println("Enter cost, asset , power and health for Daemons(space-separated) -");
		double r =Reader.nextDouble();
		double s =Reader.nextDouble();
		double t =Reader.nextDouble();
		double u =Reader.nextDouble();
		
		
		daemons d=new daemons(r,s,t,u);
        
		
		System.out.println("Enter cost, asset , power and health for Wolf(space-separated) -");
		
		double v =Reader.nextDouble();
		double x =Reader.nextDouble();
		double y =Reader.nextDouble();
		double z =Reader.nextDouble();
		
		
		
		
		
		
		wolves w=new wolves(v,x,y,z);
		
		
		
		team_good good=new team_good(gm);
		
		team_bad bad=new team_bad(bm);
		int cnt=1;
		int input;
		int input2;
		while(good.getmoney()>=h.getcost() || good.getmoney()>=f.getcost() || good.getmoney()>=w.getcost() )
		{
		System.out.println("Select Creatures For Team Good: 1. Human2. Fire Dragon3. Wolf4. Exit Selection");
		input=Reader.nextInt();
		
		if(input==1)
		{
			System.out.println("Enter Name Of The Human -");
			String name=Reader.next();
			 h=new humans(a,b,c,e);
			good.add(name, h);
			
			good.setmoney(good.getmoney()-h.getcost());
			h.name=name;
			h.setType("h");
			//System.out.println(h.getcost());
			
		}
		else if(input==2)
		{
			System.out.println("Enter Name Of The Fire Dragon-");
			String name=Reader.next();
			f=new fire_dragon(j,k,l,m);
			good.add(name, f);
			good.setmoney(good.getmoney()-f.getcost());
			f.setType("f");
			f.name=name;
		}
		else if(input==3)
		{
			System.out.println("Enter Name Of The Wolf -");
			String name=Reader.next();
			w=new wolves(v,x,y,z);
			good.add(name, w);
			good.setmoney(good.getmoney()-w.getcost());
			w.setType("w");
			w.name=name;
		}
		else{
			break;
		}

		}
		
		
		while((bad.getmoney()>=d.getcost() || bad.getmoney()>=i.getcost()))
		{
		System.out.println("Select Creatures For Team Bad: 1. Daemon2. Ice Dragon 3 .Exit Selection");
		input2=Reader.nextInt();
		
		if(input2==1)
		{
			System.out.println("Enter Name Of The Daemon -");
			String name=Reader.next();
			d=new daemons(r,s,t,u);
			bad.setmoney(bad.getmoney()-d.getcost());
			bad.add(name, d);
			d.name=name;
			d.setType("d");
			
		}
		else if(input2==2)
		{
			System.out.println("Enter Name Of The Ice Dragon-");
			String name=Reader.next();
			i=new ice_dragon(n,o,p,q);
			bad.setmoney(bad.getmoney()-i.getcost());
			bad.add(name, i);
			i.setType("i");
			i.name=name;
		}
		
		else{
			break;
		}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		while((good.size()>0&&bad.size()>0) ){
			
			
			
		
		while((good.getmoney()>=h.getcost() || good.getmoney()>=f.getcost() || good.getmoney()>=w.getcost()) && (good.size()<=0) )
		{
		System.out.println("Select Creatures For Team Good: 1. Human2. Fire Dragon3. Wolf4. Exit Selection");
		 input=Reader.nextInt();
		
		if(input==1)
		{
			System.out.println("Enter Name Of The Human -");
			String name=Reader.next();
		     h=new humans(a,b,c,e);
			good.add(name, h);
			
			good.setmoney(good.getmoney()-h.getcost());
			
			h.setType("h");
			h.name=name;
			//System.out.println(h.getcost());
			
		}
		else if(input==2)
		{
			System.out.println("Enter Name Of The Fire Dragon-");
			String name=Reader.next();
			 f=new fire_dragon(j,k,l,m);
			good.add(name, f);
			good.setmoney(good.getmoney()-f.getcost());
			f.setType("f");
			f.name=name;
		}
		else if(input==3)
		{
			System.out.println("Enter Name Of The Wolf -");
			String name=Reader.next();
			w=new wolves(v,x,y,z);
			good.add(name, w);
			good.setmoney(good.getmoney()-w.getcost());
			w.setType("w");
			w.name=name;
		}
		else
		{
			break;
		}
		}
		
		
		
		while((bad.getmoney()>=d.getcost() || bad.getmoney()>=i.getcost()) && bad.size()<0)
		{
		System.out.println("Select Creatures For Team Bad: 1. Daemon2. Ice Dragon 3 .Exit Selection");
		input2=Reader.nextInt();
		
		if(input2==1)
		{
			System.out.println("Enter Name Of The Daemon -");
			String name=Reader.next();
			d=new daemons(r,s,t,u);
			bad.setmoney(bad.getmoney()-d.getcost());
			bad.add(name, d);
			
			d.setType("d");
			d.name=name;
			
		}
		else if(input2==2)
		{
			System.out.println("Enter Name Of The Ice Dragon-");
			String name=Reader.next();
			i=new ice_dragon(n,o,p,q);
			bad.setmoney(bad.getmoney()-i.getcost());
			bad.add(name, i);
			i.setType("i");
			i.name=name;
		}
		
		else
		{
			break;
		}
	
		}
		
		
		
		
		//Fights
		
		
		System.out.println("The War Begins -");
		System.out.println("Round-"+cnt+":");
		
		int flag1=0;
		int flag2=0;
		Creature fighter1 = null;
		Creature fighter2 = null;
		
		// TO ENTER THE NAME CREATURE"S 
		if(flag1==0 )
		{
		System.out.println("Enter Creature from Good’s Team to fight in the war -");
		String iname1=Reader.next();
		
		 fighter1=good.getcreature(iname1);
		}
		
		
		if(flag2==0)
		{
		System.out.println("Enter Creature from Bad’s Team to fight in the war -");
		String iname2=Reader.next();
		
		 fighter2=bad.getcreature(iname2);
		}
		
		fighter1.fight(fighter2);   //Cross Functionalities.
		fighter2.fight(fighter1);
		
		
		//Printing Statements.
	
	
	if(fighter1.health>0 && fighter2.health>0)
	{
		cnt=cnt+1;
		
		while(fighter1.health>0 && fighter2.health>0)
		{
			//System.out.println("The War Begins -");
			//System.out.println("Round-"+cnt+":");
			fighter1.fight(fighter2);   //Cross Functionalities.
			fighter2.fight(fighter1);
			
			cnt=cnt+1;
		}
		
		System.out.println(fighter1.health+"is the health of good creature");
		System.out.println(fighter2.health+"is the health of bad creature");
		
		Creature fighterwon;
		if(fighter1.health>0){
			fighterwon=fighter1;
			flag2=0;
			flag1=1;
		}else if(fighter2.health>0){
			fighterwon=fighter2;
			flag1=0;
			flag2=1;
			
			
		}
		
		//MONEY ADD TO USER"S ACCOUNT
		
		
	}
		
	
	
	if(fighter1.health>0 && fighter2.health<0)
	{
		
	  //Print winner
		 //fighter 1
	cnt=cnt+1;	 
	good.setmoney(good.getmoney()+fighter2.asset);
	System.out.println(fighter1.health+"is the health of good creature");
	System.out.println(fighter2.health+"is the health of bad creature");
	
	System.out.println(fighter2.name+" Loses In Round-"+cnt);
	System.out.println("Money Of Bad’s Team is "+ (int)bad.getmoney());
	System.out.println("Money Of Good’s Team is "+ (int)good.getmoney());
		
		
	
		
		
		
		
		flag2=0;
		flag1=1;
		bad.remove(fighter2);
		continue;
		
		
		
		
		
		
		
		
	}
	
	if(fighter1.health<0 && fighter2.health>0)
	{
		cnt=cnt+1;
		
		bad.setmoney(bad.getmoney()+fighter1.asset);
		System.out.println(fighter1.health+"is the health of good creature");
		System.out.println(fighter2.health+"is the health of bad creature");
		
		System.out.println(fighter1.name+"Loses In Round-"+cnt);
		System.out.println("Money Of Bad’s Team is "+ (int)bad.getmoney());
		System.out.println("Money Of Good’s Team is "+(int) good.getmoney());
			
		
		
		good.remove(fighter1);
		flag2=1;
		flag1=0;
		continue;
		
		
	}
	
	
	else
	{

		bad.remove(fighter2);
		good.remove(fighter1);
		flag1=0;
		flag2=0;
	}
		
		

	}
	
		if(good.size()!=0)
		{
		System.out.println("Team Good wins the war. The money the team has is "+ good.getmoney());
		}
		else
		{
			System.out.println("Team Bad wins the war. The money the team has is "+ bad.getmoney());
		}
		
		}
	
}

