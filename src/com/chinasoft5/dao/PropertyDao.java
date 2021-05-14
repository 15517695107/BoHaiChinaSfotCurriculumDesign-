package com.chinasoft5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft5.entity.Property;

public class PropertyDao {
	//��װ�õ���˽������
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private BaseDao dao=new BaseDao();
	//------���濪ʼ�༭��������
	
	//��ѯ�ݷü�¼������
	public List<Property> selectAll(){
		//1��ע����������ȡ����
		conn=dao.getConn();
		//2-��дSQL���
		String sql="select * from Property";
		try {
			//3-Ԥ����sql���
			ps=conn.prepareStatement(sql);
			//4-��ȡ��ѯ�����
			rs = ps.executeQuery();
			System.out.println(rs.next());
			//5-ѭ������������������ݽ��з�װ���մ�ŵ�List�����з���
			List list=new ArrayList();
			while(rs.next()){
				//5-1ͨ���ֶ���ȡ����Ӧ������
				String Pid=rs.getString("Pid");
				String Hid=rs.getString("Hid");
				String STid=rs.getString("STid");
				String Pdate=rs.getString("Pdate");
				String PEdate=rs.getString("PEdate");
				String Pboolen=rs.getString("Pboolen");
				
				//��ȡ�������ݷ�װΪPropertyʵ�������
				Property p = new Property(Pid, Hid, STid, Pdate,
						PEdate, Pboolen);
				//5-3����װ�õĶ������list����
				list.add(p);
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
		
	//���Ӱݷü�¼������
	public int insert(Property p){
		//1��ע����������ȡ����
		conn=dao.getConn();
		//2-��дSQL���
		String sql="insert into Property values(?,?,?,?,?,?)";
		try {
			//3-Ԥ����sql��䣬��ȡPreparedStatement����
			ps=conn.prepareStatement(sql);
			//4-����SQL�����ռλ�����������,���������Ĳ�������SQL�����
			ps.setString(1, p.getPid());
			ps.setString(2, p.getHid());
			ps.setString(3, p.getSTid());
			ps.setString(4, p.getPdate());
			ps.setString(5, p.getPEdate());
			ps.setString(6, p.getPboolen());
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

	//�޸�ס��������(��Ҫ��ѡ�е�ס����ţ�
	public int update(Property p){
		//1��ע����������ȡ����
		conn=dao.getConn();
		//2-��дSQL���
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
			System.out.println("����ʧ��");
			return -1;
		}finally {
			dao.closeAll(conn, ps, rs);
		}
	}

}
