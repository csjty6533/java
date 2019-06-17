package Chapter8;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fin=null;
		try {
			fin=new FileReader("c:\\windows\\system.ini");
			int c;
			while((c=fin.read())!=-1)System.out.println((char)c);
			fin.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
