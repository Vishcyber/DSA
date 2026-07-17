class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int n = nums1.length;
       int m = nums2.length ;
       int idx =m+n;
       double ans =0;
       int arr[] = new int[m+n];
        int i=0;
        int j=0;
        int k=0;
        while(i<n && j<m){
            if(nums1[i] < nums2[j]){
            arr[k++]=nums1[i];
            i++;
            }else{
                arr[k++]=nums2[j++];
            }
        }
        while(i<n){
            arr[k++]=nums1[i++];
        }
        while(j<m){
            arr[k++]=nums2[j++];
        }
       if(idx%2 != 0){
       int mid = idx/2;
      ans =(double) arr[mid]; 
      
    }else{
        int mid = idx/2;
         ans = (double)( arr[mid]+arr[mid-1])/2;   
    }
    return ans;
}}