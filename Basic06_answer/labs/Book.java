class Book {
    // number変数は static int 型で定義する。
    static int number = 1;
    
    // id変数は int 型で定義する。
    int id;
    
    // name変数は String 型で定義する。
    String name;
    
    // author変数は String 型で定義する。
    String author;

    // コンストラクタを定義する。引数は、String型 title, String型 author とする。
    Book(String title, String author) {
        // this を用いてコンストラクタを呼ぶ。引数は number++, title, author とする。
        this(number++, title, author);
    }
    
    // コンストラクタを定義する。
    // 引数は、int型 id, String型 title, String型 author とする。
    Book(int id, String title, String author) {
        // 各引数値をメンバ変数に代入する。
        this.id= id;
        this.name = title;
        this.author = author;
    }

    // inform()メソッドは、voidと定義する。
    void inform(){
        // Id=id :name :作者 author と表示する。
        System.out.println("Id=" + id + " :" + name + " :作者 " + author );
    }
}