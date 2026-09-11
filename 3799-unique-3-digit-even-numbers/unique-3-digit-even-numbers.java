class Solution {
    public int totalNumbers(int[] digits) {

        int count = 0;

        for (int num = 100; num <= 998; num++) {

            if (num % 2 != 0) {
                continue;
            }

            int[] available = new int[10];

            for (int d : digits) {
                available[d]++;
            }

            int n = num;

            int a = n % 10;
            n = n / 10;

            int b = n % 10;
            n = n / 10;

            int c = n % 10;

            if (available[a] > 0) {
                available[a]--;
            } else {
                continue;
            }

            if (available[b] > 0) {
                available[b]--;
            } else {
                continue;
            }

            if (available[c] > 0) {
                count++;
            }
        }

        return count;
    }
}