package userInfo;

public class UserVO {
	//private String userNum;
	private String userName; //�̸�
	private String userNum; //�ֹι�ȣ
	private String userTel; //����ó
	private String userId; //���̵�
	private String userPwd; //���

	public UserVO() {
	}
	
	public UserVO(String name, String num, String tel, String id, String pwd) { //��ü �����͸� �ٷ�� ������ �޼ҵ�
		userName = name;
		userNum = num;
		userTel = tel;
		userId = id;
		userPwd = pwd;
	}
	
	public static void titlePrint() {
		System.out.printf("%-10s %-10s %-15s %-10s %-10s\n","ȸ����","�ֹε�Ϲ�ȣ","����ó","���̵�","��й�ȣ");
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
