class ExpThrow1 {
    public static void main(String[] args) {
        try {
            // ���b�Z�[�W�̕\��
            System.out.println("�v���O�����J�n�B");
            // ����̗�O�𔭐�������
            throw new MyException();
        } catch (MyException e) {
            // ����̗�O���L���b�`���A���\�b�h���Ăяo��
            e.printErrorMessage();
        }
    }
}