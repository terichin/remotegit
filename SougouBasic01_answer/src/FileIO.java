import java.io.*;

class FileIO{
	public static void main(String args[]){
		try {
			//�t�@�C���������݂̂��߂̃I�u�W�F�N�g���擾����
			FileWriter fw = new FileWriter("greeting.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			//�f�[�^�ƍŌ�ɉ��s�L������������
			bw.write("����ɂ���I���j�o��Y����I");
			bw.newLine();
			//�t�@�C���������݂����������̂ŁA�t�@�C�����N���[�Y����
			bw.close();
			
			//�t�@�C���ǂݍ��݂̂��߂̃I�u�W�F�N�g���擾����
			FileReader fr = new FileReader("greeting.txt");
			BufferedReader br = new BufferedReader(fr);
			//���s�܂ł̈�s��ǂݍ���
			String input = br.readLine();
			//�t�@�C���ǂݍ��݂����������̂ŁA�t�@�C�����N���[�Y����
			br.close();
			
			System.out.println("�ǂݍ��񂾃f�[�^�́A" + input + "�ł��B");
		} catch(IOException ex) {
			System.out.println("�t�@�C���A�N�Z�X�Ɏ��s���܂����B");
			System.out.println("�A�v���P�[�V�������I�����܂��B");
			System.exit(0);
		}
	}
}