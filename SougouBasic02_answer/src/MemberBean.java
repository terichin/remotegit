/*
 * �Ј�����ێ�����N���X
 */
public class MemberBean {

    private String no;       //�Ј��ԍ���ێ�����t�B�[���h
    private String name;     //�Ј�����ێ�����t�B�[���h
    private String busho;    //������ێ�����t�B�[���h
    private String shikaku;  //���i��ێ�����t�B�[���h
    private String tokugi;   //���Z��ێ�����t�B�[���h
    private String hobby;    //���ێ�����t�B�[���h
    private String hometown; //�o�g��ێ�����t�B�[���h

    public MemberBean() {
    }

    //�����̔z��v�f���e�t�B�[���h�ɃZ�b�g����R���X�g���N�^
    public MemberBean(String[] array) {
        this.no = array[0];
        this.name = array[1];
        this.busho = array[2];
        this.shikaku = array[3];
        this.tokugi = array[4];
        this.hobby = array[5];
        this.hometown = array[6];
    }

    //�e�t�B�[���h�̃A�N�Z�b�T
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