class OverLoadObject2 {
    // value�ϐ��� int�^�Œ�`����B
    int value;
    // �R���X�g���N�^���`����B
    OverLoadObject2() {
        // value ��10��������B
        value =10;
    }
    // �R���X�g���N�^�́Aint�^����value1���󂯎��悤��`����B
    OverLoadObject2(int value1) {
        // value �� value1��������B
        value = value1;
    }
    // �R���X�g���N�^�́Aint�^����value1��int�^����value2���󂯎��悤��`����B
    OverLoadObject2(int value1, int value2) {
        // value �� value1 �� value2 �̐ς�������B
        value = value1 * value2;
    }
    // printValue()���\�b�h�́Avoid�ƒ�`����B    
    void printValue(){
        // value ��\������B
        System.out.println(value);
    }
    // printValue()���\�b�h�́Avoid�Ɛ錾��String�^����msg1���󂯎��悤��`����B
    void printValue(String msg1){
        // msg1 �� value ��A�����ĕ\������B
        System.out.println(msg1 + value);
    }
    // printValue()���\�b�h�́Avoid�Ɛ錾��
    // String�^����msg1��String�^����msg2���󂯎��悤��`����B
    void printValue(String msg1, String msg2){
        // msg1 �� value �� msg2 ��A�����ĕ\������B
        System.out.println(msg1 + value + msg2);
    }
}