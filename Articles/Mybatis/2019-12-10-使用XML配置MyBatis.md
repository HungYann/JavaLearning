## Configuring MyBatis Using XML

配置**mybatis-config.xml**
基于XML配置的文件包含如下文件的配置：dataSource, environments, global settings, typeAliases, typeHandlers, and SQL mappers 和 实例化的SqlSessionFactory.


```{}
<?xml version="1.0" encoding = "UTF=8">
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

<properties resource="applicaton.properties">
	<property name="username" value="db_user"/>
	<property name="password" value="verysecurepwd"/>
</properties>

<settings>
	<setting name="cacheEnabled" value="true"/>
</settings>

<typeAliases>
	<typeAlias alias="Tutor" type="com.mybatis3.domain.Tutor"/>
	<package name="com.mybatis.domain"/>
</typeAliases>

<typeHandlers>
	<typeHandler handler="com.mybatis3.typehandlers.PhoneTypeHandler"/>
	<package name="com.mybatis3.typehandlers"/>
</typeHandlers>

<environments default="development">
	<environment id="development">
			<transactionManager type="JDBC"/>
			<dataSource type="POOLED">
				<property name="driver" value="${jdbc.drierClassName}"/>
				<property name="url" value="${jdbc.url}"/>
				<property name="username" value="${jdbc.username}"/>
				<property name="password" value="${jdbc.password}"/>
			</dataSource>
			
	</environment>	
	
	<environment id="production">
			<transactionManager type="MANAGED"/>
			<dataSource type="JNDI">
				<property name="data_source" value="java:comp/jdbc/MyBatisDemoDS"/>
			</dataSource>
	</environment>
</environments>

<mappers>
	<mapper resource="com/mybatis3/mappers/StudentMapper.xml">
	<mapper url="file:///D:/mybatisdemo/mappers/TutorMapper.xml">
	<mapper class="com.mybatis3.mappers.TutorMapper"/>
</mappers>

</configuration>

```

### Environment

Mybatis环境的配置仅需要改变development的值即可，比如**DEV**,**TEST**,**QA**,
**UAT** and **PRODUCTION**

当配置应用到生产环境服务器时，仅需要改变默认的生产环境到属性的**environment id**


有时我们需要在同一个应用中使用多个数据库，比如，我们或许需要使用**SHOPPINGCART**
数据库来存储所有的订单，使用**REPORTS**来存储订单的聚合。


如果你的应用需要连接多个数据库，你需要配置每个数据库作为一个独立的环境，并为每一个数据库创建独立**SqlSessionFactory**对象

```{}
<environments default="shoppingcart">
	<environment id="shoppingcart">
		<transactionManager type="MANAGED">
		<dataSource>
			<property/>
		</dataSource>
	</environment>
	<environment id="reports">
		<transactionManager type="MANAGED">
		<dataSource>
			<property/>
		</dataSource>
	</environment>
</environement>
```

接下来我们创建一个SqlSessionFactory：

```{}
inputStream = Resources.getResourceAsStream("mybatis-config.xml");

defaultSqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

cartSqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"shoppingcart");

reportSqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"reports");


```

当我们创建**SqlSessionFactory**时，如果没有显示的定义**environment id**时，SqlSessionFactory将会创建使用默认的环境。 在先前的代码中，**defaultSqlSessionFactory**被创建使用**shoppingcart**环境配置。



### DataSource

 ```{}
 <dataSource type="POOLED">
 	<property name="driver" value="${jdbc.driverClassName}"/>
 	<property name="url" value="${jdbc.url}"/>
 	<property name="username" value="${jdbc.username}"/>
 	<property name="password" value="${jdbc.password}"/>
 </dataSource>
 ```
 
 **dataSource**有三种类型**UNPOOLED**,**POOLED**,**JNDI**
 
- 如果将类型设置为UNPOOLED，MyBatis将打开一个新连接，并为每个数据库操作关闭该连接。 此方法可用于具有少量并发用户的简单应用程序。

- 如果将类型设置为POOLED，则MyBatis将创建数据库连接池，并且这些连接之一将用于数据库操作。 完成此操作后，MyBatis将把连接返回到池中。 这是开发/测试环境的常用方法。

- 如果将类型设置为JNDI，则MyBatis将从通常在应用程序服务器中配置的JNDI数据源获取连接。 这是生产环境中的首选方法。

###TransactionManager:**JDBC**和**MANAGED**

Mybatis 支持两种食物管理

-  当您将TransactionManager属性设置为JDBC时，MyBatis在后台使用JdbcTransactionFactory类创建TransactionManager。 例如，部署在Apache Tomcat上的应用程序应自行管理事务。

- M 当您将TransactionManager属性设置为MANAGED时，MyBatis在后台使用ManagedTransactionFactory类创建TransactionManager。
例如，部署在应用程序服务器（例如JBoss，WebLogic或GlassFish）上的JavaEE应用程序可以使用EJB来利用应用程序服务器的事务管理功能。 在这些托管环境中，您可以使用MANAGED事务管理器。



###Properties

proerties配置元素可以被用在外延配置属性在文件中，并使用properties' key names作为占位符，在先前的配置中，我们外延了数据库的连接属性在application.properties文件中使用占位符。

- 使用application.properties配置数据库连接参数

```{}

jdbc.driverClassName=com.mysql.jdbc.Driver

jdbc.url=jdbc:mysql://localhost:3306/mybatisdemo

jdbc.username = root

jdbc.password = admin

```


- 在mybatis-config.xml中，将占位符用于在中定义的属性

```{}
<properties resource="application.properties">
	<property name="jdbc.username" value="db_user"/>
	<property name="jdbc.password" value="verysecurepwd">
</properties>

<dataSource type="POOLED">
	<property name="driver" value="${jdbc.driverClassName}"/>
	<property name="url" value="${jdbc.url}"/>
	<property name="username" value="${jdbc.username}">
	<property name="password" value="${jdbc.password}">
</dataSource>
```

###typeAliases

在SQL mapper configuration文件中，我们需要给JavaBeans的全名,**resultType**和**parameterType**属性


```{}
	<select id="findStudentById" parameterType="int">
		resultType="com.mybatis3.domain.Student"
		SELECT STUD_ID AS ID, NAME, EMAIL , DOB
	</select>
	
	<update id="updateStudent" parameterType="com.mybatis.domain.Student">
		UPDATE STUDENTS SET NAME=#{name}, EMAIL=#{email}, DOB =#{dob}
		WHERE STUD_ID=#{id}
	</update>
```
在这里我们可以用别名来代替全名，在这里Student代替com.mybatis3.domain.Student代替，Tutor代替com.mybatis3.domain.Tutor

```{}
<typeAliases>
	<typeAlias alias="Student" type="com.mybatis3.domain.Student"/> 	<typeAlias alias="Tutor" type="com.mybatis3.domain.Tutor"/> 	<package name="com.mybatis3.domain"/>
 </typeAliases>
 
 <select id="findStudentById" parameterType="int" resultType="Student">
 	SELECT STUD_ID AS ID, NAME, EMAIL, DOB, FROM STUDENTS WHERE STUD_ID = #{id}
 </select>
 
 <update id="updateStudent" parameterType="Student">
 	UPDATE STUDENT SET NAME=#{name}, EMAIL=#{email}, DOB=#{dob}
 	WHERE STUD_ID=#{id}
 </update>
```





###typeHandlers




### Settings

默认的Mybatis全局设置，可以用如下的变量设置：
```{}
<settings>
<setting name="cacheEnabled" value="true"/>
<setting name="lazyLoadingEnabled" value="true"/>
<setting name="multipleResultSetsEnabled" value="true"/>
<setting name="useColumnLabel" value="true"/>
<setting name="useGeneratedKeys" value="false"/>
<setting name="autoMappingBehavior" value="PARTIAL"/>
<setting name="defaultExecutorType" value="SIMPLE"/>
<setting name="defaultStatementTimeout" value="25000"/>
<setting name="safeRowBoundsEnabled" value="false"/>
<setting name="mapUnderscoreToCamelCase" value="false"/>
<setting name="localCacheScope" value="SESSION"/>
<setting name="jdbcTypeForNull" value="OTHER"/>
<setting name="lazyLoadTriggerMethods" value="equals,clone,hashCode
,toString"/> </settings>
```

### Mappers

Mapper XML 文件包含mapped SQL语句，将使用**statement id**被应用执行,
mybatis-config.xml
```{}
<mappers>
	<mapper resource="com/mybatis3/mappers/StudentMapper.xml"/> 
	<mapper url="file:///D:/mybatisdemo/app/mappers/TutorMapper.xml"/> 	<mapper class="com.mybatis3.mappers.TutorMapper"/>
	<package name="com.mybatis3.mappers"/>
</mappers>

```

