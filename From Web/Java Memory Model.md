#Java内存模型与volatile关键字

###Java Memory Model

Java内存模型，不同于Java运行时数据区，JMM的主要目标是定义程序中各个变量的访问规则，即在虚拟机中将变量存储到内存和从内存中读取数据这样的底层细节。JMM规定了所有的变量都存储在主内存中，但每个线程还有自己的工作内存，线程的工作内存中保存了被该线程使用到的变量的主内存副本拷贝。线程对变量的所有操作都必须在工作内存中进行，而不能直接读写主内存中的变量，工作内存是线程独立的，线程之间变量值的传递均需要通过主内存来完成。

###volatile关键字

当一个变量被定义为volatile之后，就可以保证次变量对所有线程的可减刑，即当一个线程修改了此变量的值时，变量新的值对于其他线程来说是可以立即得知的。可以理解成：对volatile变量所有的写操作都能立刻被其他线程得治。但是这并不代表基于volatile变量的运算在并发下是安全的，因为volatile只能保证内存可见性，却没有保证对变量操作的原子性。

若要使用volatile变量，需符合两种场景：

+   变量的运算结果并不依赖于变量的当前值，或能够保证只有单一的线程修改变量的值。
+   变量不需要与其他的状态变量共同参与不变约束。

- - - - - - - - -

```java
    public class Singleton_2 {
        
        private volatile static Singleton_2 instance = null;
     
        private Singleton_2() {
        }
     
        public static Singleton_2 getInstacne() {
            if (instance == null) {
                synchronized (Singleton_2.class) {
                    if (instance == null) {
                        instance = new Singleton_2();
                    }
                }
            }
            return instance;
        }
    }
```

+   为了避免JIT编译器对代码的指令重排序优化，可以使用volatile关键字，
+   通过这个关键字还可以使该变量不会在多个线程中存在副本，
+   变量可以看作是直接从主内存中读取，相当于实现了一个轻量级的锁。

变量在有了volatile修饰之后，对变量的修改会有一个内存屏障的保护，使得后面的指令不能被重排序到内存屏障之前的位置。volatile变量的读性能与普通变量类似，但是写性能要低一些，因为它需要插入内存屏障指令来保证处理器不会发生乱序执行。即便如此，大多数场景下volatile的总开销仍然要比锁低，所以volatile的语义能满足需求时，选择volatile要优于使用锁。
