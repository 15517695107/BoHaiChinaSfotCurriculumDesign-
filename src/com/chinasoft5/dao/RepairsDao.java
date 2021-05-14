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
 * ע�����޼�¼������ɾ��
 */
public class RepairsDao {
	//��װ�õ���˽������
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private BaseDao dao=new BaseDao();
	//------���濪ʼ�༭��������
	
	//��ѯ�ݷü�¼������
	public List<Repairs> selectAll(){
		//1��ע����������ȡ����
		conn=dao.getConn();
		//2-��дSQL���
		String sql="select * from Repairs";
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
				String REid=rs.getString("REid");
				String Hid=rs.getString("Hid");
				String STid=rs.getString("STid");
				String REdate=rs.getString("REdate");
				String POSdate=rs.getString("POSdate");
				String REboolen=rs.getString("REboolen");
				
				//��ȡ�������ݷ�װΪRepairsʵ�������
				Repairs v = new Repairs(REid, Hid, STid, REdate,
						POSdate, REboolen);
				//5-3����װ�õĶ������list����
				list.add(v);
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
	public int insert(Repairs v){
		System.out.println(v);
		//1��ע����������ȡ����
		conn=dao.getConn();
		//2-��дSQL���
		String sql="insert into Repairs values(?, ?, ?, ?, ?, ?)";
		try {
			//3-Ԥ����sql��䣬��ȡPreparedStatement����
			ps=conn.prepareStatement(sql);
			//4-����SQL�����ռλ�����������,���������Ĳ�������SQL�����
			ps.setString(1, v.getREid());
			ps.setString(2, v.getHid());
			ps.setString(3, v.getSTid());
			ps.setString(4, v.getREdate());
			ps.setString(5, v.getPOSdate());
			ps.setString(6, v.getREboolen());
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
	public int update(Repairs r){
		System.out.println("Repairs" + r);
		//1��ע����������ȡ����
		conn=dao.getConn();
		//2-��дSQL���
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
			System.out.println("����ʧ��");
			return -1;
		}finally {
			dao.closeAll(conn, ps, rs);
		}
	}
		
}
