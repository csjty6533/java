
public class ParkingLot
{
	boolean parking[][][];
	ParkingLot()
	{
		parking=new boolean[31][12][15];
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
		for(int i=0;i<a3+1;i++)parking[a1][a2][a4]=false;
	}
	String[][][] getSlot(int a1,int a2,int a3,int a4)
	{
		return;
	}
}
class Customer extends ParkingLot
{
	private int a1,a2,a3,a4;
	public Customer(int a1,int a2,int a3,int a4,String a5[]) 
	{
		this.a1=a1;
		this.a2=a2;
		this.a3=a3;
		this.a4=a4;
	}
	void setParking()
	{
		ParkingLot instance=new ParkingLot();
		instance.setSlot(a1,a2,a3,a4);
	}
	String [] getId(int a1,int a2,int a3)
	{
		return;
	}
}
