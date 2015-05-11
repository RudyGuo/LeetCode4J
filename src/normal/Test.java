package normal;

import java.util.HashMap;
import java.util.Map;

class Key {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + val;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Key other = (Key) obj;
		if (val != other.val)
			return false;
		return true;
	}

	int val;

}

public class Test {
	public static void main(String args[]) {
		Map<Key, String> map = new HashMap<>();
		Map<String, String> map1 = new HashMap<>();
		Key key1 = new Key();
		Key key2 = new Key();
		map.put(key1, "1");
		map.put(key2, "2");
		System.out.println(map.get(key1));
	}

}
