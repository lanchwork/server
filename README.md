# si-server 链金控项目

sql 部分

- 所有创建或更新的sql语句，都需要存放在./script文件夹下，以 yyyyMMddhhmm.sql 方式命名
- 主键id通一采用32位UUID
- 在数据库中创建表，通过运行 com.seal.ljk.common.CodeGenerator 程序，自动生成通用代码

service 部分
- service 业务代码进行接口、实现分层隔离


用户验证部分
- 引入jwt验证机制，接口通过方法中通过添加 com.seal.ljk.base.AuthToken 中  VerifyToken（执行验证）、 IgnoreToken（跳过验证）注解决定是否验证用户，实际验证方式待定

异常处理
- com.seal.ljk.base.Exception 中定义了 AuthException（用户验证异常）和 ParamException（参数异常）,加入了全局异常处理
