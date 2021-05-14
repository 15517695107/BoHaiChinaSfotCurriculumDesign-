package com.chinasoft5.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft5.dao.PropertyDao;
import com.chinasoft5.entity.Property;

/**
 * Servlet implementation class PropertyChangeServlet
 */
@WebServlet("/PropertyChangeServlet")
public class PropertyChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropertyChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取请求数据
		String Pid=request.getParameter("pid");
		String Hid=request.getParameter("hid");
		String STid=request.getParameter("sTid");
		String Pdate=request.getParameter("pdate");
		String PEdate=request.getParameter("pedate");
		String Pboolen=request.getParameter("pboolen");
		//2.访问数据库
		PropertyDao dao=new PropertyDao();
		//2.1封装处理需要传递的数据
		Property p=new Property(Pid,Hid,STid,Pdate,PEdate,Pboolen);
		//将封装好的数据添加到数据库中
		int upCode=dao.update(p);
		//判断是否修改成功
		if(upCode>0){
			//修改成功，响应重定向到PropertyInfoServlet
			response.sendRedirect("/ChinaSoft/PropertyInfoServlet");
		}else{
			//修改失败，请求转发回PropertyInfo.jsp
			request.setAttribute("uptip","修改失败，请重新操作");
			request.getRequestDispatcher("/PropertyInfoServlet").forward(request, response);
			
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
