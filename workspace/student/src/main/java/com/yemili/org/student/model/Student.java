package com.yemili.org.student.model;





import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "student_details")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;

	

	@Column(name = "mobilenumber")
	private String mobilenumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "age")
	private int age;

	/*
	 * @OneToMany(mappedBy = "student", cascade = CascadeType.ALL) private
	 * List<Studentaccedamicdetails> academicDetails;
	 */
	
	/*
	 * public Student(Integer id, String name, String email) { this.id = id;
	 * this.name = name; this.email = email; }
	 */

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	private String gender;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Student() {
	}

	public Student(Integer id, String name, String gender, String password, String mobilenumber, String email,Integer age) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.mobilenumber = mobilenumber;
		this.password = password;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", mobilenumber=" + mobilenumber + ", email=" + email + ", password="
				+ password + ", age=" + age + ", gender=" + gender + "]";
	}


	// public Integer getAge() { return age; }
	// public void setAge(Integer age) { this.age = age; }

}
