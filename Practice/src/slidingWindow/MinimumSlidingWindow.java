package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumSlidingWindow {
	public static String minWindow(String s, String t) {
		int m = s.length(), n = t.length();
		Map<Character, Integer> mp = new HashMap<>();
		for (char c : t.toCharArray()) {
			mp.put(c, mp.getOrDefault(c, 0) + 1);
		}
		int ans = Integer.MAX_VALUE;
		int start = 0;

		int count = mp.size();
		int i = 0, j = 0;
		while (j < s.length()) {
			mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) - 1);
			if (mp.get(s.charAt(j)) == 0)
				count--;

			while (count == 0) {
				// ans is for ending point
				if (ans > j - i + 1) {
					ans = j - i + 1;
					start = i;
				}
				mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
				if (mp.get(s.charAt(i)) > 0)
					count++;

				i++;
			}
			j++;
		}
		if (ans != Integer.MAX_VALUE)
            return s.substring(start, start + ans);
        else
            return "";
	}

	public static void main(String[] args) {
		System.out.println(minWindow("OUZODYXAZV", "XYZ"));

	}

}
