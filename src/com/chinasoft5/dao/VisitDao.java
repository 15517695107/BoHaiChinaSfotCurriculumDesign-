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
 * ע���ݷü�¼������ɾ�����޸�
 */
public class VisitDao {
	//��װ�õ���˽������
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private BaseDao dao=new BaseDao();
	//------���濪ʼ�༭��������
	
	//��ѯ�ݷü�¼������
	public List<Visit> selectAll(){
		//1��ע����������ȡ����
		conn=dao.getConn();
		//2-��дSQL���
		String sql="select * from visit";
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
				String Vid=rs.getString("Vid");
				String Vname=rs.getString("Vname");
				String STid=rs.getString("STid");
				String Vphone=rs.getString("Vphone");
				String Vintime=rs.getString("Vintime");
				String Vouttime=rs.getString("Vouttime");
				
				//��ȡ�������ݷ�װΪVisitʵ�������
				Visit v = new Visit(Vid, Vname, STid, Vphone,
						Vintime, Vouttime);
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
	public int insert(Visit v){
		//1��ע����������ȡ����
		System.out.println("visit"+v);
		conn=dao.getConn();
		//2-��дSQL���
		String sql="insert into Visit values(?, ?, ?, ?, ?, ?)";
		try {
			//3-Ԥ����sql��䣬��ȡPreparedStatement����
			ps=conn.prepareStatement(sql);
			//4-����SQL�����ռλ�����������,���������Ĳ�������SQL�����
			ps.setString(1, v.getVid());
			ps.setString(2, v.getVname());
			ps.setString(3, v.getSTid());
			ps.setString(4, v.getVphone());
			ps.setString(5, v.getVintime());
			ps.setString(6, v.getVouttime());
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
	
	

}
