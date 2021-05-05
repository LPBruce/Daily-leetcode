### 题目
**难度**：中等


### 题解

```java
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        LinkedList<String> result = new LinkedList<>();
        Arrays.sort(folder);
        String last = "/";
        for (String next : folder) {
            if (!next.startsWith(last + "/")) {
                result.add(next);
                last = next;
            }
        }
        return result;
    }
}
```
现将字符串数组排序，然后判断是否有子串。此题的关键通过排序讲数组进行规整，方便顺序判断是否有子串。