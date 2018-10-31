## 屏蔽自动配置
 > java注解
 @EnableAutoConfiguration(exclude = {XXXAutoConfiguration.class})
 
 > 配置文件
 spring:
  autoconfigure:
    exclude: org.springframework.boot.autoconfigure.xxx.XXXAutoConfiguration
