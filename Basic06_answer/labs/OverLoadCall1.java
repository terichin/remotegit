class OverLoadCall1 {
    // main���\�b�h�́Apublic static void�Ɛ錾����`����B
    public static void main(String[] args) {
        // OverLoadObject1 �N���X�̃C���X�^���X�𐶐����� obj1 �ϐ��ɑ������B
        OverLoadObject1 obj1 = new OverLoadObject1();
        // obj1�ϐ���printValue()���\�b�h�����s����B
        obj1.printValue();
        // obj2�ϐ���printValue()���\�b�h�����s����B������"�l��"�Ƃ���B
        obj1.printValue("�l��");
    }
}