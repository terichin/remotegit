class Book {
    // number�ϐ��� static int �^�Œ�`����B
    static int number = 1;
    
    // id�ϐ��� int �^�Œ�`����B
    int id;
    
    // name�ϐ��� String �^�Œ�`����B
    String name;
    
    // author�ϐ��� String �^�Œ�`����B
    String author;

    // �R���X�g���N�^���`����B�����́AString�^ title, String�^ author �Ƃ���B
    Book(String title, String author) {
        // this ��p���ăR���X�g���N�^���ĂԁB������ number++, title, author �Ƃ���B
        this(number++, title, author);
    }
    
    // �R���X�g���N�^���`����B
    // �����́Aint�^ id, String�^ title, String�^ author �Ƃ���B
    Book(int id, String title, String author) {
        // �e�����l�������o�ϐ��ɑ������B
        this.id= id;
        this.name = title;
        this.author = author;
    }

    // inform()���\�b�h�́Avoid�ƒ�`����B
    void inform(){
        // Id=id :name :��� author �ƕ\������B
        System.out.println("Id=" + id + " :" + name + " :��� " + author );
    }
}