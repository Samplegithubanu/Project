package sdbms;

//bean class

public class Student {

	private String id;
	private int age; 
	private String name;
	private int marks;

	private static int count=101;

	public Student(int age, String name,int marks) {
		this.id="JSP"+count;
		count++;
		this.age=age;
		this.name=name;
		this.marks=marks;
	}

	public String getId() {

		return id;


	}
	public int getAge()
	{
		return age;
	}
	public String getName()
	{
		return name;
	}
	public int getMarks()
	{
		return marks;
	}
	public void setName(String name) {
		this.name=name;

	}
	public void setAge(int age) {
		this.age=age;

	}
	public void setMarks(int marks) {
		this.marks=marks;

	}
	@Override
	public String toString() {
		
		return " id: "+ id + name +" age:"+ age +" marks:" + marks;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	




}
