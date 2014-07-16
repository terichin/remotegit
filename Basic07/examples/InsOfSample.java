class InsOfSample {
    public static void main(String[] args) {
        Animal obj = new Dog();
        if (obj instanceof Dog) {
            System.out.println("‚±‚ê‚ÍDog‚Å‚·");
        } else if (obj instanceof Cat) {
            System.out.println("‚±‚ê‚ÍCat‚Å‚·");
        } else {
            System.out.println("‚±‚ê‚ÍAnimal‚Å‚·");
        }
    }
}