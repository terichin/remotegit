import basicws.entity.MemberBean;

public class MemberBeanTest {

	public static void main(String[] args) {

		// test#1
		System.out.println("** test#1 **");
		String[] array = { "0000016", "�R���t��", "�c�ƕ�", "��L1��", "������", "�f��", "������" };
		MemberBean mb1 = new MemberBean(array);
		System.out.print(mb1.getNo() + ",");
		System.out.print(mb1.getName() + ",");
		System.out.print(mb1.getBusho() + ",");
		System.out.print(mb1.getShikaku() + ",");
		System.out.print(mb1.getTokugi() + ",");
		System.out.print(mb1.getHobby() + ",");
		System.out.println(mb1.getHometown());
		System.out.println("------------------------------------------");
		
		// test#2�����#9
		System.out.println("** test#2��test#9 **");
		MemberBean mb2 = new MemberBean();
		mb2.setNo("5");
		System.out.println(mb2.getNo());
		System.out.println("------------------------------------------");
		
		// test#3�����#10
		System.out.println("** test#3��test#10 **");		
		MemberBean mb3 = new MemberBean();
		mb3.setName("�R�{");
		System.out.println(mb3.getName());
		System.out.println("------------------------------------------");
		
		// test#4�����#11
		System.out.println("** test#4��test#11 **");
		MemberBean mb4 = new MemberBean();
		mb4.setBusho("�J����");
		System.out.println(mb4.getBusho());
		System.out.println("------------------------------------------");

		// test#5�����#12
		System.out.println("** test#5��test#12 **");
		MemberBean mb5 = new MemberBean();
		mb5.setShikaku("��񏈗�1��");
		System.out.println(mb5.getShikaku());
		System.out.println("------------------------------------------");

		// test#6�����#13
		System.out.println("** test#6��test#13 **");
		MemberBean mb6 = new MemberBean();
		mb6.setTokugi("����");
		System.out.println(mb6.getTokugi());
		System.out.println("------------------------------------------");

		// test#7�����#14
		System.out.println("** test#7��test#14 **");
		MemberBean mb7 = new MemberBean();
		mb7.setHobby("���y");
		System.out.println(mb7.getHobby());
		System.out.println("------------------------------------------");

		// test#8�����#15
		System.out.println("** test#8��test#15 **");
		MemberBean mb8 = new MemberBean();
		mb8.setHometown("�k�C��");
		System.out.println(mb8.getHometown());
		System.out.println("------------------------------------------");
		
	}
}
