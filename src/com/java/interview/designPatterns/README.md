# Design Patterns - Complete Guide

A comprehensive reference for learning and understanding all 23 Gang of Four (GoF) design patterns with real-world examples, use cases, advantages, and disadvantages.

---

## Table of Contents

1. [Creational Patterns](#creational-patterns)
   - [Singleton Pattern](#singleton-pattern)
   - [Factory Pattern](#factory-pattern)
   - [Abstract Factory Pattern](#abstract-factory-pattern)
   - [Builder Pattern](#builder-pattern)
   - [Prototype Pattern](#prototype-pattern)

2. [Behavioral Patterns](#behavioral-patterns)
   - [Observer Pattern](#observer-pattern)
   - [Strategy Pattern](#strategy-pattern)
   - [State Pattern](#state-pattern)
   - [Chain of Responsibility Pattern](#chain-of-responsibility-pattern)
   - [Command Pattern](#command-pattern)
   - [Interpreter Pattern](#interpreter-pattern)
   - [Iterator Pattern](#iterator-pattern)
   - [Mediator Pattern](#mediator-pattern)
   - [Memento Pattern](#memento-pattern)
   - [Template Method Pattern](#template-method-pattern)
   - [Visitor Pattern](#visitor-pattern)

3. [Structural Patterns](#structural-patterns)
   - [Adapter Pattern](#adapter-pattern)
   - [Bridge Pattern](#bridge-pattern)
   - [Composite Pattern](#composite-pattern)
   - [Decorator Pattern](#decorator-pattern)
   - [Facade Pattern](#facade-pattern)
   - [Flyweight Pattern](#flyweight-pattern)
   - [Proxy Pattern](#proxy-pattern)

---

## CREATIONAL PATTERNS

Creational patterns deal with object creation mechanisms, trying to create objects in a manner suitable to the situation.

### Singleton Pattern

#### **Definition**

The Singleton Pattern ensures that a class has only one instance and provides a global point of access to it.

#### **Key Concepts**

- **Private Constructor**: Prevents instantiation from outside the class
- **Static Instance**: Holds the single instance of the class
- **Static Access Method**: Provides global access to the instance (usually `getInstance()`)
- **Thread Safety**: Ensures only one instance exists even in multithreaded environments

#### **Implementation Types**

1. **Eager Initialization**: Instance created at class loading time
2. **Lazy Initialization**: Instance created on first access
3. **Bill Pugh Singleton**: Using static helper class (thread-safe, lazy)
4. **Double-Checked Locking**: Optimized lazy initialization for multithreading

#### **Real-World Use Cases**

- Database connections
- Logging frameworks (Logger, Log4j)
- Configuration managers
- Thread pools
- Caches
- Spring ApplicationContext
- JDBC Connection Pool

#### **Advantages**

✅ Controlled single instance - memory efficient <br>
✅ Global access point - easier to use <br>
✅ Lazy initialization possible - defer object creation <br>
✅ Thread-safe implementations available <br>
✅ Prevents accidental duplication of resources

#### **Disadvantages**

❌ Hides dependencies - hard to test <br>
❌ Violates Single Responsibility Principle <br>
❌ Difficult to mock in unit testing <br>
❌ Can cause issues in multi-threaded applications if not properly implemented <br>
❌ Makes the code less flexible and harder to maintain <br>
❌ Global state makes code harder to reason about

#### **Common Pitfalls**

- Not handling serialization (breaks singleton in deserialization)
- Not handling cloning (breaks singleton when object is cloned)
- Reflection can break singleton pattern
- Not handling multithreading properly

---

### Factory Pattern

#### **Definition**

The Factory Pattern provides an interface for creating objects, but lets subclasses decide which class to instantiate. It creates objects without specifying the exact classes.

#### **Key Concepts**

- **Creator (Factory)**: Abstract class/interface that defines factory method
- **Concrete Creator**: Implements the factory method to create specific products
- **Product**: Interface/abstract class that defines the object interface
- **Concrete Product**: Concrete implementation of the product

#### **Real-World Use Cases**

- DatabaseConnection creation (MySQL, PostgreSQL, Oracle)
- Logger creation (FileLogger, ConsoleLogger, DatabaseLogger)
- UI element creation (Button, Checkbox, RadioButton)
- Payment processor creation (PayPal, Stripe, Square)
- Shape creation in graphics applications
- Document format creation (PDF, Word, Excel)

#### **Advantages**

✅ Loose coupling - client doesn't depend on concrete classes <br>
✅ Easy to extend - add new product types without changing existing code <br>
✅ Follows Open/Closed Principle <br>
✅ Centralizes object creation logic <br>
✅ Makes code more maintainable <br>
✅ Supports polymorphism

#### **Disadvantages**

❌ More classes needed - increases complexity <br>
❌ Can be overkill for simple object creation <br>
❌ Indirection - harder to trace which class is created <br>
❌ May lead to complex class hierarchies <br>
❌ Requires understanding of inheritance

---

### Abstract Factory Pattern

#### **Definition**

The Abstract Factory Pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes.

#### **Key Concepts**

- **Abstract Factory**: Declares methods for creating abstract products
- **Concrete Factory**: Implements methods to create concrete products
- **Abstract Product**: Interface/abstract class for related products
- **Concrete Product**: Implementations of abstract products
- **Product Family**: Related objects created together (e.g., Windows Button + Checkbox vs. Mac Button + Checkbox)

#### **Difference from Factory Pattern**

- Factory Pattern: Creates single product hierarchy
- Abstract Factory: Creates multiple related product families

#### **Real-World Use Cases**

- UI toolkit creation (Windows theme, Mac theme, Linux theme)
- Database driver families (MySQL+Dialect, PostgreSQL+Dialect)
- Cross-platform rendering engines
- Theme implementation (Dark mode, Light mode, Auto mode)
- GUI components across different operating systems
- Report generation (PDF, HTML, Excel factories)

#### **Advantages**

✅ Encapsulates family of related objects <br>
✅ Easy to switch between product families <br>
✅ Ensures consistency within product family <br>
✅ Follows Single Responsibility Principle <br>
✅ Follows Open/Closed Principle <br>
✅ Better than multiple simple factories

#### **Disadvantages**

❌ More complex than Factory Pattern <br>
❌ Adding new product type requires changing all factories <br>
❌ Overkill for small applications <br>
❌ Higher number of classes <br>
❌ Steep learning curve

---

### Builder Pattern

#### **Definition**

The Builder Pattern provides a way to construct complex objects step by step. It separates the construction logic from the object representation, allowing the same construction process to create different representations.

#### **Key Concepts**

- **Builder**: Abstract interface for building products
- **Concrete Builder**: Implements build steps, returns product
- **Director**: Constructs object using builder interface (optional)
- **Product**: Complex object being built
- **Fluent Interface**: Method chaining for cleaner syntax

#### **Real-World Use Cases**

- Creating complex objects (Burger, Pizza with many optional ingredients)
- StringBuilder in Java
- Configuration objects with many optional parameters
- HTTP request builders
- SQL query builders
- XML/JSON document builders
- House building scenarios
- Meal preparation in restaurants

#### **Advantages**

✅ Readable and maintainable code with fluent interface <br>
✅ Can create immutable objects safely <br>
✅ Handles optional parameters elegantly <br>
✅ Separates construction from representation <br>
✅ Builds objects step by step <br>
✅ Easier to understand complex object creation <br>
✅ Reduces constructor parameter count

#### **Disadvantages**

❌ More code required - even simple objects need builders <br>
❌ Slightly more overhead compared to constructors <br>
❌ May be overkill for simple objects <br>
❌ Immutability requirement might be limiting <br>
❌ Multiple classes needed (builder + product)

---

### Prototype Pattern

#### **Definition**

The Prototype Pattern creates new objects by copying an existing object (prototype) rather than creating from scratch. It specifies the kinds of objects to create using a prototypical instance and creates new objects by cloning the prototype.

#### **Key Concepts**

- **Prototype**: Interface/abstract class declaring clone method
- **Concrete Prototype**: Implements clone method for actual copying
- **Clone Methods**:
  - **Shallow Copy**: Copies object references (not deep values)
  - **Deep Copy**: Creates independent copy of nested objects
- **Prototype Registry**: Keeps track of available prototypes (optional)

#### **Real-World Use Cases**

- Game development (cloning game objects)
- Document editors (undo/redo functionality)
- Cloning database records
- Creating copies of UI elements
- Duplicate files in operating systems
- Copying email templates
- Photo editing applications
- Cloud resource instances

#### **Advantages**

✅ Creates objects faster (no complex initialization) <br>
✅ Avoids subclassing <br>
✅ Good for expensive object creation <br>
✅ Can clone partially initialized objects <br>
✅ Useful for undo/redo functionality <br>
✅ Simplifies object creation

#### **Disadvantages**

❌ Cloning complex objects is tricky <br>
❌ Deep vs. shallow copy confusion <br>
❌ Circular reference issues in cloning <br>
❌ Requires careful handling of mutable objects <br>
❌ May need significant cloning code <br>
❌ Not suitable for all object types

---

## BEHAVIORAL PATTERNS

Behavioral patterns focus on communication between objects, defining how objects interact and distribute responsibility.

### Observer Pattern

#### **Definition**

The Observer Pattern defines a one-to-many relationship where when one object (Subject/Observable) changes state, all its dependents (Observers) are notified automatically.

#### **Key Concepts**

- **Subject/Observable**: Maintains state and notifies observers
- **Observer**: Interface that observers must implement
- **Concrete Observer**: Updates itself when notified
- **Push vs. Pull**: Push (data sent) vs. Pull (observer fetches data)
- **Event-Driven Architecture**: Objects react to state changes

#### **Real-World Use Cases**

- Event handling in GUI frameworks (button clicks, window events)
- Model-View-Controller (MVC) pattern
- Social media notifications (follow someone, get updates)
- Stock price monitoring system
- Pub/Sub messaging systems
- Document change notifications
- Real-time dashboard updates
- Java's Observable/Observer classes
- RxJava reactive programming
- Spring Events

#### **Advantages**

✅ Loose coupling - subject doesn't depend on observers <br>
✅ Dynamic relationships - add/remove observers at runtime <br>
✅ Supports broadcast communication <br>
✅ Follows Open/Closed Principle <br>
✅ Easy to extend with new observers <br>
✅ Clean separation of concerns

#### **Disadvantages**

❌ Observers notified in undefined order <br>
❌ Can lead to memory leaks if observers not unregistered <br>
❌ Performance overhead for many observers <br>
❌ Difficult to trace dependencies <br>
❌ Observer might be updated even if irrelevant changes occur <br>
❌ Can cause unexpected side effects

---

### Strategy Pattern

#### **Definition**

The Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. It lets the algorithm vary independently from clients that use it.

#### **Key Concepts**

- **Strategy**: Interface for different algorithms
- **Concrete Strategy**: Implements specific algorithm
- **Context**: Uses strategy to execute algorithm
- **Runtime Selection**: Strategies chosen at runtime
- **Encapsulation**: Algorithm details hidden from client

#### **Real-World Use Cases**

- Payment methods (Credit Card, PayPal, Google Pay, Apple Pay)
- Sorting algorithms (QuickSort, MergeSort, BubbleSort)
- Compression strategies (ZIP, RAR, GZIP)
- Routing algorithms (GPS navigation - shortest, fastest, scenic)
- Searching algorithms (BinarySearch, LinearSearch)
- Image processing filters
- Authentication methods (OAuth, JWT, Basic Auth)
- Caching strategies (LRU, LFU, FIFO)

#### **Advantages**

✅ Easy to switch algorithms at runtime <br>
✅ Eliminates if-else chains <br>
✅ Follows Open/Closed Principle <br>
✅ Single Responsibility Principle <br>
✅ Testable - each strategy can be tested independently <br>
✅ Flexible and maintainable

#### **Disadvantages**

❌ Client must be aware of different strategies <br>
❌ Small number of algorithms makes pattern overkill <br>
❌ More classes needed <br>
❌ Strategy selection logic must be defined elsewhere <br>
❌ Memory overhead for many strategy objects <br>
❌ Increased complexity for simple cases

---

### State Pattern

#### **Definition**

The State Pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class. It encapsulates different behaviors for different states.

#### **Key Concepts**

- **Context**: Maintains instance of ConcreteState that defines current state
- **State**: Interface defining behavior for each state
- **Concrete State**: Implements state-specific behavior
- **State Transitions**: Context delegates to current state
- **Stateful Object**: Behavior changes based on internal state

#### **Difference from Strategy Pattern**

- **Strategy**: Client chooses algorithm to use
- **State**: Context changes behavior based on internal state

#### **Real-World Use Cases**

- Order processing (Pending → Processing → Shipped → Delivered)
- Document states (Draft → Review → Published)
- TCP connection states (Established, Listen, Closed)
- Player states in games (Running, Jumping, Falling, Dead)
- Elevator states (Moving Up, Moving Down, Idle)
- Traffic light states (Red, Yellow, Green)
- State machines in workflow engines
- Vending machine states

#### **Advantages**

✅ Eliminates large switch statements <br>
✅ Each state in separate class - Single Responsibility <br>
✅ State transitions explicit and localized <br>
✅ Easy to add new states <br>
✅ Better organization of state-dependent code <br>
✅ Testable state transitions

#### **Disadvantages**

❌ More classes needed for each state <br>
❌ Can be overkill for objects with few states <br>
❌ Overhead of creating state objects <br>
❌ Potential for complex state transition logic <br>
❌ Difficult to debug state transitions <br>
❌ Learning curve for understanding state transitions

---

### Chain of Responsibility Pattern

#### **Definition**

The Chain of Responsibility Pattern creates a chain of handler objects where each handler decides either to process the request or pass it along the chain to the next handler.

#### **Key Concepts**

- **Handler**: Abstract interface for handling requests
- **Concrete Handler**: Implements handler, passes request if not handled
- **Request**: Object passed through chain
- **Chain**: Series of handlers linked together
- **Optional Processing**: Handler may or may not process request

#### **Real-World Use Cases**

- Logging frameworks with multiple loggers (Info → Debug → Error)
- Approval workflows (Manager → Director → VP → CEO)
- Exception handling in try-catch chains
- Servlet filters and interceptors in web frameworks
- Middleware in Express.js, Spring Security
- Help desk ticket routing (Support → Manager → Director)
- Event bubbling in GUI frameworks
- ATM withdrawal (insufficient funds → account verification → bank processing)

#### **Advantages**

✅ Decouples sender from receiver <br>
✅ Handlers don't know about each other <br>
✅ Easy to add new handlers without modifying existing ones <br>
✅ Dynamic chain construction <br>
✅ Request can be processed by multiple handlers <br>
✅ Follows Single Responsibility Principle

#### **Disadvantages**

❌ Request might not be processed if chain incomplete <br>
❌ Difficult to debug - hard to trace request flow <br>
❌ Performance overhead - traversing the chain <br>
❌ Chain construction can be complex <br>
❌ Undefined order of handler execution <br>
❌ Memory consumption with long chains

---

### Command Pattern

#### **Definition**

The Command Pattern encapsulates a request as an object, allowing you to parameterize clients with different requests, queue requests, and support undoable operations.

#### **Key Concepts**

- **Command**: Interface for executing operations
- **Concrete Command**: Implements command for specific action
- **Invoker**: Asks command to carry out request
- **Receiver**: Knows how to perform actual work
- **Encapsulation**: Request becomes an object
- **Decoupling**: Invoker doesn't depend on receiver

#### **Real-World Use Cases**

- Undo/Redo functionality in text editors
- Remote control buttons (TV remote, game controller)
- Job queues and background tasks
- Macro recording in office applications
- Transaction systems (commit/rollback)
- GUI button and menu actions
- Task scheduling and batch processing
- Event handlers in event-driven systems
- Asynchronous execution

#### **Advantages**

✅ Decouples object making request from receiver <br>
✅ Enables undo/redo functionality <br>
✅ Can queue, schedule, and execute requests <br>
✅ Easy to add new commands without changing existing code <br>
✅ Supports macros and command composition <br>
✅ Can log/audit command history

#### **Disadvantages**

❌ More classes needed - command for each action <br>
❌ Increased complexity for simple operations <br>
❌ Memory overhead for each command object <br>
❌ Undo/Redo implementation can be complex <br>
❌ State management for undo can be challenging <br>
❌ May lead to large number of classes

---

### Interpreter Pattern

#### **Definition**

The Interpreter Pattern defines a grammatical representation for a language and an interpreter to interpret sentences in that language. It specifies how to evaluate sentences of a language.

#### **Key Concepts**

- **Expression**: Interface for interpreting sentences
- **Terminal Expression**: Implements interpretation for terminal symbols
- **Non-Terminal Expression**: Implements interpretation for non-terminal symbols
- **Context**: Information used during interpretation
- **Abstract Syntax Tree (AST)**: Hierarchical representation of expression
- **Grammar**: Rules for the language

#### **Real-World Use Cases**

- SQL query parsing and execution
- Regular expression evaluation
- Mathematical expression evaluation (calculator)
- Report generation languages
- Domain-specific languages (DSLs)
- Configuration file parsers
- Search query languages
- UNIX shell command interpretation
- Template engines

#### **Advantages**

✅ Easy to change and extend grammar <br>
✅ Implementing grammar is straightforward <br>
✅ Easy to implement complex languages <br>
✅ Follows Open/Closed Principle <br>
✅ Each rule in separate class <br>
✅ Supports tree representation

#### **Disadvantages**

❌ Can become complex with complex grammars <br>
❌ Performance issues with large inputs <br>
❌ Complex classes for simple expressions <br>
❌ Difficult to debug interpretation <br>
❌ Memory overhead for AST <br>
❌ Not suitable for real-time parsing

---

### Mediator Pattern

#### **Definition**

The Mediator Pattern defines an object that encapsulates how a set of objects interact. It promotes loose coupling by keeping objects from referring to each other explicitly and letting you vary their interaction independently.

#### **Key Concepts**

- **Mediator**: Interface defining methods for colleague communication
- **Concrete Mediator**: Implements mediator to coordinate colleague actions
- **Colleague**: Base class for colleagues
- **Concrete Colleague**: Interacts with other colleagues through mediator
- **Centralized Control**: All communication goes through mediator
- **Reduced Coupling**: Colleagues don't directly reference each other

#### **Real-World Use Cases**

- User interface elements (text fields, buttons, checkboxes)
- Air traffic control system
- Chat room (users communicate through chat room)
- Calendar system (appointments scheduled through central mediator)
- Dialog boxes in GUI applications
- Game character interactions
- Flight booking system
- Stock exchange system

#### **Advantages**

✅ Decouples colleagues from each other <br>
✅ Centralizes complex communication logic <br>
✅ Easy to reuse colleagues in different contexts <br>
✅ Follows Single Responsibility Principle <br>
✅ Easier to maintain and modify communication rules <br>
✅ Reduces dependencies

#### **Disadvantages**

❌ Mediator can become very complex ("God Object") <br>
❌ Hidden dependencies between colleagues <br>
❌ Difficult to debug mediator logic <br>
❌ Can become a bottleneck <br>
❌ Performance overhead <br>
❌ Not suitable for simple communication

---

### Memento Pattern

#### **Definition**

The Memento Pattern creates and externalizes an object's internal state without violating encapsulation, allowing the object to be restored to this state later. It provides undo capability.

#### **Key Concepts**

- **Originator**: Creates memento containing its state
- **Memento**: Stores internal state of originator
- **Caretaker**: Manages mementos (doesn't examine contents)
- **Snapshot**: Copy of object state at a point in time
- **Encapsulation**: Memento content not exposed to caretaker

#### **Real-World Use Cases**

- Undo/Redo in text editors and IDEs
- Photo editing applications (layer snapshots)
- Database transaction rollback
- Game save functionality
- Browser history (back button)
- Version control systems
- Snapshot backups
- Configuration rollback
- Form draft saving

#### **Advantages**

✅ Provides undo/redo capability <br>
✅ Preserves encapsulation <br>
✅ Caretaker doesn't need to know object structure <br>
✅ Easy to implement save/restore <br>
✅ Can save multiple snapshots <br>
✅ Simple to understand

#### **Disadvantages**

❌ Can consume significant memory with many mementos <br>
❌ Performance overhead for large objects <br>
❌ Difficult to manage memento lifecycle <br>
❌ Serialization issues with complex objects <br>
❌ No incremental snapshots (stores entire state) <br>
❌ Cleanup of old mementos can be complex

---

### Template Method Pattern

#### **Definition**

The Template Method Pattern defines the skeleton of an algorithm in a base class, letting subclasses override specific steps without changing the algorithm's structure.

#### **Key Concepts**

- **Abstract Class**: Defines template method with algorithm skeleton
- **Template Method**: Defines algorithm structure by calling abstract methods
- **Abstract Methods**: Defined in abstract class, implemented by subclasses
- **Hook Methods**: Optional steps that subclasses can override
- **Inversion of Control**: Framework controls flow, not client code

#### **Real-World Use Cases**

- Game development (game loop structure)
- Data processing pipelines (read → process → write)
- JUnit's TestCase (setUp → test → tearDown)
- Servlet processing (doGet → process → doPost)
- Spring Template classes (JdbcTemplate, RestTemplate)
- Build processes
- Report generation (header → content → footer)
- Authentication process (login → verify → authorize)

#### **Advantages**

✅ Code reuse - common algorithm shared <br>
✅ Enforces algorithm structure <br>
✅ Follows DRY principle <br>
✅ Inversion of control provides flexibility <br>
✅ Easy to extend without breaking existing code <br>
✅ Subclasses focus only on implementation details

#### **Disadvantages**

❌ Can violate Liskov Substitution Principle if incorrectly used <br>
❌ Inheritance chain can be deep <br>
❌ Limited to implementation through inheritance (not composition) <br>
❌ Difficult to test abstract method behavior <br>
❌ Hard to understand without seeing base class <br>
❌ May lead to fragile base class problem

---

### Visitor Pattern

#### **Definition**

The Visitor Pattern represents an operation to be performed on elements of an object structure. It lets you define a new operation without changing the classes of the elements on which it operates.

#### **Key Concepts**

- **Visitor**: Interface declaring visit methods
- **Concrete Visitor**: Implements specific operations
- **Element**: Interface with accept method for visitor
- **Concrete Element**: Implements accept, typically calls `visitor.visit(this)`
- **Object Structure**: Collection of elements
- **Double Dispatch**: Determines which method to call at runtime

#### **Real-World Use Cases**

- Document processing (visit different element types)
- XML/JSON parsing and transformation
- Compiler design (syntax tree traversal)
- Report generation from object structures
- File system traversal
- GUI component traversal
- Parsing and analysis of abstract syntax trees
- Testing and validation of object structures

#### **Advantages**

✅ Easy to add new operations without modifying elements <br>
✅ Gathers related operations in one class <br>
✅ Follows Open/Closed Principle <br>
✅ Single Responsibility Principle <br>
✅ Complex operations on object structures organized <br>
✅ Allows operations on complex object structures

#### **Disadvantages**

❌ Difficult to add new element types <br>
❌ Violates Encapsulation - elements expose internal structure <br>
❌ Complex to understand (double dispatch concept) <br>
❌ Overkill for simple operations <br>
❌ Requires strong typing for each element <br>
❌ Challenging to maintain in changing hierarchies

---

## STRUCTURAL PATTERNS

Structural patterns deal with object composition, creating relationships between entities to form larger structures.

### Adapter Pattern

#### **Definition**

The Adapter Pattern (also called Wrapper) converts the interface of a class into another interface that clients expect. It allows incompatible interfaces to work together.

#### **Key Concepts**

- **Target**: Interface that client expects
- **Adapter**: Converts source interface to target interface
- **Adaptee**: Existing class with incompatible interface
- **Client**: Uses target interface
- **Two Types**:
  - **Class Adapter**: Uses inheritance
  - **Object Adapter**: Uses composition (preferred)

#### **Real-World Use Cases**

- Charger adapters (old charger → new socket)
- Database drivers (JDBC adapters for different databases)
- Audio/video adapters (VGA to HDMI)
- SD card reader for USB
- Legacy system integration
- Third-party library integration
- Framework adapters
- Payment gateway integrations

#### **Advantages**

✅ Lets incompatible interfaces work together <br>
✅ Single Responsibility - separates interface conversion <br>
✅ Open/Closed Principle - add adapters without modifying existing code <br>
✅ Reuse existing classes with incompatible interfaces <br>
✅ Flexible composition approach
✅ Easy to test

#### **Disadvantages**

❌ Additional class creation <br>
❌ Can hide design problems <br>
❌ May indicate poor design upstream <br>
❌ Performance overhead with multiple adapters <br>
❌ Complex to debug (hides actual implementation) <br>
❌ Not suitable for situations where interfaces are similar

---

### Bridge Pattern

#### **Definition**

The Bridge Pattern decouples an abstraction from its implementation so the two can vary independently. It bridges the gap between abstraction and implementation hierarchies.

#### **Key Concepts**

- **Abstraction**: High-level interface
- **Refined Abstraction**: Extends abstraction
- **Implementor**: Low-level interface
- **Concrete Implementor**: Implements low-level operations
- **Composition**: Uses implementor instead of inheritance
- **Prevents Class Explosion**: Avoids creating multiple subclasses

#### **Real-World Use Cases**

- Shape abstraction with different drawing implementations
- Vehicle abstraction (Car, Bike) with transmission types (Manual, Auto)
- GUI frameworks (abstraction: Window, implementation: rendering engines)
- Database abstraction layers
- Cross-platform application development
- Remote controls with different TV implementations
- Payment processors with different gateways
- Logging framework with different backends

#### **Advantages**

✅ Decouples abstraction from implementation <br>
✅ Reduces class proliferation <br>
✅ Follows Single Responsibility Principle <br>
✅ Open/Closed Principle - add implementations without changing abstraction <br>
✅ Better code organization <br>
✅ Easier to test and maintain

#### **Disadvantages**

❌ Increases complexity for simple cases <br>
❌ More classes needed <br>
❌ Harder to understand <br>
❌ May be overkill when abstraction doesn't vary <br>
❌ Indirection complicates debugging <br>
❌ Performance overhead with extra indirection

---

### Composite Pattern

#### **Definition**

The Composite Pattern composes objects into tree structures to represent part-whole hierarchies, allowing clients to treat individual objects and compositions of objects uniformly.

#### **Key Concepts**

- **Component**: Common interface for leaf and composite objects
- **Leaf**: Represents leaf objects (no children)
- **Composite**: Represents nodes with children
- **Tree Structure**: Hierarchical organization
- **Uniform Treatment**: Clients treat leaves and composites uniformly
- **Recursive Composition**: Composites can contain composites

#### **Real-World Use Cases**

- File system (folders and files)
- GUI component hierarchies (Panels, Buttons, Text fields)
- Organization structure (Employees, Managers, Departments)
- Menu systems (submenus in menus)
- Document structure (sections, subsections, paragraphs)
- Game object hierarchies
- Comment threads (comments with nested replies)
- Network topology (routers, switches, devices)

#### **Advantages**

✅ Simple client code - treats parts and wholes uniformly <br>
✅ Easy to add new component types <br>
✅ Flexible hierarchies <br>
✅ Natural representation of part-whole relationships <br>
✅ Recursive operations easy to implement <br>
✅ Follows Open/Closed Principle

#### **Disadvantages**

❌ Overly generic design <br>
❌ Difficult to restrict component types <br>
❌ Can make design overly complex for simple cases <br>
❌ Inefficient for operations on individual leaves <br>
❌ Hard to prevent invalid compositions <br>
❌ Type safety issues (can add wrong type of child)

---

### Decorator Pattern

#### **Definition**

The Decorator Pattern attaches additional responsibilities to an object dynamically, providing a flexible alternative to subclassing for extending functionality.

#### **Key Concepts**

- **Component**: Interface for objects to which functionality can be added
- **Concrete Component**: Original object
- **Decorator**: Base decorator class implementing component interface
- **Concrete Decorator**: Adds specific functionality
- **Wrapping**: Decorators wrap components
- **Stacking**: Multiple decorators can wrap same object
- **Runtime Modification**: Add functionality at runtime

#### **Real-World Use Cases**

- Coffee shop (basic coffee, add milk, add sugar, add caramel)
- Input/Output streams (FileInputStream wrapped with BufferedInputStream, DataInputStream)
- GUI components (adding borders, scrollbars, titles)
- Feature additions (text formatting: bold, italic, underline)
- Caching decorators
- Logging decorators
- Authorization decorators
- Compression layers (zip before sending)

#### **Advantages**

✅ Flexible alternative to subclassing <br>
✅ Add responsibilities at runtime <br>
✅ Avoids class explosion <br>
✅ Follows Single Responsibility Principle <br>
✅ Open/Closed Principle <br>
✅ Easy to combine multiple decorations <br>
✅ Same behavior as inheritance without subclassing

#### **Disadvantages**

❌ Many small objects created (memory overhead) <br>
❌ Order of decorators matters (can be confusing) <br>
❌ Complex to debug with many decorators <br>
❌ Difficult to remove decorators <br>
❌ Type identification problems <br>
❌ Performance overhead with many decorators <br>
❌ Increased complexity

---

### Facade Pattern

#### **Definition**

The Facade Pattern provides a unified, simplified interface to a set of interfaces in a subsystem. It simplifies complex systems by providing single entry point.

#### **Key Concepts**

- **Facade**: Provides simplified interface
- **Subsystem Classes**: Complex implementations hidden
- **Unified Interface**: Hides system complexity
- **Decoupling**: Clients depend on facade, not subsystem
- **Convenience**: Combines multiple operations
- **Simplification**: Makes complex subsystems easy to use

#### **Real-World Use Cases**

- Home automation system (single facade for lights, temperature, security)
- Travel booking system (combines flight, hotel, car rental)
- Banking system (single interface for multiple operations)
- Database frameworks (Hibernate, JPA façade)
- Web frameworks routing
- Simplified API for complex libraries
- Game development (single interface for graphics, audio, physics)
- Shopping cart (combines inventory, payment, shipping)

#### **Advantages**

✅ Simplifies complex subsystems <br>
✅ Decouples clients from subsystem <br>
✅ Promotes loose coupling <br>
✅ Makes system easier to understand <br>
✅ Provides convenient interface <br>
✅ Acts as single entry point <br>
✅ Isolates client code from subsystem changes

#### **Disadvantages**

❌ Can become a "god object" if not careful <br>
❌ May hide useful subsystem features <br>
❌ Can slow down advanced users <br>
❌ Difficult to extend (changes affect many classes) <br>
❌ Can become bottleneck <br>
❌ Violates Open/Closed Principle if subsystem changes frequently <br>
❌ False sense of simplicity

---

### Flyweight Pattern

#### **Definition**

The Flyweight Pattern uses sharing to support large numbers of fine-grained objects efficiently. It reduces memory usage by sharing common state between multiple objects.

#### **Key Concepts**

- **Flyweight**: Interface for objects that can share state
- **Concrete Flyweight**: Implements shareable objects
- **Flyweight Factory**: Creates and manages flyweight instances
- **Intrinsic State**: Shared state (immutable)
- **Extrinsic State**: Unique state per object (passed to flyweight)
- **Memory Optimization**: Reduces object count
- **Object Pool**: Reuses objects instead of creating new ones

#### **Real-World Use Cases**

- Text editor (character objects sharing font/style)
- Game development (particle systems, terrain tiles)
- Database connection pooling
- String interning in Java
- Web browsers (rendering millions of DOM nodes)
- Graphics rendering (texture sharing)
- Chess game (pieces sharing same type state)
- Font caching systems
- UI framework elements

#### **Advantages**

✅ Dramatically reduces memory consumption <br>
✅ Improves performance (fewer objects to manage) <br>
✅ Sharing objects across application <br>
✅ Efficient for large-scale systems <br>
✅ Useful for resource-intensive objects <br>
✅ Good for many similar objects

#### **Disadvantages**

❌ Increased complexity <br>
❌ Difficult to implement correctly <br>
❌ Thread safety concerns with shared state <br>
❌ Performance trade-off (lookup vs. creation) <br>
❌ Difficult to debug (shared state issues) <br>
❌ Not suitable for small object counts <br>
❌ Requires careful state management

---

### Proxy Pattern

#### **Definition**

The Proxy Pattern provides a surrogate or placeholder for another object to control access to it. It acts as intermediary between client and real object.

#### **Key Concepts**

- **Subject**: Interface for real and proxy objects
- **Real Subject**: Actual object that proxy represents
- **Proxy**: Surrogate that controls access to real subject
- **Lazy Initialization**: Create real object only when needed
- **Access Control**: Restrict operations on real object
- **Logging/Monitoring**: Track access to real object
- **Caching**: Cache responses from real object

#### **Types of Proxies**

1. **Protection Proxy**: Controls access based on permissions
2. **Virtual Proxy**: Lazy initialization of expensive objects
3. **Cache Proxy**: Caches results of operations
4. **Remote Proxy**: Represents object in different process/network
5. **Logging Proxy**: Logs all accesses

#### **Real-World Use Cases**

- Network proxies (VPN, firewall)
- Database connection pooling
- Lazy loading (loading objects only when needed)
- Access control (user permissions)
- Logging access to sensitive objects
- Caching remote service calls
- Spring's AOP proxies
- Protected file access
- Virtual private network (VPN)

#### **Advantages**

✅ Controls access to another object <br>
✅ Lazy initialization - create objects on demand <br>
✅ Caching results improves performance <br>
✅ Logging and monitoring capabilities <br>
✅ Security and access control <br>
✅ Reduces memory usage (lazy loading) <br>
✅ Can add extra functionality transparently

#### **Disadvantages**

❌ Additional layer of indirection <br>
❌ Performance overhead <br>
❌ Increased complexity <br>
❌ Difficult to debug <br>
❌ May not be necessary if real object is simple <br>
❌ Maintenance burden <br>
❌ Client must know about proxy

---

## Quick Reference Comparison

### By Category

| Pattern | Type | Key Purpose | Complexity |
|---------|------|-----------|-----------|
| Singleton | Creational | One instance only | Low |
| Factory | Creational | Object creation | Low-Medium |
| Abstract Factory | Creational | Related objects creation | Medium |
| Builder | Creational | Complex object construction | Medium |
| Prototype | Creational | Object cloning | Medium |
| Observer | Behavioral | One-to-many notification | Medium |
| Strategy | Behavioral | Algorithm selection | Low |
| State | Behavioral | Behavior based on state | Medium |
| Chain of Responsibility | Behavioral | Request passing | Medium |
| Command | Behavioral | Encapsulate request | Medium |
| Interpreter | Behavioral | Language interpretation | High |
| Mediator | Behavioral | Centralized communication | Medium-High |
| Memento | Behavioral | State snapshot | Medium |
| Template Method | Behavioral | Algorithm skeleton | Low-Medium |
| Visitor | Behavioral | New operations on objects | High |
| Adapter | Structural | Interface conversion | Low |
| Bridge | Structural | Abstraction-Implementation decoupling | Medium-High |
| Composite | Structural | Part-whole hierarchy | Medium |
| Decorator | Structural | Dynamic functionality addition | Medium |
| Facade | Structural | Simplified interface | Low-Medium |
| Flyweight | Structural | Memory optimization | High |
| Proxy | Structural | Controlled access | Medium |

### By Frequency of Use

**Most Common:**

- Singleton
- Factory
- Observer
- Strategy
- Builder
- Adapter
- Decorator
- Facade

**Moderately Common:**

- Chain of Responsibility
- Command
- State
- Template Method
- Composite
- Proxy

**Less Common:**

- Abstract Factory
- Prototype
- Interpreter
- Mediator
- Memento
- Visitor
- Bridge
- Flyweight

---

## Best Practices

1. **Don't Overuse Patterns**: Use patterns to solve real problems, not to over-engineer
2. **Understand the Problem First**: Choose pattern after understanding problem
3. **Know Trade-offs**: Every pattern has advantages and disadvantages
4. **Combine Patterns**: Often multiple patterns work together
5. **Keep It Simple**: Start simple, add patterns if needed
6. **Refactor Toward Patterns**: Discover patterns through refactoring
7. **Document Pattern Usage**: Help team understand why pattern is used
8. **Test Thoroughly**: Design patterns shouldn't break testability

---

## Common Pattern Combinations

- **MVC**: Composite + Observer + Strategy
- **Dependency Injection**: Factory + Singleton
- **ORM Frameworks**: Proxy + Facade + Template Method
- **Game Development**: Strategy + State + Composite
- **Event Systems**: Observer + Command + Mediator
- **Caching**: Proxy + Flyweight + Builder

---

## Resources for Further Learning

- Gang of Four: "Design Patterns: Elements of Reusable Object-Oriented Software"
- Refactoring Guru: Design Patterns
- Source Making: Design Patterns
- Head First Design Patterns

---

**Last Updated**: December 2024
**Status**: Complete with all 23 GoF patterns documented
