// �W���[�X�N���X�̐��`
// �W���[�X�̋��ʋ@�\(�l�i�A���AID���̒�)�������Ă��邾���Ȃ̂�
// ���ꎩ�g���C���X�^���X�����Ďg�����Ƃ͖���

class Juice implements IJuice {
    // �l�i
    public int price = -1;
    // ID
    public int juiceId = -1;
    // ��
    public String taste = "��";

    public String getDrinkName() {
        // ����Ԃ�
        return taste;
    }

    public int getJuiceID() {
        // ID��Ԃ�
        return juiceId;
    }

    public int getPrice() {
        // �l�i��Ԃ�
        return price;
    }
}