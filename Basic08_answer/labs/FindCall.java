class FindCall {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("�������[�h�ƌ�����������͂��ĉ������B");
		} else {
			// ���������̊m�F
			int mode = Integer.parseInt(args[0]);
			FindUtility obj = new FindUtility();
			ValueObject vo = null;
			if (mode == 1) { // �ԍ�����
				vo = obj.findByExtension(Integer.parseInt(args[1]));
			} else if (mode == 2) { // ��������
				vo = obj.findByName(args[1]);
			} else {
				System.out.println("���[�h�̎w�肪�Ԉ���Ă��܂��B");
				return;
			}
			if (vo == null) {
				System.out.println("�������ʂ�������܂���B");
			} else {
				vo.printInformation();
			}
		}
	}
}