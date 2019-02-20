
class ParkingLot
{
	private boolean parking[][][];
	private int date,slot,startT,endT;
	private String id[][][][];
	private int cancel[]=new int[3];
	private int hour[]= {0,0,0,0,0,0};
	private int getslot;
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
		for(int i=0;i<id.length;i++)
		{
			for(int j=0;j<id[i].length;j++)
			{
				for(int k=0;k<id[i][j].length;k++)
				{
					for(int l=0;l<id[i][j][k].length;l++)id[i][j][k][l]="";
				}
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
	void setCancelSlot(int a1,int a2,int a3,int a4)
	{
		date=a1-1;
		startT=a2;
		endT=a3;
		slot=a4;
		for(int i=startT;i<startT+endT+1;i++)parking[date][slot][i]=true;
		setCancelId(date,startT,endT,slot);
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
	void setCancelId(int a1,int a2,int a3,int a4)
	{
		for(int i=a2;i<a3+1;i++)
		{
			for(int j=0;j<6;j++)id[date][slot][i][j]="";
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
	int getCancel(int a1,int a2,int a3,String a4[])
	{
		date=a1-1;
		startT=a2;
		endT=a3;
		
		for(int i=0;i<parking[0].length;i++)
		{	if(id[date][i][startT][0].equals(a4[0]))
			{
				for(int m=0;m<a4.length;m++)
				{
					if(id[date][i][startT][m].equals(a4[m]))
						{
							getslot=i; break;
						}
					else getslot=200;
				}
			}
		}
		return getslot;
	}
	
}