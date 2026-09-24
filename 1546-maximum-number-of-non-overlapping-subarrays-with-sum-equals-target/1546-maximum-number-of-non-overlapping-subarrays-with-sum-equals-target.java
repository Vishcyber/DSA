class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 0);

        long prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            // If prefixSum - target was seen, we found a valid subarray.
            if (map.containsKey(prefixSum - target)) {
                count++;
                
                // Reset for the next non-overlapping subarray.
                map.clear();
                map.put(prefixSum, count);
            } else {
                map.put(prefixSum, count);
            }
        }

        return count;
    }
}
