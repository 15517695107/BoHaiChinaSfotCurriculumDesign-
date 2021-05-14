package com.chinasoft5.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft5.dao.ResidentDao;

/**
 * Servlet implementation class ResidentDeleteServlet
 */
@WebServlet("/ResidentDeleteServlet")
public class ResidentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResidentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//1.��ȡ�������
				String Rid=request.getParameter("rid");
				//2.�������ݿ�
				ResidentDao dao=new ResidentDao();
				//3.����ɾ������
				int delCode=dao.delete(Rid);
				//4.����ҳ����ת
				if(delCode>0){
					//ɾ���ɹ�����Ӧ�ض���ResidentInfoServlet
					response.sendRedirect("/ChinaSoft/ResidentInfoServlet");
					
		}else{
					//ɾ��ʧ��,����ת����ResidentInfo��ѯҳ��
					request.setAttribute("deltip", "ɾ��ʧ�ܣ������²�����");
					request.getRequestDispatcher("/ResidentInfoServlet").forward(request, response);
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
