class StaticAccess3 {
    public static void main(String[] args) {
        // �R�}���h���C���������s�����Ă��鎞�͌x����\��
        if (args.length != 2) {
            warnMessage();
        } else {
            // �R�}���h���C�������̎擾
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            // �a�̉��Z
            System.out.println(StaticObject3.calc(num1, num2));
            // �ς̉��Z
            StaticObject3.function = 1;
            System.out.println(StaticObject3.calc(num1, num2));
        }
    }
    // �R�}���h���C���������s�����Ă���Ƃ��̃��b�Z�[�W�@�\
    static void warnMessage() {
        System.out.println("�����̒l��2�^���ĉ������B");
    }
}