import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import userInfo.UserDataSet;
import userInfo.UserVO;

public class UserLogin {

	public UserLogin() {
	}
	
	//로그인 체크 구현 (true : 로그인 성공)
	public boolean loginCheck (String inputid, String inputpwd) {
		
		Set<String> idList = UserDataSet.userList.keySet();
		Iterator<String> ii = idList.iterator();
		
		while(ii.hasNext()) {
			String id = ii.next();
			//System.out.println(id); //확인용
			String pwd = UserDataSet.userList.get(id).getUserPwd();
			String name = UserDataSet.userList.get(id).getUserName();
			
			if(inputid.equals(id)) {
				if(inputpwd.equals(pwd)) {
					System.out.println();
					System.out.println(name+" 고객님 YES24 접속을 환영합니다.");
					System.out.println("-----------------------------------");
					System.out.println();
					return true;
				}
			}

		}
		
		System.out.println("아이디 또는 비밀번호가 틀렸습니다. 다시 로그인 해주세요.");
		System.out.println("-----------------------------------");
		System.out.println();
		return false;

	}}
		