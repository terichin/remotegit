class InsOfBadSample {
    public static void main(String[] args) {
        Animal obj = new Human();
        if (obj instanceof Animal) {
            // Animal�N���X�ł̏���
        } else if (obj instanceof Human) {
            Human human = (Human)obj;
            human.speak();
        } else {
            System.out.println("�l�ԈȊO�Ȃ̂Œ���܂���");
        }
    }
}