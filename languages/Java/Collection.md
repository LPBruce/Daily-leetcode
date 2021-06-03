## Java 集合详解


为了保存数量不确定的数据，以及保存具有映射关系的数据（也被称为关联数组），Java 提供了集合类。集合类主要负责保存、盛装其他数据，因此集合类也被称为容器类。ava 所有的集合类都位于 java.util 包下，提供了一个表示和操作对象集合的统一构架，包含大量集合接口，以及这些接口的实现类和操作它们的算法。
集合类和数组不一样，数组元素既可以是基本类型的值，也可以是对象（实际上保存的是对象的引用变量），而集合里只能保存对象（实际上只是保存对象的引用变量，但通常习惯上认为集合里保存的是对象）。
Java 集合类型分为 Collection 和 Map，它们是 Java 集合的根接口，这两个接口又包含了一些子接口或实现类。




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

```java
// 创建HashMap
HashMap<Integer, String> Sites = new HashMap<Integer, String>();

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