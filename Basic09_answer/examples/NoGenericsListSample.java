import java.util.*;

class NoGenericsListSample {
    public static void main(String[] args) {
        DTOSample dto1 = new DTOSample("�f�[�^��Y", 24);
        DTOSample dto2 = new DTOSample("���j�o�Ԏq", 23);
        ArrayList list = new ArrayList();
        list.add(dto1);
        list.add(dto2);
        
        String str = new String("Java�v���O���~���O��b");
        list.add(str);
        
        Integer intVal = new Integer(100);
        list.add(intVal);
    }
}