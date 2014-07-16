// �����̔��@�̋@�\�����N���X
// �������񋟂����ƃW���[�X��񋟂��邱�Ƃ��ł���
class VendingMachine {
    // �������z��ۑ����郁���o�ϐ�
    private int amountMoney = 0;

    // �����𓊓����郁�\�b�h
    public void insertCoin(int price) {
        // �������z�𑝂₷
        amountMoney += price;
    }

    // �������z���擾���郁�\�b�h
    public int getAmountMoney() {
        // �������z��Ԃ�
        return amountMoney;
    }

    // �w���ID���W���[�X�C���X�^���X���擾���郁�\�b�h
    public IJuice pushJuiceButton(int juiceId) throws NoMoneyException {
        // �W���[�X�C���X�^���X�𐶐����ĕԂ�
        IJuice selJuice;
        if (juiceId == IJuice.JUICE_COFFEE) {
            // �R�[�q�[
            selJuice = new CoffeeJuice();
        } else if (juiceId == IJuice.JUICE_TEA) {
            // �g��
            selJuice = new TeaJuice();
        } else if (juiceId == IJuice.JUICE_ORANGE) {
            // �I�����W
            selJuice = new OrangeJuice();
        } else {
            selJuice = null;
        }
        // �W���[�X���������z�ōw���\���ǂ������ׂ�
        if (selJuice.getPrice() <= amountMoney) {
            // �w���\�Ȃ̂ŁA�������z�����炵�ăW���[�X�C���X�^���X��Ԃ�
            amountMoney -= selJuice.getPrice();
            return selJuice;
        } else {
            // �c�z�s���Ȃ̂ŗ�O�𔭐�
            throw new NoMoneyException();
        }
    }

    // �����Ԃ����\�b�h
    public int returnChange() {
        // �Ԃ��ׂ��l(���݂̓������z)��ۑ�
        int change = amountMoney;
        // �������z��0�ɂ���
        amountMoney = 0;
        // ����̊z��Ԃ�
        return change;
    }
}