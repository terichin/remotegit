class ConstructorCall3 {
	public static void main(String[] args) {
		// �R�}���h���C���������s�����Ă��鎞�͌x����\��
		if (args.length != 2) {
		    warnMessage();
		} else {
		    // �v�Z�ׂ̈̃C���X�^���X�𐶐�����
		    ConstructorObject3 util1 = new ConstructorObject3(0);
		    ConstructorObject3 util2 = new ConstructorObject3(1);
		    // �v�Z���s���A���ʂ�\��
		    int num1 = Integer.parseInt(args[0]);
		    int num2 = Integer.parseInt(args[1]);
		    System.out.println(util1.calc(num1, num2));
		    System.out.println(util2.calc(num1, num2));
		}
	}
	// �R�}���h���C���������s�����Ă���Ƃ��̃��b�Z�[�W�@�\
    static void warnMessage() {
    	System.out.println("�����̒l��2�^���ĉ������B");
    }
}