// ����̗�O�N���X(Exception���p�����č쐬)
class MyException extends Exception {
    void printErrorMessage() {
        // �G���[���b�Z�[�W�̕\��
        System.out.println("�G���[���������܂����B");
    }
    
    // ��b���10-5�̒ǉ����\�b�h
    void printMessage() {
        // �G���[���b�Z�[�W�̕\��
        System.out.println("0�ȊO�̐��l��1���͂��Ă��������B");
    }
}