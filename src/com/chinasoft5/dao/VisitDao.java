package com.chinasoft5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft5.entity.Visit;

/**
 * VisitDao
 * @author HanY
 * 2021-05-04 16:58:54
 * 注：拜访记录不允许删除和修改
 */
public class VisitDao {
	//封装用到的私有属性
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private BaseDao dao=new BaseDao();
	//------下面开始编辑公开方法
	
	//查询拜访记录表数据
	public List<Visit> selectAll(){
		//1，注册驱动，获取连接
		conn=dao.getConn();
		//2-编写SQL语句
		String sql="select * from visit";
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
				String Vid=rs.getString("Vid");
				String Vname=rs.getString("Vname");
				String STid=rs.getString("STid");
				String Vphone=rs.getString("Vphone");
				String Vintime=rs.getString("Vintime");
				String Vouttime=rs.getString("Vouttime");
				
				//将取出的数据封装为Visit实体类对象
				Visit v = new Visit(Vid, Vname, STid, Vphone,
						Vintime, Vouttime);
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
	public int insert(Visit v){
		//1，注册驱动，获取连接
		System.out.println("visit"+v);
		conn=dao.getConn();
		//2-编写SQL语句
		String sql="insert into Visit values(?, ?, ?, ?, ?, ?)";
		try {
			//3-预编译sql语句，获取PreparedStatement对象
			ps=conn.prepareStatement(sql);
			//4-设置SQL语句中占位符代表的数据,将传进来的参数放入SQL语句中
			ps.setString(1, v.getVid());
			ps.setString(2, v.getVname());
			ps.setString(3, v.getSTid());
			ps.setString(4, v.getVphone());
			ps.setString(5, v.getVintime());
			ps.setString(6, v.getVouttime());
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
	
	

}
