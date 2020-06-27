# 导师学生双选系统
## 项目描述
实现毕业生毕业设计双向选择。教师可登陆后可查看数据统计信息，包含已选学生名单，课程权值，指导学生和已选学生数量，并能设置相应权重以及参数，从Excel中批量导入学生，单独内定学生，修改自己可指导学生的数量。学生登陆后可查看是否登陆，输入成绩，后台判定是否符合入选范围，并有友好的人机交互体验。
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
- security
- devtools
## 2020.6.27
### 增加控制层和服务层组件
- StudentController 学生请求控制层
- StudentService 学生服务层
- RequestComponent 实现处理携带的请求体
## 2020.6.26
### 增加Token和加密解密组件
- EncryptComponent 加密解密组件
- MyToken 携带Token体
- TeacherService 教师服务层
- TeacherController 教师请求控制层
- 更新TeacherReposirory查询方法
## 2020.5.20
### 增加初始化组件
- init component 初始化系统时将会创建教师
- LoginController 控制登录组件
- LoginIntercepterc 登陆拦截器
- TeacherIntercepter 教师权限拦截器
## 2020.3.24
### 增加持久化操作
- 构建BaseReposirory接口，实现refresh方法
- 构建CourseReposirory接口
- 构建CourseSelectionReposirory接口
- 构建StudentReposirory接口（基于学号查询学生）
- 构建TeacherReposirory接口（基于教师登陆用户名查询教师，基于id更新已选学生数量）
- 增加StudentReposiroryTest测试类
- 增加TeacherReposiroryTest测试类
## 2020.3.16
### init
- 构建Teacher类，包含Teacher的用户名、密码、选择人数名额、入选范围属性
- 构建Student类，包含Student的姓名、学号、是否被列为入选、所选老师_id（默认为空）属性
- 构建Course类，包含Course的课程名字、最小成绩、权重（学生所选方向也将被纳入此表记录）
- 构建CourseSelection类，包含CourseSelection的成绩、学生_id、课程_id属性
- 创建sprigboot工程，添加依赖，配置项目
