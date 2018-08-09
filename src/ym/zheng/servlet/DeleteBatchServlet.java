package ym.zheng.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ym.zheng.service.MaintainService;

public class DeleteBatchServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		//设置编码
		req.setCharacterEncoding("UTF-8");
		//1.接收页面的值
		String[] ids = req.getParameterValues("id");
		//2.调用service类中方法，注意传入值得类型
		//但是传入值得类型一般放在service中判断
		
		MaintainService maintainService = new MaintainService();
		
		maintainService.deleteBatch(ids);
		
		//4.向页面跳转
		req.getRequestDispatcher("/List.action").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		this.doGet(req, resp);
	}


}

