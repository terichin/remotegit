import java.util.HashMap;

public class HashMapSample {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("1月", 31);
		map.put("3月", 31);
		map.put("2月", 28);
		map.put("4月", 30);
		System.out.println("1月=" +  map.get("1月") + "日");
		System.out.println("2月=" +  map.get("2月") + "日");
		System.out.println("3月=" +  map.get("3月") + "日");
		System.out.println("4月=" +  map.get("4月") + "日");

	}

}
