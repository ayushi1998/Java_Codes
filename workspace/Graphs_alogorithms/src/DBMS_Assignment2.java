
/* Code by - Ayushi Srivastava 2016025
             Tanish Gupta 2016106
*/
import java.util.*;
import java.util.concurrent.*;
import java.io.*;
import java.lang.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

class passenger
{
    ArrayList<Integer> flist;
    ReadWriteLock l=new ReentrantReadWriteLock();    
    passenger()
    {
        flist=new ArrayList<Integer>();
    }
}

class flight
{
    int max_cap;
    ArrayList<Integer> plist;
    ReadWriteLock l=new ReentrantReadWriteLock();    
    flight(int m) 
    {   
        plist=new ArrayList<Integer>();
        max_cap=m;
    }
}

class database 
{
    HashMap<Integer,flight> flist =new HashMap<Integer,flight>();
    //List<Integer> pass=new ArrayList<Integer>();
    HashMap<Integer, passenger> plist=new HashMap<Integer, passenger>(); 
    int total=0;
    public void reserve(int fid, int pid) throws InterruptedException
    {
       // System.out.println("reserve");
        Thread.sleep(1000);
        
        if(flist.containsKey(fid))
        {
            if(flist.get(fid).max_cap > flist.get(fid).plist.size())
            {
                if(!flist.get(fid).plist.contains(pid))
                {
                    flist.get(fid).plist.add(pid);
                    total++;
                    plist.get(pid).flist.add(fid);
                    System.out.println(pid + "Passenger added to "+ fid);
                }
                else
                    System.out.println(pid + "Passenger already booked in " + fid);
            }
            else
                System.out.println(fid + " Capacity full");
        
        }
    }
    
    public void cancel(int fid, int pid) throws InterruptedException
    {
        //System.out.println("cancel");
        Thread.sleep(1000);
        
        if(flist.containsKey(fid))
        {
            if(flist.get(fid).plist.contains(pid))
            {
                flist.get(fid).plist.remove(pid);
                total--;
                plist.get(pid).flist.remove(fid);
                System.out.println(pid + "Passenger removed from "+ fid);
            }
            else
                System.out.println("Passenger Doesnt Exists");
        
        }
    }
    
    public void my_flights(int pid) throws InterruptedException
    {
        //System.out.println("my_flights");
        Thread.sleep(1000);
        System.out.println("Number of flights booked of  "+pid + plist.get(pid).flist.size());
        
    }
    
    public void total_reservations() throws InterruptedException
    {  
        Thread.sleep(1000);
        System.out.println("Total reservations are " + total);
    }
    
    public int remove(int fid, int pid)
    {
        if(flist.containsKey(fid))
        {
            System.out.println(flist.get(fid).plist.contains(pid));
            if(flist.get(fid).plist.contains(pid))
            {
                flist.get(fid).plist.remove(pid);
                total--;
                plist.get(pid).flist.remove(fid);
                System.out.println(pid+ "Passenger removed from " + fid);
                return 1;
            }
            else
             System.out.println(pid + "Passenger Doesnt Exists");
        
        }
        return 0;
    }
    
    public int insert(int fid, int pid)
    {
        if(flist.containsKey(fid))
        {
            if(flist.get(fid).max_cap > flist.get(fid).plist.size())
            {
                if(!flist.get(fid).plist.contains(pid))
                {
                    flist.get(fid).plist.add(pid);
                    total++;
                    plist.get(pid).flist.add(fid);
                    System.out.println(pid + "Passenger added to " + fid);
                    return 1;
                }
                else
                    System.out.println(pid + "Passenger already booked");
            }
            else
                System.out.println(fid + "Capacity full");
        
        }      
        return 0;
        
    }
    public void transfer(int fid1, int fid2 , int pid) throws InterruptedException
    {
        //System.out.println("transfer");
        Thread.sleep(1000);
        if(remove(fid1,pid)==1)
            if(insert(fid2,pid)!=1)
            	reserve(fid1,pid);
            	
    }

}

class transaction implements Runnable
{
    ReentrantLock lock= new ReentrantLock();
    ReadWriteLock lc=new ReentrantReadWriteLock();
    database d= new database();
    int flag;
    transaction(database db, int f)
    {
        d=db;
        flag=f;
    }
    
    @Override
    public void run()
    {   
        Random r=new Random();
        
        if(flag==1)
        {
            int temp=3;
            //while(temp>0){
                while(!lock.tryLock())
                {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(transaction.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                try
                    {
                        
                        int task=r.nextInt(5)+1;
                        int f1=r.nextInt(5)+1;
                        int f2=r.nextInt(5)+1;
                        int p=r.nextInt(100)+1;
                        /*
                        int prob=r.nextInt(100)+1;
                        
                        if(prob<=15)
                            task=5;
                        else
                            task=r.nextInt(4)+1;
                        
                        */
                        if(task==1)
                        {
                          
                            d.reserve(f1, p);
                            
                        }
                        else if(task==2)
                        {                           
                            d.cancel(f1, p);
                        }
                        else if(task==3)              
                        {
                            d.my_flights(p);
                        }
                        else if(task==4)
                        {
                            d.total_reservations();
                           
                        }
                        else if(task==5)
                        {
                            d.transfer(f1, f2, p);
                                                       
                        }
                    }
                    catch(Exception e)
                    {
                        
                    }
                    finally
                    {
                        System.out.println(Thread.currentThread().getName() + ": lock released" );
                        lock.unlock();
                    }
                
                temp--;
            //}
        }
        else if(flag==2)
        {
            int task=r.nextInt(5)+1;
            int f1=r.nextInt(5)+1;
            int f2=r.nextInt(5)+1;
            int p=r.nextInt(100)+1;
            /*
                        int prob=r.nextInt(100)+1;
                        
                        if(prob<=15)
                            task=5;
                        else
                            task=r.nextInt(4)+1;
                        
            */
            

            if(task==1)
            {
                /*
                while(!d.flist.get(f1).l.tryLock())
                {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(transaction.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                while(!d.plist.get(p).l.tryLock())
                {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(transaction.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }*/
                d.flist.get(f1).l.writeLock().lock();
                d.plist.get(p).l.writeLock().lock();
              
                try 
                {
                   
                   d.reserve(f1,p);
                   System.out.println(Thread.currentThread().getName() + ": lock" );
                }
                catch (InterruptedException ex) {
                   
                }
                finally
                {
                    System.out.println(Thread.currentThread().getName() + ": lock released" );
                    d.flist.get(f1).l.writeLock().unlock();
                    d.plist.get(p).l.writeLock().unlock();
                  
                }   
                
            }
            else if(task==2)
            {
                /*
                while(!d.flist.get(f1).l.tryLock())
                {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(transaction.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                while(!d.plist.get(p).l.tryLock())
                {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(transaction.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }*/
                d.flist.get(f1).l.writeLock().lock();
                d.plist.get(p).l.writeLock().lock();
                try 
                {
                      
                    d.cancel(f1,p);
                    System.out.println(Thread.currentThread().getName() + ": lock" );
                }
                catch (InterruptedException ex) {
                  
                }
                finally
                {
                    System.out.println(Thread.currentThread().getName() + ": lock released" );
                    d.flist.get(f1).l.writeLock().unlock();
                    d.plist.get(p).l.writeLock().unlock();
                }   
            }
            else if(task==3)
            {
                /*
                while(!d.plist.get(p).l.tryLock())
                {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(transaction.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }*/
                //d.flist.get(f1).l.lock();
                d.plist.get(p).l.readLock().lock();
                try 
                {
                     
                    d.my_flights(p);
                    System.out.println(Thread.currentThread().getName() + ": lock" );
                }
                catch (InterruptedException ex) {
                 
                }
                finally
                {
                    System.out.println(Thread.currentThread().getName() + ": lock released" );
                    //d.flist.get(f1).l.unlock();
                    d.plist.get(p).l.readLock().unlock();
                }   
            }
            else if(task==4)
            {
                //lc.readLock().lock();
                try
                {
                    d.total_reservations();
                    System.out.println(Thread.currentThread().getName() + ": lock" );
                }
                catch(InterruptedException ex) {
                    
                }
                finally{
                    
                    System.out.println(Thread.currentThread().getName() + ": lock released" );
                   // lc.readLock().unlock();
                }
                    
               
            }
            else if(task==5)
            {
                if(f1<f2)
                {   
                    
                    d.flist.get(f1).l.writeLock().lock();
                    d.flist.get(f2).l.writeLock().lock();
                }
                else if(f2<f1)
                {
                    d.flist.get(f2).l.writeLock().lock();
                    d.flist.get(f1).l.writeLock().lock();
                }
                //System.out.println(f1 +" " + f2+ " " + p+ d.flist.get(first).l.tryLock() );
                                
                
                d.plist.get(p).l.writeLock().lock();
                
                try 
                {
                    
                    d.transfer(f1,f2,p);
                      System.out.println(Thread.currentThread().getName() + ": lock" );
                }
                catch (InterruptedException ex) {
                    
                }
                finally
                {
                    System.out.println(Thread.currentThread().getName() + ": lock released" );
                    //d.flist.get(first).l.unlock();
                    //d.flist.get(second).l.unlock();
                    if(f1<f2)
                    {     
                        d.flist.get(f1).l.writeLock().unlock();
                        d.flist.get(f2).l.writeLock().unlock();
                    }
                    else if(f2<f1)
                    {
                        d.flist.get(f2).l.writeLock().unlock();
                        d.flist.get(f1).l.writeLock().unlock();
                    }
                    d.plist.get(p).l.writeLock().unlock();                    
                }   
                
            }
        }
        
        
        
    }
}

public class DBMS_Assignment2 {
    
    public static void main(String[] args) throws Exception
    {
        database db = new database();
        flight f[]=new flight[7];
        Random r=new Random();
        for(int i=1;i<=5;i++)
        {
           int cap=r.nextInt(100)+1;
           f[i]=new flight(cap);
           db.flist.put(i,f[i]);
           
        }
        for(int i=1;i<=100;i++)
        {
            passenger p=new passenger();
            db.plist.put(i,p);
            
        }       
        
       
        int n=60;
        int mode=1;
        
        Thread th[]=new Thread[n+1];
        transaction tr[]= new transaction[n+1];
        
        for(int i=1;i<=n;i++)
        {
            tr[i]=new transaction(db,mode);
            th[i]=new Thread(tr[i]);
        }
        
        System.out.println("Start");
        long st=System.nanoTime();
        for(int i=1;i<=n;i++)
        {
            th[i].start();
            //Thread.sleep(10);
        }
        for(int i=1;i<=n;i++)
        {
            th[i].join();
        }
        long et=System.nanoTime();
        long tt=et-st;
        
        System.out.println("EnD: "+ (double)tt/1000000000);
    }
    
}
