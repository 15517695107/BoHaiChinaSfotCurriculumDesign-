package com.chinasoft5.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft5.dao.HomeDao;
import com.chinasoft5.entity.Home;

/**
 * Servlet implementation class HomeAddServlet
 */
@WebServlet("/HomeAddServlet")
public class HomeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//----�˴���д����-------
		//		1.��ȡ��������
		String Hid=request.getParameter("hid");
		String Harea=request.getParameter("harea");
		String Hsite=request.getParameter("hsite");
		//2.�������ݿ�
		//���ַ�����ʽ�ı��ת����double���͵�����
	
		double newHarea=Double.parseDouble(Harea);
		HomeDao dao=new HomeDao();
		//2.1��װ������Ҫ���ݵ�����
		Home h=new Home(Hid,newHarea,Hsite);
		//����װ�õ�������ӵ����ݿ���
		System.out.println("ss");
			int addCode=dao.insert(h);
			System.out.println("ss");
			System.out.println(addCode);
		//ͨ���жϷ��ص�addCodeֵ��ȷ���Ƿ���ӳɹ�
			if(addCode>0){
		//��ӳɹ�����Ӧ�ض���HomeInfoServlet��
				System.out.println("��ӳɹ�");
				response.sendRedirect("/ChinaSoft/HomeInfoServlet");
				
			}else{
		//���ʧ�ܣ�����ת��������HomeAdd.jspҳ��
				request.setAttribute("addtip","�����Ϣʧ��");
				request.getRequestDispatcher("/Home/homeAdd.jsp").forward(request, response);
				
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
