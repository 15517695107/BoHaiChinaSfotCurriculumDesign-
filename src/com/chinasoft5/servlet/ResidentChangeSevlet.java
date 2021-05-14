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
 * Servlet implementation class ResidentChangeSevlet
 */
@WebServlet("/Resident/Change.do")
public class ResidentChangeSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResidentChangeSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//----此处编写代码-------
				//		1.获取请求数据
				String Rid=request.getParameter("rid");
				String Rname=request.getParameter("rname");
				String Hid=request.getParameter("hid");
				String Rusername=request.getParameter("rusername");
				String Rpassword=request.getParameter("rpassword");
				String Rsex=request.getParameter("rsex");
				String Rphone=request.getParameter("rphone");
				
				String Rintime=request.getParameter("rintime");
				String Rowner=request.getParameter("rowner");
				//2.访问数据库
				ResidentDao dao=new ResidentDao();
				//2.1封装处理需要传递的数据
				Resident r = new Resident(Rid, Rname, Hid, Rusername,
						Rpassword, Rsex, Rphone, Rintime, Rowner);
				//将封装好的数据修改到数据库中
				int upCode=dao.update(r);
				//判断是否修改成功
				if(upCode>0){
					//修改成功，响应重定向到ResidentInfoServlet
					response.sendRedirect("/ChinaSoft/ResidentInfoServlet");
				}else{
					//修改失败，请求转发回ResidentInfo.jsp
					request.setAttribute("uptip","修改失败，请重新操作");
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
