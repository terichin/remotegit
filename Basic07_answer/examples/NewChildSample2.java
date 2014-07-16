class NewChildSample2 extends NewParentSample {
    void print() {
        System.out.println("サブクラス");
    }

    void oldprint() {
        super.print();
    }
}