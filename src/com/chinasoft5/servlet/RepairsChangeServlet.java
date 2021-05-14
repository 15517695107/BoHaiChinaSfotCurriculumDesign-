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
 * Servlet implementation class RepairsChangeServlet
 */
@WebServlet("/RepairsChangeServlet")
public class RepairsChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RepairsChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String REid=request.getParameter("reid");
		String Hid=request.getParameter("hid");
		String STid=request.getParameter("sTid");
		String Pdate=request.getParameter("redate");
		String PEdate=request.getParameter("posdate");
		String Pboolen=request.getParameter("reboolen");
		
		
		RepairsDao dao = new RepairsDao();
		Repairs r =new Repairs(REid, Hid, STid, Pdate, PEdate, Pboolen);
		int upCode = dao.update(r);
		if(upCode>=0){
			response.sendRedirect("/ChinaSoft/RepairsInfoServlet");
		}else{
			request.setAttribute("uptip","修改失败，请重新操作");
			request.getRequestDispatcher("/RepairsInfoServlet").forward(request, response);
			
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
