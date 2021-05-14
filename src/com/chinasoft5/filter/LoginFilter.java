package com.chinasoft5.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ����ʵ����class LoginFilter ʵ��Filter�ӿڣ�����ҳ��ķ���Ȩ��
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		//ת����������
		HttpServletRequest req=(HttpServletRequest)request;
		//ת����Ӧ����
		HttpServletResponse res=(HttpServletResponse)response;
		//��ȡSession����
		HttpSession session=req.getSession();
		//ȡ������ֵ���ж��Ƿ��Ѿ���¼����û�е�¼��Ϣ�������Ȩ������
		String username=(String)session.getAttribute("username");
		if(username==null){
			//��δ��¼������ת����¼ҳ��
			req.setAttribute("tip","���ȵ�¼����");
			req.getRequestDispatcher("/LoginFile.jsp").forward(req, response);
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
