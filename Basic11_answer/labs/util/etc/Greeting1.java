// パッケージ宣言
// このソースに書かれているクラスはutil.etcパッケージに属する
package util.etc;

// 別のパッケージのクラスから使用するのでpublic宣言が必要
public class Greeting1 {
    //  別のパッケージのクラスから使用するのでpublic宣言が必要
    public void sayHello() {
        // 「こんにちは」を表示
        System.out.println("こんにちは");
    }
}