# si-server 链金控项目

sql 部分

- 所有创建或更新的sql语句，都需要存放在./script文件夹下，以 yyyyMMddhhmm.sql 方式命名
- 在数据库中创建表，通过运行 CodeGenerator 程序，自动生成通用代码
- 主键id通一采用32位UUID，插入执行插入方法时可以不主动设置，SealInsertInterceptor 拦截器中会主动设置（包括 Base 类中的通用字段）
- 分页，Dao 中方法以 ByPage 结尾的，会自动执行分页查询，详见 SealPageInterceptor 拦截器代码
- 字典类型的字段，数据库的字段说明没有定义字典的话，开发的时候需要自己定义一下，并标注到model类字段说明里面
- model类的 verify() 验证方法要根据当前业务要求，去掉可以为空或0的字段
- update 语句中，可以更新为空的字段需要特殊注意下（ 比如清空备注 ），如果有特殊情况，可以通过新增一个字段，并要求前端传入该字段标识进行特殊处理

service 部分
- service 业务代码进行接口、实现分层隔离


用户验证部分
- 引入jwt验证机制，接口通过方法中通过添加 com.seal.ljk.base.AuthToken 中  VerifyToken（执行验证）、 IgnoreToken（跳过验证）注解决定是否验证用户，实际验证方式待定

异常处理
- com.seal.ljk.base.Exception 中定义了 AuthException（用户验证异常）和 ParamException（参数异常）,加入了全局异常处理


业务
- 业务表中需要定义 channelMark (渠道标识，如mini)字段，其中 seal 本身也是一个合作方，在业务中做特殊处理，拥有最高权限
- SysPartner 中有 partnerType 合作方类型字段，根据这个标识可以过滤一些权限方面的控制
- SysUser 中有 userType 字段，0超级管理员用户 1合作方管理员 2普通用户，管理员通过合作方类型过滤权限，普通用户通过用户所属角色读取权限
