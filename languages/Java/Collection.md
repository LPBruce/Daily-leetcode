## Java 集合详解

为了保存数量不确定的数据，以及保存具有映射关系的数据（也被称为关联数组），Java 提供了集合类。集合类主要负责保存、盛装其他数据，因此集合类也被称为容器类。ava 所有的集合类都位于 java.util 包下，提供了一个表示和操作对象集合的统一构架，包含大量集合接口，以及这些接口的实现类和操作它们的算法。
集合类和数组不一样，数组元素既可以是基本类型的值，也可以是对象（实际上保存的是对象的引用变量），而集合里只能保存对象（实际上只是保存对象的引用变量，但通常习惯上认为集合里保存的是对象）。
Java 集合类型分为 Collection 和 Map，它们是 Java 集合的根接口，这两个接口又包含了一些子接口或实现类。

![](./images/Java1.png)
在 图 1 和图 2 中，黄色块为集合的接口，蓝色块为集合的实现类。表 1 介绍了这些接口的作用。


对于 Set、List、Queue 和 Map 这 4 种集合，Java 最常用的实现类分别是 HashSet、TreeSet、ArrayList、ArrayDueue、LinkedList 和 HashMap、TreeMap 等。

表 2 Java集合实现类的作用
|类名称	|作用|
|---|---|
|HashSet	|为优化査询速度而设计的 Set。它是基于 HashMap 实现的，HashSet 底层使用 HashMap 来保存所有元素，实现比较简单|
|TreeSet	|实现了 Set 接口，是一个有序的 Set，这样就能从 Set 里面提取一个有序序列|
|ArrayList	|一个用数组实现的 List，能进行快速的随机访问，效率高而且实现了可变大小的数组|
|ArrayDueue	|是一个基于数组实现的双端队列，按“先进先出”的方式操作集合元素|
|LinkedList	|对顺序访问进行了优化，但随机访问的速度相对较慢。此外它还有 addFirst()、addLast()、getFirst()、getLast()、removeFirst() 和 removeLast() 等方法，能把它当成栈（Stack）或队列（Queue）来用|
|HsahMap	|按哈希算法来存取键对象|
|TreeMap	|可以对键对象进行排序|

## Java Collection接口详解
Collection 接口是 List、Set 和 Queue 接口的父接口，通常情况下不被直接使用。Collection 接口定义了一些通用的方法，通过这些方法可以实现对集合的基本操作。定义的方法既可用于操作 Set 集合，也可用于操作 List 和 Queue 集合。

表 1 Collection接口的常用方法
|方法名称|	说明|
|---|---|
|boolean add(E e)	|向集合中添加一个元素，如果集合对象被添加操作改变了，则返回 true。E 是元素的数据类型|
|boolean addAll(Collection c)	|向集合中添加集合 c 中的所有元素，如果集合对象被添加操作改变了，则返回 true。|
|void clear()	|清除集合中的所有元素，将集合长度变为 0。|
|boolean contains(Object o)	|判断集合中是否存在指定元素|
|boolean containsAll(Collection c)|	判断集合中是否包含集合 c 中的所有元素|
|boolean isEmpty()	|判断集合是否为空|
|Iterator<E>iterator()|	返回一个 Iterator 对象，用于遍历集合中的元素|
|boolean remove(Object o)	|从集合中删除一个指定元素，当集合中包含了一个或多个元素 o 时，该方法只删除第一个符合条件的元素，该方法将返回 true。|
|boolean removeAll(Collection c)	|从集合中删除所有在集合 c 中出现的元素（相当于把调用该方法的集合减去集合 c）。如果该操作改变了调用该方法的集合，则该方法返回 true。|
|boolean retainAll(Collection c)|	从集合中删除集合 c 里不包含的元素（相当于把调用该方法的集合变成该集合和集合 c 的交集），如果该操作改变了调用该方法的集合，则该方法返回 true。|
|int size()	|返回集合中元素的个数|
|Object[] toArray()	|把集合转换为一个数组，所有的集合元素变成对应的数组元素。|

```java
public static void main(String[] args) {
    ArrayList list1 = new ArrayList(); // 创建集合 list1
    ArrayList list2 = new ArrayList(); // 创建集合 list2
    list1.add("one"); // 向 list1 添加一个元素
    list1.add("two"); // 向 list1 添加一个元素
    list2.addAll(list1); // 将 list1 的所有元素添加到 list2
    list2.add("three"); // 向 list2 添加一个元素
    System.out.println("list2 集合中的元素如下：");
    Iterator it1 = list2.iterator();
    while (it1.hasNext()) {
        System.out.print(it1.next() + "、");
    }
}
```









