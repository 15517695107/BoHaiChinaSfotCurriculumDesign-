package com.chinasoft5.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 定义实现类 class CharacterFilter 实现Filter接口，完成过滤器功能
 * Servlet Filter implementation class CharacterFilter
 */
public class CharacterFilter implements Filter {
	//定义私有属性character存放初始化参数
	private String character;
    /**
     * 默认构造器
     * Default constructor
     */
    public CharacterFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * 实现Filter接口的destroy()方法
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * 实现doFilter(ServletRequest, ServletResponse, FilterChain)方法，实现过滤功能
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here在此处编写代码！！！
		System.out.println("执行编码规范过滤器");
		//转换请求request的数据类型
		HttpServletRequest req=(HttpServletRequest) request;
		//设置请求的编码格式
		//req.setCharacterEncoding("utf-8");
		req.setCharacterEncoding(character);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * 实现初始化方法init(FilterConfig)
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		//从配置文件中，获取初始化参数
		character =fConfig.getInitParameter("character");
	}

}
