// �����̔��@�𗘗p���郆�[�U
class JuiceUser {
    // ��������ۑ����郁���o�ϐ�
    private int money;
    
    // �R���X�g���N�^
    public JuiceUser(int money) {
        // ��������������
        this.money = money;
    }
    
    // �������𕥂����\�b�h
    public int pay() {
        // �x�������z��\��
        System.out.println("������" + money + "�~�����܂�");
        // ���݂̏������̒l��Ԃ��A��������0�ɂ���
        int pay = money;
        money = 0;
        return pay;
    }
    
    // ������󂯎�郁�\�b�h
    public void receiveMoney(int money) {
        // �󂯎��������̊z��\��
        System.out.println("�����" + money + "�~�󂯎��܂���");
        // �󂯎����������������ɉ��Z
        this.money += money; 
    }
    
    // �W���[�X�������̔��@����󂯎�郁�\�b�h
    public void receiveJuice(IJuice juice) {
        // ���ݕ��̎�ނ�\������B
        System.out.println(juice.getDrinkName() + "���o�܂���");
    }
}