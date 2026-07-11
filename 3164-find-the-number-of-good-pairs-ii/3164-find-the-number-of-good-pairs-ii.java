class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {

        Map<Integer, Integer> freq = new HashMap<>();

        for (int x : nums2) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        long ans = 0;

        for (int num : nums1) {

            if (num % k != 0) continue;

            int val = num / k;

            for (int d = 1; d * d <= val; d++) {

                if (val % d != 0) continue;

                ans += freq.getOrDefault(d, 0);

                int other = val / d;
                if (other != d) {
                    ans += freq.getOrDefault(other, 0);
                }
            }
        }

        return ans;
    }
}