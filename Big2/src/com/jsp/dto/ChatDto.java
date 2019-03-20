package com.jsp.dto;

public class ChatDto {
	private String Id;
	private String chatId;
	private String content;
	private String date;
	private String bbsid;
	public String getBbsid() {
		return bbsid;
	}
	public void setBbsid(String bbsid) {
		this.bbsid = bbsid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getChatId() {
		return chatId;
	}
	public void setChatId(String chatId) {
		this.chatId = chatId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
