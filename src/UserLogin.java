import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import userInfo.UserDataSet;
import userInfo.UserVO;

public class UserLogin {

	public UserLogin() {
	}
	
	//�α��� üũ ���� (true : �α��� ����)
	public boolean loginCheck (String inputid, String inputpwd) {
		
		Set<String> idList = UserDataSet.userList.keySet();
		Iterator<String> ii = idList.iterator();
		
		while(ii.hasNext()) {
			String id = ii.next();
			//System.out.println(id); //Ȯ�ο�
			String pwd = UserDataSet.userList.get(id).getUserPwd();
			String name = UserDataSet.userList.get(id).getUserName();
			
			if(inputid.equals(id)) {
				if(inputpwd.equals(pwd)) {
					System.out.println();
					System.out.println(name+" ���� YES24 ������ ȯ���մϴ�.");
					System.out.println("-----------------------------------");
					System.out.println();
					return true;
				}
			}

		}
		
		System.out.println("���̵� �Ǵ� ��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �α��� ���ּ���.");
		System.out.println("-----------------------------------");
		System.out.println();
		return false;

	}}
		