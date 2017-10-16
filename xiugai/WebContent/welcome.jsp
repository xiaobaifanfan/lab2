<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍管理首页</title>
</head>
<body >
<center>

<h1><font color="red">书籍清单</font></h1>
<hr color="green"/>
<div>add new book <a href="http://localhost:8080/lab/addbook.jsp">新增书籍</a> </div>

<s:form  action="query" method="post" >
		<s:textfield name="authorname"  label="请输入作家姓名"></s:textfield>
<s:submit value="查询"></s:submit>
    </s:form >
    
  <s:form  action="querybytitle" method="post" >
		<s:textfield name="title"  label="请输入书籍名称"></s:textfield>
<s:submit value="查询"></s:submit>
    </s:form >
  
        <% 
           //建立jdbc数据库连接 
           Connection connection = DriverManager.getConnection(
        		   "jdbc:mysql://localhost:3306/lab2-book?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","root");
            //创建Statement 对象 
           Statement statement = connection.createStatement() ;
           //执行sql，处理返回的结果集
           ResultSet resultset = statement.executeQuery("select * from books") ; 
           while(resultset.next()){
        	   out.println(resultset.getString(2));
           }
           out.println(resultset.getString(2));
        %>
        <TABLE BORDER="1">
            <TR>
                <TH>书名</TH>
                <TH>出版社</TH>
                <TH>出版时间</TH>
                <TH>价格</TH>
                <TH>删除</TH>
                <TH>修改</TH>
               
            </TR>
        
            <% while(resultset.next()){ %>
            <TR>
                <TD> <a href="${pageContext.request.contextPath }/show.action?bookid=<%= resultset.getString(1) %>"
						> <%= resultset.getString(2) %></a></td>
                <TD> <%= resultset.getString(4) %></TD>
                <TD> <%= resultset.getString(5) %></TD>
                <TD> <%= resultset.getString(6) %></TD>
                <td><a href="${pageContext.request.contextPath }/update.action?bookid=<%= resultset.getString(1) %>"
						> 修改</a></td> 
                <td><a href="${pageContext.request.contextPath }/delete.action?bookid=<%= resultset.getString(1) %>"
						onClick='return confirm("确定要删除吗？")'> 删除</a></td>
            </TR>
            <% } %>
        </TABLE>
</center>

</body>
</html>