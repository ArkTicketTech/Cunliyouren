package com.clyr.utils;  
  
import java.io.*;     
import java.sql.*;     
import java.util.Properties;
  
public class DBConn {     
	public static String driver;//定义驱动     
    public static String url;//定义URL     
    public static String user;//定义用户名     
	public static String password;//定义密码     
 	public static Connection conn;//定义连接     
  	public static Statement stmt;//定义STMT     
  	public ResultSet rs;//定义结果集     
  	//设置CONN     
   	static{     
   		Properties pro = new Properties();
   		try {   
   			driver="com.mysql.jdbc.Driver";  
   			try {
				pro.load(DBConn.class.getResourceAsStream("jdbc.properties"));
			} catch (IOException e) {
				System.out.println("未找到配置文件");
			} 
   			url=pro.getProperty("url");
   			user = pro.getProperty("user");
			password = pro.getProperty("password");
   			Class.forName(driver);     
   			conn = DriverManager.getConnection(url,user,password);  
   			System.out.println("-------连接成功------");  
   		} catch(ClassNotFoundException classnotfoundexception) {     
   			classnotfoundexception.printStackTrace();     
   			System.err.println("db: " + classnotfoundexception.getMessage());     
   		} catch(SQLException sqlexception) {     
   			System.err.println("db.getconn(): " + sqlexception.getMessage());     
   		}     
	}     
	//构造函数，默认加裁配置文件为jdbc.driver     
	public DBConn(){     
		this.conn=this.getConn();  
	}     
	//返回Conn     
	public Connection getConn(){     
 		return this.conn;     
	}     
	//执行插入     
	public void doInsert(String sql) {     
		try {     
			stmt = conn.createStatement();     
			int i = stmt.executeUpdate(sql);     
		} catch(SQLException sqlexception) {     
			System.err.println("db.executeInset:" + sqlexception.getMessage());     
		}finally{                     
		}     
	}     
	//执行删除     
	public void doDelete(String sql) {     
  	    try {     
  		    stmt = conn.createStatement();     
  		    int i = stmt.executeUpdate(sql);     
  	    } catch(SQLException sqlexception) {     
  		    System.err.println("db.executeDelete:" + sqlexception.getMessage());     
  		}     
    }     
	//执行更新     
	public void doUpdate(String sql) {     
		try {     
			stmt = conn.createStatement();     
			int i = stmt.executeUpdate(sql);     
		} catch(SQLException sqlexception) {     
			System.err.println("db.executeUpdate:" + sqlexception.getMessage());     
		}     
	}     
	//查询结果集     
 	public ResultSet doSelect(String sql) {     
 		try {  
 			conn=DriverManager.getConnection(url,user,password);  
 			stmt = conn.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);       
 			rs = stmt.executeQuery(sql);   
 			System.out.println("取得结果集");  
 		} catch(SQLException sqlexception) {     
 			System.err.println("db.executeQuery: " + sqlexception.getMessage());     
 		}     
 		return rs;     
	}     
	/**   
	*关闭数据库结果集，数据库操作对象，数据库链接   
  	@Function: Close all the statement and conn int this instance and close the parameter ResultSet   
 	@Param: ResultSet   
 	@Exception: SQLException,Exception   
	**/    
	public void close(ResultSet rs) throws SQLException, Exception {     
		if (rs != null) {     
			rs.close();     
			rs = null;     
		}     
        
		if (stmt != null) {     
			stmt.close();     
			stmt = null;     
		}     
        
		if (conn != null) {     
			conn.close();     
			conn = null;     
		}     
 	}     
        
	/**   
 	*关闭数据库操作对象，数据库连接对象   
	* Close all the statement and conn int this instance   
	* @throws SQLException   
	* @throws Exception   
	*/    
  	public void close() throws SQLException, Exception {     
  		if (stmt != null) {     
  			stmt.close();     
  			stmt = null;     
  		}     
        
  		if (conn != null) {     
  			conn.close();     
  			conn = null;     
  		}     
	}   
    //测试方法
//  public static void main(String []args){  
//      DBConn db=new DBConn();  
//      db.getConn();  
//     ResultSet rs=db.doSelect("select * from admin where adminName='admin'");  
//     try {  
//         while(rs.next()){  
//             System.out.println(rs.getString("adminName"));  
//             System.out.println(rs.getString("password"));
//               
//         }  
//     } catch (SQLException e) {  
//         // TODO Auto-generated catch block  
//         e.printStackTrace();  
//     }  
//  } 
         
}