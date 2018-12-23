
import	java.util.concurrent.TimeUnit;	
import	java.util.concurrent.locks.Lock;	
import	java.util.concurrent.locks.ReentrantLock;	
public	class	Example	implements	Runnable	{	
				static	ReentrantLock	lock	=	new	ReentrantLock();	
				int	id;	
				public	Example(int i)	{	id	=	i;	}	
				public	static	void	main(final	String[]	args)		
																								throws	InterruptedException	{	
								Thread	t1	=	new	Thread(new	Example(1));	
								t1.start();	
								Thread	t2	=	new	Thread(new	Example(2));	
								t2.start();
								t1.join();	
								t2.join();	
}
				public	void	run()	{	
					do	{	
								try	{	
											if	(lock.tryLock(500,		
																							TimeUnit.MILLISECONDS))	{	
															try	{	
																		System.out.println("T-"+id+":	Lock");	
																		Thread.sleep(3);	
															}	finally	{	
																		/*	sleep	throws	InterruptedException	*/	
																		lock.unlock();	
																		System.out.println("T-"+id+":	Unlock");	
															}	
															break;	
											}	else	{	
													System.out.println("T-"+id+":	Lock	failed");	
											}	
								}	catch	(InterruptedException	e)	{			}	
					}	while	(true);	
		}	
}	/*	end	of	class	TryLock	*/	