import basicws.entity.MemberBean;

public class MemberBeanTest {

	public static void main(String[] args) {

		// test#1
		System.out.println("** test#1 **");
		String[] array = { "0000016", "R‰ºt÷", "‰c‹Æ•”", "•ë‹L1‹‰", "—˜‚«ğ", "‰f‰æ", "•Ÿ“‡Œ§" };
		MemberBean mb1 = new MemberBean(array);
		System.out.print(mb1.getNo() + ",");
		System.out.print(mb1.getName() + ",");
		System.out.print(mb1.getBusho() + ",");
		System.out.print(mb1.getShikaku() + ",");
		System.out.print(mb1.getTokugi() + ",");
		System.out.print(mb1.getHobby() + ",");
		System.out.println(mb1.getHometown());
		System.out.println("------------------------------------------");
		
		// test#2‚¨‚æ‚Ñ#9
		System.out.println("** test#2‚Ætest#9 **");
		MemberBean mb2 = new MemberBean();
		mb2.setNo("5");
		System.out.println(mb2.getNo());
		System.out.println("------------------------------------------");
		
		// test#3‚¨‚æ‚Ñ#10
		System.out.println("** test#3‚Ætest#10 **");		
		MemberBean mb3 = new MemberBean();
		mb3.setName("R–{");
		System.out.println(mb3.getName());
		System.out.println("------------------------------------------");
		
		// test#4‚¨‚æ‚Ñ#11
		System.out.println("** test#4‚Ætest#11 **");
		MemberBean mb4 = new MemberBean();
		mb4.setBusho("ŠJ”­•”");
		System.out.println(mb4.getBusho());
		System.out.println("------------------------------------------");

		// test#5‚¨‚æ‚Ñ#12
		System.out.println("** test#5‚Ætest#12 **");
		MemberBean mb5 = new MemberBean();
		mb5.setShikaku("î•ñˆ—1‹‰");
		System.out.println(mb5.getShikaku());
		System.out.println("------------------------------------------");

		// test#6‚¨‚æ‚Ñ#13
		System.out.println("** test#6‚Ætest#13 **");
		MemberBean mb6 = new MemberBean();
		mb6.setTokugi("—¿—");
		System.out.println(mb6.getTokugi());
		System.out.println("------------------------------------------");

		// test#7‚¨‚æ‚Ñ#14
		System.out.println("** test#7‚Ætest#14 **");
		MemberBean mb7 = new MemberBean();
		mb7.setHobby("‰¹Šy");
		System.out.println(mb7.getHobby());
		System.out.println("------------------------------------------");

		// test#8‚¨‚æ‚Ñ#15
		System.out.println("** test#8‚Ætest#15 **");
		MemberBean mb8 = new MemberBean();
		mb8.setHometown("–kŠC“¹");
		System.out.println(mb8.getHometown());
		System.out.println("------------------------------------------");
		
	}
}
