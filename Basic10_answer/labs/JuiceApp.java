// �����̔��@�ƃ��[�U�N���X�̃C���X�^���X�𐶐����A
// �W���[�X���w������v���O����
class JuiceApp {
    public static void main(String[] args) {

        // ���[�U�Ɏ������鏊�������w�肷��
        int argMoney = 0;

        // �R��ނ̃W���[�X�Ń��[�U����v������Ă���W���[�X�̌����w�肷��
        int requestItems[] = new int[3];
        // �R��ނ̃W���[�X�ōw�������W���[�X�̌����w�肷��
        int drinkItems[] = new int[3];

        // �����`�F�b�N������B
        if (args.length != 4) {
            System.out.println("�w�肷�������4�ł��B"
                    + "���[�U�̏������Ȃ�т�3��ނ̃W���[�X�̌���"
                    + "���ꂼ��w�肵�Ă��������B");
            return;
        }
        // �������󂯎��B
        try {
            argMoney = Integer.parseInt(args[0]);
            requestItems[0] = Integer.parseInt(args[1]);
            requestItems[1] = Integer.parseInt(args[2]);
            requestItems[2] = Integer.parseInt(args[3]);
        } catch (Exception e) {
            // �������l�����͂�����Ă��Ȃ��ꍇ�̓��b�Z�[�W��\��
            System.out.println("���[�U�̏������Ȃ�т�"
                    + "3��ނ̃W���[�X�̌������ꂼ��w�肵�Ă��������B");
            // �v���O�������I��
            return;
        }

        // �����̔��@�̃C���X�^���X�𐶐�
        VendingMachine vm = new VendingMachine();
        // ���[�U�̃C���X�^���X�𐶐�
        JuiceUser user = new JuiceUser(argMoney);
        // ���[�U���������x����
        int money = user.pay();
        // �x�����������������̔��@�ɓ�������
        vm.insertCoin(money);

        try {
            for (drinkItems[0] = 0; drinkItems[0] < requestItems[0];
                    drinkItems[0] = drinkItems[0] + 1) {
                // �R�[�q�[���w������
                IJuice juice = vm.pushJuiceButton(IJuice.JUICE_COFFEE);
                // �w�������R�[�q�[������
                user.receiveJuice(juice);
            }

            for (drinkItems[1] = 0; drinkItems[1] < requestItems[1];
                    drinkItems[1] = drinkItems[1] + 1) {
                // �g�����w������
                IJuice juice = vm.pushJuiceButton(IJuice.JUICE_TEA);
                // �w�������g��������
                user.receiveJuice(juice);
            }

            for (drinkItems[2] = 0; drinkItems[2] < requestItems[2];
                    drinkItems[2] = drinkItems[2] + 1) {
                // �I�����W�W���[�X���w������
                IJuice juice = vm.pushJuiceButton(IJuice.JUICE_ORANGE);
                // �w�������I�����W�W���[�X������
                user.receiveJuice(juice);
            }
            // ���v���z���s������ꍇ�́A
            // ���[�U��`��ONoMoneyException���X���[�����
        } catch (NoMoneyException e) {
            e.printErrorMessage(requestItems, drinkItems);
        }
        // �����̔��@���炨����󂯎��
        int change = vm.returnChange();
        // �o�Ă�����������[�U�ɐݒ�
        user.receiveMoney(change);
    }
}