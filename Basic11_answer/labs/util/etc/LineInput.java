// ���̃N���X�͈ȉ��̃p�b�P�[�W�ɑ����܂�
package util.etc;
// ���o�͂ƃ��[�U��`��O�̂��߂̃C���|�[�g�錾���K�v�ł��B
import java.io.*;
import util.exception.*;
public class LineInput {
	// ���l����͂��郁�\�b�h
	public int inputNumber() throws UserException {
		int number = 0;
		try {
			InputStreamReader srd = new InputStreamReader(System.in);
			BufferedReader brd = new BufferedReader(srd);
			System.out.print("���l����͂��ĉ������F");
			String s = brd.readLine();
			number = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			throw new UserException();
		} catch (IOException e) {
			throw new UserException();
		}
		return number;
	}
}