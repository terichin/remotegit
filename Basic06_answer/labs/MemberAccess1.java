class MemberAccess1 {
    public static void main(String[] args) {
        // InstanceObject1 �N���X�̃C���X�^���X�𐶐����� obj1 �ϐ��ɑ������B
        InstanceObject1 obj1 = new InstanceObject1();
        // obj1�ϐ���print()���\�b�h�����s����B�����́uHello�v�Ƃ���
        obj1.print("Hello");
        // obj1�ϐ���number1��150��������B
        obj1.number1=150;
        // obj1�ϐ���number1��ϐ�returnNumber1�ɑ������B
        int returnNumber1 = obj1.number1;
        // returnNumber1��\������B
        System.out.println(returnNumber1);
    }
}