package servlet;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import mysqlcon.SqlCon;

public class querybyauthor extends ActionSupport {
	public String authorname;
	public String sql6;
	public String title;
public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

public String execute(){
	SqlCon mycon5=new SqlCon();
	mycon5.executeUpdate("DROP table IF EXISTS new;");
    sql6="create table new as select ISBN,Title,Name,Age,Country,Publisher,PublishDate,Price from books inner join author on books.AuthorID=author.AuthorID where Name='"+getAuthorname()+"';";
    System.out.println(sql6);
    mycon5.executeUpdate(sql6);
	return "query";
}
public String dd(){
	SqlCon mycon5=new SqlCon();
	mycon5.executeUpdate("DROP table IF EXISTS new;");
    sql6="create table new as select ISBN,Title,Name,Age,Country,Publisher,PublishDate,Price from books inner join author on books.AuthorID=author.AuthorID where Title='"+getTitle()+"';";
    System.out.println(sql6);
    mycon5.executeUpdate(sql6);
	return "query";
}
public String getSql6() {
	return sql6;
}
public void setSql6(String sql6) {
	this.sql6 = sql6;
}
}
