import java.io.*;

// �W�����́i�L�[�{�[�h�j������͂��ꂽ�f�[�^��\������v���O����
class StdIO{
    public static void main(String args[]){
    	// BuffredReader�^�̕ϐ���錾
    	BufferedReader br = null;
    	try{
    		// �W�����́i�L�[�{�[�h�j������̓f�[�^���󂯕t���邽�߂̃C���X�^���X�𐶐�
    		br = new BufferedReader(new InputStreamReader(System.in));
    		// �������[�v
    		while(true){
    			// ���͂𑣂�
    			System.out.print("Please Input Data > ");
    			// Enter�L�[���������܂ł̓��̓f�[�^�𕶎���Ƃ��ēǂݍ���
    			String input = br.readLine();
    			System.out.println("Inputed data : " + input);
    		}
    	} catch (IOException e){
    		System.out.println("���o�̓G���[���������܂���");
    	} finally{
    		// �ʏ�͓��o�͂Ɏg�p�����t�@�C�����N���[�Y���鏈�����K�v
    	}
    }
}
