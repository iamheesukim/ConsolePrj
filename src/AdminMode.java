import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import bookInfo.BookDataSet;
import bookInfo.BookVO;
import userInfo.UserDataSet;
import userInfo.UserVO;

public class AdminMode {
	Scanner s = new Scanner(System.in);

	public AdminMode() {
	}
	
	//������ ���
	public void adminMenu() {
		do {
			System.out.println("[1] ȸ�� ����");
			System.out.println("[2] ���� ����");
			System.out.println("[3] �α׾ƿ�");
			System.out.println("[4] ����");
			String option = inData("������ �޴��� �����ϼ���");
			
			if (option.equals("1")) {
				// 1�� ������ ����
				System.out.println("'ȸ�� ����'�� �����߽��ϴ�");
				System.out.println("-----------------------------------");
				System.out.println();
				allUserList();
				System.out.println();
				userManage();
			}
			else if(option.equals("2")) {
				// 2�� ������ ����
				System.out.println("'���� ����'�� �����߽��ϴ�");
				System.out.println("-----------------------------------");
				System.out.println();
				allBookList();
				System.out.println();
				bookManage();
			}
			else if(option.equals("3")) {
				// 3�� ������ ����
				System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
				System.out.println();
				break;
			}
			
			else if(option.equals("4")) {
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			}
			else {
				System.out.println("[1] ~ [3] �߿� �����ϼ���!");
				System.out.println("-----------------------------------");
			}
		}
		
		while(true);
	}
	
	//�������� �޴�
	public void bookManage() {
		do {
			System.out.println("[1]���� ����, [2]���� ����, [3]���� �߰�, [4]���� ���, [5]���� ȭ��");
			String option = inData("���� ���� �޴��� �����ϼ���");
			System.out.println();
			
			if(option.equals("1")) { //���� ����
				bookUpdate();
				System.out.println("-----------------------------------");
				allBookList();
			}
			
			else if(option.equals("2")) { //���� ����
				bookDelete();
				allBookList();
			}
			
			else if(option.equals("3")) { //���� �߰�
				insertBook();
				allBookList();
			}
			
			else if(option.equals("4")) { //å ���
				allBookList();
			}
			
			else if(option.equals("5")) { //����ȭ��
				break;
			}
		}
		
		while(true);
	}
	
	//���� �߰�
	public void insertBook() {
		System.out.println("'���� �߰�'�� �����߽��ϴ�.");
		System.out.println("-----------------------------------");
		System.out.println();
		BookVO vo = new BookVO();
		vo.setBookName(inData("å �̸�"));
		vo.setBookWri(inData("�۰�"));
		vo.setBookPri(Integer.parseInt(inData("����")));
		vo.setBookNum(inData("ISBN"));
		vo.setBookDate(inData("������"));
		vo.setBookStock(Integer.parseInt(inData("���")));
		BookDataSet.bookList.put(vo.getBookNum(),vo);
	}
	
	//å ����
	public void bookDelete() {
		System.out.println("'���� ����'�� �����߽��ϴ�.");
		System.out.println("-----------------------------------");
		System.out.println();
		
		String delNum = inData("������ å�� ISBN");
		BookDataSet.bookList.remove(delNum);
		System.out.println("������ �Ϸ�Ǿ����ϴ�!");
		System.out.println();
	}
	
	
	//å ���� ����
	public void bookUpdate() {
		
		String editNum = inData("������ å�� ISBN �Է�");
		String option = inData("[1]����, [2]��� �߰�");
		
		if(option.equals("1")) {
			bookPriUpdate(editNum);
		}
		else if (option.equals("2")) {
			bookStockUpdate(editNum);
		}
		else System.out.println("[1] �Ǵ� [2]�� �����ϼ���.");
	}
	
	//���� ����
	public void bookPriUpdate(String id) {
		System.out.println("'���� ����'�� �����߽��ϴ�.");
		int pri = Integer.parseInt(inData("����� ���� �Է�"));
		BookVO vo = BookDataSet.bookList.get(id);
		vo.setBookPri(pri);
		System.out.println();
		System.out.println("������ �Ϸ�Ǿ����ϴ�!");
		System.out.println();
	}
	
	//��� ����
	public void bookStockUpdate(String id) {
		System.out.println("'��� �߰�'�� �����߽��ϴ�.");
		int stock = Integer.parseInt(inData("�߰��� ��� ����"));
		BookVO vo = BookDataSet.bookList.get(id);
		vo.setBookStock(vo.getBookStock()+stock);
		System.out.println();
		System.out.println("������ �Ϸ�Ǿ����ϴ�!");
		System.out.println();
	}

	
	//���� ��� ���
	public void allBookList() {
		System.out.println();
		BookVO.titlePrint();
		Collection<BookVO> list = BookDataSet.bookList.values();
		Iterator<BookVO> ii = list.iterator();
		while (ii.hasNext()) {
			BookVO vo = ii.next();
			vo.bookPrint();
		}
	}
	
	//�����ڸ�� ȸ�� ��� ���
	public void allUserList() {
		System.out.println();
		UserVO.titlePrint();
		Collection<UserVO> list = UserDataSet.userList.values();
		Iterator<UserVO> ii = list.iterator();
		while (ii.hasNext()) {
			UserVO vo = ii.next();
			vo.userPrint();
		}
	}
	
	//�����ڸ�� ȸ�� ���� �޴�
	public void userManage() {
		do {
			System.out.println("[1]ȸ�� ����, [2]ȸ�� ����, [3]ȸ�� ���, [4]���� ȭ��");
			String option = inData("ȸ�� ���� �޴��� �����ϼ���");
			System.out.println("-----------------------------------");
			System.out.println();
			
			if (option.equals("1")) {
				//ȸ�� ���� ����
				userUpdate();
				allUserList();
			}
			else if (option.equals("2")) {
				// ȸ�� ���� ����
				userDelete();
				allUserList();
			}
			else if (option.equals("3")) {
				//ȸ�� ��� ���
				System.out.println();
				allUserList();
			}
			
			else if (option.equals("4")) {
				break;
			}
			else System.out.println("[1] ~ [4] �߿� �����ϼ���!");
			System.out.println("-----------------------------------");
		}
		
		while (true);
	}
	
	//�����ڸ�� ���� ����
	public void userUpdate() {
		
		String editId = inData("������ ȸ���� ���̵� �Է�");
		String option = inData("[1]ȸ����, [2]����ó");
		
		if(option.equals("1")) {
			userNameUpdate(editId);
		}
		else if (option.equals("2")) {
			userTelUpdate(editId);
		}
		else System.out.println("[1] �Ǵ� [2]�� �����ϼ���.");
	}
	
	//ȸ���� ����
	public void userNameUpdate(String id) {
		System.out.println("'ȸ���� ����'�� �����߽��ϴ�.");
		String name = inData("����� ȸ���� �Է�");
		UserVO vo = UserDataSet.userList.get(id);
		vo.setUserName(name);
		System.out.println();
		System.out.println("������ �Ϸ�Ǿ����ϴ�!");
		System.out.println();
	}
	
	//����ó ����
	public void userTelUpdate(String id) {
		System.out.println("'����ó ����'�� �����߽��ϴ�.");
		String tel = inData("����� ����ó �Է�");
		UserVO vo = UserDataSet.userList.get(id);
		vo.setUserTel(tel);
		System.out.println();
		System.out.println("������ �Ϸ�Ǿ����ϴ�!");
		System.out.println();
	}
	
	//ȸ�� ����
	public void userDelete() {
		String delId = inData("������ ȸ���� ���̵�");
		UserDataSet.userList.remove(delId);
		System.out.println("������ �Ϸ�Ǿ����ϴ�!");
		System.out.println();
	}
	
	public String inData(String st) {
		System.out.print(st+" : ");
		return s.nextLine();
	}
}
