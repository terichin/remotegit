class ImplementObject1 implements InterfaceObject1 {
    // rate�ϐ��́Adouble�^��0.20�ŏ���������悤��`����B
    double rate = 0.20;

    // getRate()���\�b�h�� double�ƒ�`����B
    public double getRate() {
        // rate ��Ԃ�
        return rate;
    }

    // printRate()���\�b�h�� void �ƒ�`����B
    void printRate() {
        // rate ��\������B
        System.out.println(rate);
    }

    // calculate()���\�b�h�́A
    // double �Ɛ錾��int�^����value���󂯎��悤��`����
    public double calculate(int value) {
        // value �� getRate() �̏�Z���ʂ�Ԃ��B
        return value * getRate();
    }
}