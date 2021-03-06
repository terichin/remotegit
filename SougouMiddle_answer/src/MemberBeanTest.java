import basicws.entity.MemberBean;

public class MemberBeanTest {

	public static void main(String[] args) {

		// test#1
		System.out.println("** test#1 **");
		String[] array = { "0000016", "山下春樹", "営業部", "簿記1級", "利き酒", "映画", "福島県" };
		MemberBean mb1 = new MemberBean(array);
		System.out.print(mb1.getNo() + ",");
		System.out.print(mb1.getName() + ",");
		System.out.print(mb1.getBusho() + ",");
		System.out.print(mb1.getShikaku() + ",");
		System.out.print(mb1.getTokugi() + ",");
		System.out.print(mb1.getHobby() + ",");
		System.out.println(mb1.getHometown());
		System.out.println("------------------------------------------");
		
		// test#2および#9
		System.out.println("** test#2とtest#9 **");
		MemberBean mb2 = new MemberBean();
		mb2.setNo("5");
		System.out.println(mb2.getNo());
		System.out.println("------------------------------------------");
		
		// test#3および#10
		System.out.println("** test#3とtest#10 **");		
		MemberBean mb3 = new MemberBean();
		mb3.setName("山本");
		System.out.println(mb3.getName());
		System.out.println("------------------------------------------");
		
		// test#4および#11
		System.out.println("** test#4とtest#11 **");
		MemberBean mb4 = new MemberBean();
		mb4.setBusho("開発部");
		System.out.println(mb4.getBusho());
		System.out.println("------------------------------------------");

		// test#5および#12
		System.out.println("** test#5とtest#12 **");
		MemberBean mb5 = new MemberBean();
		mb5.setShikaku("情報処理1級");
		System.out.println(mb5.getShikaku());
		System.out.println("------------------------------------------");

		// test#6および#13
		System.out.println("** test#6とtest#13 **");
		MemberBean mb6 = new MemberBean();
		mb6.setTokugi("料理");
		System.out.println(mb6.getTokugi());
		System.out.println("------------------------------------------");

		// test#7および#14
		System.out.println("** test#7とtest#14 **");
		MemberBean mb7 = new MemberBean();
		mb7.setHobby("音楽");
		System.out.println(mb7.getHobby());
		System.out.println("------------------------------------------");

		// test#8および#15
		System.out.println("** test#8とtest#15 **");
		MemberBean mb8 = new MemberBean();
		mb8.setHometown("北海道");
		System.out.println(mb8.getHometown());
		System.out.println("------------------------------------------");
		
	}
}
