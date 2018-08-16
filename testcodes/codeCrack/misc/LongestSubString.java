package misc;

import java.util.HashMap;

public class LongestSubString {

	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		int max = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0;
		int windowSize = 1;
		int windowStart = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}

			if (map.size() > 2) {
				System.out.println("i = " + i);
				// System.out.println("Start = "+start);
				max = Math.max(max, i - start);
				System.out.println("max = " + max);
				while (map.size() > 2) {

					char t = s.charAt(start);
					int count = map.get(t);
					if (count > 1) {
						map.put(t, count - 1);
					} else {
						map.remove(t);
					}
					if (start < max) {
						System.out.println("******printing sub string*****" + s.substring(start, max + 1));
					}
					start++;
					System.out.println("printing start " + start);
				}
			}

		}
		max = Math.max(max, s.length() - start);
		return max;
	}

	public static void main(String[] args) {
		int returnedLength = lengthOfLongestSubstringTwoDistinct("abcbbbbcccbdddadacb");
		System.out.println("*****lengthe is ********" + returnedLength);
	}

}
