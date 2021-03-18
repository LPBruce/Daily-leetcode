### 题目
**难度**：中等
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
详细内容见：[subsets](https://leetcode-cn.com/problems/subsets/)


### 题解


#### 方法一
```java
class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> tmp = new ArrayList<Integer>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return res;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        tmp.add(nums[cur]);
        dfs(cur+1, nums);
        tmp.remove(tmp.size() - 1);
        dfs(cur + 1, nums);
    }
}
```
对于提供的数据，想要获得不同的组合，可以看作是每个数据存在0/1两种状态，因为可以采用回溯法，具体来说，采用深度搜索算法，将每种情况都计算在内，深度遍历

#### 方法二

二分法，参考官方[题解](https://leetcode-cn.com/problems/subsets/solution/zi-ji-by-leetcode-solution/)
```java
class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> tmp = new ArrayList<Integer>();

    public List<List<Integer>> subsets(int[] nums) {
        int n =nums.length;
        for (int i = 0; i < (1 << n); i++) {
            tmp.clear();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    tmp.add(nums[j]);
                }
            }
            res.add(new ArrayList<Integer>(tmp));
        }
        return res;
    }
}
```

### 知识点
