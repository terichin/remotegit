class ObjectApp1 {
    // main���\�b�h�́Apublic static void�Ɛ錾����`����B
    public static void main(String[] args) {
        // Book�̔z����쐬����B
        Book[] books = new Book[5];
        
        // �e�{�̃C���X�^���X���쐬���Ĕz��ϐ��ɑ������B
        books[0] = new Book(1001, "������", "�H�열�V��");
        books[1] = new Book(1002, "�V�����", "�Ėڟ���");
        books[2] = new Book("�O�l�Y", "�Ėڟ���");
        books[3] = new Book(1004, "���_", "��t���l��");
        books[4] = new Book("���P", "�X���O");
        
        // �{�z��̗v�f�̒������� for ���J��Ԃ��B
        for (int i=0; i < books.length ; i++) {
            // �{��introduce()���\�b�h�����s����B
            books[i].inform();
        }
    }
}