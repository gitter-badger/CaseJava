Java 测试
==

[![Build Status](https://travis-ci.org/MurphyL/CaseJava.svg?branch=master)](https://travis-ci.org/MurphyL/CaseJava)

	常用的代码测试：算法、设计模式、工具类等等


## 常用工具类
 
### Joda - 时间操作的工具类

1. DataTime；

## 其他的一些内容

1. Java8 以下不支持　java.lang.reflect.Method.getParameterTypes() 以及 java.lang.reflect.Method.getParameterCount()；


-----

# 一些技巧

#### 检查一个数组包含一个值

开发者经常这么做：

```java
    Set<String> set = new HashSet<String>(Arrays.asList(arr));  
    return set.contains(targetValue);  
```
代码可以工作，但是没有必要首先转换列表到Set，转换一个列表到一个Set需要额外的时间。因此你可以把它简化为：

```java
    Arrays.asList(arr).contains(targetValue);
```
#### 在一个循环中从一个列表里删除一个元素

考虑下面删除元素的代码在迭代中的结果：

```java
    ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
    for (int i = 0; i < list.size(); i++) {
        list.remove(i);
    }
    System.out.println(list);
```

输出是：

```java
    [b, d]  
```

该方法有一个严重的问题，当一个元素被删除时，列表收缩的大小以及指针改变了。所以想要在循环内利用指针删除多个元素是无法正常进行的。

这种情况下使用迭代器才是正确的方法，foreach循环在Java中的工作像是一个迭代器，但实际上并不是，考虑下面的代码：

```java
    ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
    for (String s : list) {
        if (s.equals("a")) {
            list.remove(s);
        }
    }
```

它会报出ConcurrentModificationException异常。相反下面这个就可以正常工作。

```java
    ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
    Iterator<String> iter = list.iterator();
    while (iter.hasNext()) {
        String s = iter.next();
        if (s.equals("a")) {
            iter.remove();
        }
    }
```

.next()必须在.remove()之前被调用。在foreach循环中，编译器将在删除元素操作之后调用.next()，这也是导致ConcurrentModificationException异常的原因，你可以点击此处查看ArrayList.iterator()的源代码。