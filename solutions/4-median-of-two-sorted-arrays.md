
### 题目
**难度**：困难
详细内容见：[median-of-two-sorted-arrays](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/)


### 题解

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] sum = new int[m + n];
        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < m + n; i++) {
            if (n1 >= m) {
                sum[i] = nums2[n2++];
            } else if (n2 >= n) {
                sum[i] = nums1[n1++];
            } else {
                if (nums1[n1] > nums2[n2]) {
                    sum[i] = nums2[n2++];
                } else if (nums1[n1] < nums2[n2]) {
                    sum[i] = nums1[n1++];
                } else {
                    sum[i] = nums1[n1++];
                    i++;
                    sum[i] = nums2[n2++];
                }
            } 
        }
        
        double res = 0;
        if ((m + n)%2 == 1) {
            res = sum[(m + n)/2];
        } else {
            res = ((double)sum[(m + n)/2 -1] + (double)sum[(m + n)/2])/2;
        }
        return res;
    }
}
```
类似于归并排序，将两个数组各放一个指针在第一个位置，并以此进行比较。容易出错的地方在于：两个数相等并取值时，记得`i++`;另外最后一步，取中值时，小心序号计算错误。

[官方题解](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/)

很精彩，待补充 




