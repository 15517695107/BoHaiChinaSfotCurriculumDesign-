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
	//��װ�õ���˽������
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private BaseDao dao=new BaseDao();
	//------���濪ʼ�༭��������
	
	//��ѯס��������
	public List<Resident> selectAll(){
		System.out.println("��ѯ��");
		//1��ע����������ȡ����
		conn=dao.getConn();
		//2-��дSQL���
		String sql="select * from resident";
		try {
			//3-Ԥ����sql���
			ps=conn.prepareStatement(sql);
			System.out.println("����sql�ɹ�");
			//4-��ȡ��ѯ�����
			rs = ps.executeQuery();
			System.out.println(rs.next());
			//5-ѭ������������������ݽ��з�װ���մ�ŵ�List�����з���
			List list=new ArrayList();

			while(rs.next()){
				//5-1ͨ���ֶ���ȡ����Ӧ������
				String Rid=rs.getString("Rid");
				String Rname=rs.getString("Rname");
				String Hid=rs.getString("Hid");
				String Rusername=rs.getString("Rusername");
				String Rpassword=rs.getString("Rpassword");
				String Rsex=rs.getString("Rsex");
				String Rphone=rs.getString("Rphone");
				String Rintime=rs.getString("Rintime");
				String Rowner=rs.getString("Rowner");
				
				//��ȡ�������ݷ�װΪResidentʵ�������
				Resident r = new Resident(Rid, Rname, Hid, Rusername,
						Rpassword, Rsex, Rphone, Rintime, Rowner);
				//5-3����װ�õĶ������list����
				list.add(r);
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
	public int insert(Resident r){
		//1��ע����������ȡ����
		conn=dao.getConn();
		//2-��дSQL���
		String sql="insert into resident values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			//3-Ԥ����sql��䣬��ȡPreparedStatement����
			ps=conn.prepareStatement(sql);
			System.out.println("���1����");
			//4-����SQL�����ռλ�����������,���������Ĳ�������SQL�����
			ps.setString(1, r.getRid());
			ps.setString(2, r.getRname());
			ps.setString(3, r.getHid());
			ps.setString(4, r.getRusername());
			ps.setString(5, r.getRpassword());
			ps.setString(6, r.getRsex());
			ps.setString(7, r.getRphone());
			ps.setString(8, r.getRintime());
			ps.setString(9, r.getRowner());
		
			//5-��ȡִ�н��(�ɹ������������)
			int code =ps.executeUpdate();
			System.out.println(code);
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
	
	//�޸�ס��������(��Ҫ��ѡ�е�ס����ţ�
	public int update(Resident r){
		//1��ע����������ȡ����
		conn=dao.getConn();
		//2-��дSQL���
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
			System.out.println("����ʧ��");
			return -1;
		}finally {
			dao.closeAll(conn, ps, rs);
		}
	}
	
	//ɾ��ס��������
	public int delete(String Rid){
		//1��ע����������ȡ����
		conn=dao.getConn();
		//2-��дSQL���
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
