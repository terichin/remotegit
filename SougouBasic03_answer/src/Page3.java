/*
 * �Ј����̌��������̌����L�[���擾����N���X
 */
public class Page3 {

    public void execute() {
        System.out.println("�Ј��������s���܂��B");
        System.out.println("�Ј��̌����L�[��I�����Ă��������B");
        System.out.println();

        //�Ј����̊e���ڂ�\������
        for (int i = 1; i <= 7; i++) {
            System.out.println(i + " " + MemberMain.COLUMN_NAME[i]);
        }
        System.out.println();

        //�����L�[�̔ԍ����R���\�[������擾����
        String number = InputUtility.inputNumber(1, 7);
        System.out.println();

        //�����L�[�̔ԍ���Page4�N���X��execute()���\�b�h�ֈ����n��
        Page4 page = new Page4();
        page.execute(Integer.parseInt(number));
    }
}