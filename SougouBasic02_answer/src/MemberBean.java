/*
 * 社員情報を保持するクラス
 */
public class MemberBean {

    private String no;       //社員番号を保持するフィールド
    private String name;     //社員名を保持するフィールド
    private String busho;    //部署を保持するフィールド
    private String shikaku;  //資格を保持するフィールド
    private String tokugi;   //特技を保持するフィールド
    private String hobby;    //趣味を保持するフィールド
    private String hometown; //出身を保持するフィールド

    public MemberBean() {
    }

    //引数の配列要素を各フィールドにセットするコンストラクタ
    public MemberBean(String[] array) {
        this.no = array[0];
        this.name = array[1];
        this.busho = array[2];
        this.shikaku = array[3];
        this.tokugi = array[4];
        this.hobby = array[5];
        this.hometown = array[6];
    }

    //各フィールドのアクセッサ
    public String getNo() {
        return no;
    }

    public void setNo(String value) {
        this.no = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getBusho() {
        return busho;
    }

    public void setBusho(String value) {
        this.busho = value;
    }

    public String getShikaku() {
        return shikaku;
    }

    public void setShikaku(String value) {
        this.shikaku = value;
    }

    public String getTokugi() {
        return tokugi;
    }

    public void setTokugi(String value) {
        this.tokugi = value;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String value) {
        this.hobby = value;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String value) {
        this.hometown = value;
    }
}