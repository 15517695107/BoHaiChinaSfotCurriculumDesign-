package com.chinasoft5.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft5.dao.PropertyDao;
import com.chinasoft5.entity.Property;

/**
 * Servlet implementation class PropertyAddServlet
 */
@WebServlet("/PropertyAddServlet")
public class PropertyAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropertyAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//----�˴���д����-------
		//		1.��ȡ��������
		String Pid=request.getParameter("pid");
		String Hid=request.getParameter("hid");
		String STid=request.getParameter("sTid");
		String Pdate=request.getParameter("pdate");
		String PEdate=request.getParameter("pedate");
		String Pboolen=request.getParameter("pboolen");
		//2.�������ݿ�
		PropertyDao dao=new PropertyDao();
		//2.1��װ������Ҫ���ݵ�����
		Property p=new Property(Pid,Hid,STid,Pdate,PEdate,Pboolen);
		//����װ�õ��������ӵ����ݿ���
		int addCode=dao.insert(p);
		
		//ͨ���жϷ��ص�addCodeֵ��ȷ���Ƿ����ӳɹ�
		if(addCode>0){
	//���ӳɹ�����Ӧ�ض���PropertyInfoServlet��
			response.sendRedirect("/ChinaSoft/PropertyInfoServlet");
			
		}else{
	//����ʧ�ܣ�����ת��������PropertyAdd.jspҳ��
			request.setAttribute("addtip","������Ϣʧ��");
			request.getRequestDispatcher("/Property/propertyAdd.jsp").forward(request, response);;
			
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