import java.io.*;
class ExpMultiCatch2 {
	public static void main(String[] args) {
		try {
			InputStreamReader srd = new InputStreamReader(System.in);
			BufferedReader brd = new BufferedReader(srd);
			System.out.print("���l����͂��ĉ������F");
			String s = brd.readLine();
			int number = Integer.parseInt(s);
			System.out.println("���͂��ꂽ�l��" + number);
		} catch (NumberFormatException e) {
			System.out.println("���l�͐����œ��͂��Ȃ���΂����܂���B");
		} catch (IOException e) {
			System.out.println("���͂ɖ�肪�������܂����B");
		}
	}
}