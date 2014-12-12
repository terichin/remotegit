import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * CSV�t�@�C���Ƃ̂������s��DAO�N���X
 */
public class CsvDao {

    private static final String FILE_NAME = "member.csv";
    // �t�@�C�����̎Ј������L���b�V�����邽�߂�ArrayList�B�Ј����ꌏ��String[]�Ŋi�[����
    private static ArrayList<String[]> memberList;
    //�t�@�C���X�V�t���O�Btrue�̏ꍇ�ɂ�memberList���L���b�V�����Ȃ���
    private static boolean isChanged = true;

    // �Y������Ј����𕡐������Ԃ����߁A
    // �߂�l�̌^��ArrayList<MemberBean>�^�ɕύX
    public static ArrayList<MemberBean> search(int key, String query) {

        //�������ʂ�Ԃ����߂�ArrayList�𐶐�����
        ArrayList<MemberBean> searchList = new ArrayList<MemberBean>();
        //�s�ԍ��ɂP���Z�b�g����
        int index = 1;

        while (true) {
            //�����Ŏw�肵���s�ԍ��̎Ј������P���擾����B
            String[] record = fetch(index);

            //�擾���ʂ�null�̏ꍇ�A���[�v�𔲂���
            if (record == null) {
                break;
            }

            //�擾�����Ј���񂪈����Ŏw�肵���l���܂�ł���ꍇ�A
            //���̎Ј�����MemberBean�Ƃ���ArrayList�Ɋi�[����
            if (record[key - 1].indexOf(query) != -1) {
                MemberBean bean = new MemberBean(record);
                searchList.add(bean);
            }
            index++;
        }
        //�������ʂ�ArrayList��Ԃ�
        return searchList;
    }

    public static void insert(MemberBean bean) {

        try {
            //�t�@�C���������݂̂��߂̃I�u�W�F�N�g���擾����
            FileWriter fw = new FileWriter(FILE_NAME, true);
            BufferedWriter bw = new BufferedWriter(fw);

            //�Ј������J���}�ŋ�؂�Ȃ���t�@�C���֏�������
            String record = bean.getNo() + ","
                    + bean.getName() + ","
                    + bean.getBusho() + ","
                    + bean.getShikaku() + ","
                    + bean.getTokugi() + ","
                    + bean.getHobby() + ","
                    + bean.getHometown();
            bw.write(record);

            bw.newLine();
            bw.close();

            //�t�@�C���ɕύX���������̂ŁAisChanged�t���O��true�ɂ���B
            isChanged = true;
        } catch (IOException ex) {
            System.out.println("�t�@�C���A�N�Z�X�Ɏ��s���܂����B");
            System.out.println("�A�v���P�[�V�������I�����܂��B");
            System.exit(0);
        }
    }

    private static String[] fetch(int index) {
        // isChanged�t���O��true�̏ꍇ�ɂ́ACSV�t�@�C������Ј������L���b�V�����Ȃ���
        if (isChanged) {
            //�Ј���񃊃X�g�𐶐�����
            memberList = new ArrayList<String[]>();
            try {
                //�t�@�C���ǂݍ��݂̂��߂̃I�u�W�F�N�g���擾����
                FileReader fr = new FileReader(FILE_NAME);
                BufferedReader br = new BufferedReader(fr);
                while (true) {
                    //�t�@�C������P�s�A�Ј�����ǂݍ���
                    String line = br.readLine();

                    //�ǂݍ��ގЈ���񂪂Ȃ������ꍇ�A���[�v�𔲂���
                    if (line == null) {
                        //�L���b�V���X�V�����������̂ŁAisChanged�t���O��false�ɂ���
                        isChanged = false;
                        //�t�@�C�����N���[�Y����
                        br.close();
                        //memberList��null��������
                        memberList.add(null);
                        break;
                    }

                    //�ǂݍ��񂾎Ј������J���}�ŋ�؂��Ĕz��Ɋi�[����
                    String[] record = line.split(",");
                    memberList.add(record);
                }
            } catch (FileNotFoundException ex) {
                System.out.println("�t�@�C���A�N�Z�X�Ɏ��s���܂����B");
                System.out.println("�A�v���P�[�V�������I�����܂��B");
                System.exit(0);
            } catch (IOException ex) {
                System.out.println("�t�@�C���A�N�Z�X�Ɏ��s���܂����B");
                System.out.println("�A�v���P�[�V�������I�����܂��B");
                System.exit(0);
            }
        }
        //�����Ŏw�肳�ꂽ�s�ԍ��̎Ј�����Ԃ��B
        return memberList.get(index - 1);
    }

    public static boolean isDuplicateKey(String no) {

        //�s�ԍ��̂P���Z�b�g����
        int index = 1;

        while (true) {
            //�����Ŏw�肵���s�ԍ��̎Ј������P���擾����
            String[] record = fetch(index);

            //�擾�ł��Ȃ������ꍇ�Afalse��Ԃ�
            if (record == null) {
                return false;
            }

            //�擾�����Ј��R�[�h�Ƃ��̃��\�b�h�Ŏw�肳�ꂽ������
            //��v����ꍇ�A�Ј��R�[�h���d�����Ă���̂ŁAtrue��Ԃ�
            if (record[0].equals(no)) {
                return true;
            }
            index++;
        }
    }
}