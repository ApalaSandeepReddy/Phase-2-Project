package com.simplilearn.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subjects_data")
public class Subjects {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(name="subname")
	private String subname;

	@Column(name="subcode")
	private String subcode;

	public Subjects() {
		super();
	}

	public Subjects(int id) {
		super();
		this.id = id;
	}

	public Subjects(String subname, String subcode) {
		super();
		this.subname = subname;
		this.subcode = subcode;
	}

	public Subjects(int id, String subname, String subcode) {
		super();
		this.id = id;
		this.subname = subname;
		this.subcode = subcode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public String getSubcode() {
		return subcode;
	}

	public void setSubcode(String subcode) {
		this.subcode = subcode;
	}

	@Override
	public String toString() {
		return "Subjects [id=" + id + ", subname=" + subname + ", subcode=" + subcode + "]";
	}



}
