#Java内存问题
>   在Java中，内存泄漏一般都是忧郁引用对象不再被使用二造成的。当有多个引用的对象，同时这些对象又不再需要，然而开发者又忘记清理他们，这时极容易导致内存泄漏的发生。
>   执行消耗太多的内存而导致不必要的高内存占用。这在为了用户体验而管理大量状态信息的Web应用中很常见。
>   当用户负载增加时，低效的对象创建容易导致性能问题。从而垃圾回收器必须不断地清理堆内存。这导致了垃圾回收器对CPU产生了不必要的高占用。随着CPU因垃圾回收而被阻塞，应用程序响应时间频繁的增加，导致其一直处于中等负载之下。也就是"GC trashing"。
>   低效的垃圾回收行为往往是由于垃圾回收器的缺失或者错误的配置。这些垃圾回收器将会时刻最总对象是否被清理。

#Java的设计模式 －－ImportNew

生命中唯一不变的事实就是世事时刻在变。

###Questions

######Java集合框架的基础接口

Collection为集合层级的根接口。一个集合代表一组对象，这些对象即为它的元素。Java平台不提供这个接口任何直接的实现。
Set是一个不能包含重复元素的集合。这个接口对数学集合抽象进行建模，被用来代表集合，如一副牌。
List是一个有序集合，可以包含重复元素。可以通过它的索引来访问任何元素。List更像长度动态变换的数组。
Map是一个将key映射到value的对象。一个Map不能包含重复的key：每个key最多只能映射一个value。

######为何Map接口不继承Collection接口

尽管Map接口和它的实现也是集合框架的一部分，但Map不是集合，集合也不是Map。

Iterator接口提供遍历任何Collection的接口。我们可以从一个Collection中使用迭代器方法来获取迭代器实例。迭代器取代了Java集合框架中的Enumeration。迭代器允许调用着在迭代过程中移除元素。

Enumeration的速度是Iterator的两倍，也适用更少的内存。Enumeration是非常基础的，也满足了基础的需求。但是，与Enumeration相比，Iterator更加安全，因为当一个集合正在被遍历的时候，它会阻止其他线程去修改集合。并且，跌倒器允许调用者从集合中移除元素，而Enumeration不能做到。

Iterator可以用来遍历Set和List集合，而ListIterator只能遍历List。
Iterator只能向前遍历，而ListIterator可以双向比你。
ListIterator从Iterator接口继承，然后添加了一些额外的功能。

######HashMap和HashTable

HashMao允许key和value为null，而HashTabe不允许。
HashTable是同步的，而HashMap不是。所以HashMap适合单线程环境，HashTable适合多线程环境。
HashMap提供了对key的Set进行遍历，因此它是fail－fast的；但HashTable提供对key的Enumeration进行遍历，它不支持fail－fast。
HashTable被认为是个遗留的类，如果寻求在迭代的时候修改Map，应该使用CocurrentHashMap。

######如何选择HashMap和TreeMap

对于在Map中插入、删除和定位元素这类操作，HashMap是最好的选择。然而，假如需要对一个有序的key集合进行遍历，TreeMap是更好的选择。基于Collection的大小，也许向HashMap中添加元素会更快，将map换为TreeMap进行有序key的遍历。

######ArrayList和Vector

相同点：
两者都是基于索引的，内部由一个数组支持。
两者维护插入的顺序，我们可以根据插入顺序来获取元素。
ArrayList和Vector的迭代器实现都是fail-fast的。
ArrayLis和Vector两者允许null值，也可以使用索引值对元素进行随机访问。
不同点：
Vector是同步的，而ArrayList不是。然而，如果你寻求在迭代的时候对列表进行改变，应该使用CopyOnWriteArrayList。
ArrayList比Vector快，它因为有同步，不会过载。
ArrayList更加通用，因为我们可以使用Collections工具类轻易地获取同步列表和只读列表。

######Array和ArrayList

Array可以容纳基本类型和对象，而ArrayList只能容纳对象。
Array是指定大小的，ArrayList大小是固定的。

######线程安全的集合类

Vector、HashTable、Properties和Stack是同步类，所以是线程安全的。

######Comparable和Comparator

如果我们想使用Array或Collection的排序方法时，需要在自定义类里实现Java提供Comparable接口。Comparable接口有compareTo(T OBJ)方法，它被排序方法所使用。我们应该重写这个方法，如果"this"对象比传递的对象参数更小、相等或更大时，它返回一个负整数、0或正整数。但是，在大多数情况下，我们想根据不同参数进行排序。Comparable.compareTo(Object o)方法实现只能基于一个字段进行排序，不能根据对象排序的需要选择字段。Comparator接口的compare(Object o1, Object o2)方法的实现需要传递两个对象参数，若第一个参数比第二个小，返回负整数；若第一个等于第二个，返回0；若第一个比第二个大，返回正整数。

Comparable和Comparator接口被用来对对象集合或者数组进行排序。
Comparable接口被用来提供对象的自然排序，我们可以使用它来提供基于单个逻辑的排序。
Comparator接口被用来提供不同的排序算法，我们可以选择需要使用的Comparator来对给定的对象集合进行排序。

多态
多态是编程语言给不同的底层数据类型做相同的接口展示的一种能力。一个多态类型上的操作可以应用到其他类型的值上面。

封装
封装给对象提供了隐藏内部特性和行为的能力。

抽象
抽象是把想法从具体的实例中分离出来的步骤，因此，要根据他们的功能而不是实现细节来创建类。Java支持创建只暴漏接口而不包含方法实现的抽象的类。

static关键字表明一个成员变量活着成员方法可以在没有所属的类的实例变量的情况下被访问。
Java中static方法不能被覆盖，因为方法覆盖是基于运行时动态绑定的，而static方法是编译时静态绑定的。static方法跟类的任何实例都不相关。

static变量在Java中是属于类的，它在所有的实例中的值是一样的。当类被Java虚拟机载入时，会对static变量进行初始化。如果你的代码尝试不用实例来访问非static的变量，编译器会报错，因为这些变量还没有被创建出来，还没有跟任何实例关联上。

Java中的方法重载发生在同一个类里面两个活着多个方法的方法名相同但参数不同的情况。与此同时，方法覆盖是说子类重新定义了父类的方法。方法覆盖必须有相同的方法名，参数列表和返回类型。覆盖着可能不会限制它所覆盖的方法的访问。

接口和抽象类的区别
接口中所有的方法隐含的都是抽象的。而抽象类则可以同时包含抽象和非抽象的方法。
类可以实现很多个接口，但是只能继承一个抽象类。
类如果要实现一个接口，它必须要实现接口声明的所有方法。但是，类可以不实现抽象类声明的所有方法，当然，在这种情况下，类也必须得声明成是抽象的。
抽象类可以在不提供接口方法实现的情况下实现接口。
Java接口中声明的变量默认都是final的。抽象类可以包含非final的变量。
Java接口中的成员变量默认是public的。抽象类也不可以被实例化，但是，如果它包含main方法的话是可以被调用的。

受检异常和运行时异常
运行时异常不需要再方法或者是构造函数上声明，就算方法或者是构造函数的执行都可能会抛出这样的异常，因此运行时异常可以传播到方法或者是构造函数的外面。相反，受检异常必须要用throws语句在方法或者是构造函数上声明。

三次握手
1.客户端尝试连接服务器，向服务器发送syn包，syn＝j，客户端进入SYN_SEND状态等待服务器确认。
2.服务器接收客户端syn包并确认(ack=j+1)，同时向客户端发送一个SYN包(syn=k)，SYN＋ACK包，此时服务器进入SYN_RECV状态。
3.客户端收到服务器SYN+ACK包，向服务器发送确认包ACK(ack=k+1)，此包发送完毕，客户端和服务端进入ESTABLISHED状态，完成三次握手。
synchronize sequence numbers

volatile和synchronized
volatile关键字只用来在线程内存和主内存之间同步单个变量值，synchronized关键字用来同步线程内存和主内存之间的所有变量值以及如何锁定和释放一个监视器。清楚的是，synchronized比volatile有更大的开销。volatile变量不允许出现和当前主存中的数据值不同的本地副本。
更准确地说，被声明为volatile的变量必须保证它的数据值在所有线程中的同步。也就是当你在任一线程中访问或者更新一个变量时，所有其他线程能够立刻访问到相同的值。

