import java.util.*;
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        StringTokenizer st = new StringTokenizer(sentence);
        StringBuilder sb = new StringBuilder();
        Collections.sort(dictionary, (a,b) -> Integer.compare(a.length(), b.length()));
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            String res = token;
            for (String dic : dictionary) {
                if (token.startsWith(dic)) {
                    res = dic;
                    break;
                }
            }
            sb.append(res).append(" ");
        }
        return sb.toString().trim();
    }
}