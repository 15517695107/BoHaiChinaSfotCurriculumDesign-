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
		//----�˴���д����-------
				//		1.��ȡ��������
				String Rid=request.getParameter("rid");
				String Rname=request.getParameter("rname");
				String Hid=request.getParameter("hid");
				String Rusername=request.getParameter("rusername");
				String Rpassword=request.getParameter("rpassword");
				String Rsex=request.getParameter("rsex");
				String Rphone=request.getParameter("rphone");
				
				String Rintime=request.getParameter("rintime");
				String Rowner=request.getParameter("rowner");
				//2.�������ݿ�
				ResidentDao dao=new ResidentDao();
				//2.1��װ������Ҫ���ݵ�����
				Resident r = new Resident(Rid, Rname, Hid, Rusername,
						Rpassword, Rsex, Rphone, Rintime, Rowner);
				//����װ�õ������޸ĵ����ݿ���
				int upCode=dao.update(r);
				//�ж��Ƿ��޸ĳɹ�
				if(upCode>0){
					//�޸ĳɹ�����Ӧ�ض���ResidentInfoServlet
					response.sendRedirect("/ChinaSoft/ResidentInfoServlet");
				}else{
					//�޸�ʧ�ܣ�����ת����ResidentInfo.jsp
					request.setAttribute("uptip","�޸�ʧ�ܣ������²���");
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