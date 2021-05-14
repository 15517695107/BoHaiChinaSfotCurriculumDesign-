package com.chinasoft5.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft5.dao.RepairsDao;
import com.chinasoft5.entity.Repairs;

/**
 * Servlet implementation class RepairsAddServlet
 */
@WebServlet("/RepairsAddServlet")
public class RepairsAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RepairsAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//----�˴���д����-------
		//		1.��ȡ��������
		String REid=request.getParameter("reid");
		String Hid=request.getParameter("hid");
		String STid=request.getParameter("sTid");
		String POSdate=request.getParameter("posdate");
		String REdate=request.getParameter("redate");
		String REboolen=request.getParameter("reboolen");
		//2.�������ݿ�
		RepairsDao dao=new RepairsDao();
		//2.1��װ������Ҫ���ݵ�����
				Repairs r=new Repairs(REid,Hid,STid,REdate,POSdate, REboolen);
			//����װ�õ�������ӵ����ݿ���
				int addCode=dao.insert(r);
				//ͨ���жϷ��ص�addCodeֵ��ȷ���Ƿ���ӳɹ�
				if(addCode>0){
			//��ӳɹ�����Ӧ�ض���RepairsInfoServlet��
					response.sendRedirect("/ChinaSoft/RepairsInfoServlet");
					
				}else{
			//���ʧ�ܣ�����ת��������RepairsAdd.jspҳ��
					request.setAttribute("addtip","�����Ϣʧ��");
					request.getRequestDispatcher("/Repairs/repairsAdd.jsp").forward(request, response);;
					
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
