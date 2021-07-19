
### 题目
**难度**：中等
详细内容见：[longest-substring-without-repeating-characters](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)


### 题解
核心是滑窗，辅之以 哈希表，双指针等知识点，具体分析


```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet set = new HashSet<Character>();
        if (s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        int res = 0;
        int R = -1;
        for (int i = 0; i < n; i++) {
            if ( i != 0) {
                // 删除之前的元素
                set.remove(s.charAt(i - 1));
            }
            // 如果没有重复，则将新元素放进set中
            // 如果有重复，则开始下一个循环，直到没有重复元素
            while ((R + 1) < n && !set.contains(s.charAt(R + 1))) {
                set.add(s.charAt(R + 1));
                R++;
            }
            res = Math.max(res, R - i + 1);
        }
        return res;
    }
}
```
