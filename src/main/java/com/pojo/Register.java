package com.pojo;

public class Register {

	private String email;
	private String password;
	private String Firstname;
	private String Lastname;
	private String Age;

	public Register(String email, String password, String firstname, String lastname, String age) {
		super();
		this.email = email;
		this.password = password;
		this.Firstname = firstname;
		this.Lastname = lastname;
		this.Age = age;
	}

	public Register() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		this.Firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		this.Lastname = lastname;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		this.Age = age;
	}

}
