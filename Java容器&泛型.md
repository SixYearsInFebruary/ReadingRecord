"=="可以用于原始值进行比较，也可以用于对象进行比较。当用于对象与对象之间比较时，比较的不是对象代表的值，而是检查两个对象是否是同一个对象，这个比较过程中没有自动装箱发生。进行对象值比较不应该使用"=="，而应该使用对象对应的equals方法。
自动装卸会隐式地创建对象，如果在一个循环体内，会创建无用的中间对象，这样会增加GC压力，拉低程序的性能。所以在写循环时一定要注意代码，避免引入不必要的自动装卸操作。

#Collection vs Collections

Collection是容器层次结构中根接口。而Collections是一个提供一些处理容器类静态方法的类。
JDK不提供Collection接口的具体实现，而是提供了更加具体的子接口（Set List）实现。

###Collection接口存在的作用

所有容器的实现类（如ArrayList实现了List接口，HashSet实现了Set接口）提供了两个标准的构造函数来实现：1.一个无参的构造方法。2.一个带有Collection类型单参数构造方法，用于创建一个具有某参数相同元素新的Collection及其实现类等。实际上：因为所有通用的容器类遵循从Collection接口，用第二种构造方法是允许容器之间相互的复制。

```java
    <I>Collection: <I>Set:  HashSet
                            LinkedHashSet
                            TreeSet
                   <I>List: ArrayList
                            Vector
                            LinkedList
                   <I>Queue:LinkedList
                            PriorityQueue
```

###Set

一个不包括重复元素的Collection，是一种无序的集合。Set不包含满a.equals(b)的元素对a和b，并且最多有一个null。实现Set的接口有：EnumSet、HashSet、TreeSet等。

###List

一个有序的Collection（也成序列），元素可以重复。确切的讲，列表通常允许满足e1.equals(e2)的元素对e1和e2，并且如果列表本身允许null的话，通常它们允许多个null元素。实现List的有：ArrayList、LinkedList、Vector、Stack等。

###Queue

一种队列是双端队列，支持在头、尾两端插入和移除元素，主要包括：ArrayDeque、LinkedBlockingDeque、LinkedList。另一个是阻塞式队列，队列满了以后再插入元素则会抛出异常，主要包括ArrayBlockQueue、PriorityBlockingQueue、LinkedBlockingQueue。虽然接口并未定义阻塞方法，但是实现类扩展了此接口。

```java
    <I>Map: Hashtable
            LinkedHashMap
            HashMap
            TreeMap
```

###Map

是一给键值对的集合。也就是说，一个映射不能包含重复的键，每个键最多映射到一个值。该接口取代了Dictionary抽象类。

###Vector和ArrayList

1.  Vector是线程同步的，所以它也是线程安全的，而ArrayList是线程异步的，而不是安全的。如果不考虑线程的安全因素，一般用ArrayList效率较高。
2.  如果集合中的元素的数目大于目前集合数组的长度时，Vector增长率为目前数组长度的100%，而ArrayList增长率为目前数组长度的50%。如果在集合中使用数据量比较大的数据，用Vector有一定的优势。
3. 如果查找一个指定位置的数据，Vector和ArrayList使用的时间是相同的，都是O(1)，这时候都可以选择。

###ArrayList和LinkedList

1.  ArrayList是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构。
2.  对于随机访问get和set，ArrayList优于LinkedList，因为LinkedList要移动指针。
3.  对于新增和删除操作add和remove，LinkedList比较有优势，因为ArrayList要移动数据。

这一点要看实际情况的。若只对单条数据插入或删除，ArrayList的速度反而优于LinkedList。但若是批量随机的插入删除数据，LinkedList的速度大大优于ArrayLis。因为ArrayList每插入一条数据，要移动插入点及之后的所有数据。

###HashMap和TreeMap

1.  HashMap通过hashcode对其内容进行快速查找，而TreeMap中所有的元素都保持着某种固定的顺序，如果你需要得到一个有序的结构你就应该使用TreeMap（HashMap中元素的排列顺序是不固定的）。
2.  HashMap通过hashcode对其内容进行快速查找，而TreeMap中所有的元素都保持着某种固定的顺序，如果需要得到一个有序的结果，就应该使用TreeMap（HashMap中元素的排序顺序是不固定的）。集合框架提供两种常规的Map实现：HashMap和TreeMap（TreeMap实现SortedMap接口）。
3.  在Map中插入、删除和定位元素，HashMap是最好的选择。但如果要按自然顺序或自定义顺序遍历键，那么TreeMap会更好。使用HashMap要求添加的键类需明确定义了hashCode()和equals()的实现。这个TreeMap没有优选项，因为该树总处于平衡状态。

###Hashtable和HashMap

1.  历史原因：Hashtable是基于陈旧的Dictionary类的，HashMap是Java 1.2引进的Map接口的一个实现。
2.  同步性：Hashtable是线程安全的，也就是说是同步的，而HashMap是线程不安全的，不是同步的。
3.  值：只有HashMap可以让你将空值作为一个表的条目的key或value。


