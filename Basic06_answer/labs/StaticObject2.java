class StaticObject2 {
    // number1�ϐ��� static int�^�Œl��100�ŏ���������悤��`����B
    static int number1 = 100;
    
    // plus()���\�b�h�́Astatic void�Ɛ錾��int�^����value���󂯎��悤��`����B
    static void plus(int value) {
        // number1 �� value �𑫂����l��\������B
        System.out.println(number1 + value);
    }
    
    // number2�ϐ��� int�^�Œl��2000�ŏ���������悤��`����B
    int number2 = 2000;
    
    // minus()���\�b�h�́Avoid�Ɛ錾��int�^����value���󂯎��悤��`����B
    void minus(int value) {
        // number2 ���� value ���������l��\������B
        System.out.println(number2 - value);
    }
    
    // main()���\�b�h�́Apublic static void�Ɛ錾����`����B
    public static void main(String[] args) {
        // static �I�u�W�F�N�g StaticObject2 �� number1 �ϐ��� 150 ��������B
        StaticObject2.number1 = 150;

        // StaticObject2 �N���X�̃C���X�^���X�𐶐����� obj1 �ϐ��ɑ������
        StaticObject2 obj1 = new StaticObject2();
        // obj1�ϐ���number2��500��������B
        obj1.number2 = 500;
        // obj1�ϐ���plus()���\�b�h�����s����B������10�Ƃ���B
        obj1.plus(10);
        // obj1�ϐ���minus()���\�b�h�����s����B������10�Ƃ���B
        obj1.minus(10);
        
        // StaticObject2 �N���X�̃C���X�^���X�𐶐����� obj2 �ϐ��ɑ������
        StaticObject2 obj2 = new StaticObject2();
        // obj2�ϐ���number2��400��������B
        obj2.number2 = 400;
        // obj2�ϐ���plus()���\�b�h�����s����B������10�Ƃ���B
        obj2.plus(10);
        // obj2�ϐ���minus()���\�b�h�����s����B������10�Ƃ���B
        obj2.minus(10);
    }
}