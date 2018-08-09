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
 * �б�ҳ���ʼ������
 * @author zym
 *
 */
@SuppressWarnings("serial")
//�����л���ԭ����Ӿ���ע��
public class ListServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		//1.����ҳ���ֵ
		String command = req.getParameter("command");
		String  description = req.getParameter("description");
		//2.��ҳ�洫ֵ
		req.setAttribute("command", command);
		
		req.setAttribute("description",description);
		QueryService listService = new QueryService();
			
			
			/*
			 //�������ݿ����
			 
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
		   
		   //�����ݿ��в�ѯ
			ResultSet rs = statement.executeQuery();
			//�����ݿ��в�ѯ�Ľ����װ��List����
			List<Message> messageList = new ArrayList<Message>();
			while(rs.next()){
				//ȡ��һ�����ݾͶ�Ӧ��һ��javabean����
				Message message = new Message();
				//ȡ�����ŵ���װ��ȷź�Ŷ��У���Ϊ��ŵ������ö���
				messageList.add(message);
				message.setId(rs.getString("ID"));
				message.setCommand("COMMAND");
				message.setDescription("DESCRIPTION");
				message.setContent("CONTENT");
			}*/
		
			//3.��ѯ��Ϣ�б�����ҳ��
		req.setAttribute("messageList",listService.queryMessageList(command, 
																description) );
		//4.��ҳ����ת
		req.getRequestDispatcher("/WEB-INF/jsp/back/List.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

	
}
