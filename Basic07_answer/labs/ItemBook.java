// ��b���7-6 super�L�[���[�h���g�p����v���O����
// �{�̏��i����ۑ��E�\������@�\�����N���X�ł�
class ItemBook extends Item {
    // ��Җ���ۑ����郁���o�ϐ�
    String author;
    // ISBN�ԍ���ۑ����郁���o�ϐ�
    String isbn;

    void printInformation() {
        // Item�N���X��printInformation���Ăяo��(���O�A���i�̕\��)
        super.printInformation();
        // ��҂�\��
        System.out.println("��҂�" + author + "�ł�");
        // ISBN�ԍ���\��
        System.out.println("ISBN��" + isbn + "�ł�");
    }
}