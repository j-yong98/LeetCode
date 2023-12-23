import java.util.*;
class Solution {
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    Set<Node> set = new HashSet<>();
    public boolean isPathCrossing(String path) {
        Node start = new Node(0, 0);
        set.add(start);
        for (int i = 0; i < path.length(); i++) {
            int dir = getDir(path.charAt(i));
            int y = start.y + dy[dir];
            int x = start.x + dx[dir];
            Node next = new Node(y, x);
            if (set.contains(next)) return true;
            set.add(next);
            start = next;
        }
        return false;
    }
    
    private int getDir(char c) {
        if (c == 'N') {
            return 0;
        }
        if (c == 'S') {
            return 1;
        }
        if (c == 'W') {
            return 2;
        }
        return 3;
    }
    
    static class Node {
        int y;
        int x;
        
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return this.y == node.y && this.x == node.x;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
}