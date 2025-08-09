# js知识回顾

## 1.1 关于js的定义
> 行内写法

    <input type="button" values="点击" onclick ="alert("hello")">

> 内部写法

    <script type="text/javascript">
    	alert("hello");
    </script>

> 外部写法

将js代码定义在独立的js文件中,然后将js文件引入到对应的html页面中

第一步: 定义一个独立的js文件 common.js

第二步 : 引入

    <script type="text/javascript" src="js/common.js"></script>

## 1.2 js的变量

    <script type="text/javascript">
    	var num = 23;
    	//可以省略var关键字
    	age=12;
    	var str = "hello";
    	//可以用单引号引用字符串的值
    	var str1 = 'hello';
    	//定义布尔类型的值
    	vat flag = true;
    </script>

维护变量的时候,变量的名称必须要有意义,变量名称一定要小写,遵循驼峰命名法,不要使用js关键字

## 1.3 js的注释

    单行注释 //
    多行注释 /**/

## 1.4 js常用的数据类型

    number
    string
    boolean
    object
    undefined
    null

如何查看变量的数据类型：typeof关键字

    var num =10;
    console.log(typeof num);

### 1.4.1 number

不管是小数还是整数都是number描述,number变量值有范围

    Number.MIN_VALUE //描述number最小值
    Number.MAX_VALUE //描述number最大值

判断当前是否是个数字 : isNaN(is not a number)

    var username = "roby";
    console.log(isNaN(username));//true 如果不是一个数字返回true
    var age = "12";
    console.log(isNaN(age));//false 如果是一个数字返回false

### 1.4.2 String
关于字符串定义,单引号和双引号都可以
描述字符串的长度

    <script type="text/javascript">
    	var msg = "hello";
        console.log(msg.length)
        console.log("abc\nefg"); //换行
        console.log("abc\tefg"); //制表符
        console.log("abc\"efg"); //转义双引号
        console.log("abc\'efg"); //转义单引号
    </script>

将字符串转换成整数类型 : parseInt()
    
    console.log(parseInt("10")); //10
    console.log(parseInt("10abc")); //10
    console.log(parseInt("abc10")); //NaN
    console.log(parseInt("3.141592654")); //3
    console.log(parseInt("3.141592654abc")); //3

将字符串转换成小数类型 : parseFloat()

    console.log(parseFloat("10")); //10
    console.log(parseFloat("10abc")); //10
    console.log(parseFloat("10.111")); //10.111
    console.log(parseFloat("10.111abc")); //10.111
    console.log(parseFloat("abc10.1111abc")); //NaN

字符串转换成数字 Number , 比parseInt()方法严格,不是纯数字NaN

    console.log(Number("10")); //10
    console.log(Number("10abc")); //NaN
    console.log(Number("abc10")); //NaN
    console.log(Number("10.345")); //10.345
    console.log(Number("10.345abc")); //NaN

其他数据类型转换成布尔值 Boolean() , 非0 非空 全为true 反之false

    console.log(Boolean(1)); //true
    console.log(Boolean(1.11)); //true
    console.log(Boolean(0)); //false
    console.log(Boolean(-12)); //true
    console.log(Boolean("true")); //true
    console.log(Boolean("hello")); //true
    console.log(Boolean("null")); //true
    console.log(Boolean(null));//false
    console.log(Boolean(undefined)); //false
    console.log(Boolean(NaN)); //false

## 2.1运算符
算术运算符

    + - * / %
    /与Java不一致,Java取商,js取精准结果,有可视性无限循环

比较运算符

    > < >= <= == != ===
    == : 比较两个数据类型值值是否相等,数据不一样转换成相对应的数字之后再比较
    === : 比较数据的值是否相等,还比较数据类型是否相等
    num6 = 7;
    str1 = "7";
    console.log(num6 == str1); //true
    console.log(num6 === str1); //false

关于==的问题
比较两个操作数的值是否相等，相等返回true,比较时,首先会将两个操作符进行数据转换,然后在比较其是否相等

    var num1 = 88;
    var num2 = "88";
    console.log(num1 == num2); //true
    var obj = new Object(3);
    var num3 = 3;
    console.log(obj == num3);  //true 由于obj是对象,js会自动获取对象的值,valueof,然后对比
    num4 = NaN;
    num5 = NaN;
    console.log(num4 == num5); //false 如果一个变量是NaN,任何数据与NaN,操作符都返回false
    obj1 = new Object("hello");
    obj2 = new Object("hello");
    console.log(obj1 == obj2); //false 对比的是对象,new出的对象包false
    console.log(null == undefined); //true null和undefined相比,为true

逻辑运算符

    && : 一假则假
    || : 一真则真

三目运算符

    表达式 ? 结果1 ： 结果2
    表达式 ? true 结果1 : false 结果2

# 3.1 js中流程控制语句
if语句

    if(条件){
        //满足条件的代码
    }

if-else语句

    if(条件){
        //满足条件的代码
    }else{
        //不满足条件的代码
    }

多重if代码

    if(条件){
        //满足条件的代码
    }else if(条件){
        //满足条件的代码
    }
    ......
    else{
        //不满足以上所有条件的代码
    }

switch语句 break:直接跳出 continue:继续向下 

    switch(值){
        case "值1":
            //满足case分支执行的代码
        break;
        case "值2":
            //满足case分支执行的代码
        break;
        ......
        default:
            //不满足以上所有分支执行的代码
        break;
    }

## 4.1 循环语句
while循环

    while(条件表达式){//满足条件执行的代码 break;跳出循环} //true为死循环

do-while循环
    
    do{循环体}while(循环条件); //先执行后判断

for循环

    for(循环条件){满足循环条件执行的代码}

## 5.1 js数组
> 在js中定义数组

直接赋值

    var arr = [1,2,3,4,5]

创建数组对象,赋值

    var arr = new Array(3);
    arr[0]=0
    arr[1]=11
    arr[2]=20

> 描述数组的长度

    arr.length

js数组长度可变,Java中不可变

## 6.1 js函数
普通函数定义

    function 函数名(参数列表){
        //函数体;
    }
定义js函数时，不需要定义返回值,参数列表也不需要指定数据类型

    function getNum(num1,num2){
        return num1 + num2; //需要函数返回结果,直接return
    }
    //通过函数名调用
    var num1 = getNum(1,2);
    console.log(num1); //3

    var num2 = getNum(1,2,3);
    console.log(num2); //3

    var num3 = getNum(1);
    console.log(num3); //NaN

理解js函数中参数的传递原理
在js中,任何函数的内部都隐式的维护了一个arguments的数组对象,
在进行参数传递的时,先将参数的值传递给arguments数组对象中的元素,
arguments数组对象再将元素的值传给实际参数
实际参数没有值传递会显示未定义undefined

匿名函数定义

    var f1 = function(num1,num2){
        console.log("求和 : "+(num1+num2));
    }
    //匿名函数调用
    f1(1,8);

对象函数定义,用到了Function关键字,不推荐,可读性差

    var f2 = new Function("a","b",console.log("求和:"+(a+b)))
    //函数调用
    f2(1,8)


# Js中内置对象

string 字符串创建的方式

    var str1 = "abc"; //直接赋值
    var str2 = new String("abc"); //通过new赋值
    var str3 = String("abc"); //字符串的构造函数赋值
    console.log(typeof str1) //String
    console.log(typeof str2) //Object
    console.log(typeof str3) //String
如果js数据类型是string,这种类型存储在栈内存中
如果js数据类型是Object,这种类型存储在堆内存中
栈内存存储的是对堆内存中对象的引用

字符串中常用的方法

    indexOf():返回指定字符在字符串中索引的位置
    concat:拼接字符串
    lastIndexOf:返回指定字符在字符串中最后一次出现的索引的位置
    split:切割字符串
    replace:字符串内容的替换
    substring:截取字符串

Date内置对象

    var date = new Date();//创建系统时间的日期对象
    date.getFullYear() : 获取当前系统时间的年部分
    date.getMonth() : 获取当前系统时间的月部分
    date.getDate() : 获取当前系统时间的天部分
    date.getDay() : 获取当前系统时间是星期几
    date.getHours() : 获取当前系统时间的小时部分
    date.getMinutes() : 获取当前系统时间的分钟部分
    date.getSeconds() : 获取当前系统时间的秒部分

Math对象

    Math.abs(-90) : 取绝对值
    Math.floor(3.121) : 向下取整
    Math.ceil(3.14) : 向上取整
    Math.random() : 取0-1随机数
    Math.min(1,2,50,66) : 取最小值
    Math.max(1,2,50,66) : 取最大值

Number对象

    var num = new Number(3.141592654);
    num.toFixed(3) : 精确到小数点后两位,四舍五入

Array对象

    arr.concat(arr2) : 将arr2的数组元素追加到arr中
    arr.pop() : 将数组中的元素弹出来并返回(弹出来=删除)
    arr.reverse() : 将数组的元素翻转
    arr.sort() : 数组排序

自定义对象

    new关键字
    函数创建
    自定义构造函数
    原型的思想构建对象 prototype(增强)将一个空对象增强成一个带属性和方法的对象
    字面量的方式 -- 最常见

# js的事件
事件就是用户通过介质{HTML元素},触发行为{单击|双击|鼠标悬停|鼠标移入|鼠标移出|失去焦点|获取焦点}
行为触发对应js代码的执行,这个过程就叫js事件

    单击事件:onclick
    鼠标移入移除事件:onmouseover onmouseout
    失去焦点获取焦点:onfocus onblur
    下拉框区域改变事件:onchange
    表单提交事件:onsubmit
    窗体加载事件:windows.onload
    键盘事件:keydown(键盘按下) keypress(按下弹起瞬间) keyup(按键弹起后)

特性

    阻止事件的默认行为 : 组织a标签跳转功能 | 表单的submit按钮
    阻止事件的传播行为 : 
        div1嵌套了div2
        onmouseover,鼠标移入事件
        鼠标移入div2,弹出alert-div2后弹出alert-div1
        这种行为便是事件传播行为,也叫事件冒泡行为
        解决方法:从div2的鼠标移入事件阻止事件冒泡

# BOM编程
浏览器对象模型
window: 内置对象,对整个浏览器窗口描述,以下方法window可省略

    window.onload = function(){}
    window.confirm() 确认框  确认-true 取消-false
    window.alert() 提示框
    window.prompt("请输入用户名") 输入框
    window.open("https://www.baidu.com") 跳转,浏览器默认拦截
    window.setTimeOut("函数”,时间毫秒值) 在指定的时间后,触发指定函数,只触发一次
    window.clearTimeOut("需要接收setInterval返回值") 清除setTimeOut触发的定时函数
    window.setInterval("函数",事件毫秒值) 每隔指定时间,指定当前函数
    window.clearInterval("需要接收setInterval返回值"),停止当前系统时间
    
    location.href="https://www.baidu.com";实现地址的跳转
    location.reload(); 重新加载网页资源,从浏览器缓存重新加载
    location.reload(true); 从服务器内部加载网页资源

    history.back() 后退
    history.forward() 前进
    history.go(1) 前进
    history.go(-1) 后退

地址栏 : 网站地址
滚动条 : 侧边滚动

# DOM编程
文档对象模型(Document Object Model)
将HTML元素描述成js对象,通过对应的方法,对js对象(HTML对象)进行操作

    获取节点对象(HTML元素)
    document.getElementById(html元素id值); 根据id值获取HTML对象
    document.getElementByTagName("标签名称"); 根据标签名称获取对应标签对象的集合
    document.getElementByName("标签name属性值"); 根据标签name属性获取对应的标签集合
    document.getElementByClassName("class属性值"); 根据标签class属性获取对应标签的集合

通过节点关系查找节点
parentNode: 获取当前节点的父节点
childNodes: 获取当前节点的所有下一级元素
firstChild: 获取当前节点的第一个子节点
lastChild: 获取当前节点的最后一个子节点
nextSibling: 获取当前节点的下一个相邻节点
previousSibling: 获取当前节点的上一个兄弟节点

document.createElement("标签名称"); 创建新的元素节点
elementObj.setAttribute("属性名称","属性值")
elementObj.appendChild(e) 给指定元素添加子元素
elementObj.insertBefore(new,old) 给新节点new添加到老节点前面
elementObj.removeChild(child) 删除子节点

# 正则表达式
正则表达式格式

    ^ : 开头
    $ : 结尾
    次数 : * 0个或多个 + 1个或多个 ? 0个或1个 {n} n个 {n,m} 最少n个最多m个
    通配符 : \d 任意的数字 \D 任意的非数字 \s 任意的空白 \S 任意的非空白
    . : 任意字符,\n除外
    组合 : [a-z] [0-9]
    标志 : i 忽略大小写
    方法 : Regexp.test(msg)













