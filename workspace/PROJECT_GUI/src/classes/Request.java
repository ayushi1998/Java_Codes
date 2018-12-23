package classes;

import java.io.Serializable;

public class Request implements Serializable {
	
	private String room;
	String purpose;  // For the student to specify a purpose to RequestRoom.
	private int fh;
	private int fm;
	private int th;
	private int tm;
	private String date;
	int cap;
	int start;
	int end;
	private Student stu;
	
	public Request(String a,int b,int c,int d,int e,String f, String g, Student s)
	{
		setDate(a);
		setFh(b);
		setFm(c);
		setTh(d);
		setTm(e);
		purpose=f;
		setRoom(g);
		setStudent(s);
	}

	public Student getStudent() {
		return stu;
	}

	public void setStudent(Student stu) {
		this.stu = stu;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public int getFh() {
		return fh;
	}

	public void setFh(int fh) {
		this.fh = fh;
	}

	public int getFm() {
		return fm;
	}

	public void setFm(int fm) {
		this.fm = fm;
	}

	public int getTh() {
		return th;
	}

	public void setTh(int th) {
		this.th = th;
	}

	public int getTm() {
		return tm;
	}

	public void setTm(int tm) {
		this.tm = tm;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
