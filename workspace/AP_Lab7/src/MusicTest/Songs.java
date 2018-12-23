package MusicTest;

import java.io.Serializable;

public class Songs implements Serializable
{
	private String name;
	String singer;
	double time;
	
	public Songs(String n,String s, double d)
	{
		setName(n);
		singer=s;
		time=d;
		
	}
	
	@Override
	public String toString(){
		return (getName()+" "+singer+" "+time);
		
	}
	@Override
	public	boolean	equals(Object	o)	{	
		if(o!=null	&&	getClass()==o.getClass())	{	
						Songs s	=(Songs) o;	
						return	((getName().equals(s.getName()))&&(singer.equals(s.singer))&&(time==s.time));	
		}	
		return	false;	
}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
}


