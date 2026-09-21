class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        int total = m * n;

        k = k % total;

        for (int shift = 0; shift < k; shift++) {

            int last = grid[m - 1][n - 1];

            for (int i = m - 1; i >= 0; i--) {

                for (int j = n - 1; j > 0; j--) {

                    grid[i][j] = grid[i][j - 1];
                }

                if (i > 0) {
                    grid[i][0] = grid[i - 1][n - 1];
                }
            }

            grid[0][0] = last;
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {

                row.add(grid[i][j]);
            }

            result.add(row);
        }

        return result;
    }
}