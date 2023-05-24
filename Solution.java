package sdbms;

//main class
import java.util.Scanner;
import customeException.InvalidChoiceException;

public class Solution {
	public static void main(String[] args) {
		System.out.println("Welocome to the Student database Project");
		System.out.println("................");

		Scanner scan=new Scanner(System.in);

		//upcasting for achieving Abstraction
		StudentManagementSystem sms = new StudentManagementSystemImpl();

		//infinite loop
		while(true) {
			System.out.println("1:Add Student \n2:displayStudent\n3:displayAllStudents");
			System.out.println("4:removeStudent\n5:removeAllStudents\n6:updateStudent");
			System.out.println("7:countStudent\n8:sortStudent\n9:findStudentWithHighestMarks");
			System.out.println("10:findStudentWithLowestMarks");

			System.out.println("Enter your choice:");

			int choice= scan.nextInt();

			switch(choice) {


			case 1:
				sms.addStudent();

				break;

			case 2:
				sms.displayStudent();
				break;

			case 3:
				sms.displayAllStudents();
				break;

			case 4:
				sms.removeStudent();
				break;
			case 5:
				sms.removeAllStudents();

				break;
			case 6:
				sms.updateStudent();
				break;
			case 7:
				sms.countStudent();
				break;
			case 8:
				sms.sortStudent();
				break;
			case 9:
				sms.findStudentWithHighestMarks();
				break;
			case 10:
				sms.findStudentWithLowestMarks();
				break;
			case 11:
				System.out.println("Thank You");
				System.exit(0);
			default:
				try {

					String message="Invalid choice, Enter a valid choice";
					throw
					new InvalidChoiceException("Invalid choice");
				}
				catch(Exception e) {

					System.out.println(e.getMessage());
				}

			}
		}







































	}

}
