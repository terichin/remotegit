class StringUser1 {
    public static void main(String[] args) {
        // �����l��������String�I�u�W�F�N�g��2��������
        String str1 = new String("����ɂ���");
        String str2 = new String("����ɂ���");
        
        // �ϐ�str1�̕�����̒������擾���ĕ\������
        System.out.println("str1�̕�����̒�����" + str1.length() + "�ł�");
        
        // �ϐ�str1�ƕϐ�str2��==�Ŕ�r����
        // ==�͓����C���X�^���X���w���Ă��邩�𒲂ׂ�
        if (str1 == str2) {
            System.out.println("str1��str2�͓����I�u�W�F�N�g�ł�");
        } else {
            System.out.println("str1��str2�͈Ⴄ�I�u�W�F�N�g�ł�");
        }
        
        // �ϐ�str1�ƕϐ�str2��equals()���\�b�h�Ŕ�r����
        // equals()���\�b�h�͓����l�������Ă��邩�𒲂ׂ�
        if (str1.equals(str2)) {
            System.out.println("str1��str2�͓����l�ł�");
        } else {
            System.out.println("str1��str2�͈Ⴄ�l�ł�");
        }
    }
}