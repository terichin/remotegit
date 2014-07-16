// CSV�`���̃t�@�C������f�[�^��ǂݍ��݁A���`���ĕ\������v���O����
// �g�p����N���X��import�錾
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

class CsvViewer {
    public static void main(String[] args) {
        try {
            // FileReader��BufferedReader�Ńt�@�C������̃f�[�^��ǂݍ���
            FileReader fr = new FileReader("C:\\sample.csv");
            BufferedReader br =new BufferedReader(fr);
            
            // �t�@�C������S�Ẵf�[�^��ǂݍ���
            while(true) {
                // readLine��1�s�ǂݍ���
                String line = br.readLine();
                // �t�@�C���̍Ōォ�ǂ����𔻒肷��
                if (line == null) {
                    // �t�@�C���̍Ō�̏ꍇ�͏����I��
                    break;
                }
                
                // �ǂݍ���1�s�̕�������J���}(,)�ŕ���
                StringTokenizer st = new StringTokenizer(line, ",");
                
                // �J���}�ŋ�؂���������v�f�̃��[�v
                while(st.hasMoreTokens()) {
                    // �v�f���擾���ĕ\���B�^�u�ŋ�؂�B
                    System.out.print(st.nextToken() + "\t");
                }
                // 1�s�̕\���̍Ō�ɉ��s����
                System.out.println();
            }
            // �J�����t�@�C�������
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            // �w�肵���t�@�C���������ꍇ
            e.printStackTrace();
        } catch (IOException e) {
            // ���̓G���[�̏ꍇ
            e.printStackTrace();
        }
    }
}