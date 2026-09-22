class Solution {

    int k;
    int size;
    int[][] tree;
    int[] product;

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        this.k = k;

        int n = nums.length;

        size = 1;

        while (size < n) {
            size *= 2;
        }

        tree = new int[2 * size][k];
        product = new int[2 * size];

        for (int i = 0; i < n; i++) {

            int remainder = nums[i] % k;

            tree[size + i][remainder] = 1;

            product[size + i] = remainder;
        }

        for (int i = size - 1; i >= 1; i--) {

            merge(i);
        }

        int[] result = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int index = queries[q][0];

            int value = queries[q][1];

            int start = queries[q][2];

            int x = queries[q][3];

            update(index, value);

            int[] answer = query(start, n);

            result[q] = answer[x];
        }

        return result;
    }

    void merge(int node) {

        int left = node * 2;

        int right = node * 2 + 1;

        product[node] =
            (product[left] * product[right]) % k;

        for (int r = 0; r < k; r++) {

            tree[node][r] = tree[left][r];
        }

        for (int r = 0; r < k; r++) {

            int newRemainder =
                (product[left] * r) % k;

            tree[node][newRemainder] += tree[right][r];
        }
    }

    void update(int index, int value) {

        int node = size + index;

        int remainder = value % k;

        for (int r = 0; r < k; r++) {

            tree[node][r] = 0;
        }

        tree[node][remainder] = 1;

        product[node] = remainder;

        node /= 2;

        while (node >= 1) {

            merge(node);

            node /= 2;
        }
    }

    int[] query(int left, int right) {

        left += size;

        right += size;

        int[] leftPrefix = new int[k];

        int[] rightPrefix = new int[k];

        int leftProduct = 1;

        int rightProduct = 1;

        while (left < right) {

            if (left % 2 == 1) {

                int[] newPrefix = new int[k];

                for (int r = 0; r < k; r++) {

                    newPrefix[r] += leftPrefix[r];
                }

                for (int r = 0; r < k; r++) {

                    int newRemainder =
                        (leftProduct * r) % k;

                    newPrefix[newRemainder] += tree[left][r];
                }

                leftPrefix = newPrefix;

                leftProduct =
                    (leftProduct * product[left]) % k;

                left++;
            }

            if (right % 2 == 1) {

                right--;

                int[] newPrefix = new int[k];

                for (int r = 0; r < k; r++) {

                    newPrefix[r] += tree[right][r];
                }

                for (int r = 0; r < k; r++) {

                    int newRemainder =
                        (product[right] * r) % k;

                    newPrefix[newRemainder] +=
                        rightPrefix[r];
                }

                rightPrefix = newPrefix;

                rightProduct =
                    (product[right] * rightProduct) % k;
            }

            left /= 2;

            right /= 2;
        }

        int[] answer = new int[k];

        for (int r = 0; r < k; r++) {

            answer[r] += leftPrefix[r];
        }

        for (int r = 0; r < k; r++) {

            int newRemainder =
                (leftProduct * r) % k;

            answer[newRemainder] += rightPrefix[r];
        }

        return answer;
    }
}