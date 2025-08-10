# jquery
> 封装了原生js的框架,目前已经逐渐被vue替代

    语法 : <script>
            $(function(){//jquery代码})
          </script>

# jquery引入方式

    <!--本地引入-->
    <script src="js/jquery-3.3.1.js"></script>
    <!--在线引入-->
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>

# 选择器
## 基本选择器

### id选择器
    $("{标签}#{id属性}")
    
### 标签选择器
    $("{标签}")

### 类选择器
    $("{标签}.{class属性}")

## 高级选择器
### 并集选择器
    $("选择器1,选择器2,选择器3...")
    
### 后代选择器
    $("选择器1 选择器2 选择器3 ...")

### 子父级选择器
    $("选择器1 > 选择器2")

### 相邻兄弟选择器
    $("选择器1 + 选择器2 + 选择器3 + 选择器4")

### 通用兄弟选择器
    * $("选择器1 ～ 选择器2 ～ 选择器3")
### 结构伪类选择器

### 内容选择器
    :contains 匹配标签中文本内容
    :empty 匹配为空的HTML标签
    :has 匹配包含某个指定标签的HTML对象
    :parent 匹配包含子元素或文本的标签

### 可见性选择器
    hidden 选中隐藏的元素
    visible 选中显示的元素

### 属性选择器

### 表单选择器

    :text 选中文本表单控件
    :password 选中密码表单控件
    :radio:checked 选中的单选按钮
    :checkbox:checked 获取被选中复选框
    :selected 被选中的下拉菜单
    :disable 获取不可用表单控件