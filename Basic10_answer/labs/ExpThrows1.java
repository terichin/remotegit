class ExpThrows1 {
    public static void main(String[] args) {
        try {
            // throws�錾���ꂽprint���\�b�h�̌Ăяo��
            print(args);
        } catch (NumberFormatException e) {
            // int�^�ւ̕ϊ����s���̃��b�Z�[�W
            System.out.println("���͂���l�͐��l�łȂ���΂����܂���B");
        } catch (ArrayIndexOutOfBoundsException e) {
            // �R�}���h���C�����������͂���Ă��Ȃ������ꍇ�̃��b�Z�[�W
            System.out.println("1�̐��l����͂��ĉ������B");
        } catch (ArithmeticException e) {
            // �R�}���h���C��������0�����͂��ꂽ�ꍇ�̃��b�Z�[�W
            System.out.println("0�ȊO�̐��l����͂��ĉ������B");
        }
    }
    
    // 100����͂��ꂽ�l�Ŋ���A���ʂ�\�����郁�\�b�h
    static void print(String[] args) throws
        NumberFormatException, ArrayIndexOutOfBoundsException, 
        ArithmeticException {
        // �R�}���h���C��������int�^�ɕϊ�����
        int number = Integer.parseInt(args[0]);
        // 100����͂��ꂽ���l�Ŋ���A���ʂ�\��
        System.out.println(100 / number);
    }
}