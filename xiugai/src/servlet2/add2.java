package servlet2;
import java.sql.ResultSet;
import java.sql.SQLException;

import mysqlcon.SqlCon;
public class add2 {
	public String name;
	public String author;
	public int age;
	public String country;
	public String publisher;
	public String publishdate;
	public float  price;
	
	
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
	//增加序列bookID
	public int ceshi() throws SQLException{
		SqlCon mycon1=new SqlCon();
		int num=0;
		String insert = "select * from books where ISBN=(select MAX(ISBN) from books)";
		ResultSet rs=mycon1.executeQuery(insert);
		while(rs.next()){
			 num=rs.getInt("ISBN");
		}
		return num;
	}
	public int Fbookexist() throws SQLException{
		SqlCon mycon2 = new SqlCon();
        String sql2 = "select * from books where Title='"+getName()+"';";
        ResultSet rs1=mycon2.executeQuery(sql2);
        if(rs1!=null&&rs1.next()){
        	System.out.println("result is not null;");
        	return 0;
        }else{
        	System.out.println("result  null;");
        	return 1;
        }
  }
	public int ceshi2() throws SQLException{
		SqlCon mycon5=new SqlCon();
		int num=0;
		String sql5 = "select * from author where AuthorID=(select MAX(AuthorID) from author)";
        ResultSet rs5=mycon5.executeQuery(sql5);
		while(rs5.next()){
			 num=rs5.getInt("AuthorID")+1;
		}
		String sql6="insert into author values("+num+",'"+getName()+"','"+"',"+getAge()+",'"+getCountry()+"');";
		System.out.println(sql6);
		mycon5.executeUpdate(sql6);
		return num;
	}
	public int Fauthor() throws SQLException{
		int number=0;
		SqlCon mycon2 = new SqlCon();
        String sql3 = "select * from author where Name='"+getAuthor()+"';";
        ResultSet rs3=mycon2.executeQuery(sql3);
        if(rs3!=null&&rs3.next()){
        	number=rs3.getInt("AuthorID");
        	return number;
        }else{
        	number=ceshi2();
        	return number;
        	
        }
		
	}
	public String execute() throws SQLException
	{   
		int tip=Fbookexist();
		System.out.println(tip);
		System.out.println("---tip--");
		if(tip==0)
		{
			System.out.println("此书籍已经存在，无需重复添加！");
			return "ing";
		}
		int id=ceshi()+1;
		int authorid=Fauthor();
		SqlCon mycon = new SqlCon();
		String insert = "insert into books values("+id+",'"+getName()+"',"+authorid+",'"+getPublisher()+"','"+ getPublishdate()+"','"+getPrice()+"');";
	   System.out.println(insert);
	  
	   if( mycon.executeUpdate(insert)==0){
		   return "success";
	   }
		
	return "ing";
}
}
