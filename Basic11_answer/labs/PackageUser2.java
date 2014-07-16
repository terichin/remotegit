// 別パッケージのGreeting2を使うのでimport宣言が必要
import util.etc.Greeting2;

class PackageUser2 {
    public static void main(String[] args) {
        // importしていないクラスは完全修飾名で利用できる
        util.etc.Greeting1 obj1 = new util.etc.Greeting1();
        // import宣言しているクラスを利用
        Greeting2 obj2 = new Greeting2();
        
        // インスタンスのメソッド呼び出し
        obj1.sayHello();
        obj2.sayHello();
    }
}