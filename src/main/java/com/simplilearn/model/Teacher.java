package com.simplilearn.model;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tec_data")
public class Teacher {

	// properties
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;

	@Column(name="email")
	private String email;

	@Column(name="address")
	private String address;

	@Column(name="subject")
	private String subject;

	@Column(name="created_at")
	private Date createdAt;

	@Column(name="modified_at")
	private Date modifiedAt;

	// constructor
	public Teacher() {}

	public Teacher(int id) {
		this.id = id;
	}

	public Teacher(String name,String email, String address,String subject) {
		super();
		this.name = name;
		this.email = email;
		this.address= address;
		this.subject=subject;
		this.createdAt =  new Date();
		this.modifiedAt = new Date();
	}

	public Teacher(int id, String name,String email, String address,String subject) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.subject=subject;
		this.createdAt =  new Date();
		this.modifiedAt = new Date();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setDesc(String address) {
		this.address = address;
	}
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ",Email=" + email + ", Address=" + address + ", createdAt="
				+ createdAt + ", modifiedAt=" + modifiedAt + "]";
	}

} 
