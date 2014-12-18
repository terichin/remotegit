import java.util.HashMap;

class Information {
    public static void main(String[] args) {
        // �K�v�ȏ����쐬����B
        MemberDTO member1 = new MemberDTO("�f�[�^��Y", 24);
        MemberDTO member2 = new MemberDTO("���j�o�Ԏq", 23);
        BookDTO book = new BookDTO("Java�v���O���~���O��b", 3000);

        // Hashmap���쐬����B
        HashMap map = new HashMap();

        // ����o�^����B
        map.put("id1", member1);
        map.put("id2", member2);
        map.put("bk1", book);
        map.put("ken1", "Java�v���O���~���O��b");
        

        // �e�����\������B
        print(map);
    }

    public static void print(HashMap map) {
        // Hashmap��������擾����B
        MemberDTO mdto1 = (MemberDTO) map.get("id1");
        MemberDTO mdto2 = (MemberDTO) map.get("id2");
        BookDTO bdto1 = (BookDTO) map.get("bk1");
        String ken1 = (String) map.get("ken1");

        // �\������B
        System.out.println("id1�̖��O�́A" + mdto1.getName() + "�ł��B");
        System.out.println("id1�̔N��́A" + mdto1.getAge() + "�ł��B");
        System.out.println("id1�́A" + bdto1.getBookName() 
                                    + "���w�����܂����B���i�́A"
                                    + bdto1.getPrice()
                                    + "�~�ł��B");
    	System.out.println("id1�́A" + ken1 + "����u���܂����B");
        System.out.println("id2�̖��O�́A" + mdto2.getName() + "�ł��B");
        System.out.println("id2�̔N��́A" + mdto2.getAge() + "�ł��B");

    }
}