class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;

        int n = grid.length, m = grid[0].length;
        int output = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                output += dfs(grid, row, col);
            }
        }

        return output;
    }

    private int dfs(char[][] grid, int y, int x) {
        int n = grid.length, m = grid[0].length;
        if (grid[y][x] != '1') return 0;

        Deque<int[]> points = new ArrayDeque<>();
        points.add(new int[]{y, x});

        int[][] offsets = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!points.isEmpty()) {
            int[] coords = points.pollFirst();

            for (int[] offset : offsets) {
                int newY = coords[0] + offset[0];
                int newX = coords[1] + offset[1];

                if (inBounds(newY, 0, n) &&
                inBounds(newX, 0, m) &&
                grid[newY][newX] == '1') {
                    grid[newY][newX] = '*';
                    points.add(new int[]{newY, newX});
                }
            }
        }

        return 1;
    }

    private boolean inBounds(int val, int min, int max) {
        return val >= min && val < max;
    }
}
