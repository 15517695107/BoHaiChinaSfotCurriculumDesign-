package com.chinasoft5.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft5.dao.StaffDao;
import com.chinasoft5.entity.Staff;

/**
 * Servlet implementation class StaffChangeServlet
 */
@WebServlet("/StaffChangeServlet")
public class StaffChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//----�˴���д����-------
		//		1.��ȡ��������
		String STid=request.getParameter("sTid");
		String Sname=request.getParameter("sname");
		String Susername=request.getParameter("susername");
		String Spassword=request.getParameter("spassword");
		String Ssex=request.getParameter("ssex");
		String Sphone=request.getParameter("sphone");
		String Sintime=request.getParameter("sintime");
		String Sposition=request.getParameter("sposition");
		//2.�������ݿ�
		StaffDao dao=new StaffDao();
		//2.1��װ������Ҫ���ݵ�����
		//��ȡ�������ݷ�װΪStaffʵ�������
		Staff s = new Staff(STid, Sname, Susername, Spassword,
				Ssex, Sphone, Sintime, Sposition);
			//����װ�õ�������ӵ����ݿ���
				int upCode=dao.update(s);
			//�ж��Ƿ��޸ĳɹ�
				if(upCode>0){
					//�޸ĳɹ�����Ӧ�ض���StaffInfoServlet
					response.sendRedirect("/ChinaSoft/StaffInfoServlet");
				}else{
					//�޸�ʧ�ܣ�����ת����StaffInfo.jsp
					request.setAttribute("uptip","�޸�ʧ�ܣ������²���");
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
