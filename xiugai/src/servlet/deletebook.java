package servlet;

import mysqlcon.SqlCon;

public class deletebook {
public String  bookid;
public String getBookid() {
	return bookid;
}
public void setBookid(String bookid) {
	this.bookid = bookid;
}
public String execute(){
	SqlCon mycon = new SqlCon();
	 
    String sql="delete from books where ISBN="+getBookid();
    System.out.println(sql);
  
     mycon.executeUpdate(sql);

	  
	  
   return "delbook";
}
}
