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
		
		//���ñ���
		req.setCharacterEncoding("UTF-8");
		//1.����ҳ���ֵ
		String[] ids = req.getParameterValues("id");
		//2.����service���з�����ע�⴫��ֵ������
		//���Ǵ���ֵ������һ�����service���ж�
		
		MaintainService maintainService = new MaintainService();
		
		maintainService.deleteBatch(ids);
		
		//4.��ҳ����ת
		req.getRequestDispatcher("/List.action").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		this.doGet(req, resp);
	}


}

