class InsOfSample2 {
    public static void main(String[] args) {
        Animal obj = new Human();
        if (obj instanceof Human) {
            Human human = (Human)obj;
            human.speak();
        } else {
            System.out.println("人間以外なので喋りません");
        }
    }
}