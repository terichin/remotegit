class MemberAccess2 {
    public static void main(String[] args) {
        // InstanceObject2 �N���X�̃C���X�^���X�𐶐����� obj1 �ϐ��ɑ������B
        InstanceObject2 obj1 = new InstanceObject2();
        // InstanceObject2 �N���X�̃C���X�^���X�𐶐����� obj2 �ϐ��ɑ������B
        InstanceObject2 obj2 = new InstanceObject2();
        // obj1�ϐ���print()���\�b�h�����s����B�����́uThank you!�v�Ƃ���
        obj1.print("Thank you!");
        // obj1�ϐ���number1��200��������B
        obj1.number1=200;
        // obj1�ϐ���getNumber()���\�b�h�����s����
        // ���s���ʂ�ϐ�returnNumber1�ɑ������B
        int returnNumber1 = obj1.getNumber();
        // returnNumber1��\������B
        System.out.println(returnNumber1);
        // obj2�ϐ���number1��300��������B
        obj2.number1=300;
        // obj2�ϐ���getNumber()���\�b�h�����s����
        // ���s���ʂ�ϐ�returnNumber2�ɑ������B
        int returnNumber2 = obj2.getNumber();
        // returnNumber2��\������B
        System.out.println(returnNumber2);
    }
}