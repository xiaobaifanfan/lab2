<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增添书籍</title>
</head>
<body>

<h1><font color="red">书籍管理——添加书籍</font></h1>
<hr color="green"/>
<s:form  action="adds" method="post" >
        <s:textfield name="name" label="书名"></s:textfield>
        <s:textfield name="author"  label="作者"></s:textfield>
         <s:textfield name="publisher" label="出版商"></s:textfield>
        <s:textfield name="publishdate"  label="出版日期"></s:textfield>
         <s:textfield name="price" label="价格"></s:textfield>
        <s:submit value="提交"></s:submit>
    </s:form >


</body>
</html>