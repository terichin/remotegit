class ImplementBase1 extends Base1 implements InterfaceBase1 {
	// ���̃N���X�ł͊|���Z�����s����
	public int calculate(int target) {
		return target * value;
	}
	// �v�Z�����s���Č��ʂ�\������
	public void printResult(int target) {
		System.out.println("�v�Z���ʂ�" + calculate(target) + "�ł�");
	}
}