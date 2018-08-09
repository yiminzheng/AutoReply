package ym.zheng.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ym.zheng.service.MaintainService;

/**
 * 对话页的初始化控制
 * @author zym
 *
 */
public class InitTalkServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		//设置编码
		req.setCharacterEncoding("UTF-8");
		
		//4.向页面跳转
		req.getRequestDispatcher("/WEB-INF/jsp/front/talk.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		this.doGet(req, resp);
	}


}