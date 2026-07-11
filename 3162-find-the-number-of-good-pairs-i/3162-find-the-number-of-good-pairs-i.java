class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int sl = 0;
        int fq =0;
        while(sl < nums1.length){
            for(int ft = 0; ft<nums2.length ; ft++ ){
            if((nums1[sl] %(nums2[ft] *k) )== 0){
                fq++;
            }
            
            }
            sl++;
        }
        return fq ;
    }
}