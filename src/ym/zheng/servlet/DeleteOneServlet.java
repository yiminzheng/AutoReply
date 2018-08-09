package ym.zheng.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ym.zheng.service.QueryService;
import ym.zheng.service.MaintainService;

/**
 * ����ɾ�����Ʋ�
 * @author zym
 *
 */
public class DeleteOneServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		//���ñ���
		req.setCharacterEncoding("UTF-8");
		//1.����ҳ���ֵ
		String id = req.getParameter("id");
		//2.����service���з�����ע�⴫��ֵ������
		//���Ǵ���ֵ������һ�����service���ж�
		MaintainService maintainService = new MaintainService();
		
		maintainService.deleteOne(id);
		
		//4.��ҳ����ת
		req.getRequestDispatcher("/List.action").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		this.doGet(req, resp);
	}


}
