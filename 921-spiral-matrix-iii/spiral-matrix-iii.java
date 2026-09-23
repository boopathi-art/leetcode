class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        int total = rows * cols;

        int[][] result = new int[total][2];

        int index = 0;

        int r = rStart;
        int c = cStart;

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int direction = 0;
        int steps = 1;

        result[index++] = new int[]{r, c};

        while (index < total) {

            for (int repeat = 0; repeat < 2; repeat++) {

                for (int step = 0; step < steps; step++) {

                    r = r + dr[direction];
                    c = c + dc[direction];

                    if (r >= 0 && r < rows && c >= 0 && c < cols) {

                        result[index++] = new int[]{r, c};
                    }

                    if (index == total) {
                        return result;
                    }
                }

                direction = (direction + 1) % 4;
            }

            steps++;
        }

        return result;
    }
}