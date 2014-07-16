class UseSample {
    public static void main(String[] args) {
        ChildSample obj = new ChildSample();
        System.out.println(obj.num1);
        obj.printParent();
        System.out.println(obj.num2);
        obj.printChild();
    }
}