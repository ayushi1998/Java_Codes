package classes;

public class schedule_table
{
	String course;
	String mon_slot;
	String tue_slot;
	String wed_slot;
	String thu_slot;
	String fri_slot;
	String tut_slot;
	String lab_slot;
	
	public  schedule_table(String course,
	String mon_slot,
	String tue_slot,
	String wed_slot,
	String thu_slot,
	String fri_slot,
	String tut_slot,
	String lab_slot)
	{
		this.course=course;
		this.mon_slot=mon_slot;
		this.tue_slot=tue_slot;
		this.wed_slot=wed_slot;
		this.thu_slot=thu_slot;
		this.fri_slot=fri_slot;
		this.tut_slot=tut_slot;
		this.lab_slot=lab_slot;
	}
	
	 public String getCorse() {
	        return course;
	    }
	 public String getMon_slot() {
	        return mon_slot;
	    }
	 public String getTue_slot() {
	        return tue_slot;
	    }
	 public String getWed_slot() {
	        return wed_slot;
	    }
	 public String getThu_slot() {
	        return thu_slot;
	    }
	 public String getFri_slot() {
	        return fri_slot;
	    }
	 public String getTut_slot() {
	        return tut_slot;
	    }
	 public String getLab_slot() {
	        return lab_slot;
	    }

}
