class Solution {
    public String reverseWords(String s) {
        
        char[] str = s.toCharArray();
        int i = 0;
        int j = 0;

        while (j < str.length) {
            if (str[j] != ' ') {
                j++;
             }
             else {
             SwapWord(str, i, j-1);
               j++;
                  i = j;
          }      
     }
      SwapWord(str, i, j-1);

    return new String(str);
}
    
       public void SwapWord(char[] str, int i, int k)
   {
       while (i < k) {
           char temp = str[i];
           str[i] = str[k];
           str[k] = temp;
           i++;
           k--;
       }
   }
}
