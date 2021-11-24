import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import bookInfo.BookDataSet;
import bookInfo.BookVO;
import userInfo.UserDataSet;
import userInfo.UserVO;

public class Yes24Start {
	Scanner s = new Scanner(System.in);
	AdminMode am = new AdminMode();
	UserMode um = new UserMode();

	public Yes24Start() {
	}
	
	//���� : ȸ�� ����
	public void start() {
		UserDataSet.basicUserSet();
		BookDataSet.basicBookSet();
		do {
			System.out.println("YES24�� ���Ű� ȯ���մϴ�!");
			System.out.println("[1] ȸ�� ���");
			System.out.println("[2] ������ ���");
			System.out.println("[3] ����");
			System.out.println("");
			String option = inData("��带 �������ּ���");
			System.out.println();
			System.out.println("-----------------------------------");
			System.out.println();
			
			if (option.equals("1")) {
				enterUser();
			}
			else if (option.equals("2")) {
				adminLogin();
			}
			else if (option.equals("3")) {
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			}
			else { System.out.println("[1] ~ [3] �߿� �����ϼ���!");
			System.out.println("-----------------------------------");
			}
		}
		
		while(true);
	}
	
	//[1]ȸ�����
	public void enterUser() {
		do {
			System.out.println("[1] ���� ȸ��");
			System.out.println("[2] �ű� ȸ��");
			String option = inData("ȸ�� ������ �������ּ���.");
			
			if (option.equals("1")) {
				userLogin();
				break;
			}
			else if (option.equals("2")) {
				insertUser();
				System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�!");
				System.out.println("-----------------------------------");
				System.out.println("");
				break;
			}
			else System.out.printf("[1] �Ǵ� [2]�� �����ϼ���.\n\n");
			}
		while(true);
	}
	
	//ȸ������
	public void insertUser() {
		System.out.println();
		System.out.println("-----------------------------------");
		System.out.println("ȸ�������� �����մϴ�.");
		UserVO vo = new UserVO();
		vo.setUserName(inData("�̸�"));
		vo.setUserTel(inData("����ó"));
		vo.setUserNum(inData("�ֹε�Ϲ�ȣ"));
		vo.setUserId(checkId());

		
		vo.setUserPwd(inData("��й�ȣ"));
		UserDataSet.userList.put(vo.getUserId(),vo);
	}
	
	public String checkId() {
		do {
			String inputid = inData("���̵�");
			if(!UserDataSet.userList.containsKey(inputid)) {
				return inputid;
				}
			else System.out.println("���̵� �ߺ��Դϴ�.");
		}
		while(true);
	}
	
	//ȸ�� �α���
	public void userLogin() {
		System.out.println();
		System.out.println("-----------------------------------");
		System.out.println("YES24�� �α������ּ���!");
		System.out.println();
		boolean loginResult;
		String id, pwd;
		do {
			id = inData("���̵�");
			pwd = inData("��й�ȣ");
			UserLogin lg = new UserLogin();
			loginResult = lg.loginCheck(id, pwd);
		} //do ��
		
		while(!loginResult);
		
		um.userMenu(id);
	}
	
	//==============================================================================================================
	
	//������ ��� ����
	public void adminLogin() {
		System.out.println("'[2] ������ ���'�� �����߽��ϴ�.");
		System.out.println();
		boolean loginResult;
		do { 
			String id = inData("���̵�");
			String pwd = inData("��й�ȣ");
			AdminLogin lg = new AdminLogin();
			loginResult = lg.loginCheck(id, pwd);
		}
		
		while(!loginResult);
		am.adminMenu();
		System.out.println("-----------------------------------");
		System.out.println();
	}

	
	public String inData(String st) {
		System.out.print(st+" : ");
		return s.next();
	}
}
