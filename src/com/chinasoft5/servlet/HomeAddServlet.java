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
 * Servlet implementation class HomeAddServlet
 */
@WebServlet("/HomeAddServlet")
public class HomeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//----此处编写代码-------
		//		1.获取请求数据
		String Hid=request.getParameter("hid");
		String Harea=request.getParameter("harea");
		String Hsite=request.getParameter("hsite");
		//2.访问数据库
		//将字符串格式的编号转换成double类型的数据
	
		double newHarea=Double.parseDouble(Harea);
		HomeDao dao=new HomeDao();
		//2.1封装处理需要传递的数据
		Home h=new Home(Hid,newHarea,Hsite);
		//将封装好的数据添加到数据库中
		System.out.println("ss");
			int addCode=dao.insert(h);
			System.out.println("ss");
			System.out.println(addCode);
		//通过判断返回的addCode值来确定是否添加成功
			if(addCode>0){
		//添加成功，响应重定向到HomeInfoServlet中
				System.out.println("添加成功");
				response.sendRedirect("/ChinaSoft/HomeInfoServlet");
				
			}else{
		//添加失败，请求转发，返回HomeAdd.jsp页面
				request.setAttribute("addtip","添加信息失败");
				request.getRequestDispatcher("/Home/homeAdd.jsp").forward(request, response);
				
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
