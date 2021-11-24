import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import bookInfo.BookDataSet;
import bookInfo.BookVO;
import userInfo.UserDataSet;
import userInfo.UserVO;

public class UserMode {
	Scanner s = new Scanner(System.in);
	public static HashMap<String,Integer> bookCart = new HashMap<String,Integer>();

	public UserMode() {
	}
	
	//����� ����
	public void userMenu(String id) {
		userBookManage(id);
	}
	
	//����� �޴�
	public void userBookManage(String id) {
		do {
			allBookList();
			System.out.println();
			System.out.println("[1]���� ����, [2]���� �˻�, [3]�� ���� ����, [4]ȸ�� Ż��, [5]�α׾ƿ� [6]����");
			String option = inData("�޴��� �����ϼ���");
			System.out.println("-----------------------------------");
			System.out.println();
		
			if(option.equals("1")) { // ���� ����
				buyBook();
			}
			
			else if(option.equals("2")) {
				searchBook();
				searchMenu();
			}
			
			else if(option.equals("3")) {
				myUpdate(id);
			}
			else if(option.equals("4")) {
				userDel(id);
				break;
			}
			else if(option.equals("5")) {
				System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
				System.out.println("-----------------------------------");
				System.out.println();
				break;
			}
			
			else if(option.equals("6")) {
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			}
			else {
				System.out.println("[1] ~ [6] �߿��� �����ϼ���");
				System.out.println("-----------------------------------");
				System.out.println();
			}
		}
		
		while(true);
	}
	
	//�˻� �� �޴�
	public void searchMenu() {
		System.out.println("[1]���� ����. [2]���� ȭ��");
		String option = inData("�޴��� �����ϼ���");
		if(option.equals("1")) {
			buyBook();
		}
		else if (option.equals("2")) {
		}
		else {
			System.out.println("[1] �Ǵ� [2]�� �Է��ϼ���.");
		}
	}
	
	//å �˻�
	public void searchBook() {
		System.out.println("'���� �˻�'�� �����߽��ϴ�.");
		System.out.println("-----------------------------------");
		System.out.println();
		String msg = inData("�˻� ����");
		Collection<BookVO> list = BookDataSet.bookList.values();
		Iterator<BookVO> bb = list.iterator();
		System.out.println("�˻��� '"+msg+"'�� �� å ����Դϴ�.");
		System.out.println();
		
		while(bb.hasNext()) {
			BookVO vo =bb.next();
			if (vo.getBookName().indexOf(msg) != -1) {		
				vo.bookPrint();
			}
		}
		System.out.println("-----------------------------------");
		System.out.println();
	}
	
	//å ����
	public void buyBook() {
		do {
			try {
				String buyNum = inData("������ å�� ISBN�� �Է��ϼ���");
				int count = Integer.parseInt(inData("����"));
				BookVO vo = BookDataSet.bookList.get(buyNum);
				if (count > vo.getBookStock()) {
					System.out.println("��� �ʰ��߽��ϴ�. ��� Ȯ�� ��, ���Է����ּ���.");
					System.out.println("-----------------------------------");
					System.out.println();
				}
				else {
					int money = vo.getBookPri() * count;
					System.out.println("�� ������ "+money+"���Դϴ�.");
					Calendar now = Calendar.getInstance();
					now.add(Calendar.DATE, +2);
					
					int year = now.get(Calendar.YEAR);
					int month = now.get(Calendar.MONTH)+1;
 					int day = now.get(Calendar.DAY_OF_MONTH);
					System.out.println("���� �������� "+year+"�� "+month+"�� "+day+"�� �Դϴ�.");
					System.out.println("�������ּż� �����մϴ�.");
					vo.setBookStock(vo.getBookStock()-count);
					System.out.println("-----------------------------------");
					System.out.println();
					break;
				}
			}
			
			catch (NullPointerException np) {
				System.out.println("�������� �ʴ� ISBN�Դϴ�. Ȯ�� ��, ���Է����ּ���.");
				System.out.println("-----------------------------------");
				System.out.println();
			}
			catch (NumberFormatException nf) {
				System.out.println("���ڸ� �Է��ϼ���");
			}
			
			
		}
		while(true);
	}
	
	//����������
	public void myUpdate(String editId) {
		String option = inData("[1]�̸�, [2]����ó, [3]��й�ȣ");
		
		if(option.equals("1")) {
			userNameUpdate(editId);
		}
		else if (option.equals("2")) {
			userTelUpdate(editId);
		}
		else if (option.equals("3")) {
			userPwdUpdate(editId);
		}
		else System.out.println("[1] ~ [3] �߿� �����ϼ���.");
	}
	
	//�̸� ����
	public void userNameUpdate(String id) {
		System.out.println("'�̸� ����'�� �����߽��ϴ�.");
		UserVO vo = UserDataSet.userList.get(id);
		System.out.println("���� �̸� : "+vo.getUserName());
		String name = inData("����� �̸� �Է�");
		vo.setUserName(name);
		System.out.println();
		System.out.println("������ �Ϸ�Ǿ����ϴ�!");
		System.out.println();
	}
	
	//����ó ����
	public void userTelUpdate(String id) {
		System.out.println("'����ó ����'�� �����߽��ϴ�.");
		UserVO vo = UserDataSet.userList.get(id);
		System.out.println("���� ����ó : "+vo.getUserTel());
		String tel = inData("����� ����ó �Է�");
		vo.setUserTel(tel);
		System.out.println();
		System.out.println("������ �Ϸ�Ǿ����ϴ�!");
		System.out.println();
	}
	
	//��й�ȣ ����
		public void userPwdUpdate(String id) {
			System.out.println("'��й�ȣ ����'�� �����߽��ϴ�.");
			System.out.println();
			do {
				String inputPwd = inData("���� Ȯ���� ���� ��й�ȣ�� �ٽ� �Է����ּ���");
				if(inputPwd.equals(UserDataSet.userList.get(id).getUserPwd())) {
					String pwd = inData("����� ��й�ȣ �Է�");
					UserVO vo = UserDataSet.userList.get(id);
					vo.setUserPwd(pwd);
					System.out.println();
					System.out.println("������ �Ϸ�Ǿ����ϴ�!");
					System.out.println();
					break;
				}
				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
				System.out.println();
			}
			while(true);
		}
	
	//Ż��
	public void userDel(String id) {
		do {
			String inputPwd = inData("���� Ȯ���� ���� ��й�ȣ�� �ٽ� �Է����ּ���");
			if(inputPwd.equals(UserDataSet.userList.get(id).getUserPwd())) {
				UserDataSet.userList.remove(id);
				System.out.println("Ż�� �Ϸ�Ǿ����ϴ�!");
				System.out.println();
				break;
			}
			System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			System.out.println();
			}
		while(true);
	}
	
	
	
	//å ���
	public void allBookList() {
		System.out.println();
		BookVO.titlePrint();
		Collection<BookVO> list = BookDataSet.bookList.values();
		Iterator<BookVO> bb = list.iterator();
		while (bb.hasNext()) {
			BookVO vo = bb.next();
			vo.bookPrint();
		}
	}
	
	public String inData(String st) {
		System.out.print(st+" : ");
		return s.next();
	}

}
