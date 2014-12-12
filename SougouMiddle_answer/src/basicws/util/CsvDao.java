package basicws.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import basicws.entity.MemberBean;

public class CsvDao {

    private static final String FILE_NAME = "member.csv";
    //�t�@�C�����̎Ј������L���b�V�����邽�߂�ArrayList�B
    //�Ј����ꌏ��MemberBean�Ŋi�[����B
    private static ArrayList<String[]> memberList;
    //�t�@�C���X�V�t���O�Btrue�̏ꍇ�ɂ�memberList���L���b�V�����Ȃ����B
    private static boolean isChanged = true;

    private final static Logger logger = Logger.getLogger(CsvDao.class);

    public static ArrayList<MemberBean> search(int key, String query) {

        //�Ј������i�[���邽�߂�ArrayList���쐬����
        ArrayList<MemberBean> list = new ArrayList<MemberBean>();

        //�s�ԍ��̂P���Z�b�g����
        int index = 1;

        while (true) {
            //�����Ŏw�肵���s�ԍ��̎Ј������P���擾����
            String[] record = fetch(index);

            //�擾���ʂ�null�̏ꍇ�A���[�v�𔲂���
            if (record == null) {
                break;
            }

            //�擾�����Ј���񂪈����Ŏw�肵���l���܂�ł���ꍇ�A
            //���̎Ј�����MemberBean���쐬���AArrayList�Ɋi�[����
            if (record[key - 1].indexOf(query) != -1) {
                MemberBean bean = new MemberBean(record);
                list.add(bean);
            }
            index++;
        }
        //ArratList��Ԃ�
        return list;
    }

    public static MemberBean searchById(String query) {
        //�s�ԍ��̂P���Z�b�g����
        int index = 1;

        while (true) {
            //�����Ŏw�肵���s�ԍ��̎Ј������P���擾����
            String[] record = fetch(index);

            //�擾���ʂ�null�̏ꍇ�Anull��Ԃ�
            if (record == null) {
                return null;
            }

            //�擾�����Ј����̎Ј��ԍ��������Ŏw�肵���ԍ��Ɠ������ꍇ�A
            //���̎Ј�����MemberBean���쐬���ĕԂ�
            if (record[0].equals(query)) {
                MemberBean bean = new MemberBean(record);
                return bean;
            }
            index++;
        }
    }

    public static void insert(MemberBean bean) {

        try {
            //�t�@�C���������݂̂��߂̃I�u�W�F�N�g���擾����
            FileWriter fw = new FileWriter(FILE_NAME, true);
            BufferedWriter bw = new BufferedWriter(fw);

            //�Ј������J���}�ŋ�؂�Ȃ���t�@�C���֏�������
            bw.write(
                    bean.getNo() + ","
                    + bean.getName() + ","
                    + bean.getBusho() + ","
                    + bean.getShikaku() + ","
                    + bean.getTokugi() + ","
                    + bean.getHobby() + ","
                    + bean.getHometown());
            bw.newLine();
            bw.close();
            //�t�@�C���ɕύX���������̂ŁAisChanged�t���O��true�ɂ���B
            isChanged = true;

        } catch (IOException ex) {
            System.out.println("�t�@�C���A�N�Z�X�Ɏ��s���܂����B");
            System.out.println("�A�v���P�[�V�������I�����܂��B");
            logger.error("�t�@�C���A�N�Z�X�Ɏ��s���܂����B"+ex.toString());
            logger.error("�A�v���P�[�V�������I�����܂��B");
            System.exit(0);
        }

    }

    public static void update(MemberBean bean) {

        //�Ј������i�[���邽�߂�ArrayList���쐬����
        ArrayList<MemberBean> list = new ArrayList<MemberBean>();

        //�s�ԍ��̂P���Z�b�g����
        int index = 1;

        while (true) {
            //�����Ŏw�肵���s�ԍ��̎Ј������P���擾����
            String[] record = fetch(index);

            //�擾���ʂ�null�̏ꍇ�A���[�v�𔲂���
            if (record == null) {
                break;
            }

            //�擾�����Ј����̎Ј��ԍ��������Ŏw�肵��MemberBean��
            //�Ј��ԍ��Ɠ������ꍇ�A������MemberBean��ArrayList�Ɋi�[����
            //�������Ȃ��ꍇ�A��L�Ŏ擾�����Ј�����MemberBean��
            //�쐬����ArrayList�Ɋi�[����
            if (record[0].equals(bean.getNo())) {
                list.add(bean);
            } else {
                MemberBean mb = new MemberBean(record);
                list.add(mb);
            }
            index++;
        }

        try {
            //�t�@�C���������݂̂��߂̃I�u�W�F�N�g���擾����
            FileWriter fw = new FileWriter(FILE_NAME, false);
            BufferedWriter bw = new BufferedWriter(fw);

            //ArrayList�ɂ���Ј��������o����
            //�J���}�ŋ�؂��ăt�@�C���֏�������
            for (MemberBean mb : list) {
                bw.write(
                        mb.getNo() + ","
                        + mb.getName() + ","
                        + mb.getBusho() + ","
                        + mb.getShikaku() + ","
                        + mb.getTokugi() + ","
                        + mb.getHobby() + ","
                        + mb.getHometown());
                bw.newLine();
            }
            bw.close();
            //�t�@�C���ɕύX���������̂ŁAisChanged�t���O��true�ɂ���B
            isChanged = true;

        } catch (FileNotFoundException ex) {
            System.out.println("�t�@�C���A�N�Z�X�Ɏ��s���܂����B");
            System.out.println("�A�v���P�[�V�������I�����܂��B");
            logger.error("�t�@�C���A�N�Z�X�Ɏ��s���܂����B"+ex.toString());
            logger.error("�A�v���P�[�V�������I�����܂��B");
            System.exit(0);
        } catch (IOException ex) {
            System.out.println("�t�@�C���A�N�Z�X�Ɏ��s���܂����B");
            System.out.println("�A�v���P�[�V�������I�����܂��B");
            logger.error("�t�@�C���A�N�Z�X�Ɏ��s���܂����B"+ex.toString());
            logger.error("�A�v���P�[�V�������I�����܂��B");
           System.exit(0);
        }
    }

    public static void delete(MemberBean bean) {

        //�Ј������i�[���邽�߂�ArrayList���쐬����
        ArrayList<MemberBean> list = new ArrayList<MemberBean>();

        //�s�ԍ��̂P���Z�b�g����
        int index = 1;

        while (true) {
            //�����Ŏw�肵���s�ԍ��̎Ј������P���擾����
            String[] record = fetch(index);

            //�擾���ʂ�null�̏ꍇ�A���[�v�𔲂���
            if (record == null) {
                break;
            }

            //�擾�����Ј�����MemberBean���쐬����
            //ArrayList�Ɋi�[����
            MemberBean mb = new MemberBean(record);
            list.add(mb);

            index++;
        }

        try {
            //�t�@�C���������݂̂��߂̃I�u�W�F�N�g���擾����
            FileWriter fw = new FileWriter(FILE_NAME, false);
            BufferedWriter bw = new BufferedWriter(fw);

            //ArrayList�ɂ���Ј��������o���āA������MemberBean��
            //�Ј��ԍ��Ɣ�r���A�������Ȃ��ꍇ�̂݁A�J���}�ŋ�؂���
            //�t�@�C���֏�������
            for (MemberBean mb : list) {
                if (!bean.getNo().equals(mb.getNo())) {
                    bw.write(
                            mb.getNo() + ","
                            + mb.getName() + ","
                            + mb.getBusho() + ","
                            + mb.getShikaku() + ","
                            + mb.getTokugi() + ","
                            + mb.getHobby() + ","
                            + mb.getHometown());
                    bw.newLine();
                }
            }
            bw.close();
            //�t�@�C���ɕύX���������̂ŁAisChanged�t���O��true�ɂ���B
            isChanged = true;

        } catch (FileNotFoundException ex) {
            System.out.println("�t�@�C���A�N�Z�X�Ɏ��s���܂����B");
            System.out.println("�A�v���P�[�V�������I�����܂��B");
            logger.error("�t�@�C���A�N�Z�X�Ɏ��s���܂����B"+ex.toString());
            logger.error("�A�v���P�[�V�������I�����܂��B");
           System.exit(0);
        } catch (IOException ex) {
            System.out.println("�t�@�C���A�N�Z�X�Ɏ��s���܂����B");
            System.out.println("�A�v���P�[�V�������I�����܂��B");
            logger.error("�t�@�C���A�N�Z�X�Ɏ��s���܂����B"+ex.toString());
            logger.error("�A�v���P�[�V�������I�����܂��B");
            System.exit(0);
        }
    }

    public static boolean isDuplicateKey(String no) {

        //�s�ԍ��̂P���Z�b�g����
        int index = 1;

        while (true) {
            //�����Ŏw�肵���s�ԍ��̎Ј������P���擾����B
            String[] record = fetch(index);

            //�擾�ł��Ȃ������ꍇ�Afalse��Ԃ�
            if (record == null) {
                return false;
            }

            //�擾�����Ј��ԍ��Ƃ��̃��\�b�h�Ŏw�肳�ꂽ������
            //��v����ꍇ�A�Ј��ԍ����d�����Ă���̂ŁAture��Ԃ�
            if (record[0].equals(no)) {
                return true;
            }
            index++;
        }

    }

    private static String[] fetch(int index) {
        // isChanged�t���O��true�̏ꍇ�ɂ́A
        // CSV�t�@�C������Ј������L���b�V�����Ȃ����B
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
                        //�L���b�V���X�V�����������̂ŁA
                        //isChanged�t���O��false�ɂ���
                        memberList.add(null);
                        isChanged = false;
                        //�t�@�C�����N���[�Y����
                        br.close();
                        break;
                    }

                    //�ǂݍ��񂾎Ј������J���}�ŋ�؂��Ĕz��Ɋi�[����
                    String[] record = line.split(",");
                    memberList.add(record);
                }
            } catch (FileNotFoundException ex) {
                System.out.println("�t�@�C���A�N�Z�X�Ɏ��s���܂����B");
                System.out.println("�A�v���P�[�V�������I�����܂��B");
                logger.error("�t�@�C���A�N�Z�X�Ɏ��s���܂����B"+ex.toString());
                logger.error("�A�v���P�[�V�������I�����܂��B");
                System.exit(0);
            } catch (IOException ex) {
                System.out.println("�t�@�C���A�N�Z�X�Ɏ��s���܂����B");
                System.out.println("�A�v���P�[�V�������I�����܂��B");
                logger.error("�t�@�C���A�N�Z�X�Ɏ��s���܂����B"+ex.toString());
                logger.error("�A�v���P�[�V�������I�����܂��B");
                System.exit(0);
            }
        }
        //�����Ŏw�肳�ꂽ�s�ԍ��̎Ј�����Ԃ��B
        return memberList.get(index - 1);
    }
}