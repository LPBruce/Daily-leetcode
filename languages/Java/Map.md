## Java Map集合详解
Map 是一种键-值对（key-value）集合，Map 集合中的每一个元素都包含一个键（key）对象和一个值（value）对象。用于保存具有映射关系的数据。

Map 集合里保存着两组值，一组值用于保存 Map 里的 key，另外一组值用于保存 Map 里的 value，key 和 value 都可以是任何引用类型的数据。Map 的 key 不允许重复，value 可以重复，即同一个 Map 对象的任何两个 key 通过 equals 方法比较总是返回 false。

Map 中的 key 和 value 之间存在单向一对一关系，即通过指定的 key，总能找到唯一的、确定的 value。从 Map 中取出数据时，只要给出指定的 key，就可以取出对应的 value。

Map 接口主要有两个实现类：HashMap 类和 TreeMap 类。其中，HashMap 类按哈希算法来存取键对象，而 TreeMap 类可以对键对象进行排序。



### 1. HashMap
+ HashMap 是一个散列表，它存储的内容是键值对(key-value)映射。

+ HashMap 实现了 Map 接口，根据键的 HashCode 值存储数据，具有很快的访问速度，最多允许一条记录的键为 null，不支持线程同步。

+ HashMap 是无序的，即不会记录插入的顺序。

+ HashMap 继承于AbstractMap，实现了 Map、Cloneable、java.io.Serializable 接口。

+ HashMap 的 key 与 value 类型可以相同也可以不同，可以是字符串（String）类型的 key 和 value，也可以是整型（Integer）的 key 和字符串（String）类型的 value。

+ HashMap 中的元素实际上是对象，一些常见的基本类型可以使用它的包装类。
+ 基本类型对应的包装类表如下：

|基本类型|引用类型|
|---|---|
|boolean|Boolean|
|byte|Byte|
|short|Short|
|int|Integer|
|long|Long|
|float|Float|
|double	|Double|
|char|Character|


|方法名称	|说明|
|---|---|
|void clear()|	删除该 Map 对象中的所有 key-value 对。|
|boolean containsKey(Object key)	|查询 Map 中是否包含指定的 key，如果包含则返回 true。|
|boolean containsValue(Object value)	|查询 Map 中是否包含一个或多个 value，如果包含则返回 true。|
|V get(Object key)	|返回 Map 集合中指定键对象所对应的值。V 表示值的数据类型|
|V put(K key, V value)	|向 Map 集合中添加键-值对，如果当前 Map 中已有一个与该 key 相等的 key-value 对，则新的 key-value 对会覆盖原来的 key-value 对。|
|void putAll(Map m)	|将指定 Map 中的 key-value 对复制到本 Map 中。|
|V remove(Object key)	|从 Map 集合中删除 key 对应的键-值对，返回 key 对应的 value，如果该 key 不存在，则返回 null|
|boolean remove(Object key, Object value)	|这是 Java 8 新增的方法，删除指定 key、value 所对应的 key-value 对。如果从该 Map 中成功地删除该 key-value 对，该方法返回 true，否则返回 false。|
|Set entrySet()	|返回 Map 集合中所有键-值对的 Set 集合，此 Set 集合中元素的数据类型为 Map.Entry|
|Set keySet()	|返回 Map 集合中所有键对象的 Set 集合|
|boolean isEmpty()	|查询该 Map 是否为空（即不包含任何 key-value 对），如果为空则返回 true。|
|int size()|	返回该 Map 里 key-value 对的个数|
Collection values()	|返回该 Map 里所有 value 组成的 Collection|

**使用用例如下**
```java
// 创建HashMap
HashMap<Integer, String> Sites = new HashMap<Integer, String>();
// 初始化
HashMap<Integer, String> Sites = new HashMap<Integer, String>() {
  {
    map.put(1, "Google");
    map.put(2, "Runoob");
  }
}


// 添加元素 put() 方法:
// 添加键值对
Sites.put(1, "Google");
Sites.put(2, "Runoob");
Sites.put(3, "Taobao");
Sites.put(4, "Zhihu");

// putAll() 方法
// 将指定所有的键/值对插入到 HashMap 中。
HashMap<Integer, String> sites = new HashMap<>();
HashMap<Integer, String> sites2 = new HashMap<>();
// 将所有的映射关系从 sites 添加到 sites2
sites2.putAll(sites);

// 访问元素
// 使用 get(key) 方法来获取 key 对应的 value:
String str = Sites.get(3)

// 删除元素
// 使用 remove(key) 方法来删除 key 对应的键值对(key-value):
Sites.remove(4);
// 删除所有键值对(key-value)可以使用 clear 方法：
Sites.clear();

// 计算大小
// 计算 HashMap 中的元素数量可以使用 size() 方法：
int num = Sites.size()

// 迭代 HashMap
// 使用 for-each 来迭代 HashMap 中的元素。
for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
}
// 如果你只想获取 key，可以使用 keySet() 方法，然后可以通过 get(key) 获取对应的 value，
// 输出 key 和 value
for (Integer i : Sites.keySet()) {
    System.out.println("key: " + i + " value: " + Sites.get(i));
}
// 如果你只想获取 value，可以使用 values() 方法。
// 返回所有 value 值
for(String value: Sites.values()) {
  // 输出每一个value
  System.out.print(value + ", ");
}
// 通过Java8 Lambda表达式遍历
map.forEach((k, v) -> System.out.println("key: " + k + " value:" + v));

// 判断 hashMap 是否为空 true false
Sites.isEmpty()

// containsKey() 方法
// containsKey() 方法检查 hashMap 中是否存在指定的 key 对应的映射关系。 true/false。
sites.containsKey(1)
//检查 key 为 4 是否存在，不存在插入该 key/value 对
// 使用 ! 符号来对布尔结果取相反的值
if(!sites.containsKey(4)) {
    sites.put(4, "Wiki");
}

// containsValue() 方法
// containsValue() 方法检查 hashMap 中是否存在指定的 value 对应的映射关系。
sites.containsValue("Runoob")

// replace() 方法
// replace() 方法替换 hashMap 中是指定的 key 对应的 value。
// hashmap.replace(K key, V oldValue, V newValue)
// 如果 oldValue 不存，对 key 对应对 value 执行替换，返回 key 对应的旧值，如果存在则替换成功返回 true。
// 创建一个 HashMap
HashMap<Integer, String> sites = new HashMap<>();
// 往 HashMap 添加一些元素
sites.put(1, "Google");
sites.put(2, "Runoob");
sites.put(3, "Taobao");
// 替换key为2的映射
String value = sites.replace(2, "Wiki");  // value = Runoob
// 替换映射关系{1 = Google}，执行替换
sites.replace(1, "Google", "Wiki");  // 返回 true
// 不存在映射关系{2 = Weibo}，没有任何操作
sites.replace(2, "Weibo", "Zhihu");  // 返回 false

```