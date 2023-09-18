class NumArray {
    int N;
    int[] tree;

    public NumArray(int[] nums) {
        N = nums.length;
        tree = new int[4 * nums.length];
        init(1, 0, nums.length - 1, nums);
    }
    
    private int init(int node, int s, int e, int[] arr) {
        if (s == e) return tree[node] = arr[s];
        
        int mid = (s + e) >> 1;
        int a = init(node * 2, s, mid, arr);
        int b = init(node * 2 + 1, mid + 1, e, arr);
        return tree[node] = a + b;
    }
    
    public void update(int index, int val) {
        update(1, 0, N - 1, index, val);
    }
    
    private void update(int node, int s, int e, int idx, int val) {
        if (s > idx || e < idx) return;
        
        if (s == e) {
            tree[node] = val;
            return;
        }
        
        int mid = (s + e) >> 1;
        update(node * 2, s, mid, idx, val);
        update(node * 2 + 1, mid + 1, e, idx, val);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
    
    public int sumRange(int left, int right) {
        return query(1, 0, N - 1, left, right);
    }
    
    private int query(int node, int s, int e, int l, int r) {
        if (s > r || e < l) return 0;
        
        if (s >= l && r >= e) return tree[node];
        
        int mid = (s + e) >> 1;
        int a = query(node * 2, s, mid, l, r);
        int b = query(node * 2 + 1, mid + 1, e, l, r);
        return a + b;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */