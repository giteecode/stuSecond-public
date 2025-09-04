### 作者微信：grapro666 QQ：3642795578 (支持部署调试、支持代做毕设和论文)

### 接javaweb、python、小程序、H5、APP、各种管理系统、单片机、嵌入式等开发

### 选题+开题报告+任务书+程序定制+安装调试+论文+答辩ppt

**博客地址：
[https://blog.csdn.net/2303_76227485/article/details/128663581](https://blog.csdn.net/2303_76227485/article/details/128663581)**

**视频演示：
[https://www.bilibili.com/video/BV12a4y1w7EN/](https://www.bilibili.com/video/BV12a4y1w7EN/)**

**毕业设计所有选题地址：
[https://github.com/ynwynw/allProject](https://github.com/ynwynw/allProject)**

## 基于Springboot+vue的校园二手交易和交流论坛系统(源代码+数据库+2万字论文+开题+ppt)039

## 一、系统介绍

本项目前后端分离

这是集校园二手交易、校园交流论坛、校园表白墙为一体的项目。分为用户和管理员

学生登录 
- 校园交流论坛
  发帖、查看帖子、评论帖子、修改删除帖子 、收藏帖子
- 表白墙
   申请上墙、查看别人的表白贴
- 二手交易
   搜索商品、购买商品、发布闲置商品
- 个人中心
  我的帖子、我的回复、我的收藏、我的墙列表、我的二手商品、我的购买订单、销售订单
  后台管理
- 首页统计商品、帖子、用户、表白墙、订单、评论数据
- 人员管理
  用户管理、管理员管理
- 帖子管理
  查看、删除、导出帖子
- 评论管理
  查看、删除评论
- 表白墙管理
  表白墙审核
- 二手交易管理
  商品管理、订单管理

## 二、所用技术

后端技术栈：

- springboot
- mybatis-plus
- mysql
- shiro
- redis
- jwt

前端技术栈：

- vue全家桶
- elment-ui
- echarts
- axios

## 三、环境介绍

基础环境 :IDEA/eclipse, JDK 1.8, Mysql5.7及以上,Node.js,Maven

所有项目以及源代码本人均调试运行无问题 可支持远程调试运行

## 四、页面截图

![contents](./picture/picture1.png)

![contents](./picture/picture2.png)

![contents](./picture/picture3.png)

![contents](./picture/picture4.png)

![contents](./picture/picture5.png)

![contents](./picture/picture6.png)

![contents](./picture/picture7.png)

![contents](./picture/picture8.png)

![contents](./picture/picture9.png)

![contents](./picture/picture10.png)

![contents](./picture/picture11.png)

![contents](./picture/picture12.png)

![contents](./picture/picture13.png)

![contents](./picture/picture14.png)

![contents](./picture/picture15.png)

![contents](./picture/picture16.png)

![contents](./picture/picture17.png)

![contents](./picture/picture18.png)

![contents](./picture/picture19.png)

![contents](./picture/picture20.png)

![contents](./picture/picture21.png)

![contents](./picture/picture22.png)


## 五、浏览地址

前端访问地址：http://localhost:8080/

用户账号/密码：test1/123456

后台管理地址：http://localhost:9528/

管理员账号/密码：xzj4/123456

## 六、安装教程

1. 使用Navicat或者其它工具，在mysql中创建对应名称的数据库，并导入项目的sql文件；
2. 使用IDEA/Eclipse/MyEclipse导入项目stucompla-rear2-feature-v0.0.1，Eclipse/MyEclipse导入时，若为maven项目请选择maven;
   若为maven项目，导入成功后请执行maven clean;maven install命令，然后运行；
3. 修改application.yml 里面的数据库配置和redis配置和文件路径配置
4. 启动项目后端项目
5. vscode打开admin和stucompla-front-feature-v0.0.1项目，
6. 打开终端，执行npm install 依赖下载完成后执行 npm run dev,执行成功后会显示访问地址
7. 分别访问  后台管理http://localhost:9528/ 和 前台页面http://localhost:8080/
