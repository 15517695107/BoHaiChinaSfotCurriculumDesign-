package com.chinasoft5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft5.entity.Staff;

/**
 * StaffDao
 * @author HanY
 * 2021-05-04 16:50:42
 */

public class StaffDao {
	//封装用到的私有属性
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private BaseDao dao=new BaseDao();
	//------下面开始编辑公开方法
	
	//查询员工表数据
	public List<Staff> selectAll(){
		//1，注册驱动，获取连接
		conn=dao.getConn();
		//2-编写SQL语句
		String sql="select * from staff";
		try {
			//3-预编译sql语句
			ps=conn.prepareStatement(sql);
//			System.out.println("编译sql成功");
			//4-获取查询结果集
			rs = ps.executeQuery();
			System.out.println(rs.next());
			//5-循环遍历结果集，对数据进行封装最终存放到List集合中返回
			List list=new ArrayList();

			while(rs.next()){
				//5-1通过字段名取出对应的数据
				String STid=rs.getString("STid");
				String Sname=rs.getString("Sname");
				String Susername=rs.getString("Susername");
				String Spassword=rs.getString("Spassword");
				String Ssex=rs.getString("Ssex");
				String Sphone=rs.getString("Sphone");
				String Sintime=rs.getString("Sintime");
				String Sposition=rs.getString("Sposition");
				
				//将取出的数据封装为Staff实体类对象
				Staff s = new Staff(STid, Sname, Susername, Spassword,
						Ssex, Sphone, Sintime, Sposition);
				//5-3将封装好的对象放入list集合
				list.add(s);
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
		
	//增加住户表数据
	public int insert(Staff s){
		System.out.println("dao"+ s);
		//1，注册驱动，获取连接
		conn=dao.getConn();
		//2-编写SQL语句
		String sql="insert into Staff values(?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			//3-预编译sql语句，获取PreparedStatement对象
			ps=conn.prepareStatement(sql);
			//4-设置SQL语句中占位符代表的数据,将传进来的参数放入SQL语句中
			ps.setString(1, s.getSTid());
			ps.setString(2, s.getSname());
			ps.setString(3, s.getSusername());
			ps.setString(4, s.getSpassword());
			ps.setString(5, s.getSsex());
			ps.setString(6, s.getSphone());
			ps.setString(7, s.getSintime());
			ps.setString(8, s.getSposition());
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
	
	//修改员工表数据
	public int update(Staff s){
		System.out.println("staffdao"+ s);
		//1，注册驱动，获取连接
		conn=dao.getConn();
		//2-编写SQL语句
		String sql="update Staff set Sname=?, Susername=?, Spassword=?, Ssex=?, "
				+ " Sphone=?, Sintime=?, Sposition=? where STid=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,s.getSname());
			ps.setString(2,s.getSusername());
			ps.setString(3,s.getSpassword());
			ps.setString(4,s.getSsex());
			ps.setString(5,s.getSphone());
			ps.setString(6,s.getSintime());
			ps.setString(7,s.getSposition());
			ps.setString(8,s.getSTid());
			
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
	
	//删除员工表数据
	public int delete(String STid){
		System.out.println(STid);
		//1，注册驱动，获取连接
		conn=dao.getConn();
		//2-编写SQL语句
		String sql="delete from Staff where STid=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, STid);
			int code=ps.executeUpdate();
			return code;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return -1;
		}finally {
			dao.closeAll(conn, ps, rs);
		}
	}
	public Staff selectByUserName(String userName){
		conn = dao.getConn();
		String sql = "select STid stid, Sname sname, Susername uname, "
				+ "Spassword pwd, Ssex sex, Sphone ph, Sintime intime, "
				+ " Sposition posi from Staff "
				+ " where Susername=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			Staff s = null;
			System.out.println("staff  rs.next  " + rs.next());
			if(true){
				System.out.println("进入查询staff");
				String id = rs.getString("stid");
				String name = rs.getString("sname");
				String uname = rs.getString("uname");
				String pwd = rs.getString("pwd");
				String sex = rs.getString("sex");
				String ph = rs.getString("ph");
				String intime = rs.getString("intime");
				String pos = rs.getString("posi");
				s = new Staff(id, name, uname,
						pwd, sex, ph, intime, pos);
				System.out.println(s);
			}
			return s;
		} catch (SQLException e) {
			System.out.println("staff error");
			e.printStackTrace();
			return null;
		}
	}
}
