package classes;

import java.io.Serializable;

public class Course implements Serializable{
	
		String coption; // Mandatory / Elective
		String cname;
		String ccode;
		String instr;
		String credits;
		String acro;
		String mon_slot;
		String tue_slot;
		String wed_slot;
		String thu_slot;
		String fri_slot;
		String tut_slot;
		String lab_slot;
		String precond;
		String postcond;

		public Course(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j,
				String k, String l, String m, String n, String o) {
			coption = a;
			cname = b;
			ccode = c;
			instr = d;
			credits = e;
			acro = f;
			mon_slot = g;
			tue_slot = h;
			wed_slot = i;
			thu_slot = j;
			fri_slot = k;
			tut_slot = l;
			lab_slot = m;
			precond = n;
			postcond = o;
		}

	
}
