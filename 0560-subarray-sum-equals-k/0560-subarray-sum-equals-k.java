class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer , Integer> map = new HashMap<>();
        int presum = 0;
        int count = 0;
        map.put(0 , 1);
        for(int num : nums){
            presum += num;
        count += map.getOrDefault(presum -k , 0);
       
        map.put(presum , map.getOrDefault(presum, 0) + 1);
        }
        return count;

    }
}