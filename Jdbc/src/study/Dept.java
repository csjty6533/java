package study;

public class Dept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeptDao deptDao=DeptDao.getInstance();
		int k=deptDao.Delete("hong");
		System.out.println(k);
	}

}
