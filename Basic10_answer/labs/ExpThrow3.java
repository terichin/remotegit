import java.io.*;
class ExpThrow3 {
	public static void main(String[] args) {
		try {
			int number = inputNumber();
			System.out.println("���͒l��" + number);
		} catch (MyException e) {
			System.out.println("���͂ŃG���[���������܂����B");
		}
	}
	// ���C�����͂��s���A�������󂯎�郁�\�b�h
	public static int inputNumber() throws MyException {
		int number = 0;
		try {
			InputStreamReader srd = new InputStreamReader(System.in);
			BufferedReader brd = new BufferedReader(srd);
			System.out.print("���l����͂��ĉ������F");
			String s = brd.readLine();
			number = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			throw new MyException();
		} catch (IOException e) {
			throw new MyException();
		}
		return number;
	}
}