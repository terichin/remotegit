import java.util.HashMap;

public class HashMapSample {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("1ŒŽ", 31);
		map.put("3ŒŽ", 31);
		map.put("2ŒŽ", 28);
		map.put("4ŒŽ", 30);
		System.out.println("1ŒŽ=" +  map.get("1ŒŽ") + "“ú");
		System.out.println("2ŒŽ=" +  map.get("2ŒŽ") + "“ú");
		System.out.println("3ŒŽ=" +  map.get("3ŒŽ") + "“ú");
		System.out.println("4ŒŽ=" +  map.get("4ŒŽ") + "“ú");

	}

}
