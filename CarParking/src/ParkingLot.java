
class ParkingLot
{
	private boolean parking[][][];
	private int date,slot,hour[];
	private String name,tel1,tel2,add,num,mail;
	private String id[];
	ParkingLot()
	{
		parking=new boolean[31][15][12];
		for(int i=0;i<parking.length;i++)
		{
			for(int j=0;j<parking[i].length;j++)
			{
				for(int k=0;k<parking[i][j].length;k++)parking[i][j][k]=true;
			}
		}
	}
	void setSlot(int a1,int a2,int a3,int a4)
	{
		date=a1;
		slot=a4;
		hour=new int[a3+1];
		for(int i=a2;i<a3+1;i++)parking[date][slot][i]=false;
	}
	boolean[][][] getSlot()
	{
		return parking;
	}
	void setName()
	{
		
	}
	String getName()
	{
		return;
	}
	void setId(int a1,int a2,int a3,int a4,String a5[])
	{
		
	}
	String[] getId(int a1,int a2,int a3,int a4,String a5[])
	{
		return;
	}
}

