package com.chinasoft5.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft5.dao.HomeDao;

/**
 * Servlet implementation class HomeDeleteServlet
 */
@WebServlet("/HomeDeleteServlet")
public class HomeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡ�������
		String Hid=request.getParameter("hid");
		//2.�������ݿ�
		HomeDao dao=new HomeDao();
		//3.����ɾ������
		int delCode=dao.delete(Hid);
		//4.����ҳ����ת
	if(delCode>0){
					//ɾ���ɹ�����Ӧ�ض���HomeInfoServlet
					response.sendRedirect("/ChinaSoft/HomeInfoServlet");
					
		}else{
					//ɾ��ʧ��,����ת����HomeInfo��ѯҳ��
					request.setAttribute("deltip", "ɾ��ʧ�ܣ������²�����");
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
