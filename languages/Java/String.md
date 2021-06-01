## Java String 相关函数

### 1. 字符串 与 字符串数组初始化
```java

String[] names = new String[] { "张城", "刘丽丽", "李国旺", "孟红霞", "贺宁" }
String str1 = "aaa";
String str2 = new String(str1)
String str2 = new String("aaa")
char a[] = {'H','e','l','l','0'};  // 字符数组转字符串
String sChar = new String(a);
String sChar = new String(a,1,4);  // String(char[] value,int offset,int count)
```
### 2. String与int转换
```java

// String 字符串转整型 int
Integer.parseInt(str)
Integer.valueOf(str).intValue()
// int转换为String
String s = String.valueOf(i)
String s = Integer.toString(i)
String s = "" + i;
// 通用
int a = Integer.parseInt(str)
String s = Integer.toString(a)

```
### 3. Java字符串拼接（连接)

String 字符串虽然是不可变字符串，但也可以进行拼接只是会产生一个新的对象。String 字符串拼接可以使用“+”运算符或 String 的 concat(String str) 方法。“+”运算符优势是可以连接任何类型数据拼接成为字符串，而 concat 方法只能拼接 String 类型字符串。
```java
// 使用连接运算符“+”
String str="Welcome to"+"Beijing"+"欢迎来到"+"北京。"+"北京我的故乡。";

// String 类的 concat() 方法实现了将一个字符串连接到另一个字符串的后面。
//  concat() 方法语法格式如下： 字符串 1.concat(字符串 2);
str1.concat(str2)

// 连接其他类型数据: 字符串也可同其他基本数据类型进行连接。
String str="Welcome to"+"Beijing"+6+3.2;
```
### 4. Java获取字符串长度
```java
str1.length();
```

### 5. Java字符串大小写转换

String 类的 toLowerCase() 方法可以将字符串中的所有字符全部转换成小写，而非字母的字符不受影响。toUpperCase() 则将字符串中的所有字符全部转换成大写，而非字母的字符不受影响。
```java
str1.toLowerCase()
str1.toUpperCase()  
```

### 6. Java去除字符串中的空格

字符串中存在的首尾空格一般情况下都没有任何意义，如字符串“ Hello ”，但是这些空格会影响到字符串的操作，如连接字符串或比较字符串等，所以应该去掉字符串中的首尾空格，这需要使用 String 类提供的 trim() 方法。
```java
str1.trim()
```
### 7. Java截取（提取）子字符串
在 String 中提供了两个截取字符串的方法，一个是从指定位置截取到字符串结尾，另一个是截取指定范围的内容。
> substring(int beginIndex) 形式

此方式用于提取从索引位置开始至结尾处的字符串部分。
```java
String str = "我爱 Java 编程";
String result = str.substring(3);
```

> substring(int beginIndex，int endIndex) 形式

此方法中的 beginIndex 表示截取的起始索引，截取的字符串中包括起始索引对应的字符；endIndex 表示结束索引，截取的字符串中不包括结束索引对应的字符，如果不指定 endIndex，则表示截取到目标字符串末尾。该方法用于提取位置 beginIndex 和位置 endIndex 位置之间的字符串部分。 **左闭右关**
**注意：substring() 方法是按字符截取，而不是按字节截取。**
```java
String day = "Today is Monday"  //原始字符串
String str1 = day.substring(2,10) // day is M
```
### 8. Java截取（提取）子字符串
String 类的 split() 方法可以按指定的分割符对目标字符串进行分割，分割后的内容存放在字符串数组中

```java
// sign 为指定的分割符，可以是任意字符串。
// limit 表示分割后生成的字符串的限制个数，如果不指定，则表示不限制，直到将整个目标字符串完全分割为止。
str.split(String sign)
str.split(String sign,int limit)
```

使用分隔符注意如下：

1）“.”和“|”都是转义字符，必须得加“\\\\”。**`.`、 `$`、 `|` 和`*` 等转义字符，必须得加 \\\\。**
如果用“.”作为分隔的话，必须写成String.split("\\\\.")，这样才能正确的分隔开，不能用String.split(".")。
如果用“|”作为分隔的话，必须写成String.split("\\\\|")，这样才能正确的分隔开，不能用String.split("|")。

2）如果在一个字符串中有多个分隔符，可以用“|”作为连字符，比如：“acount=? and uu =? or n=?”，把三个都分隔出来，可以用String.split("and|or")。

### 9. Java字符串的替换
在 Java 中，String 类提供了 3 种字符串替换方法，分别是 replace()、replaceFirst() 和 replaceAll()
```java
// replace() 方法:
// replace() 方法用于将目标字符串中的指定字符（串）替换成新的字符（串），其语法格式如下：
// 其中，oldChar 表示被替换的字符串；newChar 表示用于替换的字符串。replace() 方法会将字符串中所有 oldChar 替换成 newChar。
str1.replace(String oldChar, String newChar)

// replaceFirst() 方法
// replaceFirst() 方法用于将目标字符串中匹配某正则表达式的第一个子字符串替换成新的字符串，其语法形式如下：
str2.replaceFirst(String regex, String replacement) // 其中，regex 表示正则表达式；replacement 表示用于替换的字符串。
String words = "hello java，hello php";
String newStr = words.replaceFirst("hello","你好 ");  // 你好 java,hello php 

// replaceAll() 方法
// replaceAll() 方法用于将目标字符串中匹配某正则表达式的所有子字符串替换成新的字符串，
str3.replaceAll(String regex, String replacement) // 其中，regex 表示正则表达式，replacement 表示用于替换的字符串。
```
注意：replaceFirst() 方法和replaceAll() 方法的第一个参数是正则表达式



### 9. Java字符串比较
在 Java 中，比较字符串的常用方法有 3 个：equals() 方法、equalsIgnoreCase() 方法、 compareTo() 方法。
```java
// equals() 方法
// equals() 方法将逐个地比较两个字符串的每个字符是否相同
// 如果两个字符串具有相同的字符和长度，它返回 true，否则返回 false。对于字符的大小写，也在检查的范围之内。
str1.equals(str2);

// equalsIgnoreCase() 方法
// equalsIgnoreCase() 方法的作用和语法与 equals() 方法完全相同，唯一不同的是 equalsIgnoreCase() 比较时不区分大小写。
str1.equalsIgnoreCase(str2)

// compareTo() 方法
// compareTo() 方法用于按字典顺序比较两个字符串的大小，该比较是基于字符串各个字符的 Unicode 值。
// 如果按字典顺序 str 位于 otherster 参数之前，比较结果为一个负整数；
// 如果 str 位于 otherstr 之后，比较结果为一个正整数；
// 如果两个字符串相等，则结果为 0。
str1.compareTo(str2)
```

### 10. Java字符串查找
字符串查找分为两种形式：一种是在字符串中获取匹配字符（串）的索引值，另一种是在字符串中获取指定索引位置的字符。



### 1X. 其他重要函数
```java
//数组排序 boolean startsWith(String prefix) 测试此字符串是否以指定的前缀开始。
str.startsWith("aaa")
	

```


