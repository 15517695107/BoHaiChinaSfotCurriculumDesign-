package com.chinasoft5.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft5.dao.ResidentDao;
import com.chinasoft5.entity.Resident;

/**
 * Servlet implementation class ResidentAddServlet
 */
@WebServlet("/ResidentAddServlet")
public class ResidentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResidentAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//----�˴���д����-------
		//		1.��ȡ��������
		String Rid=request.getParameter("rid");
		String Rname=request.getParameter("rname");
		String Hid=request.getParameter("hid");
		String Rusername=request.getParameter("rusername");
		String Rpassword=request.getParameter("rpassword");
		String Rsex=request.getParameter("rsex");
		String Rphone=request.getParameter("rphone");
		String Rintime=request.getParameter("rintime");
		String Rowner=request.getParameter("rowner");
	

		//2.�������ݿ�
		ResidentDao dao=new ResidentDao();
		//2.1��װ������Ҫ���ݵ�����
		Resident r = new Resident(Rid, Rname, Hid, Rusername,Rpassword, Rsex, Rphone, Rintime, Rowner);
		//����װ�õ�������ӵ����ݿ���
		System.out.println("ss");
			int addCode=dao.insert(r);
			System.out.println(addCode);
		//ͨ���жϷ��ص�addCodeֵ��ȷ���Ƿ���ӳɹ�
			if(addCode>0){
		//��ӳɹ�����Ӧ�ض���ResidentInfoServlet��
				System.out.println("��ӳɹ�");
				response.sendRedirect("/ChinaSoft/ResidentInfoServlet");
				
			}else{
		//���ʧ�ܣ�����ת��������ResidentAdd.jspҳ��
				request.setAttribute("addtip","�����Ϣʧ��");
				request.getRequestDispatcher("/Resident/residentAdd.jsp").forward(request, response);;
				
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
