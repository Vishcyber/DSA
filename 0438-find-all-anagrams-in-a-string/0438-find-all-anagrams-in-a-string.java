class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] count = new int[26];

        // Store frequency of characters in p
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }

        int left = 0, right = 0, needed = p.length();

        while (right < s.length()) {
            // Include current character in the window
            if (count[s.charAt(right) - 'a'] > 0) {
                needed--;
            }
            count[s.charAt(right) - 'a']--;
            right++;

            // If all characters matched
            if (needed == 0) {
                result.add(left);
            }

            // Maintain window size equal to p.length()
            if (right - left == p.length()) {
                if (count[s.charAt(left) - 'a'] >= 0) {
                    needed++;
                }
                count[s.charAt(left) - 'a']++;
                left++;
            }
        }

        return result;
    }
}