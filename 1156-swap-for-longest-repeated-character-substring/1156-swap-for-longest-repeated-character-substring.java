class Solution {
    public int maxRepOpt1(String text) {
        int[] count = new int[26];
        int result = 0;
        
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
            result = Math.max(result, count[c - 'a']);
        }
        
        if (result <= 1) return result;
        
        int maxResult = 1;
        int left = 0;
        int length = text.length();
        
        while (left < length) {
            int start =left;
            char character = text.charAt(left);
            while (left < length && text.charAt(left) == character) left++;
            
            int right = left + 1;
            while (right < length && text.charAt(right) == character) right++;
            
            int currLength = (right - start <= count[character - 'a']) ? right - start :right - start - 1;
            maxResult = Math.max(maxResult, currLength);
            
        }
        
        return maxResult;
    }
}
