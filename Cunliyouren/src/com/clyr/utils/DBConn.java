package com.clyr.utils;  
  
import java.io.*;     
import java.sql.*;     
import java.util.Properties;
  
public class DBConn {     
	public static String driver;     
    public static String url;    
    public static String user;   
	public static String password;   
 	public static Connection conn;    
  	public static Statement stmt;     
  	public ResultSet rs;
  	 
   	static{     
   		Properties pro = new Properties();
   		try {   
   			driver="com.mysql.jdbc.Driver";  
   			try {
				pro.load(DBConn.class.getResourceAsStream("jdbc.properties"));
			} catch (IOException e) {
				System.out.println("connect failure");
			} 
   			url=pro.getProperty("url");
   			user = pro.getProperty("user");
			password = pro.getProperty("password");
   			Class.forName(driver);     
   			conn = DriverManager.getConnection(url,user,password);  
   			System.out.println("---connect success---");  
   		} catch(ClassNotFoundException classnotfoundexception) {     
   			classnotfoundexception.printStackTrace();     
   			System.err.println("db: " + classnotfoundexception.getMessage());     
   		} catch(SQLException sqlexception) {     
   			System.err.println("db.getconn(): " + sqlexception.getMessage());     
   		}     
	}     
	     
	public DBConn(){     
		this.conn=this.getConn();  
	}     
	   
	public Connection getConn(){     
 		return this.conn;     
	}     
	 
	public void doInsert(String sql) {     
		try {    
			conn=DriverManager.getConnection(url,user,password);
			stmt = conn.createStatement();     
			int i = stmt.executeUpdate(sql);     
		} catch(SQLException sqlexception) {     
			System.err.println("db.executeInset:" + sqlexception.getMessage());     
		}finally{                     
		}     
	}     
	
	public void doDelete(String sql) {     
  	    try {     
  	    	conn=DriverManager.getConnection(url,user,password);
  		    stmt = conn.createStatement();     
  		    int i = stmt.executeUpdate(sql);     
  	    } catch(SQLException sqlexception) {     
  		    System.err.println("db.executeDelete:" + sqlexception.getMessage());     
  		}     
    }     
	
	public void doUpdate(String sql) {     
		try {     
			conn=DriverManager.getConnection(url,user,password);
			stmt = conn.createStatement();     
			int i = stmt.executeUpdate(sql);     
		} catch(SQLException sqlexception) {     
			System.err.println("db.executeUpdate:" + sqlexception.getMessage());     
		}     
	}     
	
 	public ResultSet doSelect(String sql) {     
 		try {  
 			conn=DriverManager.getConnection(url,user,password);  
 			stmt = conn.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);       
 			rs = stmt.executeQuery(sql);   
 		} catch(SQLException sqlexception) {     
 			System.err.println("db.executeQuery:" + sqlexception.getMessage());     
 		}     
 		return rs;     
	}     
	/**   
  	 * @Function: Close all the statement and conn int this instance and close the parameter ResultSet   
 	 * @Param: ResultSet   
 	 * @Exception: SQLException,Exception   
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
    //Test类
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