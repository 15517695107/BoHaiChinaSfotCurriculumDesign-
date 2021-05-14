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
		//1.获取请求参数
		String Hid=request.getParameter("hid");
		//2.连接数据库
		HomeDao dao=new HomeDao();
		//3.进行删除操作
		int delCode=dao.delete(Hid);
		//4.进行页面跳转
	if(delCode>0){
					//删除成功，响应重定向到HomeInfoServlet
					response.sendRedirect("/ChinaSoft/HomeInfoServlet");
					
		}else{
					//删除失败,请求转发回HomeInfo查询页面
					request.setAttribute("deltip", "删除失败，请重新操作！");
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
