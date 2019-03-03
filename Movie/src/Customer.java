
public class Customer 
{
	private Ticket t;
	private String id;
	private String pw;
	private int tel;
	private String name;
	Customer(String a1[])
	{
		id=a1[0];
		pw=a1[1];
		name=a1[2];
		tel=Integer.parseInt(a1[3]);
	}
	boolean getCutomer(String a1[])
	{
		if(a1[0].equals(id)&&a1[1].equals(pw)&&a1[2].equals(name)&&a1[3].equals(tel)) return true;
		else return false;
	}
	String getId()
	{
		return id;
	}
}
