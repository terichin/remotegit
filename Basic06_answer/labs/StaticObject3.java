class StaticObject3 {
    // �@�\�𐧌䂷��ׂ̃����o�ϐ�
    static int function = 0;
    // �v�Z���s�����߂̃��\�b�h
    static int calc(int num1, int num2) {
        if (function == 0) {
            return num1 + num2;
        }
        // �ȉ���else���ɓ���Ă��ǂ��B
        return num1 * num2;
    }
}