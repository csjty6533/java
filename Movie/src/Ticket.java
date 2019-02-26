
public class Ticket {
	private boolean slot[][];
	private Customer c[][];
	private int key[];
	Ticket()
	{
		slot=new boolean[2][50];
		c=new Customer[2][50];
		for(int j=0;j<2;j++)
		{	for(int i=0;i<50;i++)
			{
				slot[j][i]=true;
			}
		}
	}
	void setSlotAdd(int a1,int a2,String a3[])
	{
		slot[a1][a2]=false;
		c[a1][a2]=new Customer(a3);
	}
	void setSlotCancel(int a1,int a2)
	{
		slot[a1][a2]=true;
	}
	boolean []getSlot(int a1)
	{
		return slot[a1];
	}
	int[] getSlotCancel(String a1[])
	{
		key=new int[2];
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<50;j++)
			{
				if(slot[i][j]);
				else if(c[i][j].getCutomer(a1))
				{
					key[0]=i;
					key[1]=j;
				}
			}
		}
		return key;
	}
}
