
class ParkingLot
{
	private boolean parking[][][];
	private int date,slot,startT,endT;
	private String id[][][][];
	private int cancel[]=new int[3];
	private int hour[]= {0,0,0,0,0,0};
	ParkingLot()
	{
		parking=new boolean[31][15][12];
		id=new String[31][15][12][6];
		for(int i=0;i<parking.length;i++)
		{
			for(int j=0;j<parking[i].length;j++)
			{
				for(int k=0;k<parking[i][j].length;k++)parking[i][j][k]=true;
			}
		}
	}
	void setSlot(int a1,int a2,int a3,int a4,String a5[])
	{
		date=a1-1;
		startT=a2;
		endT=a3;
		slot=a4;
		for(int i=startT;i<startT+endT+1;i++)parking[date][slot][i]=false;
		setId(date,startT,endT,slot,a5);
	}
	boolean[][][] getSlot()
	{
		return parking;
	}
	void setId(int a1,int a2,int a3,int a4,String a5[])
	{
		for(int i=a2;i<a3+1;i++)
		{
			for(int j=0;j<6;j++)id[date][slot][i][j]=(a5[j]);
		}
	}
	String[] getId(int a1,int a2,int a3,int a4,String a5[])
	{
		date=a1-1;
		startT=a2;
		endT=a3;
		slot=a4;
		return id[date][slot][startT];
	}
	int[] getCancel(String a1[])
	{
		int a=0;
		for(int i=0;i<id.length;i++)
		{
		for(int j=0;j<id[i].length;j++)
		{
		for(int k=0;k<id[i][j].length;k++)
		{	
		for(int l=0;l<id[i][j][k].length;l++)
		{
			if(id[i][j][k][0].equals(a1[0]))
			{
				for(int m=0;m<a1.length;m++)
				{
					if(id[i][j][k][m].equals(a1[m]))a=0;
					else a=1;
				}
			}
		}
		}
		}
		}
		return cancel;
	}
	void setCancel(String a1[])
	{
		
	}
}

