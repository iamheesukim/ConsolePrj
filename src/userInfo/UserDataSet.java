package userInfo;

import java.util.HashMap;

public class UserDataSet {
	
	public static HashMap<String, UserVO> userList = new HashMap<String, UserVO>();

	public UserDataSet() {
	}
	
	//�⺻������ ����
	public static void basicUserSet() {
		//�ֹε�Ϲ�ȣ�� ���� 000000-0 ���·� ����
		userList.put("user",new UserVO("���ظ�", "910522-1", "010-1234-5678", "user", "1234"));
		userList.put("user02",new UserVO("�����", "930112-1", "010-1111-2222", "user02", "0000"));
		userList.put("user03",new UserVO("������", "920506-1", "010-3333-4444", "user03", "0000"));
		userList.put("user04",new UserVO("��μ�", "900326-1", "010-5555-6666", "user04", "0000"));
	}

}