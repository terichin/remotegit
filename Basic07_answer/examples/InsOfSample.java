class InsOfSample {
    public static void main(String[] args) {
        Animal obj = new Dog();
        if (obj instanceof Dog) {
            System.out.println("�����Dog�ł�");
        } else if (obj instanceof Cat) {
            System.out.println("�����Cat�ł�");
        } else {
            System.out.println("�����Animal�ł�");
        }
    }
}