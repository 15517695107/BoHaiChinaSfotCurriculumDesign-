package com.chinasoft5.dao;

import com.chinasoft5.entity.Resident;

public class DaoTest {
	public static void main(String[]args){
//		测试获取连接方法	
//		BaseDao dao=new BaseDao();
//		Connection conn=dao.getConn();
//		System.out.println("获取到的连接对象："+conn);
		//部门模块测试
		ResidentDao Rdao=new ResidentDao();
//		//测试插入
		int insernum = Rdao.insert(new Resident("006", "赵五2", "490310", "006", "666", "女", "15539765637", "2000-6-9", "是"));
		System.out.println(insernum);
//		//测试修改
//		int updatenum = Rdao.update(new Resident("003", "赵五2", "450210", "006", "666", "女", "15539765637", "2000-6-9", "否"));
//		System.out.println(updatenum);
////		//测试删除
////		int deletenum = Rdao.delete("006");
////		System.out.println(deletenum);
//		//测试查询
//		List<Resident> l = Rdao.selectAll();
//		System.out.println(l.size());
//		for(Resident r: l){
//			System.out.println(r);
//		}
		
//		HomeDao Hdao = new HomeDao();
//		//测试查询
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
