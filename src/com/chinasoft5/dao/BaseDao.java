package com.chinasoft5.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * 封装jdbc代码
 * @author HanY
 * 2021-05-04 10:59:54
 */
import java.sql.SQLException;
public class BaseDao {
	//封装jdbc使用的接口作为属性，方便使用
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	//封装获取连接方法
	public Connection getConn(){
		//1-注册驱动
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("注册成功！！！");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("注册失败！！！");
			return null;
			
		}
		//建立连接
		try {
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","orcl");
//			System.out.println("连接成功！！！");
			//成功返回获取到的连接对象conn
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("连接失败！！！");
			
			return null;
			
		}
		
		
	}
	//定义关闭资源方法
	public void closeAll(Connection conn,PreparedStatement ps,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}		
}

