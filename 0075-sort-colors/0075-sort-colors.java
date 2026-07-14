class Solution {
    public void swap(int[] nums , int i ,int j){
                int temp= nums[i];
                nums[i] =nums[j];
                nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        int end = nums.length-1;
        int st = 0;
        int mid= 0;
        while(mid <= end){
            if(nums[mid]==0){
                swap(nums , st , mid);
                st++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                swap(nums , mid , end);
                
                end--;
            }
        }
       
    }
}