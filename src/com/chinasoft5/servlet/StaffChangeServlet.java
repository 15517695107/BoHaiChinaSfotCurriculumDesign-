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
 * Servlet implementation class StaffChangeServlet
 */
@WebServlet("/StaffChangeServlet")
public class StaffChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//----此处编写代码-------
		//		1.获取请求数据
		String STid=request.getParameter("sTid");
		String Sname=request.getParameter("sname");
		String Susername=request.getParameter("susername");
		String Spassword=request.getParameter("spassword");
		String Ssex=request.getParameter("ssex");
		String Sphone=request.getParameter("sphone");
		String Sintime=request.getParameter("sintime");
		String Sposition=request.getParameter("sposition");
		//2.访问数据库
		StaffDao dao=new StaffDao();
		//2.1封装处理需要传递的数据
		//将取出的数据封装为Staff实体类对象
		Staff s = new Staff(STid, Sname, Susername, Spassword,
				Ssex, Sphone, Sintime, Sposition);
			//将封装好的数据添加到数据库中
				int upCode=dao.update(s);
			//判断是否修改成功
				if(upCode>0){
					//修改成功，响应重定向到StaffInfoServlet
					response.sendRedirect("/ChinaSoft/StaffInfoServlet");
				}else{
					//修改失败，请求转发回StaffInfo.jsp
					request.setAttribute("uptip","修改失败，请重新操作");
					request.getRequestDispatcher("/StaffInfoServlet").forward(request, response);
					
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
