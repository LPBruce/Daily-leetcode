### 题目
**难度**：中等


### 题解

```java
class Solution {
    public int countServers(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count_m[] = new int[rows];
        int count_n[] = new int[cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == 1) {
                    ++count_m[i];
                    ++count_n[j];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == 1 && (count_m[i] > 1 || count_n[j] > 1)) {
                    ++ans;
                }
            }
        }
        return ans;
    }
}
}
```
官方题解-计数。先计算每一行和每一类有多少台服务器，用连个数组保存起来，然后对每一个数据进行判定，如果一行或者一列的数据>1, 则意味着本台服务器可以链接，+1；