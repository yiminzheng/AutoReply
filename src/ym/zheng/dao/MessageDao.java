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
 * 和message表相关的数据库操作
 * @author zym
 *
 */
public class MessageDao {
	
	//批量删除数据
	public void deleteBatch(List<Integer> ids){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			
			//通过sqlSession执行SQL语句
			//只能传递一个参数，要想传递多个参数可以将其封装成对象
			sqlSession.delete("Message.deleteBatch",ids);
			//手动提交事务
			sqlSession.commit();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession != null)
			  sqlSession.close();
		}
	}
	
	//删除一条数据的dao方法
	public void deleteOne(int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			
			//通过sqlSession执行SQL语句
			//只能传递一个参数，要想传递多个参数可以将其封装成对象
			sqlSession.delete("Message.deleteOne",id);
			//手动提交事务
			sqlSession.commit();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession != null)
			  sqlSession.close();
		}
	}
	
	//根据查询条件查询消息列表
	public List<Message> queryMessageList(String command,String description ){
		
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			
			//通过sqlSession执行SQL语句
			//只能传递一个参数，要想传递多个参数可以将其封装成对象
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
			
			while(rs.next()){
				//取出一条数据就对应了一条javabean对象
				Message message = new Message();
				//取出来放到封装里，先放后放都行，因为存放的是引用对象
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
