class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int original = image[sr][sc];

        if (original == color) {
            return image;
        }

        dfs(image, sr, sc, original, color);

        return image;
    }

    public void dfs(int[][] image, int r, int c, int original, int color) {

        int rows = image.length;
        int columns = image[0].length;

        if (r < 0 || r >= rows || c < 0 || c >= columns) {
            return;
        }

        if (image[r][c] != original) {
            return;
        }

        image[r][c] = color;

        dfs(image, r - 1, c, original, color);
        dfs(image, r + 1, c, original, color);
        dfs(image, r, c - 1, original, color);
        dfs(image, r, c + 1, original, color);
    }
}