package ym.zheng.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ym.zheng.service.QueryService;
import ym.zheng.service.MaintainService;

/**
 * 单条删除控制层
 * @author zym
 *
 */
public class DeleteOneServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		//设置编码
		req.setCharacterEncoding("UTF-8");
		//1.接收页面的值
		String id = req.getParameter("id");
		//2.调用service类中方法，注意传入值得类型
		//但是传入值得类型一般放在service中判断
		MaintainService maintainService = new MaintainService();
		
		maintainService.deleteOne(id);
		
		//4.向页面跳转
		req.getRequestDispatcher("/List.action").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		this.doGet(req, resp);
	}


}
