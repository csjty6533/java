import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.Map.Entry;

public class Seat {
	private boolean seat[]=new boolean[50];
	private HashMap<String, Customer> identity=new HashMap<String, Customer>();
	Seat()
	{
		seat=new boolean[50];
		
		for(int i=0;i<50;i++)seat[i]=true;
		
	}
	void add(Vector<Integer>a2)
	{
		Iterator<Integer>it=a2.iterator();
		for(int i=0;i<a2.size();i++)seat[it.next()]=false;
	}
	void remove(Vector<Integer>a2)
	{
		Iterator<Integer>it=a2.iterator();
		for(int i=0;i<a2.size();i++)seat[it.next()]=true;
	}
	boolean []getSeat()
	{
		return seat;
	}
	boolean getid(String a1[])
	{
		boolean id=true;
		Iterator<Entry<String, Customer>>it=identity.entrySet().iterator();
		Entry entry[]=new Entry[identity.size()]; 
		for(int i=0;i<identity.size();i++)
		{
			entry[i] = (Entry)it.next();
			System.out.println(entry[i].getKey()+" "+i);
			if(entry[i].getKey()==a1[0])
			{
				if(entry[i].getValue().toString()==a1[i])id=true;
				else id=false;
			}
			else 
			{
				
				id=true;
			}
		}
		return id;
	}
}
