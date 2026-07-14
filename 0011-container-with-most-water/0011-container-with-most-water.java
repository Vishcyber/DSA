class Solution {
    public int maxArea(int[] height) {
        
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            int w =right-left;
            int h = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, h * w);
            
            while (left < right && height[left] <= h)
                left++;
            while (left < right && height[right] <= h)
                right--;
        }

        return maxArea;
    }
}
