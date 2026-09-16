class Solution {
    public int longestPalindrome(String s) {

        int[] count = new int[52];

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                count[ch - 'a']++;
            } else {
                count[ch - 'A' + 26]++;
            }
        }

        int length = 0;
        boolean odd = false;

        for (int i = 0; i < 52; i++) {

            length += (count[i] / 2) * 2;

            if (count[i] % 2 == 1) {
                odd = true;
            }
        }

        if (odd) {
            length++;
        }

        return length;
    }
}