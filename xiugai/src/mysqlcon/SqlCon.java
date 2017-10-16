package mysqlcon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class SqlCon {
	 Connection con =null;
	    Statement stat=null;
	    ResultSet rs=null;
	    String url="jdbc:mysql://localhost:3306/lab2-book?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	    String user="root";
	    String pwd="root";
	    
	    public SqlCon()
	    {
	        try
	        {
	            Class.forName("com.mysql.jdbc.Driver");//连接驱动
	            con=DriverManager.getConnection(url,user,pwd);//连接数据库
	            stat=con.createStatement();
	            
	        }
	        
	        catch(Exception e)
	        {
	            con=null;
	        }
	    
	    }
	    
	    public ResultSet executeQuery(String sql)
	    {
	        try
	        {
	            
	            rs=stat.executeQuery(sql);
	            
			      
	        
	        }
	        
	        catch(Exception e)
	        {
	            rs=null;
	        }
	        return rs;
	    }
	    
	    public int executeUpdate(String sql)
	    {
	        try
	        {
	         stat.executeUpdate(sql);
	         System.out.println("添加成功");
	            return 0;
	        }
	        catch(Exception e)
	        {System.out.println("添加没有成功");
	            return -1;
	        }
	    }
}
