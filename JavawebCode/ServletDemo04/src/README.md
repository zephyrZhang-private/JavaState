# Cookie
## 状态管理 
* HTTP协议无状态,不能保存每次提交的信息
* 登录功能需要保持登录状态
* 将浏览器与web服务器之间多次交互当作一个整体处理,并将交互数据保存

## 状态管理技术
* 客户端状态管理技术:cookie,数据存在客户端
* 服务器状态管理技术:session,数据存储在服务器,服务器传递sessionID时需要使用Cookie方式

## 什么是cookie
* cookie是浏览器访问web时，由web服务器在http相应消息头附带传输给客户端一小段数据
* 存在cookie的客户端以后访问服务器，都会回传cookie
* 一个cookie主要标识该信息的键和值

## 关键类说明
ServletCookie01 -- 创建cookie
ServletCookie02 -- 获取cookie
ServletCookie03 -- 删除cookie


# Session
## session概述
* 用于记录用户的状态,session是指在一段时间内,单个客户端与服务器一段交互过程
* 一个session中,可能多次请求同一资源,或多次请求不同资源

## session原理
* 服务器会给每一个会话分配一个对象
* 同一个浏览器的多次请求,同属于一个会话
* 首次使用session时,服务器会自动创建session,并创建cookie存储sessionID发送回客户端

ps:session 是由服务器创建


