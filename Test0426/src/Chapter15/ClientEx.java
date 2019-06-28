package Chapter15;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader in=null;
		BufferedWriter out=null;
		Socket socket=null;
		Scanner scn=new  Scanner(System.in);
		try {
			socket=new Socket("localhost",9997);
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true)
			{
				System.out.print(">>");
				String outscan=scn.nextLine();
				if(outscan.equalsIgnoreCase("bye"))
				{
					out.write(outscan+"\n");
					out.flush();
					break;
				}
				out.write(outscan+"\n");
				out.flush();
				String inscan=in.readLine();
				System.out.println(inscan);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("exception!!!");
			System.out.println(e.getMessage());
		}finally
		{
			try {
				scn.close();
				if(socket!=null)socket.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("error");
			}
	}
	}

}
