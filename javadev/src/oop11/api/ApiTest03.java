package oop11.api;

import java.util.HashMap;
import java.util.Map;

public class ApiTest03 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("서인국", "010-1111-1111");
		map.put("정해인", "010-1111-2222");
		map.put("임시완", "010-1111-3333");
		map.put("안효섭", "010-1111-4444");

		// System.out.println(map.get("서인국"));

		// Iterator<String> iter = map.keySet().iterator();
		// while (iter.hasNext()) {
		// String key = iter.next();
		// System.out.println(key + " : " + map.get(key));
		// }

		for (String key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
	}
}
