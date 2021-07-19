### 题目
209. 长度最小的子数组

**难度**：中等

详细内容见：[minimum-size-subarray-sum](https://leetcode-cn.com/problems/minimum-size-subarray-sum/)


### 题解
滑窗 - 双指针

DFS算法:
```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int num = 0;
        int res = Integer.MAX_VALUE;
        while (right < n) {
            num += nums[right];
            while(num >= target) {
                res = Math.min(res, right - left + 1);
                num -= nums[left];
                left++;
            }
            right++;
        }
        return res == Integer.MAX_VALUE? 0: res;
    }
}
```
