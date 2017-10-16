package servlet;
import java.sql.ResultSet;
import java.sql.SQLException;
import mysqlcon.SqlCon;
public class addinfo {
	public String author;
	public int age;
	public String country;
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
	public int ceshi2() throws SQLException{
		SqlCon mycon5=new SqlCon();
	
		String sql6="update author set Age="+getAge()+",Country='"+getCountry()+"' where Name='"+getAuthor()+"';";
		System.out.println(sql6);
		mycon5.executeUpdate(sql6);
		return 0;
	}
public String execute(){
	System.out.println(getCountry()+" "+ getAge());
	try {
		ceshi2();
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	return "success";
}
}
