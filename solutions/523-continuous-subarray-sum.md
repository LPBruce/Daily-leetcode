### 题目
523. 连续的子数组和

**难度**：中等
详细内容见：[continuous-subarray-sum](https://leetcode-cn.com/problems/continuous-subarray-sum/)


### 题解
**前缀和**

**前缀和 + HashMap**
通过比较560和这个题，可以看到前缀和是一个比较灵活的算法，核心思路是累加前缀和，但是针对具体问题，进行具体的出来，比如560比较关注的是数量，有多少个，那么Hash里面保存的就是presum - k的数量，方便后面的计算，而看523，保存的是前缀和最小的余数索引

```java
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int presum = 0;
        for (int i = 0; i < nums.length; i++) {
            presum += nums[i];
            // 排除k为0的情况，presum % k保存余数，意味着倍数转为余数
            int key = k == 0? presum: presum % k;
            if (map.containsKey(key)) {
                if (i - map.get(key) >= 2) {
                    return true;
                }
                // 因为要保存最小的索引，所以这里直接continue，而不会更新索引
                continue;
            }
            map.put(key, i); 
        }
        return false;
    }
}
```