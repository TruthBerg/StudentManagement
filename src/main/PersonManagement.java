package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This program reads Persons’ information from an input file, stores the
 * information in an array, and performs simple search and update operations.
 * Each element of the array is the reference to a Person object.
 * 
 * @author emmettgreenberg
 *
 */
public class PersonManagement {

	public static void main(String[] args) throws FileNotFoundException {

		Person[] pArray = readPersonData(); // reads data into an array

		Scanner input = new Scanner(System.in);
		boolean done = false;

		// Menu-driven program
		// loop until user chooses to quit
		while (!done) {
			displayMenu();

			int option;
			if (input.hasNextInt()) {
				option = input.nextInt();
			} else {
				System.out.println("Not an integer. Please try again"); // bad input (wrong type)
				input.next(); // clears the bad input
				continue;
			}

			if (!(option == 1 || option == 2 || option == 3)) {
				System.out.println("Invalid option. Please try again"); // invalid input
				continue;
			}

			switch (option) {
			case 1:
				// Prompts the user to enter the ssn of a person, and reads it.
				// If there is no person with the given ssn in your array, your program issues
				// an error message and displays the main menu.
				// If there is a person with the given ssn, your program displays the ssn, the
				// name, the
				// address, and the email of the person. Then, your program displays the main
				// menu.
				System.out.println("Enter an SSN: ");
				String ssn = input.next();
				boolean found = false;

				for (Person p : pArray) {
					if (p.getSsn().equals(ssn)) {
						System.out.println(p.toString());
						found = true;
						break;
					}
				}
				if (!found) {
					System.out.println("Sorry, that SSN is not in our records.");
				}
				break;

			case 2:
				// Prompts the user to enter the ssn of a person, and reads it.
				// If there is a person with the given ssn, then your program prompts the user
				// to enter a new address, and reads it.
				System.out.println("Enter an SSN: ");
				ssn = input.next();
				found = false;
				input.nextLine(); // clears input for user to enter new address

				for (Person p : pArray) {
					if (p.getSsn().equals(ssn)) {
						// prompt user to enter a new address
						System.out.println(p.toString());
						System.out.println("Enter the new address: ");
						p.setAddress(input.nextLine());

						// display updated person data
						System.out.println(p.toString());
						found = true;
						break;
					}
				}
				if (!found) {
					System.out.println("Sorry, that SSN is not in our records.");
				}
				break;

			case 3:
				// Program terminates
				System.out.println("Goodbye.");
				done = true;
				break;
			}
		}
		input.close();
	}

	/** Displays the set of options for the user */
	public static void displayMenu() {
		System.out.println("Choose an option:\n" + "1. Person information\n" + "2. Update address\n" + "3. Exit");
	}

	/** Reads person data from file and stores it in an array */
	public static Person[] readPersonData() throws FileNotFoundException {
		// Using Scanner to read the file
		Scanner scan = new Scanner(
				new File("/Users/emmettgreenberg/Emmett-eclipse-workspace/homework-1/person_info.txt"));
		// read in first line, save as array size
		int numPersons = scan.nextInt();
		// array of Persons to store data
		Person[] pArray = new Person[numPersons];
		// move to next line
		scan.nextLine();

		String[] pData; // this will store each person's data (SSN, name, address, email)
		int i = 0;

		// read data one line at a time
		while (scan.hasNextLine()) {
			// split each line into tokens and store them in the array
			// tokens in each line a separated by comma, followed by one or more spaces
			pData = scan.nextLine().split(",\\s+");

			// create a Person object
			Person p = new Person(pData[0], pData[1], pData[2], pData[3]);
			// store reference to person in pArray
			pArray[i] = p;
			i++;
		}
		scan.close();

		return pArray;
	}

}
