// ���̃N���X�̓p�b�P�[�W�ɑ����Ă��܂���
// ���[�U��`��O���g�p���邽�߂ɃC���|�[�g���K�v�ł�
import util.etc.LineInput;
import util.exception.*;
public class PackageUser3 {
	public static void main(String[] args) {
		try {
			LineInput obj = new LineInput();
			int number = obj.inputNumber();
			System.out.println("���͒l��" + number);
		} catch(UserException e) {
			System.out.println("���̓G���[�ł��B");
		}
	}
}