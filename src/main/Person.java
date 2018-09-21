package main;

/**
 * Person class contains
 * ssn: String type
 * name: String type
 * address: String type
 * email: String type
 * 
 * @author emmettgreenberg
 */

public class Person {
	protected String ssn;
	protected String name;
	protected String address;
	protected String email;

	public Person(String ssn, String name, String address, String email) {
		this.ssn = ssn;
		this.name = name;
		this.address = address;
		this.email = email;

	}

	public String getSsn() {
		return this.ssn;
	}

	public String getName() {
		return this.name;
	}

	public String getAddress() {
		return this.address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;

	}

	public void setName(String name) {
		this.name = name;

	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return this.ssn + ", " + this.name + ", " + this.address + ", " + this.email;
	}
}
