import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
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

class Grassland
{
	
	private double x_centre;
	private double y_centre;
	private double radius;
	private double grass_avail;
	
	Grassland(double a,double b,double c,double d)
	{
		setX_centre(a);
		setY_centre(b);
		setRadius(c);
		setGrass_avail(d);
		
		
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	

	public double getX_centre() {
		return x_centre;
	}

	public void setX_centre(double x_centre) {
		this.x_centre = x_centre;
	}

	public double getY_centre() {
		return y_centre;
	}

	public void setY_centre(double y_centre) {
		this.y_centre = y_centre;
	}

	public double getGrass_avail() {
		return grass_avail;
	}

	public void setGrass_avail(double grass_avail) {
		this.grass_avail = grass_avail;
	}
	
}

abstract class  Animal
{
	protected double x_a;
	protected double y_a;
	private double health;
	private int ts;
	 protected double maxgrass;
	 protected String name;
	Animal(double a,double b,double health,int time,String name)
	{
		x_a=a;
		y_a=b;
		this.setHealth(health);
		setTs(time);
		this.name=name;
		
	}
	public int getTs() {
		return ts;
	}
	public void setTs(int ts) {
		this.ts = ts;
	}
	public double getHealth() {
		return health;
	}
	public void setHealth(double health) {
		this.health = health;
	}
	public double getDistance(double x1,double y1)
	{
		double val=(Math.pow((this.x_a-x1), 2)+Math.pow((this.y_a-y1), 2));
		return(Math.sqrt(val));
	}
	
	
	public double getDistance_grassland(Grassland g)
	{
		double val=(Math.pow((this.x_a-g.getX_centre()), 2)+Math.pow((this.y_a-g.getY_centre()), 2));
		return(Math.sqrt(val));
	}
	
	public void move(Grassland g1,Grassland g2, int mov)
	{
		if(this.nearest_grassland(g1, g2)==g1)
		{
			int hyp=(int) this.getDistance_grassland(g1);
			int cos_angle=(int) (((this.x_a-g1.getX_centre()))/hyp);
			int sin_angle=(int) (((this.y_a-g1.getY_centre()))/hyp);
			this.x_a=this.x_a+mov*cos_angle;
			this.y_a=this.y_a+mov*sin_angle;	
		}
		else if(this.nearest_grassland(g1, g2)==g2)
		{
			int hyp=(int) this.getDistance_grassland(g2);
			int cos_angle=(int) (((this.x_a-g2.getX_centre()))/hyp);
			int sin_angle=(int) (((this.y_a-g2.getY_centre()))/hyp);
			this.x_a=this.x_a+mov*cos_angle;
			this.y_a=this.y_a+mov*sin_angle;	
		}
		
		 
		
		
	}
	
	
	
   public abstract void Act_one(Herbivore h1,Herbivore h2,Grassland g1,Grassland g2);
   public abstract void Act_two(Carnivore c1, Carnivore c2,Grassland g1,Grassland g2,Herbivore h1,Herbivore h2);
   public abstract void Act_three(Carnivore c1, Carnivore c2,Grassland g1,Grassland g2,Herbivore h1,Herbivore h2);
   
   
   public Grassland checkGrassland(Grassland g1,Grassland g2){
		
		if(((Math.pow(this.x_a, 2)+Math.pow(this.y_a, 2))-Math.pow(g1.getRadius(),2)>0) & ((Math.pow(this.x_a, 2)+Math.pow(this.y_a, 2))-Math.pow(g2.getRadius(),2)>0))
		{
			//Outside both the circles
			return null;
		}
		else
		{
			if((Math.pow(this.x_a, 2)+Math.pow(this.y_a, 2))-Math.pow(g1.getRadius(),2)<=0)
			{
				//Inside grassland 1
				
				return (g1);
				
			}
			else
			{
				//Inside grassland 2
				
				return(g2);
			}
		}
		
		
		
		
	}
   public Grassland nearest_grassland(Grassland g1,Grassland g2)
   {
	   if(this.checkGrassland(g1,g2)==null) // Oustside both the grasslands
	   {
		   // Check distance with grassland 1, 
		   if(this.getDistance_grassland(g1)<this.getDistance_grassland(g2)){
			   return g1;
		   }
		   else{
			   return g2;
		   }
		   
		   
	   }
	   else
	   {
		   return(this.checkGrassland(g1, g2));
		   
	   }
	   
   }
   
   public void move(Animal c1,Animal c2, int mov)
   {
	   if(c1.getHealth()>0 & c2.getHealth()<=0) 
	   {
		   int hyp=(int) this.getDistance(c1.x_a,c1.y_a);
			int cos_angle=(int) (((this.x_a-c1.x_a))/hyp);
			int sin_angle=(int) (((this.y_a-c1.y_a))/hyp);
			this.x_a=this.x_a+mov*cos_angle;
			this.y_a=this.y_a+mov*sin_angle;
		   
		   
	   }
	   else if(c1.getHealth()<=0 & c2.getHealth()>0)
	   {
		   int hyp=(int) this.getDistance(c2.x_a,c2.y_a);
			int cos_angle=(int) (((this.x_a-c2.x_a))/hyp);
			int sin_angle=(int) (((this.y_a-c2.y_a))/hyp);
			this.x_a=this.x_a+mov*cos_angle;
			this.y_a=this.y_a+mov*sin_angle;
		   
		   
		   
	   }
	   else
	   {
		   if(this.getDistance(c2.x_a,c2.y_a)>this.getDistance(c1.x_a,c1.y_a))
		   {
			   //Got to C1
			   int hyp=(int) this.getDistance(c1.x_a,c1.y_a);
				int cos_angle=(int) (((this.x_a-c1.x_a))/hyp);
				int sin_angle=(int) (((this.y_a-c1.y_a))/hyp);
				this.x_a=this.x_a+mov*cos_angle;
				this.y_a=this.y_a+mov*sin_angle;
			   
		   }
		   else{
			   int hyp=(int) this.getDistance(c2.x_a,c2.y_a);
				int cos_angle=(int) (((this.x_a-c2.x_a))/hyp);
				int sin_angle=(int) (((this.y_a-c2.y_a))/hyp);
				this.x_a=this.x_a+mov*cos_angle;
				this.y_a=this.y_a+mov*sin_angle;
			   
		   }
	   }
	   
	   
   }
	
	
}




class Herbivore extends Animal 
{
   private int turn=0;
	Herbivore(double a, double b, double health, int time,double grass, String string) {
		super(a, b, health, time,string);
		maxgrass=grass;
		turn=0;
	}
	public void Act_one(Herbivore h1,Herbivore h2,Grassland g1,Grassland g2)
	{
		//We'll Know the status of the animal about its whereabouts.
		// Calling checkGrasslands .
		Random num=new Random();
		int val=num.nextInt(101);
		if(this.checkGrassland(g1,g2)==null)
		{
			if(val<=50)
			{
				this.move(g1, g2, 5);
				this.setHealth(this.getHealth()-25);
				System.out.println("It moves"+this.x_a+" "+this.y_a+" "+val);
			}
			
			
		}
		else{
			this.move(g1, g2, 5);
			this.setHealth(this.getHealth()-25);
			System.out.println("It moves"+this.x_a+" "+this.y_a+" "+val);
		}
		
		
		
		
		
	}
	
	
	public void Act_two(Carnivore c1,Carnivore c2,Grassland g1,Grassland g2,Herbivore h1,Herbivore h2)
	{
		int f=0;
		Random num=new Random();
		int val=num.nextInt(101);
		if(val<=5){
			f=1;
		}
		else{
			if(val<=65)
			{
				this.move(g1, g2, 5);
				this.setHealth(this.getHealth()-25);
				System.out.println("It moves"+this.x_a+" "+this.y_a+" "+val);
				
			}
			else
			{  //move from carnivore;
				
				
				this.move(c1,c2, -4);
				
				
				this.setHealth(this.getHealth()-25);
				System.out.println("It moves"+this.x_a+" "+this.y_a+" "+val);
				
			}
		}
		
		
		
	}
	
	public void Act_three(Carnivore c1, Carnivore c2,Grassland g1,Grassland g2,Herbivore h1,Herbivore h2)
	{
		Random num=new Random();
		int val=num.nextInt(101);
		if(this.checkGrassland(g1, g2)==g1)
		{
			if(g1.getGrass_avail()>=this.maxgrass)
			{
				if(val<=90){
					// Grass eaten to maximum capacity
					g1.setGrass_avail(g1.getGrass_avail()-this.maxgrass);
				}
				else
				{
					int val2=num.nextInt(101);
					if(val2<=50){
						//Carnivore move
						this.move(c1, c2, -2);
						this.setHealth(this.getHealth()-25);
						System.out.println("It moves"+this.x_a+" "+this.y_a+" "+val+" "+val);
					}
					else
					{
						this.move(g1, g2, 3);
						this.setHealth(this.getHealth()-25);
						System.out.println("It moves"+this.x_a+" "+this.y_a+" "+val);
					}
					
				}
				
			}
			else{
				{
					
					if(val<=20)
					{
						g1.setGrass_avail(0);
						this.setHealth(this.getHealth()+(this.getHealth()*0.2));
					}
					else
					{
						int val2=num.nextInt(101);
						if(val2<=70)
						{
							
							
							// carnivore move
							this.move(c1, c2, -4);
							
							this.setHealth(this.getHealth()-25);
							System.out.println("It moves"+this.x_a+" "+this.y_a+" "+val);
						}
						else
						{
							this.move(g1, g2, 2);
							this.setHealth(this.getHealth()-25);
							System.out.println("It moves"+this.x_a+" "+this.y_a+" "+val);
						}
					}
					
				}
				
			}
			
		
		}
		else{
		if(g2.getGrass_avail()>=this.maxgrass)
		{

			if(val<=90){
				// Grass eaten to maximum capacity
				g2.setGrass_avail(g2.getGrass_avail()-this.maxgrass);
				this.setHealth(this.getHealth()+(this.getHealth()*0.5));
			}
			else
			{
				int val2=num.nextInt(101);
				if(val2<=50){
					//Carnivore move
					this.move(c1, c2, -2);
					this.setHealth(this.getHealth()-25);
					System.out.println("It moves"+this.x_a+" "+this.y_a+" "+val);
					
				}
				else
				{
					this.move(g2, g2, 3);
					
					
					this.setHealth(this.getHealth()-25);
					System.out.println("It moves"+this.x_a+" "+this.y_a+" "+val);
				}
				
			}
	
		}
		else{
			{
				
				if(val<=20)
				{
					g2.setGrass_avail(0);
					this.setHealth(this.getHealth()+(this.getHealth()*0.2));
				}
				else
				{
					int val2=num.nextInt(101);
					if(val2<=70)
					{
						// carnivore move
						this.move(c1, c2, -4);
						
						this.setHealth(this.getHealth()-25);
						System.out.println("It moves"+this.x_a+" "+this.y_a+" "+val);
						
					}
					else
					{
						this.move(g1, g2, 2);
						this.setHealth(this.getHealth()-25);
						System.out.println("It moves"+this.x_a+" "+this.y_a+" "+val);
					}
				}
				
			}
			
		}
		
		}
		
		
		
		
		
		
		
	}
	

	
	
	
}
class Carnivore extends Animal
{
   
	Carnivore(double a, double b, double health, int time,double grass, String string) {
		super(a, b, health, time,string);
		maxgrass=grass;
	}
	
public void Act_one(Herbivore h1,Herbivore h2,Grassland g1,Grassland g2)
{
	/*
	    * If a carnivore is within a 1 unit radius of a herbivore then it will kill and eat the herbivore.
Below points are the cases when it is not inside the 1 unit radius of the herbivore. (If both
the herbivores are within 1 mile radius then it will eat the nearest herbivore)
	    */
	
	if(h1.getHealth()>0 & h2.getHealth()<=0)
	{// H1 is alive and within 1 unit
		if(this.getDistance(h1.x_a, h1.y_a)<=1){
			h1.setHealth(0);
			this.setHealth(this.getHealth()+((2/3)*this.getHealth()));
		}
		
	}
	else if(h2.getHealth()>0 & h1.getHealth()<=0)
	{
		if(this.getDistance(h2.x_a, h2.y_a)<=1){
			h2.setHealth(0);
			this.setHealth(this.getHealth()+((2/3)*this.getHealth()));
		}
		
	}
	else
	{
		if(this.getDistance(h1.x_a, h1.y_a)<=1 || this.getDistance(h2.x_a, h2.y_a)<=1)
		{
			if(this.getDistance(h1.x_a, h1.y_a)<=1){
				h1.setHealth(0);
				this.setHealth(this.getHealth()+((2/3)*this.getHealth()));
			}
			else if(this.getDistance(h2.x_a, h2.y_a)<=1)
			{
				h2.setHealth(0);
				this.setHealth(this.getHealth()+((2/3)*this.getHealth()));
			}
			else{
				if(this.getDistance(h1.x_a, h1.y_a)> this.getDistance(h2.x_a, h2.y_a)){
					h2.setHealth(0);
					this.setHealth(this.getHealth()+((2/3)*this.getHealth()));
				}
				else{
					h1.setHealth(0);
					this.setHealth(this.getHealth()+((2/3)*this.getHealth()));
				}
			}
			
		}
		
		
	}
	
		
}

public void Act_two(Carnivore c1,Carnivore c2,Grassland g1,Grassland g2,Herbivore h1,Herbivore h2)
{
	
	Random num=new Random();
	int val=num.nextInt(101);
	if(val<=92)
	{
		// Move towards nearest Herbivore
		this.move(h1, h2, 4);
		System.out.println("It moves"+this.x_a+" "+this.y_a+" "+val);
	}
	else
	{
		this.setHealth(this.getHealth()-60);
	}
	

}

public void Act_three(Carnivore c1, Carnivore c2, Grassland g1, Grassland g2, Herbivore h1, Herbivore h2)
{
	// TODO Auto-generated method stub
	Random num=new Random();
	int val=num.nextInt(101);
	if(val>=25)
	{
		this.move(h1, h2, 2);
		System.out.println("It moves"+this.x_a+" "+this.y_a+" "+val);
	}
	
	else
	{
		this.setHealth(this.getHealth()-30);
	}
	
	
	
	
}

	
}



class AnimalCompare implements Comparator<Animal>
{
	
	@Override
	public int compare(Animal an1, Animal an2) {
		if(an1.getTs()==an2.getTs())
		{
			if(an1.getHealth()==an1.getHealth())
			{
				if( (an1.getClass()==an2.getClass() && an1.getClass().getName()=="Herbivore"))
				{
					if(an1.getDistance(0,0)>an2.getDistance(0,0))
					{
						return(1);
					}
					else{
						return(-1);
					}
					
					
				}
				else if( (an1.getClass()==an2.getClass() && an1.getClass().getName()=="Carnivore")){
					if(an1.getDistance(0,0)>an2.getDistance(0,0))
					{
						return(1);
					}
					else{
						return(-1);
					}
					
				}
				else{
					if(an1.getClass().getName()=="Herbivore")
					{
						return(-1);
					}
					else
                   {
						return(1);
					}
					
			}
			}
			else
			{
				if(an1.getHealth()>an2.getHealth())
				{
					return (-1);
					
				}
				else
				{
					return (1);
				}
				
			}
			
			
		}
		else
		{
			if(an1.getTs()>an2.getTs())
			{
				return(1);
				
			}
			else
			{
				return(-1);
			}
		}
		
		
		
		
	
		// TODO Auto-generated method stub
	
	}

}










public class World {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
           Reader.init(System.in);
		
		   
		   System.out.println("Enter Total Final Time for Simulation:");
		   int time=Reader.nextInt();
		   System.out.println("Enter x, y centre, radius and Grass Available for First Grassland:");
		   double x1=Reader.nextDouble();
		   double y1=Reader.nextDouble();
		   double r1=Reader.nextDouble();
		   double gr1=Reader.nextDouble();
		   
		   Grassland g1=new Grassland(x1,y1,r1,gr1);
		   
		   System.out.println("Enter x, y centre, radius and Grass Available for Second Grassland:");
		   double x2=Reader.nextDouble();
		   double y2=Reader.nextDouble();
		   double r2=Reader.nextDouble();
		   double gr2=Reader.nextDouble();
		   
		   Grassland g2=new Grassland(x2,y2,r2,gr2);
		   System.out.println("Enter Health and Grass Capacity for Herbivore:");
		   double h2=Reader.nextDouble();
		   double gc2=Reader.nextDouble();
		   
		   
		   System.out.println("Enter x, y position and timestamp for First Herbivore:");
		   double x5=Reader.nextDouble();
		   double y5=Reader.nextDouble();
		   int ts5=Reader.nextInt();
		   Herbivore hb1=new Herbivore(x5,y5,h2,ts5,gc2,"hb1");
		   
		   System.out.println("Enter x, y position and timestamp for Second Herbivore:");
		   double x6=Reader.nextDouble();
		   double y6=Reader.nextDouble();
		   int ts6=Reader.nextInt();
		   Herbivore hb2=new Herbivore(x6,y6,h2,ts6,gc2,"hb2");
		   
		   
		   System.out.println("Enter Health and Grass Capacity for Carnivore:");
		   double h1=Reader.nextDouble();
		   double gc1=Reader.nextDouble();
		   
		   
		   System.out.println("Enter x, y position and timestamp for First Carnivore:");
		   double x3=Reader.nextDouble();
		   double y3=Reader.nextDouble();
		   int ts3=Reader.nextInt();
		   Carnivore c1=new Carnivore(x3,y3,h1,ts3,gc1,"c1");
		   
		   System.out.println("Enter x, y position and timestamp for Second Carnivore:");
		   double x4=Reader.nextDouble();
		   double y4=Reader.nextDouble();
		   int ts4=Reader.nextInt();
		   Carnivore c2=new Carnivore(x4,y4,h1,ts4,gc1,"c2");
		   
		   Comparator<Animal> compare=new AnimalCompare();
		   
		   PriorityQueue<Animal> pq=new PriorityQueue<Animal>(4,compare);
		   pq.add(hb1);
		   pq.add(hb2);
		   pq.add(c1);
		   pq.add(c2);
		   
		   
		   
		   //Simulation
		   Iterator i=pq.iterator();
		   int flag=0;
		   int tot=0;
		   while(!pq.isEmpty() & tot<time)
		   {
			   Animal ani=pq.remove();
			   
			   if(ani.getClass().getName()=="Herbivore")
			   {
			   if(c1.getHealth()<=0 && c2.getHealth()<=0) //No Carnivore
			   {
				   
				   ani.Act_one(hb1,hb2,g1,g2); //nearest Grassland;  First find in which grassland he is.? 2. Then if he is in either , move him 5 unts , else go to next in 5 units
				   
			   }
			   else
			   {
				   int t=0;
				   if( ani.checkGrassland(g1,g2)==null)
					  {// Not inside
					   ani.Act_two(c1,c2,g1,g2,hb1,hb2); 
						 
						  
						  
					  }
				   else
				   {
					   ani.Act_three(c1,c2,g1,g2,hb1,hb2);
				   }
					   
				   
			   }
			   
			   
		   }
			   else
			   {
				   /*
				    * If a carnivore is within a 1 unit radius of a herbivore then it will kill and eat the herbivore.
Below points are the cases when it is not inside the 1 unit radius of the herbivore. (If both
the herbivores are within 1 mile radius then it will eat the nearest herbivore)
				    */
				   
				   if(hb1.getHealth()>0 || hb2.getHealth()>0 ) // Atleast 1 herbivore is alive
				   {
					   
					   ani.Act_one(hb1,hb2,g1, g2);
					   
					   
				   }
				   else  
				   {
					   if(ani.checkGrassland(g1,g2)==null)
					   {
						   // Carnivore not inside Grassland
						   
						  ani.Act_two(c1, c2, g1, g2, hb1, hb2); 
						  
						   
						   
					   }
					   else
					   {
						   ani.Act_three(c1, c2, g1, g2, hb1, hb2);
					   }
					   
				   }
				   
				   
			   }
			   if(ani.name=="hb1")
			   {
				   System.out.println("It is First Herbivore.");
				   if(ani.getHealth()>0)
				   {
				   System.out.println("It’s health after taking turn is"+ani.getHealth());}
				   else{
					   System.out.println("It is dead");
				   }
				   
			   }
			   
			   else if(ani.name=="hb2")
			   {
				   System.out.println("It is Second Herbivore.");
				   if(ani.getHealth()>0)
				   {
				   System.out.println("It’s health after taking turn is"+ani.getHealth());}
				   else{
					   System.out.println("It is dead");
				   }
			   }
			   else if(ani.name=="c1"){
				   System.out.println("It is First Carnivore.");
				   if(ani.getHealth()>0)
				   {
				   System.out.println("It’s health after taking turn is"+ani.getHealth());}
				   else{
					   System.out.println("It is dead");
				   }
				   
			   }
			   else{
				   System.out.println("It is Second Carnivore.");
				   if(ani.getHealth()>0)
				   {
				   System.out.println("It’s health after taking turn is"+ani.getHealth());}
				   else{
					   System.out.println("It is dead");
				   }
			   }
			  
			   if(ani.getHealth()>0 & ani.getTs()<time-1)
			   {
				  
				   //time stamp
				   int[] c=new int[4];
				  
				   c[0]=hb1.getTs();
				   c[1]=hb2.getTs();
				   c[2]=c1.getTs();
				   c[3]=c2.getTs();
				   
				  // FIND MAX TIME STAMP
				   Arrays.sort(c);
				   
				   Random n=new Random();
				   int val=n.nextInt(time-c[3]+1)+c[3];
				   System.out.println("value time"+val);
				   
				   ani.setTs(val);
				   pq.add(ani);
			   }
			   
			   
			   tot=tot+1;
			   
			   
		   }
		   
	

	}
	

}
