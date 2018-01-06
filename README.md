# cy-fast

 **框架说明** 

1. 基于springboot+shiro+freemarker的快速开发框架,代码结构清晰，快速上手使用！
2. 配置代码生成器，减少70%开发时间，专注业务逻辑。
3. 前端声明式组件封装、附带文档编写 ctrl+c ctrl+v 即可使用。封装数据源，可通过url、枚举、字典直接渲染组件。代码量极少且易维护。
4. layui常用代码的二次封装，省略layui部分繁琐的代码！
    
 例：

![输入图片说明](https://gitee.com/uploads/images/2017/1213/182658_b69a61e5_1334796.png "屏幕截图.png")


![输入图片说明](https://gitee.com/uploads/images/2017/1213/182830_c824ecdd_1334796.png "屏幕截图.png")


 **java** 


- common     
        - config         配置类 <br>
        - enumresource   枚举类<br>
        - exception      统一异常处理<br>
        - log            统一日志处理<br>
        - shiro          shiro相关<br>
        - utils          工具类<br>
        - xss            xss相关类<br>
       
- controller  

- dao   
   
- entity   
  
- service


 **resources** 

- db.migration     flyway sql脚本

- generator        代码生成器相关配置

- mapper           mapper文件

- static           静态文件

- templates        freemarker页面



 **如何启动**
 
1. 通过git下载源码
2. 创建数据库cy-fast，数据库编码为UTF-8（已配置flyway数据库版本管理，无需创建表）
3. IDEA、Eclipse导入项目
4. 启动 CyFastApplication 类
5. 项目访问路径：http://localhost:8080/
6. 账号密码：admin/admin



 **项目演示** 

- 演示地址：http://fast.cymall.xin
- 账号密码：admin/admin


 **如何交流、反馈、参与贡献？** 

- 项目主页 http://fast.cymall.xin
- 码云地址 https://gitee.com/leiyuxi/cy-fast
- 中国开源 https://www.oschina.net/p/cy-fast
- qq群    275846351


 **项目截图** 

后台管理页面

![输入图片说明](https://gitee.com/uploads/images/2018/0106/183812_8ac728a1_1334796.png "屏幕截图.png")



前端框架页面

![输入图片说明](https://gitee.com/uploads/images/2017/1226/173206_cf4ab878_1334796.png "屏幕截图.png")


 **组件使用说明页面** 

代码示例

![输入图片说明](https://gitee.com/uploads/images/2017/1213/155929_6041fc05_1334796.png "屏幕截图.png")

效果

![输入图片说明](https://gitee.com/uploads/images/2017/1213/155939_d335ad4a_1334796.png "屏幕截图.png")

参数详解

![输入图片说明](https://gitee.com/uploads/images/2017/1213/155950_a6543f8b_1334796.png "屏幕截图.png")

图片上传组件

![上传组件封装](https://gitee.com/uploads/images/2017/1213/181231_21621036_1334796.png "屏幕截图.png")

![输入图片说明](https://gitee.com/uploads/images/2017/1213/181319_13d218bc_1334796.png "屏幕截图.png")

![输入图片说明](https://gitee.com/uploads/images/2017/1213/181422_1ab20aee_1334796.png "屏幕截图.png")


 **捐赠作者** 

如有帮助到您，请作者喝杯咖啡吧！

![输入图片说明](https://gitee.com/uploads/images/2018/0106/184140_fd082023_1334796.png "屏幕截图.png")
