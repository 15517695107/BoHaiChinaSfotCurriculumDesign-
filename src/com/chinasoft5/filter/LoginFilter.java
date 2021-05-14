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
 * 创建实现类class LoginFilter 实现Filter接口，控制页面的访问权限
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
		//转换请求类型
		HttpServletRequest req=(HttpServletRequest)request;
		//转换响应类型
		HttpServletResponse res=(HttpServletResponse)response;
		//获取Session对象
		HttpSession session=req.getSession();
		//取出属性值，判断是否已经登录，若没有登录信息，则进行权限设置
		String username=(String)session.getAttribute("username");
		if(username==null){
			//若未登录，则跳转到登录页面
			req.setAttribute("tip","请先登录！！");
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
