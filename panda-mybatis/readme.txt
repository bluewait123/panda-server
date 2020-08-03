# 配置
spring:
  datasource:
    druid:
      type: com.alibaba.druid.pool.DruidDataSource
      filters: stat
      driver-class-name: com.mysql.cj.jdbc.Driver
      url: jdbc:mysql://127.0.0.1:3306/panda-boss-system?useUnicode=true&characterEncoding=utf-8
      username: test
      password: 11223344
      #配置初始化大小/最小/最大
      initial-size: 1
      min-idle: 1
      max-active: 20
      #获取连接等待超时时间
      max-wait: 60000
      #间隔多久进行一次检测，检测需要关闭的空闲连接
      time-between-eviction-runs-millis: 60000
      #一个连接在池中最小生存的时间
      min-evictable-idle-time-millis: 300000
      validation-query: SELECT 'x'
      test-while-idle: true
      test-on-borrow: false
      test-on-return: false
      #打开PSCache，并指定每个连接上PSCache的大小。oracle设为true，mysql设为false。分库分表较多推荐设置为false
      pool-prepared-statements: false
      max-pool-prepared-statement-per-connection-size: 20

druid:
  monitor:
    ip:
      allow: 127.0.0.1
      deny:
    login:
      username: admin
      password: admin
    reset: true