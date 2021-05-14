package com.chinasoft5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft5.entity.Property;

public class PropertyDao {
	//封装用到的私有属性
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private BaseDao dao=new BaseDao();
	//------下面开始编辑公开方法
	
	//查询拜访记录表数据
	public List<Property> selectAll(){
		//1，注册驱动，获取连接
		conn=dao.getConn();
		//2-编写SQL语句
		String sql="select * from Property";
		try {
			//3-预编译sql语句
			ps=conn.prepareStatement(sql);
			//4-获取查询结果集
			rs = ps.executeQuery();
			System.out.println(rs.next());
			//5-循环遍历结果集，对数据进行封装最终存放到List集合中返回
			List list=new ArrayList();
			while(rs.next()){
				//5-1通过字段名取出对应的数据
				String Pid=rs.getString("Pid");
				String Hid=rs.getString("Hid");
				String STid=rs.getString("STid");
				String Pdate=rs.getString("Pdate");
				String PEdate=rs.getString("PEdate");
				String Pboolen=rs.getString("Pboolen");
				
				//将取出的数据封装为Property实体类对象
				Property p = new Property(Pid, Hid, STid, Pdate,
						PEdate, Pboolen);
				//5-3将封装好的对象放入list集合
				list.add(p);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查询异常");
			return null;
	}finally{
		//关闭资源
		dao.closeAll(conn, ps, rs);
	}
		}
		
	//增加拜访记录表数据
	public int insert(Property p){
		//1，注册驱动，获取连接
		conn=dao.getConn();
		//2-编写SQL语句
		String sql="insert into Property values(?,?,?,?,?,?)";
		try {
			//3-预编译sql语句，获取PreparedStatement对象
			ps=conn.prepareStatement(sql);
			//4-设置SQL语句中占位符代表的数据,将传进来的参数放入SQL语句中
			ps.setString(1, p.getPid());
			ps.setString(2, p.getHid());
			ps.setString(3, p.getSTid());
			ps.setString(4, p.getPdate());
			ps.setString(5, p.getPEdate());
			ps.setString(6, p.getPboolen());
			//5-获取执行结果(成功添加数据条数)
			int code =ps.executeUpdate();
			//6-若添加成功，则将条数返回
			return code;
		} catch (SQLException e) {
			//添加失败，则返回-1
			System.out.println("添加失败");
			return -1;
		}
		//关闭资源
		finally{
			dao.closeAll(conn, ps, rs);
		}
	}

	//修改住户表数据(需要被选中的住户编号）
	public int update(Property p){
		//1，注册驱动，获取连接
		conn=dao.getConn();
		//2-编写SQL语句
		String sql="update Property set Hid=?, STid=?, Pdate=?, "
				+ " PEdate=?, Pboolen=? where Pid=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,p.getHid());
			ps.setString(2,p.getSTid());
			ps.setString(3,p.getPdate());
			ps.setString(4,p.getPEdate());
			ps.setString(5,p.getPboolen());
			ps.setString(6,p.getPid());
			int code=ps.executeUpdate();
			return code;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("更新失败");
			return -1;
		}finally {
			dao.closeAll(conn, ps, rs);
		}
	}

}
