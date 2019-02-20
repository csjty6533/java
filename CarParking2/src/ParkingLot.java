class ParkingLot
{
	private boolean parking[][][];
	private Customer customer[][][];
	private int date,slot,startT,endT;
	private boolean key;
	private int getslot;
	ParkingLot()
	{
		customer=new Customer[31][15][12];
		parking=new boolean[31][15][12];
		
		for(int i=0;i<parking.length;i++)
		{
			for(int j=0;j<parking[i].length;j++)
			{
				for(int k=0;k<parking[i][j].length;k++)parking[i][j][k]=true;
			}
		}
	}
	boolean[][][] getSlot()
	{
		return parking;
	}
	void setSlot(int a1,int a2,int a3,int a4,String a5[])
	{
		date=a1-1;
		startT=a2;
		endT=a3;
		slot=a4;
		for(int i=startT;i<startT+endT+1;i++)parking[date][slot][i]=false;
		for(int i=startT;i<startT+endT+1;i++)customer[date][slot][i]=new Customer(a5);
	}
	void setCancelSlot(int a1,int a2,int a3,int a4,String a5[])
	{
		date=a1-1;
		startT=a2;
		endT=a3;
		slot=a4;
		for(int i=startT;i<startT+endT+1;i++)
			{
			if(parking[date][slot][i]);
			else{
					parking[date][slot][i]=true;
					customer[date][slot][i].setCancelId();
				}
			}
	}
	
	int getCancel(int a1,int a2,int a3,String a4[])
	{
		date=a1-1;
		startT=a2;
		endT=a3;
	
		for(int i=0;i<parking[0].length;i++)
		{	
			for(int j=startT;j<startT+endT+1;j++)
			{
				if(parking[date][i][j]);
				else 
				{
					if(customer[date][i][j].getId(a4))getslot=i;
				}
			}
		}
		return getslot;
	}
	boolean getCancelSlot(int a1,int a2,int a3,String a4[],int a5)
	{
		date=a1-1;
		startT=a2;
		endT=a3;
		slot=a5;
		
		for(int j=startT;j<startT+endT+1;j++)
		{
			if(parking[date][slot][j]);
			else 
			{
				if(customer[date][slot][j].getId(a4))key=true;
				else key=false;
			}
		}
		return key;
	}
}