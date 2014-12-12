import basicws.util.InputUtility;

public class InputUtilityTest {

	public static void main(String[] args) {

		int testNo = 45;
		// test#45
		System.out.println("** test#"+(testNo++)+" **");
		System.out.println("「あいうえお」を入力して結果確認する＞");
		System.out.println("[" + InputUtility.inputString() + "]");
		System.out.println("------------------------------------------");

		// test#46
		System.out.println("** test#"+(testNo++)+" **");
		System.out.println("何も入力しないで結果確認する＞");
		System.out.println("[" + InputUtility.inputString() + "]");
		System.out.println("------------------------------------------");

		// test#47
		System.out.println("** test#"+(testNo++)+" **");
		System.out.println("「あいうえお」を入力して結果確認する＞");
		System.out.println("[" + InputUtility.inputString(true) + "]");
		System.out.println("------------------------------------------");

		// test#48
		System.out.println("** test#"+(testNo++)+" **");
		System.out.println("何も入力しないで結果確認する＞");
		System.out.println("[" + InputUtility.inputString(true) + "]");
		System.out.println("------------------------------------------");

		// test#49
		System.out.println("** test#"+(testNo++)+" **");
		System.out.println("「あいうえお」を入力して結果確認する＞");
		System.out.println("[" + InputUtility.inputString(false) + "]");
		System.out.println("------------------------------------------");

		// test#50
		System.out.println("** test#"+(testNo++)+" **");
		System.out.println("何も入力しないで結果確認する＞");
		System.out.println("[" + InputUtility.inputString(false) + "]");
		System.out.println("------------------------------------------");

		// test#51
		System.out.println("** test#"+(testNo++)+" **");
		System.out.println("「あいうえおかきく」を入力して結果確認する＞");
		System.out.println("[" + InputUtility.inputString(5, true) + "]");
		System.out.println("------------------------------------------");

		// test#52
		System.out.println("** test#"+(testNo++)+" **");
		System.out.println("「あいうえおかきく」を入力して結果確認する＞");
		System.out.println("[" + InputUtility.inputString(7, true) + "]");
		System.out.println("------------------------------------------");

		// test#53
		System.out.println("** test#"+(testNo++)+" **");
		System.out.println("「あいうえおかきく」を入力して結果確認する＞");
		System.out.println("[" + InputUtility.inputString(10, true) + "]");
		System.out.println("------------------------------------------");

		// test#54
		System.out.println("** test#"+(testNo++)+" **");
		System.out.println("何も入力しないで結果確認する＞");
		System.out.println("[" + InputUtility.inputString(10, true) + "]");
		System.out.println("------------------------------------------");

		// test#55
		System.out.println("** test#"+(testNo++)+" **");
		System.out.println("「あいうえおかきく」を入力して結果確認する＞");
		System.out.println("[" + InputUtility.inputString(5, false) + "]");
		System.out.println("------------------------------------------");

		// test#56
		System.out.println("** test#"+(testNo++)+" **");
		System.out.println("「あいうえおかきく」を入力して結果確認する＞");
		System.out.println("[" + InputUtility.inputString(7, false) + "]");
		System.out.println("------------------------------------------");

		// test#57
		System.out.println("** test#"+(testNo++)+" **");
		System.out.println("「あいうえおかきく」を入力して結果確認する＞");
		System.out.println("[" + InputUtility.inputString(10, false) + "]");
		System.out.println("------------------------------------------");

		// test#58
		System.out.println("** test#"+(testNo++)+" **");
		System.out.println("何も入力しないで結果確認する＞");
		System.out.println("[" + InputUtility.inputString(10, false) + "]");
		System.out.println("------------------------------------------");

		// test#59
		System.out.println("** test#"+(testNo++)+" **");
		System.out.println("「あいうえおかきく」を入力して結果確認する＞");
		System.out.println("[" + InputUtility.inputString(5) + "]");
		System.out.println("------------------------------------------");

		// test#60
		System.out.println("** test#"+(testNo++)+" **");
		System.out.println("「あいうえおかきく」を入力して結果確認する＞");
		System.out.println("[" + InputUtility.inputString(7) + "]");
		System.out.println("------------------------------------------");

		// test#61
		System.out.println("** test#"+(testNo++)+" **");
		System.out.println("「あいうえおかきく」を入力して結果確認する＞");
		System.out.println("[" + InputUtility.inputString(10) + "]");
		System.out.println("------------------------------------------");

		// test#62
		System.out.println("** test#"+(testNo++)+" **");
		System.out.println("何も入力しないで結果確認する＞");
		System.out.println("[" + InputUtility.inputString(10) + "]");
		System.out.println("------------------------------------------");

		// test#63
		System.out.println("** test#"+(testNo++)+" **");
		System.out.println(" 123 を入力して結果確認する＞");
		System.out.println("[" + InputUtility.inputNumber() + "]");
		System.out.println("------------------------------------------");

		// test#64
		System.out.println("** test#"+(testNo++)+" **");
		System.out.println("「a」を入力して結果確認する＞");
		System.out.println("[" + InputUtility.inputNumber() + "]");
		System.out.println("------------------------------------------");

		// test#65
		System.out.println("** test#"+(testNo++)+" **");
		System.out.println("何も入力しないで結果確認する＞");
		System.out.println("[" + InputUtility.inputNumber() + "]");
		System.out.println("------------------------------------------");

		// test#66
		System.out.println("** test#"+(testNo++)+" **");
		System.out.println(" 2 を入力して結果確認する＞");
		System.out.println("[" + InputUtility.inputNumber(1, 3) + "]");
		System.out.println("------------------------------------------");

		// test#67
		System.out.println("** test#"+(testNo++)+" **");
		System.out.println(" 4 を入力して結果確認する＞");
		System.out.println("[" + InputUtility.inputNumber(1, 3) + "]");
		System.out.println("------------------------------------------");

		// test#68
		System.out.println("** test#"+(testNo++)+" **");
		System.out.println(" -1 を入力して結果確認する＞");
		System.out.println("[" + InputUtility.inputNumber(1, 3) + "]");
		System.out.println("------------------------------------------");

		// test#69
		System.out.println("** test#"+(testNo++)+" **");
		System.out.println(" 6 を入力して結果確認する＞");
		System.out.println("[" + InputUtility.inputNumber(1, 5) + "]");
		System.out.println("------------------------------------------");

		// test#70
		System.out.println("** test#"+(testNo++)+" **");
		System.out.println("「a」を入力して結果確認する＞");
		System.out.println("[" + InputUtility.inputNumber(1, 5) + "]");
		System.out.println("------------------------------------------");

	}

}
