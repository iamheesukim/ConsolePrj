package userInfo;

import java.util.HashMap;

public class UserDataSet {
	
	public static HashMap<String, UserVO> userList = new HashMap<String, UserVO>();

	public UserDataSet() {
	}
	
	//기본데이터 셋팅
	public static void basicUserSet() {
		//주민등록번호는 임의 000000-0 형태로 저장
		userList.put("user",new UserVO("김준면", "910522-1", "010-1234-5678", "user", "1234"));
		userList.put("user02",new UserVO("도경수", "930112-1", "010-1111-2222", "user02", "0000"));
		userList.put("user03",new UserVO("변백현", "920506-1", "010-3333-4444", "user03", "0000"));
		userList.put("user04",new UserVO("김민석", "900326-1", "010-5555-6666", "user04", "0000"));
	}

}