### 题目
**难度**：中等


### 题解

```java
class Solution {
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    if (DFS(grid, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean DFS(int[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;
        if(i < 0 || j < 0 || i >=rows || j >= cols){
            return false;
        }
        if(grid[i][j] == 1){
            return true;
        }
        // 
        grid[i][j] = 1;
        boolean up = DFS(grid,i-1,j);
        boolean down = DFS(grid,i+1,j);
        boolean left = DFS(grid,i,j-1);
        boolean right = DFS(grid,i,j+1);
        if(up && down && left && right){
            return true;
        }
        return false;
    }
}
```
比较典型的dfs/bfs算法题型，四个方向判断是否是封闭岛屿，注意`grid[i][j] = 1;`，讲判判断过的岛屿置为0，不然会引起栈溢出错误。