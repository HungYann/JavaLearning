### Maven依赖、Eclipse中使用Maven、生命周期 

依赖:
A.jar -> B.jar

依赖范围：

 compile、test、provided
 
|  | compile | test | provided |
| :---- | :---- | :---- | :---- |
| 编译(main) |  yes   |  no | yes |
| 测试(test) |  yes | yes | yes|
| 部署(运行)  |    yes  |  no | no |


Maven 在编译、测试、运行项目时，各自使用一套classpath


当依赖范围是**compile**时，编译，测试，运行阶段A.jar都起作用。

当依赖范围是**test**时，以**Junit**举例，A.jar包仅在测试阶段被导入
当依赖范围是**provided**时，以**servlet.jar**举例,A.jar包在**编译**和**测试**时起作用




![](https://tva1.sinaimg.cn/large/006y8mN6gy1g993a9ir6pj30hq0cggmc.jpg)



在eclipse中新建一个Maven项目：

![](https://tva1.sinaimg.cn/large/006y8mN6gy1g993vfbxubj30y80u0424.jpg)


配置Maven，在eclipse中勾选installations.将eclipse自带的版本改成自己下载的版本。


![](https://tva1.sinaimg.cn/large/006y8mN6gy1g9948bedk3j30zm0towjj.jpg)



