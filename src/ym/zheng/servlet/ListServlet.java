package ym.zheng.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ym.zheng.bean.Message;
import ym.zheng.service.QueryService;

/**
 * 列表页面初始化控制
 * @author zym
 *
 */
@SuppressWarnings("serial")
//可序列化的原因，添加警告注解
public class ListServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		//1.接收页面的值
		String command = req.getParameter("command");
		String  description = req.getParameter("description");
		//2.向页面传值
		req.setAttribute("command", command);
		
		req.setAttribute("description",description);
		QueryService listService = new QueryService();
			
			
			/*
			 //连接数据库操作
			 
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/micro_message","root","root");
		   StringBuilder sql = new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from MESSAGE where 1=1");
			List<String> paramList = new ArrayList<String>();
		   if(command != null && !"".equals(command.trim())){
				
				sql.append("and COMMAND=?");
				paramList.add(command);
				
			}
		   if(description != null && !"".equals(description.trim())){
			   sql.append(" and DESCRIPTION like '%' ? '%'");
			   paramList.add(description);
		   }
		   
		   PreparedStatement statement = conn.prepareStatement(sql.toString());
			
		   for(int i = 0;i< paramList.size();i++){
			   statement.setString(i+1, paramList.get(i));
		   }
		   
		   //从数据库中查询
			ResultSet rs = statement.executeQuery();
			//从数据库中查询的结果封装成List数组
			List<Message> messageList = new ArrayList<Message>();
			while(rs.next()){
				//取出一条数据就对应了一条javabean对象
				Message message = new Message();
				//取出来放到封装里，先放后放都行，因为存放的是引用对象
				messageList.add(message);
				message.setId(rs.getString("ID"));
				message.setCommand("COMMAND");
				message.setDescription("DESCRIPTION");
				message.setContent("CONTENT");
			}*/
		
			//3.查询消息列表并传给页面
		req.setAttribute("messageList",listService.queryMessageList(command, 
																description) );
		//4.向页面跳转
		req.getRequestDispatcher("/WEB-INF/jsp/back/List.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

	
}
