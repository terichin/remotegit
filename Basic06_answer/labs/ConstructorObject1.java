class ConstructorObject1 {
    // value�ϐ��� int�^�Œ�`����B
    int value;
    
    // �R���X�g���N�^�́Aint�^����value1���󂯎��悤��`����B
    ConstructorObject1(int value1) {
        // value �� value1��������B
        value = value1;
    }

    // printValue()���\�b�h�́Avoid�ƒ�`����B
    void printValue() {
        // value ��\������B
        System.out.println(value);
    }
}