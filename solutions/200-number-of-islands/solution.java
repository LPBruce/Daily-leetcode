// DFS解法
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        // DFS solution
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                // 岛屿数量加1
                if (grid[i][j] == '1') {
                    count++;
                    // 通过深度遍历将该岛屿网格全部置为0
                    DFS(grid, i, j);
                }
            }
        }
        return count;
    }

    public void DFS (char[][] grid, int i, int j) {
        // 边界判定
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j]  == 0) {
            return;
        }
        grid[i][j] = 0;
        DFS(grid, i-1, j);
        DFS(grid, i, j-1);
        DFS(grid, i+1, j);
        DFS(grid, i, j+1);
    }
}

// BFS 解法
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rm = grid.length;
        int cm = grid[0].length;

        // BFS solution
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    Queue<Integer> store = new LinkedList<>();
                    // 因为要存入的是位置信息，为了避免存一个数组，使用i * cm + j方式完成存储
                    grid[i][j] = '0';
                    store.add(i * cm + j);
                    while(!store.isEmpty()) {
                        int num = store.remove();
                        int r = num / cm;
                        int c = num % cm;
                        if ((r - 1) >= 0 && grid[r-1][c] == '1') {
                            store.add((r - 1) * cm + c);
                            grid[r - 1][c] = '0';
                        }
                        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                            store.add(r * cm + c -1);
                            grid[r][c - 1] = '0';
                        }
                        if (r + 1 < rm && grid[r + 1][c] == '1') {
                            store.add((r + 1) * cm + c);
                            grid[r + 1][c] = '0';
                        }
                        if (c + 1 < cm && grid[r][c + 1] == '1') {
                            store.add(r * cm + c + 1);
                            grid[r][c + 1] = '0';
                        }
                    }
                }
            }
        }
        return count;
    }
}