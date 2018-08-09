package ym.zheng.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import ym.zheng.bean.Message;
import ym.zheng.db.DBAccess;

/**
 * ��message����ص����ݿ����
 * @author zym
 *
 */
public class MessageDao {
	
	//����ɾ������
	public void deleteBatch(List<Integer> ids){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			
			//ͨ��sqlSessionִ��SQL���
			//ֻ�ܴ���һ��������Ҫ�봫�ݶ���������Խ����װ�ɶ���
			sqlSession.delete("Message.deleteBatch",ids);
			//�ֶ��ύ����
			sqlSession.commit();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession != null)
			  sqlSession.close();
		}
	}
	
	//ɾ��һ�����ݵ�dao����
	public void deleteOne(int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			
			//ͨ��sqlSessionִ��SQL���
			//ֻ�ܴ���һ��������Ҫ�봫�ݶ���������Խ����װ�ɶ���
			sqlSession.delete("Message.deleteOne",id);
			//�ֶ��ύ����
			sqlSession.commit();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession != null)
			  sqlSession.close();
		}
	}
	
	//���ݲ�ѯ������ѯ��Ϣ�б�
	public List<Message> queryMessageList(String command,String description ){
		
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			
			//ͨ��sqlSessionִ��SQL���
			//ֻ�ܴ���һ��������Ҫ�봫�ݶ���������Խ����װ�ɶ���
			messageList = sqlSession.selectList("Message.queryMessageList",
																message);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession != null)
			  sqlSession.close();
		}
		
		return null;
		
	}
	
	public static void main(String[] args){
		MessageDao messageDao = new MessageDao();
		messageDao.queryMessageList("", "");
	}
	
	
	
	
	
	
	
	/*public List<Message> queryMessageList(String command,String description ){
		List<Message> messageList = new ArrayList<Message>();
		try {
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
			
			while(rs.next()){
				//ȡ��һ�����ݾͶ�Ӧ��һ��javabean����
				Message message = new Message();
				//ȡ�����ŵ���װ��ȷź�Ŷ��У���Ϊ��ŵ������ö���
				messageList.add(message);
				message.setId(rs.getString("ID"));
				message.setCommand(rs.getString("COMMAND"));
				message.setDescription(rs.getString("DESCRIPTION"));
				message.setContent(rs.getString("CONTENT"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messageList;
	}*/

}
