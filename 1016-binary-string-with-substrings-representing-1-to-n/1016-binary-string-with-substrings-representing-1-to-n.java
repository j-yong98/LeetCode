class Solution {
    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            if (!s.contains(toBinary(i))) {
                return false;
            }
        }
        return true;
    }
    
    private String toBinary(int num) {
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        while ((1 << cur) <= num) {
            if ((num & (1 << cur)) != 0) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            cur++;
        }
        return sb.reverse().toString();
    }
}