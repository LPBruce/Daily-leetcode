### 题目
560. 和为K的子数组

**难度**：中等
详细内容见：[subarray-sum-equals-k](https://leetcode-cn.com/problems/subarray-sum-equals-k/)


### 题解
类似的问题，首先想到的是 滑窗和前缀和。首先分析滑窗，这个题不适合滑窗，因为是整数数组，有可能是负数，如果考虑负数的话，不是单纯的递增，导致窗口左边无法正确的判断和移动。所以这个提醒考虑的是前缀和。

**暴力解法**
双重循环遍历出所有可能的子串，并判断是否和是k，这里不再列出，很好实现

**前缀和**
相比较暴力解法，其实并没有性能提升，因为还是需要双重循环，不同的地方在于计算区间的和的方式不同而已，空间复杂度变小。
```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        // 求出前缀和数组
        // 为啥要多一位，是因为多出以为来通过加法得出第一个值
        int[] presum = new int[num.length + 1];
        for (int i = 0; i < num.length; i++) {
            // 前缀和数组是从presum[1] 开始填充
            presum[i+1] = presum[i] + nums[i];
        }
        // 统计个数
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            for (int j = i; j < num.length; j++) {
                if (presum[j+1] - presum[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
```

**前缀和 + HashMap**
好好理解一下就可了，map保存的是前缀和及其对应的次数，而我们找的是 前缀和-k,
相比于滑窗，这样的好处是

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        // 用来存放前缀和的数量的map
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 记录前缀和为0的情况
        map.put(0, 1);
        int count = 0;
        int presum = 0;
        for (int num: nums) {
            // 前缀和为0
            presum += num;
            // 找之前前缀和为presum - k 的情况，如果有，则把这些情况的次数加到map上去
            if (map.containsKey(presum - k)) {
                count += map.get(presum - k);
            }
            // 保存当前的前缀和，以及次数，次数先取之前的加1 即可，
            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return count;
    }
}
```