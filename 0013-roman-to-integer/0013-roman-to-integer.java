class Solution {
    Map<Character, Integer> map = new HashMap<>();
    public Solution() {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
    public int romanToInt(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int res = map.get(c);
            if (i < s.length() - 1) {
                char next = s.charAt(i + 1);
                if (c == 'I' && (next == 'V' || next == 'X')) {
                    res = map.get(next) - map.get(c);
                    i++;
                }
                else if (c == 'X' && (next == 'L' || next == 'C')) {
                    res = map.get(next) - map.get(c);
                    i++;
                }
                else if (c == 'C' && (next == 'D' || next == 'M')) {
                    res = map.get(next) - map.get(c);
                    i++;
                }
            }
            ans += res;
        }
        return ans;
    }
}