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