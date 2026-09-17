class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid.length, m = grid[0].length, count = 0;
        for (int i = 0; i < n; i++) {
            int l = 0, r = m - 1, x = m;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (grid[i][mid] < 0) {
                    x = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            count += (m - x);
        }
        return count;
    }
}