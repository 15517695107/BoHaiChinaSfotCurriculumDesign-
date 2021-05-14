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
 * 管理员登录
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Slogin.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//2-访问数据库
		StaffDao dao = new StaffDao();
		Staff s = dao.selectByUserName(username);
		//2-1处理数据
		if(s == null){
			//该账号不存在
			request.setAttribute("usernametip", "该账号不存在");
			request.getRequestDispatcher("Slogin.jsp").forward(request, response);
		}else if(!s.getSpassword().equals(password)){
			//密码错误
			request.setAttribute("pwdtip", "密码错误");
			request.getRequestDispatcher("Slogin.jsp").forward(request, response);
		}else{
			//登录成功
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
