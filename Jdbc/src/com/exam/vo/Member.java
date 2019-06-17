package com.exam.vo;//value object

import java.sql.Timestamp;

public class Member {
	private int id;
	private String name;
	private Timestamp reg_Date;
	public Member()
	{
		
	}
	
	public Member(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() //alt+S ->generate->getter,setter
	{
		return id;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", reg_Date=" + reg_Date + "]";
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
	public Timestamp getReg_Date() {
		return reg_Date;
	}
	public void setReg_Date(Timestamp timestamp) {
		this.reg_Date = timestamp;
	}
	
}
