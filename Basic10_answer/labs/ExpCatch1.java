class ExpCatch1 {
    public static void main(String[] args) {
        // ������1�ł͂Ȃ��ꍇ�̓G���[�Ƃ��A���b�Z�[�W��\��
        if (args.length == 1) {
            try {
                // �R�}���h���C��������int�^�ɕϊ�����
                int number = Integer.parseInt(args[0]);
                // �K����v�Z���ĕ\������
                System.out.println(number * number);
            } catch (NumberFormatException e) {
                // int�^�ւ̕ϊ��Ɏ��s�����ꍇ�̓��b�Z�[�W��\��
                System.out.println("���͂���l�͐��l�łȂ���΂����܂���B");
            }
        } else {
            // ������1�ł͂Ȃ������ꍇ�̓��b�Z�[�W��\��
            System.out.println("1�̐��l����͂��ĉ������B");
        }
    }
}