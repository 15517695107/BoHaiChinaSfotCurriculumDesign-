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
 * Servlet implementation class HomeChangeServlet
 */
@WebServlet("/HomeChangeServlet")
public class HomeChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1.��ȡ��������
		String Hid=request.getParameter("hid");
		String Harea=request.getParameter("harea");
		String Hsite=request.getParameter("hsite");
		//2.�������ݿ�
		//���ַ�����ʽ�ı��ת����double���͵�����
		double newHarea=Double.parseDouble(Harea);		
		//2.1��װ������Ҫ���ݵ�����
		Home h=new Home(Hid,newHarea,Hsite);
		//3.�������ݿ�
		HomeDao dao=new HomeDao();
		//4.����dao�㷽����ʵ���޸Ĺ��ܡ�ע�����ݷ�װ��
		int upCode=dao.update(h);
		System.out.println("dd");
		System.out.println(upCode);
		//�ж��Ƿ��޸ĳɹ�
				if(upCode>0){
					//�޸ĳɹ�����Ӧ�ض���HomeInfoServlet
					response.sendRedirect("/ChinaSoft/HomeInfoServlet");
				}else{
					//�޸�ʧ�ܣ�����ת����HomeInfo.jsp
					request.setAttribute("uptip","�޸�ʧ�ܣ������²���");
					request.getRequestDispatcher("/HomeInfoServlet").forward(request, response);
					
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
