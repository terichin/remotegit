class InsSample { 
    public static void main(String[] args) {
        int a = 10;
        int b = a;
        b = 20;
        System.out.println(a);
        System.out.println(b);

        ObjSample obj1 = new ObjSample();
        obj1.number = 10;
        ObjSample obj2 = obj1;
        obj2.number = 20;
        obj1.print();
        obj2.print(); 
    }
}