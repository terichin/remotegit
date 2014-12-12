import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import basicws.entity.MemberBean;
import basicws.util.CsvDao;
import basicws.util.InputUtility;

public class CsvDaoTest {

    private static final String FILE_NAME = "member.csv";

    public static void main(String[] args) {

        // test#16-29

        // search���\�b�h�ɓn��������
        int[] test_16_29_arg1 = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7};

        // search���\�b�h�ɓn��������
        String[] test_16_29_arg2 = {
            "12", "123", "�c��", "���", "�J����",
            "������", "��{��񏈗�", "����΂񌟒�", "�}�[�W����", "���j��H",
            "�Ǐ�", "�f��ӏ�", "��������", "�k�C��"
        };
        for (int i = 0; i < test_16_29_arg1.length; i++) {
            System.out.println("** test#" + (i + 16) + " **");
            ArrayList<MemberBean> list = CsvDao.search(test_16_29_arg1[i], test_16_29_arg2[i]);
            for (MemberBean m : list) {
                callGetter(m);
            }
            System.out.println("------------------------------------------");
        }

        // test#30-36

        // searchById���\�b�h�ɓn������
        String[] test_30_36_arg = {
            "0000011", "0000012", "0000013", "0000014", "0000015", "0000123", "11"
        };
        for (int i = 0; i < test_30_36_arg.length; i++) {
            System.out.println("** test#" + (i + 30) + " **");
            MemberBean mb = CsvDao.searchById(test_30_36_arg[i]);
            callGetter(mb);
            System.out.println("------------------------------------------");
        }

        // test#37
        System.out.println("** test#37 **");
        String[] test37_arg = {"0000017", "�O�����", "������", "�p��1��", "��֎�", "�h���C�u", "���R��"};
        MemberBean mb37 = new MemberBean(test37_arg);
        CsvDao.insert(mb37);
        printCsv();
        System.out.println("------------------------------------------");

        // test#38
        System.out.println("** test#38 **");
        String[] test38_arg = {"0000017", "�O�����", "������", "�p��1��", "��֎�", "�h���C�u", "���R��"};
        MemberBean mb38 = new MemberBean(test38_arg);
        CsvDao.insert(mb38);
        printCsv();
        System.out.println("------------------------------------------");

        // test#39
        System.out.println("** test#39 **");
        String[] test39_arg = {"0000099", "�O�����", "�c�ƕ�", "�p��1��", "��֎�", "�h���C�u", "���R��"};
        MemberBean mb39 = new MemberBean(test39_arg);
        CsvDao.update(mb39);
        printCsv();
        System.out.println("------------------------------------------");

        // test#40
        System.out.println("** test#40 **");
        String[] test40_arg = {"0000017", "�O�����", "�c�ƕ�", "�p��1��", "��֎�", "�h���C�u", "���R��"};
        MemberBean mb40 = new MemberBean(test40_arg);
        CsvDao.update(mb40);
        printCsv();
        System.out.println("------------------------------------------");

        // test#41
        System.out.println("** test#41 **");
        String[] test41_arg = {"0000099", "�O�����", "�c�ƕ�", "�p��1��", "��֎�", "�h���C�u", "���R��"};
        MemberBean mb41 = new MemberBean(test41_arg);
        CsvDao.delete(mb41);// test#39�őΏۂƂ������R�[�h���폜����
        printCsv();
        System.out.println("------------------------------------------");

        // test#42
        System.out.println("** test#42 **");
        String[] test42_arg = {"0000017", "�O�����", "�c�ƕ�", "�p��1��", "��֎�", "�h���C�u", "���R��"};
        MemberBean mb42 = new MemberBean(test42_arg);
        CsvDao.delete(mb42);// test#40�őΏۂƂ������R�[�h���폜����
        printCsv();
        System.out.println("------------------------------------------");

        // test#43
        System.out.println("** test#43 **");
        System.out.println(CsvDao.isDuplicateKey("0000018"));
        System.out.println("------------------------------------------");

        // test#44
        System.out.println("** test#44 **");
        System.out.println(CsvDao.isDuplicateKey("0000015"));
        System.out.println("------------------------------------------");

    }

    private static void callGetter(MemberBean mb) {
        if (mb == null) {
            System.out.println("null");
        } else {
            System.out.print(mb.getNo() + ",");
            System.out.print(mb.getName() + ",");
            System.out.print(mb.getBusho() + ",");
            System.out.print(mb.getShikaku() + ",");
            System.out.print(mb.getTokugi() + ",");
            System.out.print(mb.getHobby() + ",");
            System.out.print(mb.getHometown());
            System.out.println();
        }
    }

    private static void printCsv() {

        try {
            FileReader fr = new FileReader(FILE_NAME);
            BufferedReader br = new BufferedReader(fr);

            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }

                System.out.println(line);
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}