// ��{���7-4 �T�u�N���X���g�p����v���O����
class InheritUser1 {
    public static void main(String[] args) {
        // �T�u�N���X�̃C���X�^���X�𐶐����Ă��܂�
        InheritChild1 obj = new InheritChild1();
        // �X�[�p�[�N���X�̃����o�ϐ��̒l��\�����܂�
        System.out.println(obj.num1);
        // �X�[�p�[�N���X�̃��\�b�h�Ăяo�������܂�
        obj.printParent();
        // �T�u�N���X�̃����o�ϐ��̒l��\�����܂�
        System.out.println(obj.num2);
        // �T�u�N���X�̃��\�b�h�Ăяo�������܂�
        obj.printChild();
    }
}