package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 
For this assignment, students’ information is not read from an input file. Instead, it will be entered by the user. 
As mentioned earlier, you must store students’ information in Java’s ArrayList. 
The reference to a Student object should be an element of an ArrayList.
 * @author emmettgreenberg
 *
 */
public class StudentManagement {

	public static void main(String[] args) throws InterruptedException {
		
		// Store students’ information in Java’s ArrayList
		ArrayList<Student> students = new ArrayList<Student>();
		
		Scanner input = new Scanner(System.in);
		boolean done = false;
		
		while (!done) {
			displayMenu();
		
			// get users option
			int option;
			if (input.hasNextInt()) {
				option = input.nextInt(); 
			}
			else { 
				System.out.println("Invalid option. Please try again");
				input.next(); // clears the bad input
				continue;
			}
			
			if (!(option >= 1 && option <= 5)) {
				System.out.println("Did not recognize that option. Please try again"); // invalid input
				continue;
			}
			
			
			switch (option) {
			case 1:
				System.out.println("* Add Student *");
				String id, ssn, name, address, email, major;
				double gpa = 0.00;
				
				 // prompt user to enter student ID
				System.out.println("Please enter the student's ID:");
				id = input.next();
				
				Student st = findStudentWithID(id, students);
				if (st != null) {
					System.out.println("That student ID already exists.");
					Thread.sleep(1000);
					continue;
				}
				
//				// check if the given student ID is already in the list
//				boolean found = false;
//				for (Student s: students) {
//					if (s.getStudentID().equals(id)) {
//						found = true;
//						break;
//					}
//				}
//				// if it exists, display error message and return to main menu
//				if (found) {
//					System.out.println("That student ID already exists.");
//					continue;
//				}
				
				// prompt user to enter SSN
				input.nextLine(); // clears the input
				System.out.println("Please enter the student's SSN:");
				ssn = input.next();
				
				// prompt user to enter name
				input.nextLine();
				System.out.println("Please enter the student's name:");
				name = input.nextLine();
				
				// prompt user for address
				//input.next();
				System.out.println("Please enter the student's address:");
				address = input.nextLine();
				
				//  prompt user for email
				//input.nextLine();
				System.out.println("Please enter the student's email:");
				email = input.next();
				
				// major
				input.nextLine();
				System.out.println("Please enter the student's major:");
				major = input.nextLine();
				
				// prompt user for GPA (must be a double)..
				gpa = getGPA(input); // gets the GPA from user input
				
//				System.out.println("Please enter the student's gpa (two decimals):");
//				boolean isDouble = false;
//				while (!isDouble) {
//					if (input.hasNextDouble()) {
//						gpa = input.nextDouble();
//						isDouble = true;
//					}
//					else {
//						System.out.println("Invalid input. Please try again:");
//						input.nextLine();
//					}
//				}
				
				// create student object and store in array
				Student stud = new Student(ssn, name, address, email, id,  major, gpa);
				students.add(stud);
				
				stud.printStudent();
				
				break; // exit the case
			
			case 2:
				System.out.println("* Remove Student *");
				/*
				 *  Prompts the user to enter a studentID, and reads it.
				 *  If a student with the given studentID does not exist in the list, displays an appropriate
				 *  error message, and displays the main menu.
				 *  Otherwise, removes the student with the given studentID from the list, displays
				 *  appropriate message indicating a successful operation, and displays the main menu.
				 */
				
				System.out.println("Please enter the student's ID:");
//				if (!input.hasNext()) {
//					input.next();
//				}
				String id2  = input.next();
				
				Student st2 = findStudentWithID(id2, students); // student to be removed
				
				if (st2 == null) {
					System.out.println("Operation failed: There is  no student with that ID.");
					Thread.sleep(1000); // pause for one second
					continue; // return to main menu
				}
				
				// remove student
				students.remove(st2);
				System.out.println("Successfully removed student " + st2.getStudentID());
				
//				boolean removed = false;
//				
//				// find the index of the student whose ID matches the input ID
//				
//				// use an iterator to search list and remove student with the given id
//				Iterator<Student> itr = students.iterator();
//				while (itr.hasNext()){
//					if (itr.next().getStudentID().equals(id2)) {
//						System.out.println("ID matches");
//						itr.remove(); // removes the current element
//						removed = true;
//					}
//				}
//				if (!removed) {
//					System.out.println("That student ID " + id2 + "is not in our records.");
//					continue; // return to main menu
//				}
//				else {
//					System.out.println("Successfully removed student.");
//				}
				
				// check that student was removed
				for (Student s: students) {
					s.printStudent();
				}
				System.out.println("list size " + students.size());
				
				break;
				
				
			case 3:
				System.out.println("* Update Student GPA *");
				/*
				 * Prompts the user to enter a studentID, and reads it.
				 * If a student with the given studentID does not exist in the list, displays an appropriate
				 * error message, and displays the main menu.
				 * Otherwise:
				 * Prompts the user to enter a GPA, and reads it
				 * Updates the GPA of the student with the new GPA, displays an appropriate message
				 * indicating a successful operation, and displays the main menu.
				 */
				
				System.out.println("Please enter the student's ID:");
				 // prompt user to enter student ID
				String id3 = input.next();
				
				// check if the given student ID exsists
				Student st3 = findStudentWithID(id3, students);
		
				// if it does not exist, display error message and return to main menu
				if (st3 == null) { // if student not null
					System.out.println("A student with that ID does not exist.");
					Thread.sleep(1000);
					continue;
				}
				
				// otherwise, prompt user to enter GPA
				double newGPA = getGPA(input);
				// update GPA
				st3.setGPA(newGPA);
				System.out.println("Successfully updated the GPA of student " + st3.getName());
				 break;
				
			case 4:
				/*
				 * Prompts the user to enter a studentID, and reads it.
				 * If a student with the given studentID does not exist in the list, displays an appropriate
				 * error message, and displays the main menu.
				 * Otherwise, displays the student information (s.printStudent())
				 */
				System.out.println("* Display Student *");
				String id4 = getStudentIDFromUser(input);
				// find student with given id
				Student st4 = findStudentWithID(id4, students);
				if (st4 == null) {
					System.out.println("There is no student with that ID.");
					Thread.sleep(1000);
					continue;
				}
				
				// print student
				st4.printStudent();
				Thread.sleep(1000);
				break;
			case 5:
				System.out.println("Goodbye.");
				done = true;
				
			}
		}
	}

	public static String getStudentIDFromUser(Scanner input) {
		System.out.println("Please enter the student's ID:");
		if (!input.hasNext()) {
			input.next();
		}
		String id  = input.next();
		return id;
	}
	
	public static Student findStudentWithID (String id, ArrayList<Student> students) {
		for (Student s: students) {
			if (s.getStudentID().equals(id)) {
				return s;
			}
		}
		return null;
	}
	
	@SuppressWarnings("resource")
	public static double getGPA(Scanner input) {
		input = new Scanner (System.in);
		System.out.println("Please enter the student's gpa (two decimals):");
		double gpa;
		while (true) {
			if (input.hasNextDouble()) {
				gpa = input.nextDouble();
				break;
			}
			else {
				System.out.println("Invalid input. Please try again:");
				input.nextLine();
			}
		}
		return gpa;
	}
	
	public static void displayMenu() throws InterruptedException {
	
//		Thread.sleep(1000);	// pause for a second
		System.out.println("*** Menu ***\n" + 
				"Please choose an option:\n" +
				"1. Add a student\n" + 
				"2. Remove a student\n" + 
				"3. Update student GPA\n" +
				"4. Display student information\n" +
				"5. Exit"
				);
	}
	

}
