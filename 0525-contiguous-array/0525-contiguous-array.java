class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer , Integer>map = new  HashMap<>();
        int presum =0;
        int maxlen = 0 ;
        map.put(0 , -1);

        for(int i=0 ; i<nums.length ; i++){
            if(nums[i]== 0){
                //for 0 use -1
                presum--;

            }else{
                presum++;
                //for 1 use +1
            }
            if(map.containsKey(presum)){
              int  len =i-map.get(presum);
                maxlen =  Math.max(maxlen , len );
            }else{
                map.put(presum , i);
            }
        }
        return maxlen;
    }
}