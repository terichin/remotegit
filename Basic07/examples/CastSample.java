class CastSample {
    public static void main(String[] args) {
        Dog obj1 = new Dog();
        Animal obj2 = obj1;     // �A�b�v�L���X�g
        Dog obj3 = (Dog)obj2;   // �_�E���L���X�g
    }
}