import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("T�V���c", 1000);
		map.put("Y�V���c", 3900);
		map.put("�|���V���c", 2900);
		Integer value = map.get("Y�V���c");
		System.out.println("Y�V���c�̒l�i��" + value + "�~�ł�");

	}

}
