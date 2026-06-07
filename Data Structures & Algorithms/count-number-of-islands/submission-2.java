class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int islandCount = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == '1') {
                    islandCount++;
                    fillIsland(grid, row, col);
                }
            }
        }

        return islandCount;
    }

    private void fillIsland(char[][] grid, int y, int x) {
        int n = grid.length, m = grid[0].length;
        int[][] offsets = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        Deque<int[]> points = new ArrayDeque<>();
        points.add(new int[]{y, x});

        while (!points.isEmpty()) {
            int[] coords = points.pollFirst();

            for (int[] offset : offsets) {
                int newY = coords[0] + offset[0];
                int newX = coords[1] + offset[1];

                if ((newY >= 0 && newY < n) &&
                (newX >= 0 && newX < m) &&
                grid[newY][newX] == '1') {
                    points.offerFirst(new int[]{newY, newX});
                    grid[newY][newX] = '*';
                }
            }
        }
    }
}
