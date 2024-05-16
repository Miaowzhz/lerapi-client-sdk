# lerapi-client-sdk
sdk开发入门
## 开发简单易用的 SDK

开发者只需要关心调用哪些接口、传递哪些参数

优点：开发者引入之后，可以直接在 application.yml 中写配置，自动创建客户端


1、创建springboot项目

2、勾选依赖

- lombok
- spring-boot-configuration-processor：自动生成配置的代码提示

3、开发

...

指定目录
![image](https://github.com/Miaowzhz/lerapi-client-sdk/assets/138358376/c4df512e-e5df-48e5-aa23-8af3243ff5a4)


```xml
# spring boot starter
org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.ler.lerapiclientsdk.LerApiClientConfig
```

4、打包到本地（m2仓库）

![img](https://cdn.nlark.com/yuque/0/2024/png/40918944/1715750498363-68cdb012-a65a-43d9-859d-0e6c1aa31b6d.png)

5、引入依赖
```xml
<dependency>
    <groupId>com.ler</groupId>
    <artifactId>lerapi-client-sdk</artifactId>
    <version>0.0.1</version>
</dependency>
```
6、配置信息
```yaml
lerapi:
  client:
    access-key: ler
    secret-key: asdfghjk
```
