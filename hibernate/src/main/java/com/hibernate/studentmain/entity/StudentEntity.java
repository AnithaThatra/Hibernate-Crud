package com.hibernate.studentmain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class StudentEntity {
	
	@Id
	@Column(name="id")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String stdname;
	@Column(name="dept")
	private String stddept;
	@Column(name="rollnumber")
	private String stdrollno;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStdname() {
		return stdname;
	}
	public void setStdname(String stdname) {
		this.stdname = stdname;
	}
	public String getStddept() {
		return stddept;
	}
	public void setStddept(String stddept) {
		this.stddept = stddept;
	}
	public String getStdrollno() {
		return stdrollno;
	}
	public void setStdrollno(String stdrollno) {
		this.stdrollno = stdrollno;
	}
	

}
