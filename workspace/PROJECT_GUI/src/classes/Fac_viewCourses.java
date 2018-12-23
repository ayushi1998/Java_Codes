package classes;

public class Fac_viewCourses {
	 String man, course, code,credits;
		public Fac_viewCourses (String man,String course,String code,String credits)
		{
			this.man=man;
			this.course=course;
			this.code=code;
		
			this.credits=credits;
			
		}
		
		public String getMan() 
		{
	        return man;
	    }

	   /* void setSn(String fName) {
	        sn.set(fName);
	    }*/

	    public String getCourse()
	    {
	        return course;
	    }

	    /*void setCours(String fName) {
	        cours.set(fName);
	    }*/

	     public String getCode() 
	    {
	        return code;
	    }
	
	     public String getCredits() 
	     {
		        return credits;
		 }

}
