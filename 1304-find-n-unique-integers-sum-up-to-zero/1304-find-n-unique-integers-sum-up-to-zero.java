class Solution {
    public int[] sumZero(int n) {
      int[] result =new int[n];
      int l =0;
      int r= n-1;
      int num =1;
      while(l<r){
        result[l++] =num;
        result[r--] = -num;
        num++;
      } 
      return result; 
    }
}