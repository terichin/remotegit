class Person {
    String name = "Tom";
    
    Person(String name){
        this.name = name;
    }
    void sayHello() {
        System.out.println("Hello I'm " + name );
    }
}