class Solution {
    int[] a = new int[26];
    int[] b = new int[26];
    public char findTheDifference(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            a[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            b[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i])
                return (char) (i + 'a');
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        return 'z' + 1;
    }
}