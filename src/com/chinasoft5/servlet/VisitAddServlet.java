package com.chinasoft5.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft5.dao.VisitDao;
import com.chinasoft5.entity.Visit;

/**
 * Servlet implementation class VisitAddServlet
 */
@WebServlet("/VisitAddServlet")
public class VisitAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//----此处编写代码-------
				//		1.获取请求数据
				String Vid=request.getParameter("vid");
				String Vname=request.getParameter("vname");
				String STid=request.getParameter("sTid");
				String Vphone=request.getParameter("vphone");
				String Vintime=request.getParameter("vintime");
				String Vouttime=request.getParameter("vouttime");
				//2.访问数据库
				VisitDao dao=new VisitDao();
				//2.1封装处理需要传递的数据
				Visit v = new Visit(Vid, Vname, STid, Vphone,Vintime, Vouttime);				//将封装好的数据添加到数据库中
					int addCode=dao.insert(v);
				//通过判断返回的addCode值来确定是否添加成功
					if(addCode>0){
				//添加成功，响应重定向到VisitInfoServlet中
						response.sendRedirect("/ChinaSoft/VisitInfoServlet");
						
					}else{
				//添加失败，请求转发，返回VisitAdd.jsp页面
						request.setAttribute("addtip","添加信息失败");
						request.getRequestDispatcher("/Visit/visitAdd.jsp").forward(request, response);;
						
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
