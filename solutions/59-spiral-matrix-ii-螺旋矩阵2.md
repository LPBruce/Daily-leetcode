
### 题目
**难度**：中等

给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
详细内容见：[spiral-matrix-ii](https://leetcode-cn.com/problems/spiral-matrix-ii/)


### 题解
```java
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int L = 0, T = 0, R = n-1, B = n-1;
        int num = 1;
        // int row = 0, col = 0;
        while(num <= n*n) {
            int i = 0;
            // to right
            for(i = L; i <= R; i++) {
                res[T][i] = num++;
            };
            T++;
            for(i = T; i <= B; i++) {
                res[i][R] = num++;
            };
            R--;
            for(i = R; i >= L; i--) {
                res[B][i] = num++;
            };
            B--;
            for(i = B; i >= T; i--) {
                res[i][L] = num++;
            };
            L++;
        }
        return res;
    }
}
```

这种类型的题目关键是在移动中，控制好边界条件。类似的题目很多，如棋盘移动，需要控制棋子四周的方向，总的来说，不是很难。



