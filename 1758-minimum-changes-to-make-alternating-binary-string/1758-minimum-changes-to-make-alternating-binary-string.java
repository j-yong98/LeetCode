import java.util.*;
class Solution {
    public int minOperations(String s) {
        char[] chars = s.toCharArray();
        int min = Integer.MAX_VALUE;
        min = Math.min(min, change(s.toCharArray(), '0'));
        min = Math.min(min, change(s.toCharArray(), '1'));
        return min;
    }
    
    private int reverseNumber(char c) {
        int n = c - '0';
        return n ^ 1;
    }
    
    private int change(char[] chars, char start) {
        int cnt = 0;
        if (chars[0] != start) {
            chars[0] = start;
            cnt = 1;
        }
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                chars[i] = (char) (reverseNumber(chars[i]) + '0');
                cnt += 1;
            }
        }
        return cnt;
    }
}