# 入坑手册

# step0: create `mavenWeb` project

then, 指定 `Targeted Runtime: Apache Tomcate v8.5`.

# step1:dependencies

##  configurate `pom.xml`

 pom.xml

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.cheng</groupId>
	<artifactId>struts2-file_upload</artifactId>
	<packaging>war</packaging>
	<version>0.0.1-SNAPSHOT</version>
	<name>struts2-file_upload Maven Webapp</name>
	<url>http://maven.apache.org</url>


	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<struts2.version>2.5.13</struts2.version>
		<log4j2.version>2.8.2</log4j2.version>
	</properties>


	<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>3.8.1</version>
			<scope>test</scope>
		</dependency>


		<dependency>
			<groupId>org.apache.struts</groupId>
			<artifactId>struts2-core</artifactId>
			<version>${struts2.version}</version>
		</dependency>

		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-core</artifactId>
			<version>${log4j2.version}</version>
		</dependency>
      
      		<dependency>
			<groupId>javassist</groupId>
			<artifactId>javassist</artifactId>
			<version>3.12.0.GA</version>
		</dependency>
	</dependencies>

	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.apache.logging.log4j</groupId>
				<artifactId>log4j-api</artifactId>
				<version>${log4j2.version}</version>
			</dependency>
		</dependencies>
	</dependencyManagement>

	<build>
		<finalName>struts2-file_upload</finalName>
	</build>
</project>
```



> When complete the `pom.xml` , save it, and maven will help to add the `dependencies`.



# step2: source folder

添加 `source folder` :

1. `src/main/java`
2. `src/test/java`
3. `src/test/resources`

first:

project => properties => `Java Build Path` => `Source` => `Remove` the missing folder => then, `Apply ` => at the project level, New `Source Folder` => input `Folder name` like `src/main/java` => Finish, and ok!



# step3: view

index.jsp

```xml
<html>
<head><meta http-equiv="Refresh" content="0;URL=upload.action"></head>
<body>
<h2>Loading ...</h2>
</body>
</html>

```



WEB-INF/upload.jsp

```xml
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File upload</title>
</head>
<body>
	
	<s:form action="upload" method="post" enctype="multipart/form-data">
		<s:file name="upload"></s:file>
		<s:file name="upload"></s:file>
		<s:file name="upload"></s:file>
		<s:submit></s:submit>
	</s:form>
	
	<s:iterator value="upload" var="u">
		<s:property value="u"/><br>
	</s:iterator>
	<s:iterator value="uploadContentType" var="ct">
		<s:property value="ct"/><br>
	</s:iterator>
	<s:iterator value="uploadFileName" var="fn">
		<s:property value="fn"/><br>
	</s:iterator>
	
</body>
</html>
```



WEB-INF/web.xml

```xml
<!DOCTYPE web-app >

<web-app>
	<display-name>Struts Blank</display-name>
	<welcome-file-list>
		<welcome-file>index.jsp</welcome-file>
	</welcome-file-list>

	<filter>
		<filter-name>struts2</filter-name>
		<!-- 注意2.2.1版本的struts2的filter在ng包里 -->
		<filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
	</filter>
	<filter-mapping>
		<filter-name>struts2</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
</web-app>
```



# step4: log4j2

log4j2.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration>
	<Appenders>
		<Console name="STDOUT" target="SYSTEM_OUT">
			<PatternLayout pattern="%d %-5p [%t] %C{2} (%F:%L) -%m%n" />
		</Console>
	</Appenders>

	<Loggers>
		<Logger name="com.opensymphony.xwork2" level="info" />
		<Logger name="org.apache.struts2" level="info" />
		<Root level="warn">
			<AppenderRef ref="STDOUT" />
		</Root>
	</Loggers>
</Configuration>
```



# step5: controller

src/main/java/cheng/Upload.java

```java
package cheng;

import java.io.File;
import java.util.Arrays;

import com.opensymphony.xwork2.ActionSupport;

/**
 * <code>Allows upload a file</code>
 */
public class Upload extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private File[] upload;
	private String[] uploadFileName;
	private String[] uploadContentType;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return INPUT;
	}

	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String[] getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	@Override
	public String toString() {
		return "Upload [upload=" + Arrays.toString(upload) + ", uploadFileName=" + Arrays.toString(uploadFileName)
				+ ", uploadContentType=" + Arrays.toString(uploadContentType) + "]";
	}

}
```



# step6:  struts.xml

struts.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE struts PUBLIC
        "-//Apache Software Foundation//DTD Struts Configuration 2.5//EN"
        "http://struts.apache.org/dtds/struts-2.5.dtd">
<struts>
    <constant name="struts.enable.DynamicMethodInvocation" value="false"/>
    <constant name="struts.devMode" value="true"/>
	
	<!-- 指定国际化编码所使用的字符集 -->	
	<constant name="struts.i18n.encoding" value="UTF-8"/>

	<package name="default" namespace="/" extends="struts-default">

		<default-action-ref name="index"></default-action-ref>

		<action name="index">
			<result type="redirectAction">
				<param name="actionName">upload</param>
			</result>
		</action>

		<action name="upload" class="cheng.Upload">
			<result name="input">WEB-INF/upload.jsp</result>
		</action>

	</package>

	<!-- Add addition packages and configuration here. -->
</struts>
```



# step7:  war

export as `war`





