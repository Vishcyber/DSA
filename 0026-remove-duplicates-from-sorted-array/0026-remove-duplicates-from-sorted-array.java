class Solution {
    public int removeDuplicates(int[] nums) {
      int n = nums.length;
    int i =0;
    int j =1;
    int k =1;
    while(i<=j && j<n){
       
        while( j<n && nums[j] ==nums[i]){
            j++;
        }
        if( j<n && nums[i] !=nums[j] ){
            nums[k++]=nums[j];
            i=j;
            j++;
        }
    } 
   
    return k;
    }
}