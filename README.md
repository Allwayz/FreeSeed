# FreeSeed



>   FreeSeed是一款现代化的，独立的，学生管理系统。

<p align="center">
    <a href = "https://docs.oracle.com/javase/8/docs/"><img src="https://badgen.net/badge/JDK/1.8/yellow"></a>
    <a href = "https://github.com/Allwayz/FreeSeed"><img src="https://badgen.net/github/forks/Allwayz/FreeSeed"></a>
    <a href = "https://github.com/Allwayz/FreeSeed/issues"><img src="https://badgen.net/github/issues/Allwayz/FreeSeed"></a>
	<a href = "https://github.com/Allwayz/FreeSeed/releases"><img src="https://badgen.net/github/release/Allwayz/FreeSeed"></a>
    <a href = "https://github.com/Allwayz/FreeSeed"><img src="https://badgen.net/github/commits/Allwayz/FreeSeed"></a>
    <img src="https://badgen.net/github/last-commit/Allwayz/FreeSeed">
	<img src="https://badgen.net/github/license/Allwayz/FreeSeed">
</p>
------

[TOC]

### 简介

**FreeSeed是一款现代化的，独立的，学生管理系统。**

[websiteDemo](https://allwayz.github.io/FreeSeedDemo)

>   [官网](https://allwayz.github.io/) | 社区 | [Email](2584491610@qq.com) | Telegram




### FreeSeed Request Method
| 实验功能                             | 请求URI | 请求方式 |
| ------------------------------------ | ------- | -------- |
| Select ALL                       | emps    | GET      |
| Select One(pass to Edit Page)           | emp/1   | GET      |
| pass to add Page                         | emp     | GET      |
| Add                              | emp     | POST     |
| pass to Edit Page | emp/1   | GET      |
| update                             | emp     | PUT      |
| delete                             | emp/1   | DELETE   |

### 接口文档

|web interface | Param | Return | Method|createDate|
|--------------|-------|-------|--------|--------|
|roleList|null|JSON|get|2020-02-16|
|cityList|null|JSON|get|2020-02-16|
|addRole|role_desc|void|post|2020-02-16|
|addUser|email,password,role|void|post|2020-02-16|
|nationLoad|null|JSON|get|2020-02-18|
|provinceLoad|nation|JSON|get|2020-02-18|
|cityLoad|province|JSON|get|2020-02-18|



------

### 数据库文件！本地 `mysql`

[下载地址](https://allwayz-blog-1259174617.cos.ap-shanghai.myqcloud.com/FreeSeed/FreeSeed.sql)

### `Oracle`版本（可能有bug）
[下载地址](https://allwayz-blog-1259174617.cos.ap-shanghai.myqcloud.com/FreeSeed/FreeSeed_Oracle.sql)

------

## License

[![](https://badgen.net/github/license/Allwayz/FreeSeed)](https://github.com/Allwayz/FreeSeed/blob/master/LICENSE)

>   FreeSeed使用Apache-v2.0协议开源，请遵守开源协议。

------

## Reference

[Allwayz](https://allwayz.github.io)
