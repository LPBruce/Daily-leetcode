### 题目
**难度**：中等
详细内容见：[permutations](https://leetcode-cn.com/problems/permutations/)


### 题解
回溯——需要注意回溯递归的结束条件判断，另外结束回溯流程后，回复原始数据

```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        // 临时List，方便用来进行数组转换
        List<Integer> out = new ArrayList<Integer>();
        for (int num: nums) {
            out.add(num);
        }
        
        int n = nums.length;
        backtrack(n, out, res, 0);
        return res;
    }

    void backtrack (int n, List<Integer> out, List<List<Integer>> res, int first) {
        // 如果是，怎以为这已经到了最后一位，则作为返回条件，开始回溯
        if (first == n) {
            // 进行List拷贝
            res.add(new ArrayList<Integer>(out));
        }
        // 从first开始，开始进一逐一交换
        for (int i = first; i < n; i++) {
            Collections.swap(out, first, i);
            // 交换后，意味着这意味已经定了，那么开始新的递归流程
            backtrack(n, out, res, first + 1);
            // 回复到原始的情况，开始下个循环
            Collections.swap(out, first, i);
        }
    }
}
```