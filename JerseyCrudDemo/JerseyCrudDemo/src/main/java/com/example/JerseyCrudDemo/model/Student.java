package com.example.JerseyCrudDemo.model;

public class Student {

	private int sId;
	private String name;
	
	public Student() {
		super();
	}

	public Student(int sId, String name) {
		super();
		this.sId = sId;
		this.name = name;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
	
	
}
