class ExpThrows2 {
    public static void main(String[] args) {
        try {
            // throws�錾���ꂽaverage()���\�b�h�̌Ăяo��
            average(args);
        } catch (NumberFormatException e) {
            // int�^�ւ̕ϊ����s���̃��b�Z�[�W
            System.out.println("���͂���l�͐��l�łȂ���΂����܂���B");
        } catch (ArithmeticException e) {
            // �R�}���h���C�����������͂���Ă��Ȃ������ꍇ�̃��b�Z�[�W
            System.out.println("���͂�����܂���B");
        }
    }
    
    // ���͂��ꂽ���l�̕��ϒl�����߂郁�\�b�h
    static void average(String[] args) throws 
        NumberFormatException, ArithmeticException {
        // ���v�l��ۑ�����ϐ��̐錾
        int sum = 0;
        // String�^�z��𐔒l�ɕϊ����č��v�l���v�Z
        for (int i = 0; i < args.length; ++i) {
            sum += Integer.parseInt(args[i]);
        }
        
        // ���v�l��v�f���Ŋ����āA���ϒl���v�Z���ĕ\��
        int avg = sum / args.length;
        System.out.println("���ς�" + avg + "�ł��B");
    }
}