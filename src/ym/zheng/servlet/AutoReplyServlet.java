package ym.zheng.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ym.zheng.service.QueryService;

public class AutoReplyServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		//…Ë÷√±‡¬Î
		resp.setContentType("text/html;chrset=UTF-8");
		PrintWriter out = resp.getWriter();
		QueryService queryService = new QueryService();
		out.write(queryService.queryByCommand(req.getParameter("content")));
		out.flush();
		out.close();
		
	}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
				throws ServletException, IOException {
			this.doGet(req, resp);
		}


	}
