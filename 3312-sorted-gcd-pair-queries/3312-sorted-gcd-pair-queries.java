class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            m = Math.max(m, nums[i]);
        }
        long[] cnt = new long[m + 1];

        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = i * 2; j <= m; j+=i) {
                cnt[i] += cnt[j];
            }
        }

        for (int i = 1; i <= m; i++) {
            cnt[i] = (cnt[i] * (cnt[i] - 1)) / 2;
        }

        for (int i = m; i >= 1; i--) {
            for (int j = i * 2; j <= m; j+=i) {
                cnt[i] -= cnt[j];
            }
        }
        for (int i = 1; i <= m; i++) {
            cnt[i] += cnt[i - 1];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long q = queries[i] + 1;
            int l = 1;
            int r = m;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (cnt[mid] >= q) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            ans[i] = l;
        }
        return ans;
    }
}