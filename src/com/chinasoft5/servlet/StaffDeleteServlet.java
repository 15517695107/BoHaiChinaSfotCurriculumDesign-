package com.chinasoft5.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft5.dao.StaffDao;

/**
 * Servlet implementation class StaffDeleteServlet
 */
@WebServlet("/StaffDeleteServlet")
public class StaffDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡ�������
		String STid=request.getParameter("sTid");
		System.out.println("servlet��" + STid);
		//2.�������ݿ�
		StaffDao dao=new StaffDao();
		//3.����ɾ������
		System.out.println("����delete");
		int delCode=dao.delete(STid);
		//4.����ҳ����ת
		if(delCode>0){
			//ɾ���ɹ�����Ӧ�ض���StaffInfoServlet
			response.sendRedirect("/ChinaSoft/StaffInfoServlet");
			
}else{
			//ɾ��ʧ��,����ת����StaffInfo��ѯҳ��
			request.setAttribute("deltip", "ɾ��ʧ�ܣ������²�����");
			request.getRequestDispatcher("/StaffInfoServlet").forward(request, response);
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
