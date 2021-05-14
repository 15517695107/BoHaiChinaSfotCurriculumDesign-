package com.chinasoft5.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft5.dao.VisitDao;
import com.chinasoft5.entity.Visit;

/**
 * Servlet implementation class VisitAddServlet
 */
@WebServlet("/VisitAddServlet")
public class VisitAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//----�˴���д����-------
				//		1.��ȡ��������
				String Vid=request.getParameter("vid");
				String Vname=request.getParameter("vname");
				String STid=request.getParameter("sTid");
				String Vphone=request.getParameter("vphone");
				String Vintime=request.getParameter("vintime");
				String Vouttime=request.getParameter("vouttime");
				//2.�������ݿ�
				VisitDao dao=new VisitDao();
				//2.1��װ������Ҫ���ݵ�����
				Visit v = new Visit(Vid, Vname, STid, Vphone,Vintime, Vouttime);				//����װ�õ�������ӵ����ݿ���
					int addCode=dao.insert(v);
				//ͨ���жϷ��ص�addCodeֵ��ȷ���Ƿ���ӳɹ�
					if(addCode>0){
				//��ӳɹ�����Ӧ�ض���VisitInfoServlet��
						response.sendRedirect("/ChinaSoft/VisitInfoServlet");
						
					}else{
				//���ʧ�ܣ�����ת��������VisitAdd.jspҳ��
						request.setAttribute("addtip","�����Ϣʧ��");
						request.getRequestDispatcher("/Visit/visitAdd.jsp").forward(request, response);;
						
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
