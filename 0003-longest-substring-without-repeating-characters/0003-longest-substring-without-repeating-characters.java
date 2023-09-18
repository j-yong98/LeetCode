import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> checked = new HashMap<>();
            for (int i = 0; i < s.length(); i++)
                checked.put(s.charAt(i), -1);
            int len = 0;
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (checked.get(c) != -1) {
                    ans = Math.max(ans, len);
                    i = checked.get(c) + 1;
                    c = s.charAt(i);
                    for (char ch : checked.keySet())
                        checked.put(ch, -1);
                    len = 0;
                }
                len += 1;
                checked.put(c, i);
            }
            ans = Math.max(ans, len);
            return ans;
    }
}