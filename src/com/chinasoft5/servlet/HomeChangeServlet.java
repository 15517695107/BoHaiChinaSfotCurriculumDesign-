package com.chinasoft5.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft5.dao.HomeDao;
import com.chinasoft5.entity.Home;

/**
 * Servlet implementation class HomeChangeServlet
 */
@WebServlet("/HomeChangeServlet")
public class HomeChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1.获取请求数据
		String Hid=request.getParameter("hid");
		String Harea=request.getParameter("harea");
		String Hsite=request.getParameter("hsite");
		//2.访问数据库
		//将字符串格式的编号转换成double类型的数据
		double newHarea=Double.parseDouble(Harea);		
		//2.1封装处理需要传递的数据
		Home h=new Home(Hid,newHarea,Hsite);
		//3.连接数据库
		HomeDao dao=new HomeDao();
		//4.调用dao层方法，实现修改功能【注意数据封装】
		int upCode=dao.update(h);
		System.out.println("dd");
		System.out.println(upCode);
		//判断是否修改成功
				if(upCode>0){
					//修改成功，响应重定向到HomeInfoServlet
					response.sendRedirect("/ChinaSoft/HomeInfoServlet");
				}else{
					//修改失败，请求转发回HomeInfo.jsp
					request.setAttribute("uptip","修改失败，请重新操作");
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
