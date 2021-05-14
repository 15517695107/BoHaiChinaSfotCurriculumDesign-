package com.chinasoft5.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft5.dao.PropertyDao;
import com.chinasoft5.entity.Property;

/**
 * Servlet implementation class PropertyInfoServlet
 */
@WebServlet("/PropertyInfoServlet")
public class PropertyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropertyInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//--------�˴��༭servlet����-------
		//1-��ȡ��������
		//2-��ȡ���ݿ�����
		PropertyDao dao=new PropertyDao();
		List<Property> list=dao.selectAll();
		//3-�����߼��ṹ������ϣ��������������ݿ�����
		if(list!=null){
			//����ѯ�ɹ�����ת��
			request.setAttribute("propertylist", list);
			request.getRequestDispatcher("/Property/propertyInfo.jsp").forward(request, response);
		}
		else{
			//����ѯʧ�ܣ���ת��
			request.setAttribute("tip","��Ϣ��ҳ����ˣ�");
			request.getRequestDispatcher("/Property/propertyInfo.jsp").forward(request, response);
			//4-ҳ����ת������ת��/��Ӧ�ض��򡪡���
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
