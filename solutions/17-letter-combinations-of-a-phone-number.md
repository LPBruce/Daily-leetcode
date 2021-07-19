### 题目
**难度**：中等
详细内容见：[letter-combinations-of-a-phone-number](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)


### 题解
DFS，另外使用map来保存电话号码的数据，使用StringBuffer来拼接字符串

```java
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        HashMap<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        DFS(res, phoneMap, digits, 0, new StringBuffer());
        return res;
    }

    private void DFS(List<String> res, HashMap<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        // 如果已到最后一位数，则返回该结果
        if (index == digits.length()) {
            res.add(combination.toString());
        } else {
            // 第 index 位数字
            char numChar = digits.charAt(index);
            // 取出改数字对应的 字典，字母表
            String letters = phoneMap.get(numChar);
            // 
            for (int i = 0; i < letters.length(); i++) {
                combination.append(letters.charAt(i));
                DFS(res, phoneMap, digits, index+1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
```
DFS算法