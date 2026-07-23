class Solution {
    public int maxRepOpt1(String text) {
        int n = text.length();
        int[] count = new int[26];

        // Frequency of each character
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }

        int ans = 0;

        // Try making the window consist of each character
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int left = 0;
            int diff = 0;

            for (int right = 0; right < n; right++) {
                if (text.charAt(right) != ch) {
                    diff++;
                }

                while (diff > 1) {
                    if (text.charAt(left) != ch) {
                        diff--;
                    }
                    left++;
                }

                // Window can't exceed total occurrences of ch
                ans = Math.max(ans,
                        Math.min(right - left + 1, count[ch - 'a']));
            }
        }

        return ans;
    }
}