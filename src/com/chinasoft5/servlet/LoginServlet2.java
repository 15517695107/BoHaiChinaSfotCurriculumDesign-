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
 * ס����¼
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Rlogin.do")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-��ȡ�������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//2-�������ݿ�
		ResidentDao dao = new ResidentDao();
		Resident s = dao.selectByUserName(username);
		//2-1��������
		if(s == null){
			//���˺Ų�����
			request.setAttribute("usernametip", "���˺Ų�����");
			request.getRequestDispatcher("Rlogin.jsp").forward(request, response);
		}else if(!s.getRpassword().equals(password)){
			//�������
			request.setAttribute("pwdtip", "�������");
			request.getRequestDispatcher("Rlogin.jsp").forward(request, response);
		}else{
			//��¼�ɹ�
			response.sendRedirect("/ChinaSoft/main.jsp");
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
