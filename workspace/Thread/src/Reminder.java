import	java.util.*;	
public	class	Reminder	{	
				Timer	timer;	
				private int a=2;
				public	Reminder(int millisecs)	{	
								timer	=	new	Timer();	
								timer.schedule(new	RemindTask(),	millisecs*1000);	
				}	
				class	RemindTask extends	TimerTask	{	
								public	void	run()	{	
												System.out.println("Time's	up!");	
												//	Terminate	the	timer	thread	
												//	or	set	the	timer	as	daemon	
												timer.cancel();	
												System.out.println("Time's	up! now");
								}	
				}	
				public	static	void	main(String	args[])	{	
								Reminder r=new	Reminder(5);
								int val=r.a;
								System.out.println("Task	scheduled.");	
								String n="jh";
								String m=new String("jh");
								System.out.println(n==m);	

								
				}	
}