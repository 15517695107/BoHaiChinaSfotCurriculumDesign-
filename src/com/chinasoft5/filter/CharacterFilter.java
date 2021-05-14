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
 * ����ʵ���� class CharacterFilter ʵ��Filter�ӿڣ���ɹ���������
 * Servlet Filter implementation class CharacterFilter
 */
public class CharacterFilter implements Filter {
	//����˽������character��ų�ʼ������
	private String character;
    /**
     * Ĭ�Ϲ�����
     * Default constructor
     */
    public CharacterFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * ʵ��Filter�ӿڵ�destroy()����
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * ʵ��doFilter(ServletRequest, ServletResponse, FilterChain)������ʵ�ֹ��˹���
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here�ڴ˴���д���룡����
		System.out.println("ִ�б���淶������");
		//ת������request����������
		HttpServletRequest req=(HttpServletRequest) request;
		//��������ı����ʽ
		//req.setCharacterEncoding("utf-8");
		req.setCharacterEncoding(character);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * ʵ�ֳ�ʼ������init(FilterConfig)
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		//�������ļ��У���ȡ��ʼ������
		character =fConfig.getInitParameter("character");
	}

}
