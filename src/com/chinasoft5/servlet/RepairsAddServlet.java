package com.chinasoft5.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft5.dao.RepairsDao;
import com.chinasoft5.entity.Repairs;

/**
 * Servlet implementation class RepairsAddServlet
 */
@WebServlet("/RepairsAddServlet")
public class RepairsAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RepairsAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//----此处编写代码-------
		//		1.获取请求数据
		String REid=request.getParameter("reid");
		String Hid=request.getParameter("hid");
		String STid=request.getParameter("sTid");
		String POSdate=request.getParameter("posdate");
		String REdate=request.getParameter("redate");
		String REboolen=request.getParameter("reboolen");
		//2.访问数据库
		RepairsDao dao=new RepairsDao();
		//2.1封装处理需要传递的数据
				Repairs r=new Repairs(REid,Hid,STid,REdate,POSdate, REboolen);
			//将封装好的数据添加到数据库中
				int addCode=dao.insert(r);
				//通过判断返回的addCode值来确定是否添加成功
				if(addCode>0){
			//添加成功，响应重定向到RepairsInfoServlet中
					response.sendRedirect("/ChinaSoft/RepairsInfoServlet");
					
				}else{
			//添加失败，请求转发，返回RepairsAdd.jsp页面
					request.setAttribute("addtip","添加信息失败");
					request.getRequestDispatcher("/Repairs/repairsAdd.jsp").forward(request, response);;
					
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
