package classes;

public class sem_course
{
    String sn, cours, credit, p;
	public sem_course(String sno,String course,String credits,String pc)
	{
		this.sn=sno;
		this.cours=course;
		this.credit=credits;
		this.p=pc;
		
	}
	
	public String getSn() {
        return sn;
    }

   /* void setSn(String fName) {
        sn.set(fName);
    }*/

    public String getCours() {
        return cours;
    }

    /*void setCours(String fName) {
        cours.set(fName);
    }*/

     public String getCredit() {
        return credit;
    }

   /* void setCredit(String fName) {
        credit.set(fName);
    }
    */
     
     public String getP() {
        return p;
    }

    /* void setP(String fName) {
        p.set(fName);
    }
	*/
	

}