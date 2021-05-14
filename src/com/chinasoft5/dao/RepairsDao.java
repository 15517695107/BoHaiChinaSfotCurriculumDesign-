package com.chinasoft5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft5.entity.Repairs;

/**
 * RepairsDao
 * @author 86155
 * 2021-05-04 17:06:39
 * 注：报修记录不允许删除
 */
public class RepairsDao {
	//封装用到的私有属性
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private BaseDao dao=new BaseDao();
	//------下面开始编辑公开方法
	
	//查询拜访记录表数据
	public List<Repairs> selectAll(){
		//1，注册驱动，获取连接
		conn=dao.getConn();
		//2-编写SQL语句
		String sql="select * from Repairs";
		try {
			//3-预编译sql语句
			ps=conn.prepareStatement(sql);
			System.out.println("编译sql成功");
			//4-获取查询结果集
			rs = ps.executeQuery();
			System.out.println(rs.next());
			//5-循环遍历结果集，对数据进行封装最终存放到List集合中返回
			List list=new ArrayList();

			while(rs.next()){
				//5-1通过字段名取出对应的数据
				String REid=rs.getString("REid");
				String Hid=rs.getString("Hid");
				String STid=rs.getString("STid");
				String REdate=rs.getString("REdate");
				String POSdate=rs.getString("POSdate");
				String REboolen=rs.getString("REboolen");
				
				//将取出的数据封装为Repairs实体类对象
				Repairs v = new Repairs(REid, Hid, STid, REdate,
						POSdate, REboolen);
				//5-3将封装好的对象放入list集合
				list.add(v);
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
	public int insert(Repairs v){
		System.out.println(v);
		//1，注册驱动，获取连接
		conn=dao.getConn();
		//2-编写SQL语句
		String sql="insert into Repairs values(?, ?, ?, ?, ?, ?)";
		try {
			//3-预编译sql语句，获取PreparedStatement对象
			ps=conn.prepareStatement(sql);
			//4-设置SQL语句中占位符代表的数据,将传进来的参数放入SQL语句中
			ps.setString(1, v.getREid());
			ps.setString(2, v.getHid());
			ps.setString(3, v.getSTid());
			ps.setString(4, v.getREdate());
			ps.setString(5, v.getPOSdate());
			ps.setString(6, v.getREboolen());
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
	public int update(Repairs r){
		System.out.println("Repairs" + r);
		//1，注册驱动，获取连接
		conn=dao.getConn();
		//2-编写SQL语句
		String sql="update Repairs set Hid=?, STid=?, REdate=?, "
				+ " POSdate=?, REboolen=? where REid=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,r.getHid());
			ps.setString(2,r.getSTid());
			ps.setString(3,r.getREdate());
			ps.setString(4,r.getPOSdate());
			ps.setString(5,r.getREboolen());
			ps.setString(6,r.getREid());
			
			int code=ps.executeUpdate();
			System.out.println("RepairsDao update" + code);
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
