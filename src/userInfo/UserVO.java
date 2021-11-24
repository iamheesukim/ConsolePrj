package userInfo;

public class UserVO {
	//private String userNum;
	private String userName; //이름
	private String userNum; //주민번호
	private String userTel; //연락처
	private String userId; //아이디
	private String userPwd; //비번

	public UserVO() {
	}
	
	public UserVO(String name, String num, String tel, String id, String pwd) { //전체 데이터를 다루는 생성자 메소드
		userName = name;
		userNum = num;
		userTel = tel;
		userId = id;
		userPwd = pwd;
	}
	
	public static void titlePrint() {
		System.out.printf("%-10s %-10s %-15s %-10s %-10s\n","회원명","주민등록번호","연락처","아이디","비밀번호");
		System.out.println("=============================================================================");
	}
	
	public void userPrint() {
		System.out.printf("%-10s %-12s %-15s %-12s %s\n",userName,userNum,userTel,userId,userPwd);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserNum() {
		return userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
}
