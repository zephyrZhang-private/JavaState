<%--
  Created by IntelliJ IDEA.
  User: zhangwei
  Date: 2025/8/18
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSON</title>
</head>
<body>

<script>

    //简单json串遍历
  var p = {
    name : "json1",
    age : 23,
    address : "USA"
  }
  //遍历json数据获取对应key-value
  for (var key in p) {
    console.log(key +":"+p[key]);
  }

  console.log("----------------------")


    //数组json遍历
  var p1 = {
      person:[
          {name: "Mark",age:22,address:"USA"},
          {name: "Eric",age:24,address:"CHN"},
          {name: "Lily",age:23,address:"ENG"}
      ]
  }
  for (var key in p1) {
      var arr = p1[key];
      for (let i = 0; i < arr.length; i++) {
          var persion = arr[i];
          for (var key1 in persion) {
              console.log(key1 + ":" + persion[key1]);
          }
      }
  }
  console.log("---------------------------");

  //json对象遍历
    var p2 = {
        person1:{name: "Mark",age:22,address:"USA"},
        person2:{name: "Eric",age:24,address:"CHN"},
        person3:{name: "Lily",age:23,address:"ENG"}
    }
    for (var key in p2) {
        var person = p2[key];
        for (var key1 in person) {
            console.log(key1 + ":" + persion[key1]);
        }
    }


</script>

</body>
</html>
