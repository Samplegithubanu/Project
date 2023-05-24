package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customeException.InvalidChoiceException;
import customeException.studentNotFoundException;
import customsorting.sortStudentByAge;
import customsorting.sortStudentById;
import customsorting.sortStudentByMarks;
import customsorting.sortStudentByName;

//implementation class

public class StudentManagementSystemImpl implements StudentManagementSystem {

	Scanner scan= new Scanner(System.in);
	//key-> student id & value-> student object

	Map<String, Student> db= new LinkedHashMap<String, Student>();

	@Override
	public void addStudent() {

		//Accepting age
		System.out.println("Enter age");
		int age=scan.nextInt();

		//accepting name
		System.out.println("Enter Name");
		String name= scan.next();

		//Accepting marks

		System.out.println("Enter Marks");
		int marks= scan.nextInt();

		Student s= new Student(age,name,marks);

		db.put(s.getId(), s);

		System.out.println("Student record inserted successfully");

		System.out.println("your student id is:" +s.getId());




	}
	@Override
	public void displayStudent() {

		//accepting student id
		System.out.println("enter student id:");
		String id=scan.next();// String id=scan.next().toUppercase();


		// touppercase()

		id=id.toUpperCase();

		//checking if the id is present or not(id==key)
		if(db.containsKey(id)) 
		{
			Student std= db.get(id);


			System.out.println("Student record found!");
			System.out.println("Student record are as follows");





			System.out.println("id:"+std.getId());
			System.out.println("age:"+std.getAge());
			System.out.println("name:"+std.getName());
			System.out.println("marks:"+std.getMarks());

			//printing reference variable as toString() is overriden
		}
		else 
		{
			try {
				String message="student with Id" +id+ "is not found!";
				throw new studentNotFoundException(message);

			}
			catch(studentNotFoundException e){

				System.out.println(e.getMessage());

			}

		}

	}
	@Override
	public void displayAllStudents() {

		if(!db.isEmpty()) 
		{
			System.out.println("Student record are as follows");
			System.out.println("..............................");

			Set<String> keys=db.keySet();

			for(String key:keys) {
				Student std=db.get(key);
				System.out.println(std);
			}
		}

		else {

			try {
				throw new studentNotFoundException("Student not found Exception");
			}
			catch(Exception e) {

				System.out.println("db is empty");
			}


		}
	}

	@Override
	public void removeStudent() {

		System.out.println("Enter student Id:");
		String id=scan.next().toUpperCase();

		if(db.containsKey(id)) {
			System.out.println("Student record found");
			System.out.println(db.get(id));
			db.remove(id);

			System.out.println("student record deleted successfully");


		}
		else {

			try 
			{
				String message="Student id" +id+ "is removed";

				throw new studentNotFoundException(message);
			}
			catch(Exception e) {

				System.out.println(e.getMessage());
			}
		}



	}
	@Override
	public void removeAllStudents() {

		if(!db.isEmpty()) {
			System.out.println("No of Student record"+db.size());
			db.clear();
			System.out.println("All student records deleted");

		}
		else 
		{
			try 
			{
				String message="No of records to delete";

				throw new studentNotFoundException(message);
			}
			catch(Exception e) {

				System.out.println(e.getMessage());
			}
		}

	}



	@Override
	public void updateStudent() {
		System.out.println("Enter Student Id:");
		String id= scan.next().toUpperCase();

		if(db.containsKey(id)) {
			System.out.println("Student record found");
			Student std=db.get(id);


			System.out.println("1:Update age\n2:Update Name");
			System.out.println("3:Update Marks\nEnter Choice:");
			int choice= scan.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Age:");
				int age= scan.nextInt();
				std.setAge(age);
				System.out.println("Age Updated Successfully");
				break;
			case 2:
				System.out.println("Enter Name:");
				String name= scan.next();
				std.setName(name);
				System.out.println("name Updated Successfully");
				break;
			case 3:
				System.out.println("Enter Marks:");
				int marks= scan.nextInt();
				std.setMarks(marks);
				System.out.println("marks Updated Successfully");
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");


			}


		}
		else {

			try {

				throw new studentNotFoundException("Id not found");
			}
			catch(Exception e) {

				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void countStudent() {
		System.out.println("No of Student Record:" + db.size());
	}
	@Override
	public void sortStudent() {

		/** 
		 * we cannot sort map based on values, therefore we are getting
		 * the values from map and storing it inside list so that we can sort
		 * list using -> collections.sort(list,sorting logic object);
		 */

		//Reference of list and object of arraylist storing student objects

		List<Student> list= new ArrayList<Student>();

		//converting map into set, which stores keys(id)
		Set<String> keys=db.keySet();

		//traversing keys(id)

		for(String key:keys) {

			//getting value (Student object) and adding it into list

			list.add(db.get(key));

		}
		System.out.println("1:sort Student By Id\n2:Sort Student By Age");
		System.out.println("3:Sort Student By Name\n4:Sort Student By Marks");
		System.out.println("Enter choice");
		int choice= scan.nextInt();

		switch(choice) {

		case 1:
			Collections.sort(list, new sortStudentById());
			for(Student s: list) {
				System.out.println(s);
			}
			break;
		case 2:
			Collections.sort(list, new sortStudentByName());
			for(Student s: list) {
				System.out.println(s);
			}
			break;
		case 3:
			Collections.sort(list, new sortStudentByAge());
			for(Student s: list) {
				System.out.println(s);
			}
			break;
		case 4:
			Collections.sort(list, new sortStudentByMarks());
			for(Student s: list) {
				System.out.println(s);
			}
			break;
		case 5:
			System.exit(0);
		default:
			try{

				throw new InvalidChoiceException("Invalid choice");

			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}


	}
	@Override
	public void findStudentWithHighestMarks() {

		List<Student> list= new ArrayList<Student>();

		//converting map into set, which stores keys(id)
		Set<String> keys=db.keySet();

		//traversing keys(id)

		for(String key:keys) {

			//getting value (Student object) and adding it into list

			list.add(db.get(key));

		}
		Collections.sort(list, new sortStudentByMarks());
		System.out.println("Student with highest Marks:");
		System.out.println(list.get(list.size()-1)); 


	}
	@Override
	public void findStudentWithLowestMarks() {

		List<Student> list= new ArrayList<Student>();

		//converting map into set, which stores keys(id)
		Set<String> keys=db.keySet();

		//traversing keys(id)

		for(String key:keys) {

			//getting value (Student object) and adding it into list

			list.add(db.get(key));

		}
		Collections.sort(list, new sortStudentByMarks());
		System.out.println("Student with lowest Marks:");
		System.out.println(list.get(0)); 



	}



}
