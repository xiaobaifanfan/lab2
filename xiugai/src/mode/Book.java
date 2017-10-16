package mode;

public class Book {
public int isbn;
public String title;
public int authorID;
public String publisher;
public String publishDate;
public float price;
public Book(){
	
}
public Book(int isbn,String title,int authorID,String publisher,String publishDate,float price){
	this.authorID=authorID;
	this.isbn=isbn;
	this.price=price;
	this.publishDate=publishDate;
	this.title=title;
	this.price=price;
	
}
public int getIsbn() {
	return isbn;
}
public void setIsbn(int isbn) {
	this.isbn = isbn;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getAuthorID() {
	return authorID;
}
public void setAuthorID(int authorID) {
	this.authorID = authorID;
}
public String getPublisher() {
	return publisher;
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
public String getPublishDate() {
	return publishDate;
}
public void setPublishDate(String publishDate) {
	this.publishDate = publishDate;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}



}
