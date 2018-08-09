# AutoReply

项目来源:[慕课网免费课程](http://www.imooc.com/learn/154)

### 技术实现
+ MyBatis+jsp+servlet+jQuery+MySQL



MyBatis实现微信自动回复页面
+ 搭建简易的前端后台
+ 前端页面传入SQL参数，利用sql拼接等向servlet发送查询请求；
+ servlet控制器接收参数去service层中调用dao方法；
+ dao方法调用dbAccess数据库访问类：通过mybatis的核心打开数据库会话sqlsession取出数据返回；
+ dbAccess类会首先读取mybatis-config.xml的数据库配置找到对应数据库，还会提供以方法为id，以实体类为参数，返回结果集的配置sql语句的xml，通过OGNL进行动态SQL的拼接；
+ 通过sqlsession取出数据再最后通过servlet向页面传值。
+ 然后将原表进行分表，存在一对多的关系，进行一对多的配置；

