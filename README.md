# 基于MVC模式的一个简单购物车实例

##  一、开发环境

- Eclipse
- Mysql

## 二、实验内容

1. 需求分析

   普通用户可以通过登录进去购物系统，在验证用户名密码正确后进入图书显示页面，通过勾选图书（默认一本），可批量加入购物车，也可以点击某本图书进入详情页面，选择更多的数量进行购买，提交订单后，对数据库进行更新操作，更新成功后显示支付成功页面。

   管理员可以通过登录进入购物系统，对图书进行添加、修改、删除操作。

2. 系统设计

   [![](https://mermaid.ink/img/eyJjb2RlIjoiZ3JhcGggVERcblx0QShMb2dpbiBpbikgLS0-IEJ76aqM6K-B56CB5piv5ZCm5q2j56GufVxuXHRCIC0tPiB8Tm98QVxuXHRCIC0tPiB8WWVzfEN755So5oi35ZCN5LiO5a-G56CB5piv5ZCm5q2j56GufVxuXHRDIC0tPiB8Tm98QVxuXHRDIC0tPiBEW1Nob3cgYm9vayBsaXN0XVxuXHREIC0tPiB8Q2xpY2sgc2hvcENhcnQgYnV0dG9ufEVbU2hvdyBzaG9wQ2FydCBpbmZvXVxuXHREIC0tPiB8Q2xpY2sgbW9yZSBkZXRhaWx8RltTaG93IGJvb2sgcHJpY2UgcXVhbnRpdHkgYXV0aG9yXVxuXHRFIC0tPnxDbGljayBCdXkgYnV0dG9ufEdbVXBkYXRlIGRhdGViYXNlLGRpc3BsYXkgcGF5bWVudCBzdWNjZXNzIGluZm9dXG5cdEUgLS0-fENsaWNrIEJhY2sgYnV0dG9ufCBEXG5cdEYgLS0-fENsaWNrIEJ1eSBidXR0b258IEdcblx0RiAtLT58Q2xpY2sgQmFjayBidXR0b258IERcblx0RyAtLT4gSChMb2dpbiBvdXQpXG5cbmNsYXNzRGVmIGNsYXNzTmFtZSBmaWxsOiNmZmNjMDAsc3Ryb2tlOiMwMDAsc3Ryb2tlLXdpZHRoOjJweCxmb250LWZhbWlseTpjb25zb2xhcztcbmNsYXNzIEEsQixDLEQsRSxGLEcsSCBjbGFzc05hbWU7XG5cdFxuXHRcdCIsIm1lcm1haWQiOnsidGhlbWUiOiJkZWZhdWx0In19)](https://mermaid-js.github.io/mermaid-live-editor/#/edit/eyJjb2RlIjoiZ3JhcGggVERcblx0QShMb2dpbiBpbikgLS0-IEJ76aqM6K-B56CB5piv5ZCm5q2j56GufVxuXHRCIC0tPiB8Tm98QVxuXHRCIC0tPiB8WWVzfEN755So5oi35ZCN5LiO5a-G56CB5piv5ZCm5q2j56GufVxuXHRDIC0tPiB8Tm98QVxuXHRDIC0tPiBEW1Nob3cgYm9vayBsaXN0XVxuXHREIC0tPiB8Q2xpY2sgc2hvcENhcnQgYnV0dG9ufEVbU2hvdyBzaG9wQ2FydCBpbmZvXVxuXHREIC0tPiB8Q2xpY2sgbW9yZSBkZXRhaWx8RltTaG93IGJvb2sgcHJpY2UgcXVhbnRpdHkgYXV0aG9yXVxuXHRFIC0tPnxDbGljayBCdXkgYnV0dG9ufEdbVXBkYXRlIGRhdGViYXNlLGRpc3BsYXkgcGF5bWVudCBzdWNjZXNzIGluZm9dXG5cdEUgLS0-fENsaWNrIEJhY2sgYnV0dG9ufCBEXG5cdEYgLS0-fENsaWNrIEJ1eSBidXR0b258IEdcblx0RiAtLT58Q2xpY2sgQmFjayBidXR0b258IERcblx0RyAtLT4gSChMb2dpbiBvdXQpXG5cbmNsYXNzRGVmIGNsYXNzTmFtZSBmaWxsOiNmZmNjMDAsc3Ryb2tlOiMwMDAsc3Ryb2tlLXdpZHRoOjJweCxmb250LWZhbWlseTpjb25zb2xhcztcbmNsYXNzIEEsQixDLEQsRSxGLEcsSCBjbGFzc05hbWU7XG5cdFxuXHRcdCIsIm1lcm1haWQiOnsidGhlbWUiOiJkZWZhdWx0In19)
   
   
   
3. 页面跳转

   

   [![](https://mermaid.ink/img/eyJjb2RlIjoiZ3JhcGggVERcblx0QShTdWJtaS5qc3ApIC0tPiBCKFN1Ym1pdFJlc3VsdC5qYXZhKVxuXHRCIC0tPiBDKERvZ2V0LmphdmEpXG5cdEMgLS0-IEQoU2hvd2Jvb2suanNwP3N0YXJ0PTEpXG5cdEQgLS0-RShBZGRDYXJ0LmphdmEpXG5cdEQgLS0-RihEZXRhaWwuanNwKVxuXHRGIC0tPkRcblx0Ri0tPkVcblx0RSAtLT5HKFNlcmNoU2hvcENhcnQuanNwKVxuXHRHIC0tPkRcblx0Ry0tPkgoQWZ0ZXJQYWlkLmphdmEpXG5cdEgtLT5JKFBhaWQuanNwKVxuXG5jbGFzc0RlZiBjbGFzc05hbWUgZmlsbDojZmZjYzAwLHN0cm9rZTojMDAwLHN0cm9rZS13aWR0aDoxcHgsZm9udC1mYW1pbHk6Y29uc29sYXM7XG5jbGFzcyBBLEIsQyxELEUsRixHLEgsSSBjbGFzc05hbWU7XG5cblxuXHRcblx0XHQiLCJtZXJtYWlkIjp7InRoZW1lIjoiZm9yZXN0In19)](https://mermaid-js.github.io/mermaid-live-editor/#/edit/eyJjb2RlIjoiZ3JhcGggVERcblx0QShTdWJtaS5qc3ApIC0tPiBCKFN1Ym1pdFJlc3VsdC5qYXZhKVxuXHRCIC0tPiBDKERvZ2V0LmphdmEpXG5cdEMgLS0-IEQoU2hvd2Jvb2suanNwP3N0YXJ0PTEpXG5cdEQgLS0-RShBZGRDYXJ0LmphdmEpXG5cdEQgLS0-RihEZXRhaWwuanNwKVxuXHRGIC0tPkRcblx0Ri0tPkVcblx0RSAtLT5HKFNlcmNoU2hvcENhcnQuanNwKVxuXHRHIC0tPkRcblx0Ry0tPkgoQWZ0ZXJQYWlkLmphdmEpXG5cdEgtLT5JKFBhaWQuanNwKVxuXG5jbGFzc0RlZiBjbGFzc05hbWUgZmlsbDojZmZjYzAwLHN0cm9rZTojMDAwLHN0cm9rZS13aWR0aDoxcHgsZm9udC1mYW1pbHk6Y29uc29sYXM7XG5jbGFzcyBBLEIsQyxELEUsRixHLEgsSSBjbGFzc05hbWU7XG5cblxuXHRcblx0XHQiLCJtZXJtYWlkIjp7InRoZW1lIjoiZm9yZXN0In19)



   

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

本来想嵌入视频的，但是好像GFM不支持

[实验视频解说](https://www.bilibili.com/video/BV14T4y137Uk/)



