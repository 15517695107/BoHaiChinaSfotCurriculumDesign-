package com.chinasoft5.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * ��װjdbc����
 * @author HanY
 * 2021-05-04 10:59:54
 */
import java.sql.SQLException;
public class BaseDao {
	//��װjdbcʹ�õĽӿ���Ϊ���ԣ�����ʹ��
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	//��װ��ȡ���ӷ���
	public Connection getConn(){
		//1-ע������
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("ע��ɹ�������");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("ע��ʧ�ܣ�����");
			return null;
			
		}
		//��������
		try {
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","orcl");
//			System.out.println("���ӳɹ�������");
			//�ɹ����ػ�ȡ�������Ӷ���conn
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("����ʧ�ܣ�����");
			
			return null;
			
		}
		
		
	}
	//����ر���Դ����
	public void closeAll(Connection conn,PreparedStatement ps,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}		
}

