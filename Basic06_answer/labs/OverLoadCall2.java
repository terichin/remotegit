class OverLoadCall2 {
	// main()���\�b�h�́Apublic static void�Ɛ錾����`����B
    public static void main(String[] args) {
        // OverLoadObject2 �N���X�̃C���X�^���X�𐶐����� obj1 �ϐ��ɑ������B
        OverLoadObject2 obj1 = new OverLoadObject2();
        // OverLoadObject2 �N���X�̃C���X�^���X�𐶐����� obj2 �ϐ��ɑ������B
        // ������ 15 �Ƃ���B
        OverLoadObject2 obj2 = new OverLoadObject2(15);
        // OverLoadObject2 �N���X�̃C���X�^���X�𐶐����� obj3 �ϐ��ɑ������B
        // ������ 20,3 �Ƃ���B
        OverLoadObject2 obj3 = new OverLoadObject2(20,3);
        
    	// obj1�ϐ���printValue()���\�b�h�����s����B
        obj1.printValue();
        // obj2�ϐ���printValue()���\�b�h�����s����B������"�l��"�Ƃ���B
        obj2.printValue("�l��");
        // obj3�ϐ���printValue()���\�b�h�����s����B
        // ������"value ��"��"�ł�"�Ƃ���B
        obj3.printValue("value ��", "�ł�");
    }
}