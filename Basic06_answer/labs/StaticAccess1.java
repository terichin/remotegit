class StaticAccess1 {
    // main���\�b�h�́Apublic static void�Ɛ錾����`����B
    public static void main(String[] args) {
        // static �I�u�W�F�N�g StaticObject1 �� number1 �ϐ��� 200 ��������B
        StaticObject1.number1 =200;
        // static �I�u�W�F�N�g StaticObject1 �� number1 ��\������B
        System.out.println(StaticObject1.number1);
        // static �I�u�W�F�N�g StaticObject1 �� print()���\�b�h��
        // ���� "John" �������Ď��s����B
        StaticObject1.print("John");
    }
}