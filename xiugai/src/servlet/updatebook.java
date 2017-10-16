package servlet;

import java.sql.ResultSet;
import java.sql.SQLException;

import mysqlcon.SqlCon;

public class updatebook {
	public int bookid;
	public String name;
	public String author;
	public int age;
	public String country;
	public String publisher;
	public String publishdate;
	public float  price;
	public int authorid;

public String execute() throws Exception{
	System.out.println("---update---"+getBookid());
	SqlCon mycon1=new SqlCon();
	String insert = "select * from books right join author on books.AuthorID=author.AuthorID where ISBN="+getBookid();
	ResultSet rs=mycon1.executeQuery(insert);
	try{
		while(rs.next()){
			authorid=rs.getInt(3);
			//System.out.println(authorid+" "+rs.getString(2));
			name=rs.getString(2);
			author=rs.getString(8);
			age=rs.getInt(9);
			country=rs.getString(10);
			publisher=rs.getString(4);
			publishdate=rs.getString(5);
			price=rs.getFloat(6);
			bookid=rs.getInt(1);
		}
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	System.out.println(getName());
	return "updbook";
}
public String updateend() throws SQLException{
	System.out.println("---update2---"+getBookid());
	SqlCon mycon1=new SqlCon();
	String sql6="select * from books where Title='"+getName()+"';";
	ResultSet rs1=mycon1.executeQuery(sql6);
	try{
		while(rs1.next()){
			bookid=rs1.getInt(1);
			authorid=rs1.getInt(3);
		}
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	String sql7= "update  books set Title='"+getName()+"',Publisher='"+getPublisher()+"',PublishDate='"+getPublishdate()+"',Price="+getPrice()+" where ISBN="+getBookid();
	String sql8="update author set Age="+getAge()+",Country='"+getCountry()+"',Name='"+getAuthor()+"' where AuthorID="+getAuthorid()+";";
	mycon1.executeUpdate(sql7);
	mycon1.executeUpdate(sql8);
	//System.out.println(sql7);
	//System.out.println(sql8);
	return "endupd";
}
public int getAuthorid() {
	return authorid;
}
public void setAuthorid(int authorid) {
	this.authorid = authorid;
}
public int getBookid() {
	return bookid;
}
public void setBookid(int bookid) {
	this.bookid = bookid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getPublisher() {
	return publisher;
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
public String getPublishdate() {
	return publishdate;
}
public void setPublishdate(String publishdate) {
	this.publishdate = publishdate;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
}
