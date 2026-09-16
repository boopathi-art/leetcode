class Solution {
    public String longestCommonPrefix(String[] strs) {

        int length = strs[0].length();

        for (int i = 1; i < strs.length; i++) {

            int j = 0;

            while (j < length &&
                   j < strs[i].length() &&
                   strs[0].charAt(j) == strs[i].charAt(j)) {
                j++;
            }

            length = j;

            if (length == 0) {
                return "";
            }
        }

        return strs[0].substring(0, length);
    }
}