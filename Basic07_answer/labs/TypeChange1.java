// ��{���7-7 �C���X�^���X�̌^�ϊ�������
class TypeChange1 {
    public static void main(String[] args) {
        // Parent1�^�̕ϐ����`���܂�
        InheritParent1 obj;
        // Child1�N���X�̃C���X�^���X�𐶐����AParent1�^�̕ϐ��ɑ�����܂�
        obj = new InheritChild1();
        // ���������C���X�^���X�̃��\�b�h���Ăяo���܂�
        obj.printParent();
    }
}