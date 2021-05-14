package com.chinasoft5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft5.entity.Home;

/**
 * HomeDao
 * @author HanY
 * 2021-05-04 15:56:29
 */
public class HomeDao {
	//封装用到的私有属性
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private BaseDao dao=new BaseDao();
	//------下面开始编辑公开方法
	
	//查询房屋表数据
	public List<Home> selectAll(){
		//1，注册驱动，获取连接
		conn=dao.getConn();
		//2-编写SQL语句
		String sql="select * from home";
		try {
			//3-预编译sql语句
			ps=conn.prepareStatement(sql);
			//4-获取查询结果集
			rs=ps.executeQuery();
			//5-循环遍历结果集，对数据进行封装最终存放到List集合中返回
			List list=new ArrayList();
			while(rs.next()){
				//5-1通过字段名取出对应的数据
				String Hid=rs.getString("Hid");
				double Harea=rs.getDouble("Harea");
				String Hsite=rs.getString("Hsite");
				
				//将取出的数据封装为Department实体类对象
				Home h=new Home(Hid, Harea, Hsite);
				//5-3将封装好的对象放入list集合
				list.add(h);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
	}finally{
		//关闭资源
		dao.closeAll(conn, ps, rs);
	}
		}
		
	//增加房屋表数据
	public int insert(Home h){
		//1，注册驱动，获取连接
		conn=dao.getConn();
		//2-编写SQL语句
		String sql="insert into home values(?, ?, ?)";
		try {
			//3-预编译sql语句，获取PreparedStatement对象
			ps=conn.prepareStatement(sql);
			//4-设置SQL语句中占位符代表的数据,将传进来的参数放入SQL语句中
			ps.setString(1, h.getHid());
			ps.setDouble(2, h.getHarea());
			ps.setString(3, h.getHsite());
			//5-获取执行结果(成功添加数据条数)
			int code =ps.executeUpdate();
			//6-若添加成功，则将条数返回
			return code;
		} catch (SQLException e) {
			//添加失败，则返回-1
			return -1;
		
		}
		//关闭资源
		finally{
			dao.closeAll(conn, ps, rs);
		}
		
	}
	//修改房屋表数据
	public int update(Home h){
		//1，注册驱动，获取连接
		conn=dao.getConn();
		//2-编写SQL语句
		String sql="update home set Hsite=?, Harea=? where Hid=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(3,h.getHid());
			ps.setDouble(2,h.getHarea());
			ps.setString(1,h.getHsite());
			int code=ps.executeUpdate();
			return code;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return -1;
		}finally {
			dao.closeAll(conn, ps, rs);
		}
	}
	//删除房屋表数据
	public int delete(String Hid){
		//1，注册驱动，获取连接
		conn=dao.getConn();
		//2-编写SQL语句
		String sql="delete from home where Hid=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, Hid);
			int code= ps.executeUpdate();
			return code;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return -1;
		}finally {
			dao.closeAll(conn, ps, rs);
		}

	}
}
