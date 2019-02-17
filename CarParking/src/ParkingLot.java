
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
	ParkingLot(int a1,int a2,int a3,int a4)
	{
		for(int i=0;i<a3+1;i++)parking[a1][a2][a4]=false;
	}

}
