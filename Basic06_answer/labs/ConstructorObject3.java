class ConstructorObject3 {
    // �@�\�𐧌䂷��ׂ̃����o�ϐ�
    int function = 0;
    // �R���X�g���N�^
    ConstructorObject3(int function) {
    	this.function = function;
    }
    // �v�Z���s�����߂̃��\�b�h
    int calc(int num1, int num2) {
    	if (function == 0) {
    		return num1 + num2;
    	}
    	// �ȉ���else���ɓ���Ă��ǂ��B
    	return num1 * num2;
    }
}