class OverLoadObject1 {
    // value�ϐ��� int�^�Œ�`����B
    int value;    
    // �R���X�g���N�^���`����B
    OverLoadObject1() {
        // value ��10��������B
        value =10;
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
}