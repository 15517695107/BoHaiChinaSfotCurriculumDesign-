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
	//��װ�õ���˽������
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private BaseDao dao=new BaseDao();
	//------���濪ʼ�༭��������
	
	//��ѯ���ݱ�����
	public List<Home> selectAll(){
		//1��ע����������ȡ����
		conn=dao.getConn();
		//2-��дSQL���
		String sql="select * from home";
		try {
			//3-Ԥ����sql���
			ps=conn.prepareStatement(sql);
			//4-��ȡ��ѯ�����
			rs=ps.executeQuery();
			//5-ѭ������������������ݽ��з�װ���մ�ŵ�List�����з���
			List list=new ArrayList();
			while(rs.next()){
				//5-1ͨ���ֶ���ȡ����Ӧ������
				String Hid=rs.getString("Hid");
				double Harea=rs.getDouble("Harea");
				String Hsite=rs.getString("Hsite");
				
				//��ȡ�������ݷ�װΪDepartmentʵ�������
				Home h=new Home(Hid, Harea, Hsite);
				//5-3����װ�õĶ������list����
				list.add(h);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
	}finally{
		//�ر���Դ
		dao.closeAll(conn, ps, rs);
	}
		}
		
	//���ӷ��ݱ�����
	public int insert(Home h){
		//1��ע����������ȡ����
		conn=dao.getConn();
		//2-��дSQL���
		String sql="insert into home values(?, ?, ?)";
		try {
			//3-Ԥ����sql��䣬��ȡPreparedStatement����
			ps=conn.prepareStatement(sql);
			//4-����SQL�����ռλ�����������,���������Ĳ�������SQL�����
			ps.setString(1, h.getHid());
			ps.setDouble(2, h.getHarea());
			ps.setString(3, h.getHsite());
			//5-��ȡִ�н��(�ɹ������������)
			int code =ps.executeUpdate();
			//6-����ӳɹ�������������
			return code;
		} catch (SQLException e) {
			//���ʧ�ܣ��򷵻�-1
			return -1;
		
		}
		//�ر���Դ
		finally{
			dao.closeAll(conn, ps, rs);
		}
		
	}
	//�޸ķ��ݱ�����
	public int update(Home h){
		//1��ע����������ȡ����
		conn=dao.getConn();
		//2-��дSQL���
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
	//ɾ�����ݱ�����
	public int delete(String Hid){
		//1��ע����������ȡ����
		conn=dao.getConn();
		//2-��дSQL���
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
