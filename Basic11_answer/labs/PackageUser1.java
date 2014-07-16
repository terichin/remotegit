// 別パッケージのGreeting1を使うのでimport宣言が必要
import util.etc.Greeting1;

class PackageUser1 {
    public static void main(String[] args) {
        // import宣言しているクラスを利用
        Greeting1 obj = new Greeting1();
        // インスタンスのメソッド呼び出し
        obj.sayHello();
    }
}