<script src="mermaid.full.min.js"></script>

# 基于MVC模式的一个简单购物车实例

##  一、开发环境

- Eclipse
- Mysql

## 二、实验内容

1. 需求分析

   普通用户可以通过登录进去购物系统，在验证用户名密码正确后进入图书显示页面，通过勾选图书（默认一本），可批量加入购物车，也可以点击某本图书进入详情页面，选择更多的数量进行购买，提交订单后，对数据库进行更新操作，更新成功后显示支付成功页面。

   管理员可以通过登录进入购物系统，对图书进行添加、修改、删除操作。

2. 系统设计

   ```
   graph TD
   	A(Login in) --> B{验证码是否正确}
   	B --> |No|A
   	B --> |Yes|C{用户名与密码是否正确}
   	C --> |No|A
   	C --> D[Show book list]
   	D --> |Click shopCart button|E[Show shopCart info]
   	D --> |Click more detail|F[Show book price quantity author]
   	E -->|Click Buy button|G[Update datebase,display payment success info]
   	E -->|Click Back button| D
   	F -->|Click Buy button| G
   	F -->|Click Back button| D
   	G --> H(Login out)
   
   classDef className fill:#ffcc00,stroke:#000,stroke-width:2px,font-family:consolas;
   class A,B,C,D,E,F,G,H className;
   	
   
   
   	
   	
   ```
3. 页面跳转
   

   ```
   graph TD
   	A(Submi.jsp) --> B(SubmitResult.java)
   	B --> C(Doget.java)
   	C --> D(Showbook.jsp?start=1)
   	D -->E(AddCart.java)
   	D -->F(Detail.jsp)
   	F -->D
   	F-->E
   	E -->G(SerchShopCart.jsp)
   	G -->D
   	G-->H(AfterPaid.java)
   	H-->I(Paid.jsp)
   
   classDef className fill:#ffcc00,stroke:#000,stroke-width:1px,font-family:consolas;
   class A,B,C,D,E,F,G,H,I className;
   ```

   

4. 数据库设计

      | 字段名    | 数据类型 | NULL | 主键 | 默认值 | 描述             |
      | --------- | -------- | ---- | ---- | ------ | ---------------- |
      | Id        | Int      | NO   | YES  | 无     | 图书标识自动增加 |
      | Name      | String   | NO   | NO   | 无     | 书籍名称         |
      | Price     | Float    | NO   | NO   | 无     | 书籍价格         |
      | BookCount | Int      | NO   | NO   | 无     | 书籍库存         |
      | Author    | String   | NO   | NO   | 无     | 书籍作者         |

   

5. 开发环境实验架构

   <img src="https://i.loli.net/2020/05/28/qKWIFMEPxb8QYok.png" alt="实验架构.png" style="zoom:67%;" />

| **Submit.jsp**      | **登录页面**                                            |
| ------------------- | ------------------------------------------------------- |
| SubmitResult.java   | 判断验证码是否正确，用户名与密码是否正确                |
| DoGet.java          | 从数据库中获取图书信息并存入session，转发至showBook.jsp |
| showBook.jsp        | 分页显示所有图书                                        |
| AddCart.java        | 把图书加入购物车,并把购物车信息存入session              |
| serchShopCart.jsp   | 显示购物车中的信息                                      |
| Detail.jsp          | 显示图书详情页面                                        |
| Paid.jsp            | 显示支付成功页面                                        |
| AfterPaid.java      | 支付成功后对数据库进行更新，注销用户，删除Cookie        |
| BookStorage.jsp     | 管理员操作的页面，可对图书进行增删改查                  |
| Index.jsp           | 增加图书页面                                            |
| AddBook.java        | 增加图书                                                |
| Update.java         | 修改图书数量                                            |
| Delete.java         | 删除图书                                                |
| Book.java           | 图书JavaBean                                            |
| DBUtils.java        | 对数据库操作进行封装                                    |
| DataSourceUtil.java | 数据库连接                                              |
| EncodingFilter.java | 设置编码规则                                            |
| CodeServlet.java    | 绘制验证码                                              |
| Jdbc.properties     | 数据库配置文件                                          |

## 三、实验演示

<iframe src="//player.bilibili.com/player.html?aid=925561380&bvid=BV14T4y137Uk&cid=189211982&page=1" scrolling="no" border="0" frameborder="no" framespacing="0" allowfullscreen="true"> </iframe>

