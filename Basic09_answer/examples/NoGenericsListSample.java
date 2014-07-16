import java.util.*;

class NoGenericsListSample {
    public static void main(String[] args) {
        DTOSample dto1 = new DTOSample("データ一郎", 24);
        DTOSample dto2 = new DTOSample("ユニバ花子", 23);
        ArrayList list = new ArrayList();
        list.add(dto1);
        list.add(dto2);
        
        String str = new String("Javaプログラミング基礎");
        list.add(str);
        
        Integer intVal = new Integer(100);
        list.add(intVal);
    }
}