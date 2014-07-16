class PersonManager {
    static String name; 

    public static void main(String[] args) {
        name="Bob";
        PersonLeader leader = new PersonLeader();
        String result = leader.call(name);
        printResult(result); 
    } 
    static void printResult(String msg) {
        System.out.println("Result is "+msg);
    }
}