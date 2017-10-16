<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍详情</title>
</head>
<body>
<h1><font color="red">书籍管理———书籍详情</font></h1>
<hr color="green"/>
        <% 
         
        //获得number  
        String str=request.getParameter("bookid"); 
         int number=Integer.parseInt(str);  
  
           //建立jdbc数据库连接 
           Connection connection = DriverManager.getConnection( "jdbc:mysql://nlwqbfkwzskt.mysql.sae.sina.com.cn:10635/lab2?characterEncoding=utf8","45xjo353lw","2y405xxzxk0yhhxihm44kwx2k5442m2lz3mwik2k");
            //创建Statement 对象 
           Statement statement = connection.createStatement() ;
           //执行sql，处理返回的结果集
           ResultSet resultset = statement.executeQuery("select * from books right join author on books.AuthorID=author.AuthorID where ISBN="+number) ; 
          
        %>
<TABLE BORDER="1">
            <TR>
                <TH>书名</TH>
                <TH>作者</TH>
                <TH>年纪</TH>
                <TH>国籍</TH>
                <TH>出版社</TH>
                <TH>出版时间</TH>
                <TH>价格</TH>
               
                
               
            </TR>
        
             <% while(resultset.next()){ %>
            <TR>
                <td>  <%= resultset.getString(2)%></td>
                <TD> <%= resultset.getString(8) %></TD>
                <TD> <%= resultset.getString(9) %></TD>
                <TD> <%= resultset.getString(10) %></TD>
                <td>  <%= resultset.getString(4)%></td>
                <TD> <%= resultset.getString(5) %></TD>
                <TD> <%= resultset.getString(6) %></TD>
               
                
            </TR>
            <% } %>
              
        </TABLE>
</body>
</html>