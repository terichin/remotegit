// ��b���7-6 super�L�[���[�h���g�p����v���O����
class OverrideUser2 {
    public static void main(String[] args) {
        // �{�̏���ێ����邽�߂�ItemBook�C���X�^���X�𐶐�����
        ItemBook book = new ItemBook();
        // �쐬�����C���X�^���X�ɏ���ۑ�����
        book.name = "Java�v���O���~���O��b";
        book.price = 5000;
        book.author = "NTT�f�[�^���j�o�[�V�e�B";
        book.isbn = "XXXX-YYYYYY-ZZZZ";
        // �C���X�^���X�ɕۑ����ꂽ���i����\������
        book.printInformation();
    }
}