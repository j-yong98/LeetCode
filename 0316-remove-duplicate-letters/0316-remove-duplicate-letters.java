import java.util.*;
class Solution {
    Stack<Character> stack = new Stack<>();
    int[] cnt = new int[26];
    boolean[] alpha = new boolean[26];
    public String removeDuplicateLetters(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (alpha[c - 'a']) {
                cnt[c - 'a']--;
                continue;
            }
            System.out.println(Arrays.toString(cnt));
            while (!stack.isEmpty() && stack.peek() > c && cnt[stack.peek() - 'a'] > 0)
                alpha[stack.pop() - 'a'] = false;
            stack.push(c);
            alpha[c - 'a'] = true;
            cnt[c - 'a']--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();
        System.out.println(sb);
        return sb.toString();
    }
}