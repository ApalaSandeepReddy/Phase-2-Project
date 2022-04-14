package com.simplilearn.model;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_data")
public class Student {

	// properties
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;

	@Column(name="rollno")
	private String rollno;

	@Column(name="ad")
	private String ad;

	@Column(name="cl")
	private  String cl;

	@Column(name="gender")
	private String gender;

	@Column(name="dob")
	private String dob;

	// constructor
	public Student() {}

	public Student(int id) {
		this.id = id;
	}

	public Student(String name, String rollno, String ad,String cl,String gender,String dob) {
		super();
		this.name = name;
		this.rollno = rollno;
		this.ad =ad;
		this.cl=cl;
		this.gender=gender;
		this.dob=dob;
	}

	public Student(int id, String name, String rollno, String ad,String cl) {
		super();
		this.id = id;
		this.name = name;
		this.rollno = rollno;
		this.ad = ad;
		this.cl=cl;
		this.gender=gender;
		this.dob=dob;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {

		this.ad = ad;
	}
	public String getCl() {
		return cl;
	}

	public void setCl(String cl) {
		this.cl =cl;
	}

	public String getGender() {
		return gender;
	}

	public void setCreatedAt(String gender) {
		this.gender=gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", rollno=" + rollno+ ", address="+ ad + ",class="+ cl + ", Gender="
				+ gender+ ", Date of Birth =" + dob + "]";
	}

} 
