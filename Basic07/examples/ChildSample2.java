class ChildSample2 extends ParentSample {
    void printChild() {
        //以下はスーパークラスのメンバを使用している
        printParent();
        System.out.println(num1);
    }
}