package com.jsp.dto;

public class MemberDto {
	private String Id;
	private String Pw;
	private String Name;
	private String Email;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPw() {
		return Pw;
	}
	public void setPw(String pw) {
		Pw = pw;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	@Override
	public String toString() {
		return "MemberDto [Id=" + Id + ", Pw=" + Pw + ", Name=" + Name + ", Email=" + Email + "]";
	}
	
}
