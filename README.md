# easypoi 导出报表 #
### 导出Excle ###

- 说明<br/>
graph TD
A[1111] -->|Get money|B(Go Shopping)
B --> C{enough?}
C --> |YES| D[laptop]
C --> |NO| E[iPhone]


- 启动<br/>
运行：spring-boot-easypoi/src/main/java/com/spring/test/poi/SpringBootEasypoiApplication <br/>
访问：http://localhost:8080/poi/exportExcel<br/>

此项目为一个DEMO，高级功能请查看:<br/>
[https://github.com/lemur-open/easypoi](https://github.com/lemur-open/easypoi)
