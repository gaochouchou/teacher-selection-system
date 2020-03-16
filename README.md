# 导师学生双选系统
## 项目描述
实现毕业生毕业设计双向选择。教师可登陆后可设置相应权重以及参数，并能按照指定顺序对学生进行排序。学生无需登录，验证学号确认后即可选择该老师为导师
## 开发环境
#### 开发工具
- idea 2020
#### 数据库
- mysql 8.0
#### 依赖
- spring-data-jpa
- test
- lombok
- junit
- mySQL driver
## 2020.3.16
### init
```
- 构建Teacher类，包含Teacher的用户名、密码、选择人数名额、入选范围属性
- 构建Student类，包含Student的姓名、学号、是否被列为入选、所选老师_id（默认为空）属性
- 构建Course类，包含Course的课程名字、最小成绩、权重（学生所选方向也将被纳入此表记录）
- 构建CourseSelection类，包含CourseSelection的成绩、学生_id、课程_id属性
- 创建sprigboot工程，添加依赖，配置项目
```