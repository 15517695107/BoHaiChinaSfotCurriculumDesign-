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
			//1.获取请求参数
				String Rid=request.getParameter("rid");
				//2.连接数据库
				ResidentDao dao=new ResidentDao();
				//3.进行删除操作
				int delCode=dao.delete(Rid);
				//4.进行页面跳转
				if(delCode>0){
					//删除成功，响应重定向到ResidentInfoServlet
					response.sendRedirect("/ChinaSoft/ResidentInfoServlet");
					
		}else{
					//删除失败,请求转发回ResidentInfo查询页面
					request.setAttribute("deltip", "删除失败，请重新操作！");
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
