class SeqSample {
    public static void main(String[] args) {
        Person person = new Person("John"); 
        person.sayHello();
        printHello();
    }
    
    static void printHello() {
        System.out.println("Hello!"); // この仕様はシーケンス図には含まれていない
    }
}