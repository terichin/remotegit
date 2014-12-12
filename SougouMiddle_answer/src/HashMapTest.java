import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("Tシャツ", 1000);
		map.put("Yシャツ", 3900);
		map.put("ポロシャツ", 2900);
		Integer value = map.get("Yシャツ");
		System.out.println("Yシャツの値段は" + value + "円です");

	}

}
