
public class AdminLogin {
	
	private final String ADMINID  = "admin";
	private final String ADMINPWD = "1234";

	public AdminLogin() {
	}
	
	//로그인 체크 구현 (true : 로그인 성공)
	public boolean loginCheck (String userid, String userpwd) {
		if(userid.equals(ADMINID) && userpwd.equals(ADMINPWD)) {
			//로그인성공
			System.out.println("관리자 모드로 로그인했습니다.");
			System.out.println("-----------------------------------");
			System.out.println();
			return true;
		}
		else {
			System.out.println("아이디 또는 비밀번호가 틀렸습니다. 다시 로그인 해주세요.");
			System.out.println("-----------------------------------");
			System.out.println();
			return false; //로그인 실패
		}
	}

}
