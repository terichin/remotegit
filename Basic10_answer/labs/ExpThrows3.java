import java.io.*;
class ExpThrows3 {
	public static void main(String[] args) {
		try {
			int number = inputNumber();
			int rnumber = (int)(Math.random() * 2.0);
			System.out.println("���͒l��" + number);
			System.out.println("�����l��" + rnumber);
			System.out.println("�v�Z�l��" + number / rnumber);
		} catch (NumberFormatException e) {
			System.out.println("���l�͐����œ��͂��Ȃ���΂����܂���B");
		} catch (ArithmeticException e) {
			System.out.println("�v�Z�ŃG���[���������܂����B");
		}
	}
	// ���C�����͂��s���A�������󂯎�郁�\�b�h
	public static int inputNumber() throws NumberFormatException {
		int number = 0;
		try {
			InputStreamReader srd = new InputStreamReader(System.in);
			BufferedReader brd = new BufferedReader(srd);
			System.out.print("���l����͂��ĉ������F");
			String s = brd.readLine();
			number = Integer.parseInt(s);
		} catch (IOException e) {
			System.out.println("���͂ɖ�肪�������܂����B");
			System.exit(0);
		}
		return number;
	}
}