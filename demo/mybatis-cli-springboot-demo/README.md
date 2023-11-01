# mybatis-cli-demo 

# 使用
1、新建mysql数据 mybatis-cli
2、通过 mybatis-cli.sql 创建表。
3、在 mp-api/src/main/resources/application.yml 修改相关数据库配置。
```
server:
  port: 8083

spring:
  mvc:
    static-path-pattern: /**
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/mybatis-cli?serverTimezone=Asia/Shanghai&characterEncoding=utf8
    username: xxx
    password: xxx
```
4、启动应用
打开 mp-api/src/main/java/com/lucaswangdev/MpApiApplication.java 文件，启动应用。

5、打包应用
打包：在maven设置，mybatis-cli-demo => Lifecycle => install

参考：
Maven打包报错：jar:1.0-SNAPSHOT is missing, no dependency information available
https://blog.csdn.net/weixin_50707679/article/details/116609127