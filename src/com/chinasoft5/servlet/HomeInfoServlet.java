package com.chinasoft5.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft5.dao.HomeDao;
import com.chinasoft5.entity.Home;

/**
 * Servlet implementation class HomeInfoServlet
 */
@WebServlet("/HomeInfoServlet")
public class HomeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//--------此处编辑servlet代码-------
				//1-获取请求数据
				//2-获取数据库数据
		HomeDao dao=new HomeDao();
		List<Home> list=dao.selectAll();
		//3-利用逻辑结构语句整合，请求数据与数据库数据
		if(list!=null){
			//若查询成功，则转发
			request.setAttribute("homelist", list);
			request.getRequestDispatcher("/Home/homeInfo.jsp").forward(request, response);
		}
		else{
			//若查询失败，则转发
			request.setAttribute("tip","信息离家出走了！");
			request.getRequestDispatcher("/Home/homeInfo.jsp").forward(request, response);
			//4-页面跳转（请求转发/响应重定向——）
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
