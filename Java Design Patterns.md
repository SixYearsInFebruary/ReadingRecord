#Java Design Patterns

###Abstract Factory

Intent: Provide an interface for creating families of related or dependent objects without specifying their concrete classes.

+   a system should be independent of how its products are created, composed and represented.
+   a system should be configured with one of multiple families of products.
+   a family of related product objects is designed to be used together, and you need to enforce this constraint.
+   you want to provide a class library of products, and you want to reveal just their interfaces, not their implementations.

###Factory Method

Intent: Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.

+   a class can't anticipate the class of objects it must create.
+   a class wants subclasses to specify the objects it creates.
+   classes delegate responsibility to one of several helper subclasses, and you want to localize the knowledge of which helper subclass is the delegate.

###Builder

Intent: Separate the construction of a complex object from its representation so that the same construction process can create different representations.

+   the algorithm for creating a complex object should be independent of the parts that make up the object and how they're assembled.
+   the construction process must allow different representations for the object that's constructed.

###Prototype

Intent: Specify the kinds of objects to create using a prototypical instance, and create new objects by copying this prototype.

+   when the classes to instantiate are specified at run-time, for example, by dynamic loading; or
+   to avoid building a class hierarchy of factories that parallels the class hierarchy of products; or
+   when instances of a class can have one of only a few different combinations of states. It may be more convenient to install a corresponding number of prototypes and clone them rather than instantialing the class manually, each time with the appropriate state.

###Multiton

Intent: Ensure a class only has limited number of instances, and provide a global point of access to them.

+   there must be specific number of instances of a class, and they must be accessible to clients from a well-known access point.

###Object Pool

Intent: When objects are expensive to create and they are needed only for short periods of time it is advantageous to utilize the Object Pool Pattern. The Object Pool provides a cache for instantiated objects tracking which ones in use and which are available.

+   The objects are expensive to create (allocate cast).
+   You need a large number of short-lived objects (memory fragmentation).

###Observer

Intent: Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

+   when an abstaction has two aspects, one dependent on the other. Encapsulating these objects in separate objects lets you vary and reuse them independently.
+   when a change to one object requires changing others, and you don't know how many objects need to be changed.
+   when an object should be able to notify other objects without making assumptions about who these objects are. In other words, you don't want these objects tightly coupled.