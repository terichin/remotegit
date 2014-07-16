class ExpThrow2 {
    public static void main(String[] args) {
        try {
            // throws�錾���ꂽprint()���\�b�h�̌Ăяo��
            print(args);
        } catch (MyException e) {
            // ����̗�O���L���b�`���A���\�b�h���Ăяo��
            e.printMessage();
        }
    }
    
    static void print(String[] args) throws MyException {
        try {
            // �R�}���h���C��������int�^�ɕϊ�����
            int number = Integer.parseInt(args[0]);
            // 100����͂��ꂽ���l�Ŋ���A���ʂ�\��
            System.out.println(100 / number);
        } catch (NumberFormatException e) {
            // int�^�ւ̕ϊ����s���̏���
            throw new MyException();
        } catch (ArrayIndexOutOfBoundsException e) {
            // �R�}���h���C�����������͂���Ă��Ȃ������ꍇ�̏���
            throw new MyException();
        } catch (ArithmeticException e) {
            // �R�}���h���C��������0�����͂��ꂽ�ꍇ�̏���
            throw new MyException();
        }
    }
}