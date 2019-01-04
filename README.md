# seleniumJavaTest
selenium与java结合的自动化网页测试，支持FireFox、Edge、IE、Safari、Chrome

## 使用方法
更改``configure.yaml``修改配置，baseUrl参数是用来更换测试域名用，编写测试的时候不要把域名写死，对于更换不同的服务有好处。
本项目已经下载好Chrome需要的驱动，运行

``sh test.sh``

可以在``target``目录下的``surefire-reports``中查看测试报告
如果遇到`` The driver is not executable``错误，则是maven打包的时候损坏了驱动，需要手动替换，或者手动更改``configure.yaml``中的驱动路径。