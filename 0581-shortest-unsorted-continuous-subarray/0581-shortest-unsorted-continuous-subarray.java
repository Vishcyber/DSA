class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;

        int left = -1;
        int right = -1;

        // Find the first position from the left
        // where nums[i] > nums[i + 1]
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                left = i;
                break;
            }
        }

        // Already sorted
        if (left == -1) {
            return 0;
        }

        // Find the last position from the right
        // where nums[i] > nums[i + 1]
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] > nums[i]) {
                right = i;
                break;
            }
        }

        // Find min and max inside the unsorted portion
        int min = nums[left];
        int max = nums[left];

        for (int i = left; i <= right; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        // Expand left while elements are greater than min
        while (left > 0 && nums[left - 1] > min) {
            left--;
        }

        // Expand right while elements are smaller than max
        while (right < n - 1 && nums[right + 1] < max) {
            right++;
        }

        return right - left + 1;
    }
}
