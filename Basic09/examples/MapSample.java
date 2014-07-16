import java.util.*;

class MapSample {
    public static void main(String[] args) {
        DTOSample dto1 = new DTOSample("データ一郎", 24);
        DTOSample dto2 = new DTOSample("ユニバ花子", 23);
        HashMap<String, DTOSample> map = new HashMap<String, DTOSample>();
        map.put("id1", dto1);
        map.put("id2", dto2);
        print(map);
    }
    
    public static void print(HashMap<String, DTOSample> map) {
        DTOSample dto1 = map.get("id1");
        DTOSample dto2 = map.get("id2");
        System.out.println("id1の名前は、" + dto1.getName() + "です");
        System.out.println("id1の年齢は、" + dto1.getAge() + "です");
        System.out.println("id2の名前は、" + dto2.getName() + "です");
        System.out.println("id2の年齢は、" + dto2.getAge() + "です");
    }
}