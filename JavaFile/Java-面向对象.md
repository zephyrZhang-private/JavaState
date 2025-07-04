## 面向对象

### 1、概念

* 面向过程
  * 面向功能
* 面向对象
  * 面向拥有功能的载体

* 面向对象是对于面向过程而言，基于面向过程

### 2、比较全局变量和局部变量

全局变量也称成员变量

* 成员变量作用在整个对象，局部变量作用在当前函数或方法中
* 成员变量有默认值，局部变量必须先赋值在使用
* 成员变量释放机制跟对象保持一致，由垃圾回收机制负责回收，局部变量使用完立即释放
* 成员变量存储在堆区中，局部变量存储在栈区的方法中

## 3、静态成员

* 静态成员需要使用类调用，非静态成员使用引用调用（实例化对象）
* 静态成员只可以调用静态成员，非静态成员都可以调用

## 4、构造方法

* 便于给属性赋值
* 结构：修饰符 方法名(参数列表){方法体}
* 构造方法方法名必须与类名一致
* 构造方法没有返回值
* 构造方法之间的关系是重载
* 实例化对象赋值时，系统默认创建一个空参构造方法，手动创建后系统便不在创建
* 为了更好的赋值提示，参数列表一般与属性名一致，但因就近原则，构造方法优先识别局部变量，无法正常给全局变量赋值，this关键字调用成员变量，this.name = name;代表构造方法接收的name值赋给成员变量
* this是一个引用类型，保存的是当前对象的地址，this调用的一定是成员变量
* this必须在当前类使用
* this只能作为构造方法使用，作为构造方法只能放在方法第一行，this作为构造方法，不能相互调用
* this(name,age)，有几个参数就表示哪个构造方法 --简化代码，减少冗余





# Object类

* 1个方法
  * equals：默认比对对象的地址，根据自己的需要进行重写
  * hashCode：对象的hash码，类似对象身份证，与equals一起重写，打印16进制，利用包装类Integer.toHexString(对象.hashCode())
  * getClass：获取当前类字节码文件对象，一个类有一个字节码文件和一个字节码文件对象字节码文件对象称类对象 -- Student student = new Student(); Class cla = student.getClass();
  * toSring：重写打印正常值，默认打印包名+类名+@+16进制hashcode



# 访问权限修饰符

* private：当前类可见可用
* default：当前包可用
* public：所有属性公开



# 多态

1、原理：一种事物的多种形态

2、前提：继承，如果没有继承关系，就不会存在多态

3、解释：父类的引用指向子类的对象，Person person = new Student();  Object object = new Student();

4、优缺点

* 缺点：
  *  编译阶段，执行运行前，识别=前引用类型，不能识别=后的对象
  * 运行阶段：识别=后的对象，开始工作
  * 不能直接调用子类中特有的方法
    * 解决办法1：在父类中生成一个同名的方法，此时子类重写，父类代码不能随意修改
    * 解决办法2：强制类型转换，父类强转成子类，Person person = new Student; Student student = (Student)person;student调用方法就可
* 优点
  * 提高拓展性，使用之前定义好的功能，后续直接使用，无需重复添加  

5、强转在多态中称为向上转型、向下转型

* 子类转父类：向上转型（隐式）一定会成功  目的实现多态
* 父类转子类：向下转型（显式）可能会失败  目的调用子类特有的成员
* 子类的引用不能指向父类的对象

6、多态的instanceof运算符

* 向下转型可能会失败，引用对象指向的对象，不是要强转的类型，执行会出现ClassCastException异常，向下转型前，使用instanceof进行类型检查
* 语法：对象 instanceof 类或当前类的子类
* 原理：判断当前是否为后面的类或者子类的对象，是true否false
* instanceof前要有继承关系

# 抽象类

* 抽象类，abstract修饰的类
* 抽象方法：abstract修饰的方法，只有方法定义，没有具体实现，没有方法体
* 抽象方法一定在抽象类中，抽象类中不一定有抽象方法
* 抽象类不可以直接实例化对象，只能通过子类实现
* abstract与final、static、private连用
  * abstract修饰的类只能通过子类实现，抽象方法通过子类重写实现
  * final修饰的类不能有子类，方法不能被重写
  * static修饰的方法可以通过类名直接调用
  * private
* 优点：指定一部分规则



# 接口

* 只有抽象方法的抽象类就叫接口
* 接口可成为规则的列表
* 默认成分：(public static final)成员变量;(public abstract)成员方法;成员变量定义成final为了实现符号变量，现已被枚举替代
* 可利用多态实现接口，父类的引用指向子类的对象
* 实现接口：子类 implements 父类接口，抽象类实现，非抽象类实现（必须重写接口中所有方法）
* 在继承中：
  * 一个父类可以有多个子类，一个子类只能有一个直接的父类
  * 一个父接口可以有多个子类，一个子类可以同时实现多个父接口，多个父接口之间用逗号隔开
  * 一个父接口可以有多个子接口，一个子接口同时继承多个父接口，此时子接口便拥有了所有父接口的行为
* 作为单继承的补充，间接实现了多继承，减轻父类压力，功能列表清晰明了
* 接口的新特性：
  * 当接口中有多个重名的抽象方法时，子类不会出错，因为父接口的方法都没有实现
  * 从jdk1.8开始，接口中允许有非抽象的方法存在，必须使用static（只能使用接口名字调用，接口的引用和实现类都不能使用）或者default（可以重写也可以不重写）修饰
  * 如果接口中有多个重名带实现的方法和抽象方法时，子类必须重写





# 内部类

* 内部类：定义在类中的类，在java中，可以在类的内部定义一个完整的类
* 内部类作为外部类的成员，地位和外部类的成员变量和成员方法一样，可以互相访问
* 内部类编译后，可以生成独立的字节码文件
* 内部类可以直接访问外部类的私有成员，不用破坏封装
* 可为外部类提供必要的内部功能