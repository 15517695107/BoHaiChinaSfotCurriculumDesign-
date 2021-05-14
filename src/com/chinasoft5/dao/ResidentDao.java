package com.chinasoft5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft5.entity.Resident;

/**
 * ResidentDao
 * @author HanY
 * 2021-05-04 15:56:29
 */
public class ResidentDao {
	//封装用到的私有属性
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private BaseDao dao=new BaseDao();
	//------下面开始编辑公开方法
	
	//查询住户表数据
	public List<Resident> selectAll(){
		System.out.println("查询：");
		//1，注册驱动，获取连接
		conn=dao.getConn();
		//2-编写SQL语句
		String sql="select * from resident";
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
				String Rid=rs.getString("Rid");
				String Rname=rs.getString("Rname");
				String Hid=rs.getString("Hid");
				String Rusername=rs.getString("Rusername");
				String Rpassword=rs.getString("Rpassword");
				String Rsex=rs.getString("Rsex");
				String Rphone=rs.getString("Rphone");
				String Rintime=rs.getString("Rintime");
				String Rowner=rs.getString("Rowner");
				
				//将取出的数据封装为Resident实体类对象
				Resident r = new Resident(Rid, Rname, Hid, Rusername,
						Rpassword, Rsex, Rphone, Rintime, Rowner);
				//5-3将封装好的对象放入list集合
				list.add(r);
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
	public int insert(Resident r){
		//1，注册驱动，获取连接
		conn=dao.getConn();
		//2-编写SQL语句
		String sql="insert into resident values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			//3-预编译sql语句，获取PreparedStatement对象
			ps=conn.prepareStatement(sql);
			System.out.println("添加1！！");
			//4-设置SQL语句中占位符代表的数据,将传进来的参数放入SQL语句中
			ps.setString(1, r.getRid());
			ps.setString(2, r.getRname());
			ps.setString(3, r.getHid());
			ps.setString(4, r.getRusername());
			ps.setString(5, r.getRpassword());
			ps.setString(6, r.getRsex());
			ps.setString(7, r.getRphone());
			ps.setString(8, r.getRintime());
			ps.setString(9, r.getRowner());
		
			//5-获取执行结果(成功添加数据条数)
			int code =ps.executeUpdate();
			System.out.println(code);
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
	public int update(Resident r){
		//1，注册驱动，获取连接
		conn=dao.getConn();
		//2-编写SQL语句
		String sql="update resident set Rname=?, Hid=?, Rusername=?, Rpassword=?, Rsex=?, "
				+ " Rphone=?, Rintime=?, Rowner=? where Rid=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,r.getRname());
			ps.setString(2,r.getHid());
			ps.setString(3,r.getRusername());
			ps.setString(4,r.getRpassword());
			ps.setString(5,r.getRsex());
			ps.setString(6,r.getRphone());
			ps.setString(7,r.getRintime());
			ps.setString(8,r.getRowner());
			ps.setString(9, r.getRid());
			
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
	
	//删除住户表数据
	public int delete(String Rid){
		//1，注册驱动，获取连接
		conn=dao.getConn();
		//2-编写SQL语句
		String sql="delete from resident where Rid=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, Rid);
			int code=ps.executeUpdate();
			return code;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return -1;
		}finally {
			dao.closeAll(conn, ps, rs);
		}

	}
	
	public Resident selectByUserName(String userName){
		conn = dao.getConn();
		String sql = "select Rid rid, Rname rname, Hid hid, Rusername uname, "
				+ "Rpassword pwd, Rsex sex, Rphone ph, Rintime intime, "
				+ " Rowner rown from resident "
				+ " where Rusername=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
//			System.out.println(rs.next());
			Resident s = null;
			if(rs.next()){
				String id = rs.getString("rid");
				String name = rs.getString("rname");
				String hid = rs.getString("hid");
				String uname = rs.getString("uname");
				String pwd = rs.getString("pwd");
				String sex = rs.getString("sex");
				String ph = rs.getString("ph");
				String intime = rs.getString("intime");
				String row = rs.getString("rown");
				s = new Resident(id, name, hid, uname,
						pwd, sex, ph, intime, row);
				System.out.println(s);
			}
			return s;
		} catch (SQLException e) {
			System.out.println("error");
			e.printStackTrace();
			return null;
		}
	}
}
