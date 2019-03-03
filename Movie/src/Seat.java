import java.util.HashMap;
import java.util.Vector;

public class Seat {
	private boolean seat[][][];
	HashMap<String, Customer>id;
	HashMap<String, Ticket>tk;
	Seat()
	{
		id=new HashMap<String, Customer>();
		tk=new HashMap<String, Ticket>();
		seat=new boolean[6][6][50];
		
		for(int j=0;j<6;j++)
		{	
			for(int k=0;k<6;k++)
			{
				for(int i=0;i<50;i++)
				{
					seat[j][k][i]=true;
				}
			}
			
		}
	}
	void Add(int a1,int a2,int a3,Vector<Integer>a4,String a5,int a6)//a4=id a5=movie
	{
		seat[a1][a2][a3]=false;
		tk.remove(a5);
		tk.put(a5,new Ticket(a4,a6));
	}
	void Remove(int a1,int a2,int a3)
	{
		seat[a1][a2][a3]=true;
	}
	void addC(Customer a1)
	{
		id.put(a1.getId(), a1);
	}
	boolean []getSeat(int a1,int a2)
	{
		return seat[a1][a2];
	}
}
