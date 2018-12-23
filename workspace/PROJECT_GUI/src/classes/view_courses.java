package classes;

public class view_courses {
	 String man, course, code,ins,credits;
		public view_courses(String man,String course,String code,String ins,String credits)
		{
			this.man=man;
			this.course=course;
			this.code=code;
			this.ins=ins;
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
	     public String getIns() 
	     {
		        return ins;
		 }
	     public String getCredits() 
	     {
		        return credits;
		 }

}
