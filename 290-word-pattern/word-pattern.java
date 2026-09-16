class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        String[] map = new String[26];

        for (int i = 0; i < pattern.length(); i++) {

            int index = pattern.charAt(i) - 'a';

            if (map[index] == null) {

                for (int j = 0; j < 26; j++) {
                    if (map[j] != null && map[j].equals(words[i])) {
                        return false;
                    }
                }

                map[index] = words[i];

            } else {

                if (!map[index].equals(words[i])) {
                    return false;
                }
            }
        }

        return true;
    }
}