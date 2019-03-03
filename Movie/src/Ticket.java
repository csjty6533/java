import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class Ticket 
{
	Vector<Integer>seat[];
	Ticket(Vector<Integer>v,int a1)
	{
		seat=new Vector[6];
		Iterator<Integer>it=v.iterator();
		while(it.hasNext())seat[a1].add(it.next());
	}
	Vector<Integer> get(int a1)
	{
		return seat[a1];
	}
}