import java.util.*;

class IteratorSample {
    public static void main(String[] args) {
        DTOSample dto1 = new DTOSample("�f�[�^��Y", 24);
        DTOSample dto2 = new DTOSample("���j�o�Ԏq", 23);
        ArrayList<DTOSample> list = new ArrayList<DTOSample>();
        list.add(dto1);
        list.add(dto2);
        print(list);
    }
    
    public static void print(ArrayList<DTOSample> list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            DTOSample obj = (DTOSample) iterator.next();
            String name = obj.getName();
            int age = obj.getAge();
            System.out.println(name);
            System.out.println(age);
        }
    }
}