class PersonLeader { 
    String call(String n) { 
        Person p = new Person(n);
        p.sayHello(); 
        return "Success"; 
    } 
}