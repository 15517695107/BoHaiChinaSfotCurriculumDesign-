package com.chinasoft5.dao;

import com.chinasoft5.entity.Resident;

public class DaoTest {
	public static void main(String[]args){
//		���Ի�ȡ���ӷ���	
//		BaseDao dao=new BaseDao();
//		Connection conn=dao.getConn();
//		System.out.println("��ȡ�������Ӷ���"+conn);
		//����ģ�����
		ResidentDao Rdao=new ResidentDao();
//		//���Բ���
		int insernum = Rdao.insert(new Resident("006", "����2", "490310", "006", "666", "Ů", "15539765637", "2000-6-9", "��"));
		System.out.println(insernum);
//		//�����޸�
//		int updatenum = Rdao.update(new Resident("003", "����2", "450210", "006", "666", "Ů", "15539765637", "2000-6-9", "��"));
//		System.out.println(updatenum);
////		//����ɾ��
////		int deletenum = Rdao.delete("006");
////		System.out.println(deletenum);
//		//���Բ�ѯ
//		List<Resident> l = Rdao.selectAll();
//		System.out.println(l.size());
//		for(Resident r: l){
//			System.out.println(r);
//		}
		
//		HomeDao Hdao = new HomeDao();
//		//���Բ�ѯ
//		List<Home> l = Hdao.selectAll();
//		for(Home r: l){
//			System.out.println(r);
//		}
//		StaffDao Sdao = new StaffDao();
		
//		Staff s = Sdao.selectByUserName("zhangsan");
//		System.out.println(s);
//		HomeDao dao = new HomeDao();
//		int i = dao.delete("450210");
//		System.out.println(i);
		
	}
}
