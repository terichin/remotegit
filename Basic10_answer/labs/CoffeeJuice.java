// �R�[�q�[�W���[�X��\���N���X
class CoffeeJuice implements IJuice {
    // �l�i��120�~
    public int price = 120;
    // ���ݕ��̎�ނ̓R�[�q�[
    public String taste = "�R�[�q�[";
    // ID��JUICE_COFFEE(IJuice�C���^�[�t�F�[�X�ɒ�`)
    public int juiceId = JUICE_COFFEE;
    
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