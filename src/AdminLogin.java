
public class AdminLogin {
	
	private final String ADMINID  = "admin";
	private final String ADMINPWD = "1234";

	public AdminLogin() {
	}
	
	//�α��� üũ ���� (true : �α��� ����)
	public boolean loginCheck (String userid, String userpwd) {
		if(userid.equals(ADMINID) && userpwd.equals(ADMINPWD)) {
			//�α��μ���
			System.out.println("������ ���� �α����߽��ϴ�.");
			System.out.println("-----------------------------------");
			System.out.println();
			return true;
		}
		else {
			System.out.println("���̵� �Ǵ� ��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �α��� ���ּ���.");
			System.out.println("-----------------------------------");
			System.out.println();
			return false; //�α��� ����
		}
	}

}
