import java.util.List;

import com.exam.dao.MemberDao;
import com.exam.vo.Member;

public class memberdaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MemberDao m=new MemberDao();
		
		int e=m.deleteAll();
		System.out.println(e);
		
		Member a1=new Member(1,"È«±æµ¿");
		Member a2=new Member(2,"¹Úº¸°Ë");
		Member a3=new Member(3,"¼ÛÇý±³");
		int c=m.insert(a1);
		int d=m.insert(a2);
		int d2=m.insert(a3);
		List<Member>list=m.getMembers();
		for(Member m1:list)
		{
			System.out.println(m1);
		}
		
		System.out.println(c+" "+d+" "+d2);
		
		Member u1=new Member(1,"¿øºó");
		int u=m.updateByid(u1);
		
		System.out.println(u);
		
		Member mem=m.getMemberById(u1.getId());
		System.out.println(mem);
	}//main

}
