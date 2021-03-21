### 题目
**难度**：中等

给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
详细内容见：[spiral-matrix-ii](https://leetcode-cn.com/problems/spiral-matrix-ii/)


### 题解
```java
class ParkingSystem {
    int big = 0;
    int medium = 0;
    int small = 0;
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
        if (carType == 1 && big > 0) {
            big--;
            return true;
        }
        else if (carType == 2 && medium > 0) {
            medium--;
            return true;
        }
        else if (carType == 3 && small > 0) {
            small--;
            return true;
        }
        else return false;
    }
}
```
简单，so easy。