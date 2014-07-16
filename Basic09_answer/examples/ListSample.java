import java.util.*;

class ListSample {
    public static void main(String[] args) {
        DTOSample dto1 = new DTOSample("データ一郎", 24);
        DTOSample dto2 = new DTOSample("ユニバ花子", 23);
        ArrayList<DTOSample> list = new ArrayList<DTOSample>();
        list.add(dto1);
        list.add(dto2);
    }
}