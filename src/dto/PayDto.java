package dto;

public class PayDto {
	private int scode;
	private String pcode;
	private String starttime;
	private String endtime;
	public PayDto(int scode,String pcode,String starttime,String endtime)
	{
		this.scode = scode;
		this.pcode = pcode;
		this.starttime = starttime;
		this.endtime = endtime;
	}
	public int getScode() {
		return scode;
	}
	public void setScode(int scode) {
		this.scode = scode;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
}
