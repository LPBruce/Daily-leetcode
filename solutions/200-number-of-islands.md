### 题目
**难度**：中等
详细内容见：[number-of-islands](https://leetcode-cn.com/problems/number-of-islands/)


### 题解
DFS算法:
```java
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int num = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    DFS(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    void DFS(char[][] grid, int r, int c) {
        int rm = grid.length;
        int cm = grid[0].length;

        if(r < 0 || c < 0 || r >= rm || c >= cm || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        DFS(grid, r - 1, c);
        DFS(grid, r + 1, c);
        DFS(grid, r, c - 1);
        DFS(grid, r, c + 1);
    }
}
```

BFS:
```java
```
