package ym.zheng.service;

import java.util.List;

import ym.zheng.bean.Message;
import ym.zheng.dao.MessageDao;
import ym.zheng.util.Iconst;

/**
 * �б����ҵ��
 * @author zym
 *
 */
public class QueryService {

	public List<Message> queryMessageList(String command,String description ){
		
		MessageDao messageDao = new MessageDao();
		return messageDao.queryMessageList(command, description);
		
	}
	
	
	/**
	 * ͨ��ָ���ѯ�Զ��ظ�������
	 * @param command ָ��
	 * @return �Զ��ظ�������
	 */
	public String queryByCommand(String command) {
		MessageDao messageDao = new MessageDao();
		List<Message> messageList;
		if(Iconst.HELP_COMMAND.equals(command)) {
			messageList = messageDao.queryMessageList(null, null);
			StringBuilder result = new StringBuilder();
			for(int i = 0; i < messageList.size(); i++) {
				if(i != 0) {
					result.append("<br/>");
				}
				result.append("�ظ�[" + messageList.get(i).getCommand() + "]���Բ鿴" + messageList.get(i).getDescription());
			}
			return result.toString();
		}
		messageList = messageDao.queryMessageList(command, null);
		if(messageList.size() > 0) {
			return messageList.get(0).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}
}
