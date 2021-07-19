
### 题目
**难度**：中等
详细内容见：[number-of-provinces/](https://leetcode-cn.com/problems/number-of-provinces/)


### 题解
以下是两种形式的并查集，详情参照算法文档中的并查集部分，其实从leetcode的执行结果来看，并没有很大的差别。

**并查集-未优化版**
```java
class Solution {

    // 优化版的并查集
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] root = new int[n];
        if (isConnected == null) {
            return 0;
        }
        init(root, isConnected);
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    merge(root, i, j);
                }
            }
        }
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (root[i] == i) {
                num++;
            }
        }        
        return num;
    }
    
    void init(int[] root, int[][] isConnected) {
        for (int i = 0; i < isConnected.length; i++) {
            root[i] = i;
        }
    }

    int find(int[] root, int x) {
        if(root[x] == x) {
            return x;
        } else {
            root[x] = find(root, root[x]);
            return root[x];
        }

    }

    void merge(int[] root, int i, int j) {
        root[find(root, i)] = root[find(root, j)];
    }
}
```

**并查集-优化版**
```java
class Solution {

    // 优化版的并查集
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] root = new int[n];
        int[] rank = new int[n];
        if (isConnected == null) {
            return 0;
        }
        init(root, rank, isConnected);
        // for (int i = 0; i < root.length; i++) {
        //     System.out.println(root[i]);
        // }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                merge(root, rank, i, j);
            }
        }

        int num = 0;
        for (int i = 0; i < n; i++) {
            if (root[i] == i) {
                num++;
            }
        }        
        for (int i = 0; i < root.length; i++) {
            System.out.println(root[i]);
        }
        return num;
    }
    
    void init(int[] root, int[] rank, int[][] isConnected) {
        for (int i = 0; i < isConnected.length; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    int find(int[] root, int x) {
        if(root[x] == x) {
            return x;
        } else {
            root[x] = find(root, root[x]);
            return root[x];
        }

    }

    void merge(int[] root, int[] rank, int i, int j) {

        int x = find(root, i);
        int y = find(root, j);
        if (rank[x] <= rank[y]) {
            root[x] = y;
        } else {
            root[y] = x;
        }
        if(rank[x] == rank[y] && x != y) {
            rank[y]++;
        }
        // System.out.println(root[x]);
        // System.out.println(root[y]);
    }
}
```

