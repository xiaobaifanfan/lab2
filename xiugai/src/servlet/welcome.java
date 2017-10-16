package servlet;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import mode.Book;
import mysqlcon.SqlCon;

public class welcome extends ActionSupport {
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	List<Book> bookList=null;
	public String wewe(){
		SqlCon mycon1=new SqlCon();
		String sql="select * from books";
		ResultSet rs=mycon1.executeQuery(sql);
	    bookList=getBook(rs);
	    for(Book item:bookList){
	    	System.out.print(item.publishDate);
	    }
		return "SUCCESS";
	}
	public List<Book> getBook(ResultSet rs) {
		
		
		List<Book> bookList=new ArrayList<Book>();
			try {
				
				while(rs.next())
				{ 
					int isbn=rs.getInt("ISBN");
					String title=rs.getString("Title");
					int authorID=rs.getInt("AuthorID");
					String publisher=rs.getString("Publisher");
					String publishDate=rs.getString("PublishDate");
					float price=rs.getFloat("Price");
					
					Book book=new Book();
					book.setAuthorID(authorID);
					book.setIsbn(isbn);
		            book.setPrice(price);	
		            book.setPublishDate(publishDate);
		            book.setPublisher(publisher);
		            book.setTitle(title);
		            bookList.add(book);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bookList;
		}
}
