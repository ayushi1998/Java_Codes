package classes;

public class request_table
{

	String sno;
	String date;
	String time;
	String purose;
	String room;
	String status;
	
	public request_table(String sno,String date, String time, String purpose, String room , String status)
	{
		this.sno=sno;
		this.date=date;
		this.time=time;
		this.purose=purpose;
		this.room=room;
		this.status=status;
		
	}
	
	 public String getSno() {
	        return sno;
	    }
	 public String getDate() {
	        return date;
	    }
	 public String getTime() {
	        return time;
	    }
	 public String getRoom() {
	        return room;
	    }
	 public String getStatus() {
	        return status;
	    }
	
	
	
	
	
}
