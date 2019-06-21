package chating3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	public void serverSetting()
	{
		try
		{
			serverSocket=new ServerSocket(9996);
			clientSocket=serverSocket.accept();
			System.out.println("connect");
			
			
		}
		catch(Exception e)
		{
			
		}
	}
	public void closeAll()
	{
		try
		{
			serverSocket.close();
			clientSocket.close();
			dataInputStream.close();
			dataOutputStream.close();
			
		}catch(Exception e) {}
	}
	public void streamSetting()
	{
		try {
			dataInputStream=new DataInputStream(clientSocket.getInputStream());
			dataOutputStream=new DataOutputStream(clientSocket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String dataRecv()
	{
		try {
			return dataInputStream.readUTF();
		}catch(Exception e)
		{
			
		}
		return null;
	}
	public void dataSend(String sendData)
	{
		try
		{
			dataOutputStream.writeUTF(sendData);
			
		}catch(Exception e)
		{
			
		}
	}
	public Server()
	{
		serverSetting();
		streamSetting();
		System.out.println(dataRecv());
		dataSend("close");
		closeAll();
	}
	public static void main(String[] args)
	{
		new Server();
	}
}
