package main;

public class Student extends Person {
	String studentID;
	String major;
	double gpa;

	public Student(String ssn, String name, String address, String email, String studentID, String major, double gpa) {
		super(ssn, name, address, email);
		this.studentID = studentID;
		System.out.println("Student ID: " + this.studentID);
		this.major = major;
		this.gpa = gpa;
	}
	
	public String getStudentID() {
		return this.studentID;
	}
	
	public String getMajor() {
		return this.major;
	}
	
	public double getGPA() {
		return this.gpa;
	}
	
	public void setStudentID(String id) {
		this.studentID = id;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public void setGPA(double gpa) {
		this.gpa = gpa;
	}
	
	public void printStudent() {
		System.out.println( "** Student Info **" 
				+ "\nName: " + this.name
				+ "\nStudent ID: " + this.studentID
				+ "\nEmail: " + this.email
				+ "\nAddress: " + this.address
				+ "\nMajor: " + this.major
				+ "\nGPA: " + this.gpa
				);
	}
	
	public String toString() {
		return  "Name: " + this.name
				+ ", Student ID: " + this.studentID
				+ ", Email: " + this.email
				+ ", Address: " + this.address
				+ ", Major: " + this.major
				+ ", GPA: " + this.gpa
				;
	}

}
