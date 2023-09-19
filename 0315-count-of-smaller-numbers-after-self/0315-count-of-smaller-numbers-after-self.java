import java.util.*;
class Solution {
    int N;
    Node[] arr;
    int[] tree;
    int[] ans;
    public List<Integer> countSmaller(int[] nums) {
        N = nums.length;
        arr = new Node[N];
        ans = new int[N];
        tree = new int[4 * N];
        for (int i = 0; i < N; i++)
            arr[i] = new Node(i, nums[i]);
        Arrays.sort(arr, (a, b) -> a.val - b.val);
        for (int i = 0; i < N; i++) {
            ans[arr[i].idx] = query(1, 0, N - 1, arr[i].idx + 1, N - 1);
            update(1, 0, N - 1, arr[i].idx);
        }
        return Arrays.stream(ans).boxed().collect(Collectors.toList());
    }
    
    private void update(int node, int s, int e, int idx) {
        if (s > idx || e < idx) return;
        
        tree[node] += 1;
        if (s == e) return;
        
        int mid = (s + e) >> 1;
        update(node * 2, s, mid, idx);
        update(node * 2 + 1, mid + 1, e, idx);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
    
    private int query(int node, int s, int e, int l, int r) {
        if (s > r || e < l) return 0;
        
        if (s >= l && r >= e) return tree[node];
        
        int mid = (s + e) >> 1;
        int a = query(node * 2, s, mid, l, r);
        int b = query(node * 2 + 1, mid + 1, e, l, r);
        return a + b;
    }
    
    static class Node {
        int idx;
        int val;
        
        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}