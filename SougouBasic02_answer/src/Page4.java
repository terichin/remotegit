/*
 * �Ј����̌��������̌����L�[���[�h���擾���A�������s���N���X
 */
public class Page4 {

    public void execute(int key) {

        System.out.println(MemberMain.COLUMN_NAME[key] + "�ŎЈ��������s���܂��B");
        System.out.println("�����L�[���[�h����͂��Ă��������B");
        System.out.println();

        //�����L�[���[�h���R���\�[������擾����
        String query = InputUtility.inputString();

        //�����L�[�Ƃ���ɑ΂��錟���L�[���[�h�Ō������A
        //��v����Ј�����MemberBean�Ƃ��Ď擾����
        MemberBean bean = CsvDao.search(key, query);

        //�������ʂł���MemberBean��Page5�N���X��execute()���\�b�h��
        Page5 page = new Page5();
        page.execute(bean);
    }
}