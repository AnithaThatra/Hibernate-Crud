package com.hibernate.model;

public class StudentResponse {private int id;
private String stdname;
private String stddept;
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
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
