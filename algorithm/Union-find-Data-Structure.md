## 并查集

并查集（Union-find Data Structure）是一种树型的数据结构。它的特点是由子结点找到父亲结点，用于处理一些不交集（Disjoint Sets）的合并及查询问题。

Find：确定元素属于哪一个子集。它可以被用来确定两个元素是否属于同一子集。
Union：将两个子集合并成同一个集合。

**学习文档：**
https://zhuanlan.zhihu.com/p/93647900/
https://segmentfault.com/a/1190000004023326
https://blog.csdn.net/guo15331092/article/details/78702686?tdsourcetag=s_pctim_aiomsg

详情参考文档https://zhuanlan.zhihu.com/p/93647900/
**套用模板一：（简化版）**
```java
int fa[MAXN];
inline void init(int n)
{
    for (int i = 1; i <= n; ++i)
        fa[i] = i;
}

int find(int x)
{
    if(fa[x] == x)
        return x;
    else
        return find(fa[x]);
}

void merge(int i, int j)
{
    fa[find(i)] = find(j);
}
```


**套用模板二：（优化版）**
优化版指得是考虑路径压缩以及按秩合并，
```java
// 数据集
int fa[MAXN]  // 根集
int rank[MAXN];  // 秩集

// 初始化
void init(int n)
{
    for (int i = 1; i <= n; ++i)
    {
        fa[i] = i;
        rank[i] = 1;
    }
}
// 查找（路径压缩）
int find(int x)
{
    if(x == fa[x])
        return x;
    else{
        fa[x] = find(fa[x]);  //父节点设为根节点
        return fa[x];         //返回父节点
    }
    // 简化版
    // return x == fa[x] ? x : (fa[x] = find(fa[x]));
}

// 合并（按秩合并）
void merge(int i, int j)
{
    int x = find(i), y = find(j);    //先找到两个根节点
    if (rank[x] <= rank[y])
        fa[x] = y;
    else
        fa[y] = x;
    if (rank[x] == rank[y] && x != y)
        rank[y]++;                   //如果深度相同且根节点不同，则新的根节点的深度+1
}

```
