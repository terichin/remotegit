class ConstructorObject2_2 {
    ConstructorObject2_2() {
        // �������Ȃ��R���X�g���N�^
    }
    
    // value�ϐ��� int�^�Œ�`����B
    int value;
    
    // setValue()���\�b�h�́Avoid�Ɛ錾��int�^����value1���󂯎��悤��`����B
    void setValue(int value1) {
        // value �� value1��������B
        value = value1;
    }

    // printValue()���\�b�h�́Avoid�ƒ�`����B
    void printValue() {
        // value ��\������B
        System.out.println(value);
    }
}