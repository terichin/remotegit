class ExpMultiCatch1 {
    public static void main(String[] args) {
        try {
            // �R�}���h���C��������int�^�ɕϊ�����
            int number = Integer.parseInt(args[0]);
            // �K����v�Z���ĕ\������
            System.out.println(number * number);
        } catch (NumberFormatException e) {
            // int�^�ւ̕ϊ����s���̃��b�Z�[�W
            System.out.println("���͂���l�͐��l�łȂ���΂����܂���B");
        } catch (ArrayIndexOutOfBoundsException e) {
            // �R�}���h���C�����������͂���Ă��Ȃ������ꍇ�̃��b�Z�[�W
            System.out.println("1�̐��l����͂��ĉ������B");
        }
    }
}