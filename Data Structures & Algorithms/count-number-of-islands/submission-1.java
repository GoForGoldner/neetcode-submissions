    class Solution {
        public int numIslands(char[][] grid) {
            int n = grid.length, m = grid[0].length;
            int islandCount = 0;

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    if (isIsland(grid, row, col)) islandCount++;
                }
            }

            return islandCount;
        }

        private boolean isIsland(char[][] grid, int y, int x) {
            if (grid[y][x] != '1') return false;

            int n = grid.length, m = grid[0].length;
            int[][] offsets = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
            };

            Deque<int[]> stack = new ArrayDeque<>();
            stack.offerFirst(new int[]{y, x});
            grid[y][x] = '*';

            while (!stack.isEmpty()) {
                int[] coords = stack.pollFirst();

                for (int[] offset : offsets) {
                    int newY = coords[0] + offset[0];
                    int newX = coords[1] + offset[1];

                    if ((newY >= 0 && newY < n) &&
                    (newX >= 0 && newX < m) &&
                    grid[newY][newX] == '1') {
                        grid[newY][newX] = '*';
                        stack.offerFirst(new int[]{newY, newX});
                    }
                }
            }

            return true;
        }
    }
