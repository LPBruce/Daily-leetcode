### 题目
**难度**：中等
详细内容见：[redundant-connection](https://leetcode-cn.com/problems/redundant-connection/)


### 题解
并查集，只需要注意一下如何找出冗余的数据即可

**并查集**
```java
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null) {
            return null;
        }
        int[] res = new int[2];
        int size = edges.length;
        int[] root = new int [size];
        for (int i = 0; i < size; i++) {
            root[i] = i + 1;
        }
        for (int i = 0; i < size; i++) {
            int index1 = edges[i][0];
            int index2 = edges[i][1];
            if (find(root, index1) == find(root, index2)) {
                return edges[i];
            }
            merge(root, index1, index2);
        }
        return res;
    }

    int find(int[] root, int index) {
        if (root[index-1] == index) {
            return index-1;
        } else {
            return find(root, root[index-1]);
        }
    }

    void merge (int[] root, int i, int j) {
        root[find(root, i)] = root[find(root, j)];
    }
}
```