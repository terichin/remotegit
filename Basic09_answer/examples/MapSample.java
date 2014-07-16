import java.util.*;

class MapSample {
    public static void main(String[] args) {
        DTOSample dto1 = new DTOSample("�f�[�^��Y", 24);
        DTOSample dto2 = new DTOSample("���j�o�Ԏq", 23);
        HashMap<String, DTOSample> map = new HashMap<String, DTOSample>();
        map.put("id1", dto1);
        map.put("id2", dto2);
        print(map);
    }
    
    public static void print(HashMap<String, DTOSample> map) {
        DTOSample dto1 = map.get("id1");
        DTOSample dto2 = map.get("id2");
        System.out.println("id1�̖��O�́A" + dto1.getName() + "�ł�");
        System.out.println("id1�̔N��́A" + dto1.getAge() + "�ł�");
        System.out.println("id2�̖��O�́A" + dto2.getName() + "�ł�");
        System.out.println("id2�̔N��́A" + dto2.getAge() + "�ł�");
    }
}