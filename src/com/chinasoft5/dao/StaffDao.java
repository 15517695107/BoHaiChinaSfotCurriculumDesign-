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
	//��װ�õ���˽������
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private BaseDao dao=new BaseDao();
	//------���濪ʼ�༭��������
	
	//��ѯԱ��������
	public List<Staff> selectAll(){
		//1��ע����������ȡ����
		conn=dao.getConn();
		//2-��дSQL���
		String sql="select * from staff";
		try {
			//3-Ԥ����sql���
			ps=conn.prepareStatement(sql);
//			System.out.println("����sql�ɹ�");
			//4-��ȡ��ѯ�����
			rs = ps.executeQuery();
			System.out.println(rs.next());
			//5-ѭ������������������ݽ��з�װ���մ�ŵ�List�����з���
			List list=new ArrayList();

			while(rs.next()){
				//5-1ͨ���ֶ���ȡ����Ӧ������
				String STid=rs.getString("STid");
				String Sname=rs.getString("Sname");
				String Susername=rs.getString("Susername");
				String Spassword=rs.getString("Spassword");
				String Ssex=rs.getString("Ssex");
				String Sphone=rs.getString("Sphone");
				String Sintime=rs.getString("Sintime");
				String Sposition=rs.getString("Sposition");
				
				//��ȡ�������ݷ�װΪStaffʵ�������
				Staff s = new Staff(STid, Sname, Susername, Spassword,
						Ssex, Sphone, Sintime, Sposition);
				//5-3����װ�õĶ������list����
				list.add(s);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("��ѯ�쳣");
			return null;
	}finally{
		//�ر���Դ
		dao.closeAll(conn, ps, rs);
	}
		}
		
	//����ס��������
	public int insert(Staff s){
		System.out.println("dao"+ s);
		//1��ע����������ȡ����
		conn=dao.getConn();
		//2-��дSQL���
		String sql="insert into Staff values(?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			//3-Ԥ����sql��䣬��ȡPreparedStatement����
			ps=conn.prepareStatement(sql);
			//4-����SQL�����ռλ�����������,���������Ĳ�������SQL�����
			ps.setString(1, s.getSTid());
			ps.setString(2, s.getSname());
			ps.setString(3, s.getSusername());
			ps.setString(4, s.getSpassword());
			ps.setString(5, s.getSsex());
			ps.setString(6, s.getSphone());
			ps.setString(7, s.getSintime());
			ps.setString(8, s.getSposition());
			//5-��ȡִ�н��(�ɹ������������)
			int code =ps.executeUpdate();
			//6-����ӳɹ�������������
			return code;
		} catch (SQLException e) {
			//���ʧ�ܣ��򷵻�-1
			System.out.println("���ʧ��");
			return -1;
		
		}
		//�ر���Դ
		finally{
			dao.closeAll(conn, ps, rs);
		}
		
	}
	
	//�޸�Ա��������
	public int update(Staff s){
		System.out.println("staffdao"+ s);
		//1��ע����������ȡ����
		conn=dao.getConn();
		//2-��дSQL���
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
			System.out.println("����ʧ��");
			return -1;
		}finally {
			dao.closeAll(conn, ps, rs);
		}
	}
	
	//ɾ��Ա��������
	public int delete(String STid){
		System.out.println(STid);
		//1��ע����������ȡ����
		conn=dao.getConn();
		//2-��дSQL���
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
				System.out.println("�����ѯstaff");
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
