package com.jsp.dto;

public class BbsFileDto {
	private String Id;
	private String bbsId;
	private String orgn_file_nm;
	private String save_file_nm;
	private String key;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getBbsId() {
		return bbsId;
	}
	public void setBbsId(String bbsId) {
		this.bbsId = bbsId;
	}
	public String getOrgn_file_nm() {
		return orgn_file_nm;
	}
	public void setOrgn_file_nm(String orgn_file_nm) {
		this.orgn_file_nm = orgn_file_nm;
	}
	public String getSave_file_nm() {
		return save_file_nm;
	}
	public void setSave_file_nm(String save_file_nm) {
		this.save_file_nm = save_file_nm;
	}
	
}
