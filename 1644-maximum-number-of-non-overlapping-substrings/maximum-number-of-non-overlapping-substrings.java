import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            if (first[ch] == -1) {
                first[ch] = i;
            }

            last[ch] = i;
        }
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            if (first[ch] != i) {
                continue;
            }
            int end = last[ch];
            boolean valid = true;
            for (int j = i; j <= end; j++) {
                int c = s.charAt(j) - 'a';
                if (first[c] < i) {
                    valid = false;
                    break;
                }
                end = Math.max(end, last[c]);
            }

            if (valid) {
                intervals.add(new int[]{i, end});
            }
        }
        intervals.sort((a, b) -> a[1] - b[1]);
        List<String> result = new ArrayList<>();
        int prevEnd = -1;
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (start > prevEnd) {
                result.add(s.substring(start, end + 1));
                prevEnd = end;
            }
        }
        return result;
    }
}