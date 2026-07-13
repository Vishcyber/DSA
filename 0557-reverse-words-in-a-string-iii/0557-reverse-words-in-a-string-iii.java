class Solution {
    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        int st = 0;
        for (int end = 0; end <= ch.length; end++) {
            if ( end == ch.length || ch[end] == ' ' ) {
                reverse(ch, st, end - 1);
                st = end + 1;
            }
        }
        return new String(ch);
    }

    public static void reverse(char[] ch, int st, int end) {
        while (st < end) {
            char temp = ch[st];
            ch[st] = ch[end];
            ch[end] = temp;
            st++;
            end--;
        }
    }
}