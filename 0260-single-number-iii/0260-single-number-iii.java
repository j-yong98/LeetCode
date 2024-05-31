import java.util.*;
class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        for (int key : cnt.keySet()) {
            if (cnt.get(key) == 1) {
                list.add(key);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}