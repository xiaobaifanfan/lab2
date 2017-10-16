package servlet;


import java.sql.ResultSet;
import java.sql.SQLException;


import mysqlcon.SqlCon;
public class add  {

	
	public String name;
	public String author;
	public int age=-100;
	public String country="中国";
	public String publisher;
	public String publishdate;
	public float  price;
	

	
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
try {
			
			while(rs.next())
			{
				num=rs.getInt("ISBN");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return num;
	}
	//查询书籍是否已经存在
	public int Fbookexist() throws SQLException{
		SqlCon mycon2 = new SqlCon();
        String sql2 = "select * from books where Title='"+getName()+"';";
        System.out.println(sql2);
        ResultSet rs1=mycon2.executeQuery(sql2);
        if(rs1!=null&&rs1.next()){
        	System.out.println("result is not null;");
        	return 0;
        }else{
        	System.out.println("result  null;");
        	return 1;
        }
  }
	//新增作者下标
	public int ceshi2() throws SQLException{
		SqlCon mycon5=new SqlCon();
		int num=0;
		String sql5 = "select * from author where AuthorID=(select MAX(AuthorID) from author)";
        ResultSet rs5=mycon5.executeQuery(sql5);
        try{
        	while(rs5.next()){
   			 num=rs5.getInt("AuthorID")+1;
   		}
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql6="insert into author values("+num+",'"+getAuthor()+"',"+age+",'"+country+"');";
		System.out.println(sql6);
		mycon5.executeUpdate(sql6);
		return num;
	}
	//查找作者编号
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
	//判断作家是否已经存在，若不存在，则跳转页面，进行信息补充
	public String jumppage() throws SQLException{
		SqlCon mycon2 = new SqlCon();
        String sql3 = "select * from author where Name='"+getAuthor()+"' and Age>0;";
        ResultSet rs3=mycon2.executeQuery(sql3);
        if(rs3!=null&&rs3.next()){
        	return "success";
        	
        }else{
        	return "addauthor";
        	
        	
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
		  
		   return  jumppage();
	   }
		
	return "ing";
	}
}
