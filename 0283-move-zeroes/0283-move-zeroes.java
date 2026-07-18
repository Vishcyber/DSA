class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if(n==1 && n==0){
            return ;
        }
        int i = 0;
        int j = 1;
        while (j < n && i<j) {
            if (nums[j] == 0) {
                j++;
            } else if(nums[i] == 0){
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
                j++;
            }else{ 
                i++;
                j =i+1;
            }
        }
    }
}