import java.util.HashMap;

public class HashMapSample {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("1��", 31);
		map.put("3��", 31);
		map.put("2��", 28);
		map.put("4��", 30);
		System.out.println("1��=" +  map.get("1��") + "��");
		System.out.println("2��=" +  map.get("2��") + "��");
		System.out.println("3��=" +  map.get("3��") + "��");
		System.out.println("4��=" +  map.get("4��") + "��");

	}

}
