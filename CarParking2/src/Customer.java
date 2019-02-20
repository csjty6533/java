public class Customer 
{
	private String id[];
	private boolean key;
	Customer(String a1[])
	{
		id=new String[6];
		for(int i=0;i<id.length;i++)
		{
			id[i]=a1[i];
		}
	}
	boolean getId(String a1[])
	{
		for(int i=0;i<id.length;i++)
		{
			if(id[i].equals(a1[i]))
			{
				if(i==id.length-1)key=true;
			}
			else
			{
				key=false;
				break;
			}
		}
		return key;
	}
	void setCancelId()
	{
		for(int i=0;i<id.length;i++)
		{
			id[i]="";
		}
	}
}
