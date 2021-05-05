### 题目
**难度**：中等


### 题解

```cpp
class Solution {
public:
    int res;
    int count[60] = {0};
    int numPairsDivisibleBy60(vector<int>& time) {
        if (time.empty()) return 0;
        int n = time.size();
        for (int i = 0; i < n; i++) {
           time[i] %= 60;
           count[time[i]] ++;
        }
        for (int i = 1; i < 30; i++) {
            res += count[i]*count[60-i];
        }
        res += count[0]*(count[0]-1)/2;
        res += count[30]*(count[30]-1)/2;
        return res;
    }
};
```
如果采用嵌套的for循环，圈复杂度高，本题解的思路是利用两个时长除以60的余数，两两相加为60，表示一组结果。