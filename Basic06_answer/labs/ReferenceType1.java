class ReferenceType1 {
    public static void main(String[] args) {
        // �ϐ�number1��int�^��50�ŏ��������Đ錾����B
        int number1 = 50;
        // �ϐ�number2�ɕϐ�number1��������B
        int number2 = number1;
        // number1��100��������B
        number1 = 100;
        // �ϐ�number1��\������B
        System.out.println(number1);
        // �ϐ�number2��\������B
        System.out.println(number2);
        // ReferenceObject1 �N���X�̃C���X�^���X�𐶐����� obj1 �ϐ��ɑ������B
        ReferenceObject1 obj1 = new ReferenceObject1();
        // �ϐ� obj2 ��obj1��������B
        ReferenceObject1 obj2 = obj1;
        // obj1�ϐ���number1��500��������B
        obj1.number1 = 500;
        // obj1��printNumber()���\�b�h�����s����B
        obj1.printNumber();
        // obj2��printNumber()���\�b�h�����s����B
        obj2.printNumber();
    }
}