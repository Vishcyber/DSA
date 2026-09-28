class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];               // best[i] = shortest valid subarray ending at or before i
        Arrays.fill(best, Integer.MAX_VALUE);

        int result = Integer.MAX_VALUE;
        int sum = 0, left = 0;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            // Shrink window while sum is too large
            while (sum > target && left <= right) {
                sum -= arr[left++];
            }

            // Carry forward the best so far
            best[right] = (right > 0) ? best[right - 1] : Integer.MAX_VALUE;

            if (sum == target) {
                int len = right - left + 1;

                // Combine with the best subarray that ends before 'left'
                if (left > 0 && best[left - 1] != Integer.MAX_VALUE) {
                    result = Math.min(result, best[left - 1] + len);
                }

                best[right] = Math.min(best[right], len);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}