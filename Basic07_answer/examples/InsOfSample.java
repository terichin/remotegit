class InsOfSample {
    public static void main(String[] args) {
        Animal obj = new Dog();
        if (obj instanceof Dog) {
            System.out.println("これはDogです");
        } else if (obj instanceof Cat) {
            System.out.println("これはCatです");
        } else {
            System.out.println("これはAnimalです");
        }
    }
}