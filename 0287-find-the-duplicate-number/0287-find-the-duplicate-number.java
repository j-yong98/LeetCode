class Solution {
    final int MAX = 100_000;
    public int findDuplicate(int[] nums) {
        boolean[] cnt = new boolean[MAX + 1];
        for (int i = 0; i < nums.length; i++) {
            if (cnt[nums[i]]) return nums[i];
            cnt[nums[i]] = true;
        }
        return -1;
    }
}