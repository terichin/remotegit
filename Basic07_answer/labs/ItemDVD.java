// �I�v�V�������7-1 super�L�[���[�h���g�p����v���O����
// DVD�̏��i����ۑ��E�\������@�\�����N���X�ł�
class ItemDVD extends Item {
    // ���^���Ԃ�ۑ����郁���o�ϐ�
    int time;

    void printInformation() {
        // Item�N���X��printInformation���Ăяo��(���O�A���i�̕\��)
        super.printInformation();
        // ���^���Ԃ�\��
        System.out.println("���^���Ԃ�" + time + "���ł�");
    }
}