class Solution {
    public int numIslands(char[][] grid) {
        int output = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                output += dfs(grid, row, col);
            }
        }

        return output;
    }

    private int dfs(char[][] grid, int y, int x) {
        // Base case
        if (grid[y][x] != '1') return 0;

        int[][] offsets = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        Deque<int[]> stack = new ArrayDeque<>();
        stack.offerFirst(new int[]{ y, x });
        grid[y][x] = '*';

        while(!stack.isEmpty()) {
            int[] tile = stack.pollFirst();

            for (int[] offset : offsets) {
                int newY = tile[0] + offset[0];
                int newX = tile[1] + offset[1];

                if (newY >= 0 && newY < grid.length && 
                newX >= 0 && newX < grid[0].length && 
                grid[newY][newX] == '1') {
                    stack.offer(new int[]{ newY, newX });
                    grid[newY][newX] = '*';
                }
            }
        }

        return 1;
    }
}
