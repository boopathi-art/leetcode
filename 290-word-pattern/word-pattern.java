class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {

            for (int j = 0; j < i; j++) {

                if (pattern.charAt(i) == pattern.charAt(j)) {
                    if (!words[i].equals(words[j])) {
                        return false;
                    }
                }

                if (words[i].equals(words[j])) {
                    if (pattern.charAt(i) != pattern.charAt(j)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}