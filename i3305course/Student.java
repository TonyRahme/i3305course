package i3305course;

public class Student implements Comparable<Student> 
{
	String fname, lname;
	int age;
	public Student(String fname, String lname,int age)
	{
		super();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
	}
	@Override
	public int compareTo(Student o)
	{
		if(this.fname.compareTo(o.fname)==0)
			return this.lname.compareTo(o.lname);
		return this.fname.compareTo(o.fname);
	}
	@Override
	public String toString()
	{
		return fname+" "+lname;
	}
}
