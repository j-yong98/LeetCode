int max(int a, int b) {
    return a > b ? a : b;
}
int findMaxK(int* nums, int numsSize) {
    int ans = -1;
    int check[1001] = {0,};

    for (int i = 0; i < numsSize; i++) {
        if (nums[i] < 0) continue;
        check[nums[i]]++;
    }

    for (int i = 0; i < numsSize; i++) {
        if (nums[i] > 0) continue;
        int target = nums[i] * -1;
        if (check[target]) {
            ans = max(ans, target);
        }
    }
    return ans;
}