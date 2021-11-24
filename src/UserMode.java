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
	
	//사용자 접속
	public void userMenu(String id) {
		userBookManage(id);
	}
	
	//사용자 메뉴
	public void userBookManage(String id) {
		do {
			allBookList();
			System.out.println();
			System.out.println("[1]도서 구입, [2]도서 검색, [3]내 정보 수정, [4]회원 탈퇴, [5]로그아웃 [6]종료");
			String option = inData("메뉴를 선택하세요");
			System.out.println("-----------------------------------");
			System.out.println();
		
			if(option.equals("1")) { // 도서 구입
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
				System.out.println("로그아웃 되었습니다.");
				System.out.println("-----------------------------------");
				System.out.println();
				break;
			}
			
			else if(option.equals("6")) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
			else {
				System.out.println("[1] ~ [6] 중에서 선택하세요");
				System.out.println("-----------------------------------");
				System.out.println();
			}
		}
		
		while(true);
	}
	
	//검색 후 메뉴
	public void searchMenu() {
		System.out.println("[1]도서 구입. [2]이전 화면");
		String option = inData("메뉴를 선택하세요");
		if(option.equals("1")) {
			buyBook();
		}
		else if (option.equals("2")) {
		}
		else {
			System.out.println("[1] 또는 [2]를 입력하세요.");
		}
	}
	
	//책 검색
	public void searchBook() {
		System.out.println("'도서 검색'을 선택했습니다.");
		System.out.println("-----------------------------------");
		System.out.println();
		String msg = inData("검색 내용");
		Collection<BookVO> list = BookDataSet.bookList.values();
		Iterator<BookVO> bb = list.iterator();
		System.out.println("검색어 '"+msg+"'가 들어간 책 목록입니다.");
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
	
	//책 구입
	public void buyBook() {
		do {
			try {
				String buyNum = inData("구입할 책의 ISBN을 입력하세요");
				int count = Integer.parseInt(inData("수량"));
				BookVO vo = BookDataSet.bookList.get(buyNum);
				if (count > vo.getBookStock()) {
					System.out.println("재고가 초과했습니다. 재고 확인 후, 재입력해주세요.");
					System.out.println("-----------------------------------");
					System.out.println();
				}
				else {
					int money = vo.getBookPri() * count;
					System.out.println("총 가격은 "+money+"원입니다.");
					Calendar now = Calendar.getInstance();
					now.add(Calendar.DATE, +2);
					
					int year = now.get(Calendar.YEAR);
					int month = now.get(Calendar.MONTH)+1;
 					int day = now.get(Calendar.DAY_OF_MONTH);
					System.out.println("예상 도착일은 "+year+"년 "+month+"월 "+day+"일 입니다.");
					System.out.println("구입해주셔서 감사합니다.");
					vo.setBookStock(vo.getBookStock()-count);
					System.out.println("-----------------------------------");
					System.out.println();
					break;
				}
			}
			
			catch (NullPointerException np) {
				System.out.println("존재하지 않는 ISBN입니다. 확인 후, 재입력해주세요.");
				System.out.println("-----------------------------------");
				System.out.println();
			}
			catch (NumberFormatException nf) {
				System.out.println("숫자를 입력하세요");
			}
			
			
		}
		while(true);
	}
	
	//내정보수정
	public void myUpdate(String editId) {
		String option = inData("[1]이름, [2]연락처, [3]비밀번호");
		
		if(option.equals("1")) {
			userNameUpdate(editId);
		}
		else if (option.equals("2")) {
			userTelUpdate(editId);
		}
		else if (option.equals("3")) {
			userPwdUpdate(editId);
		}
		else System.out.println("[1] ~ [3] 중에 선택하세요.");
	}
	
	//이름 수정
	public void userNameUpdate(String id) {
		System.out.println("'이름 수정'을 선택했습니다.");
		UserVO vo = UserDataSet.userList.get(id);
		System.out.println("기존 이름 : "+vo.getUserName());
		String name = inData("개명된 이름 입력");
		vo.setUserName(name);
		System.out.println();
		System.out.println("수정이 완료되었습니다!");
		System.out.println();
	}
	
	//연락처 수정
	public void userTelUpdate(String id) {
		System.out.println("'연락처 수정'을 선택했습니다.");
		UserVO vo = UserDataSet.userList.get(id);
		System.out.println("기존 연락처 : "+vo.getUserTel());
		String tel = inData("변경된 연락처 입력");
		vo.setUserTel(tel);
		System.out.println();
		System.out.println("수정이 완료되었습니다!");
		System.out.println();
	}
	
	//비밀번호 수정
		public void userPwdUpdate(String id) {
			System.out.println("'비밀번호 수정'을 선택했습니다.");
			System.out.println();
			do {
				String inputPwd = inData("본인 확인을 위해 비밀번호를 다시 입력해주세요");
				if(inputPwd.equals(UserDataSet.userList.get(id).getUserPwd())) {
					String pwd = inData("변경된 비밀번호 입력");
					UserVO vo = UserDataSet.userList.get(id);
					vo.setUserPwd(pwd);
					System.out.println();
					System.out.println("수정이 완료되었습니다!");
					System.out.println();
					break;
				}
				System.out.println("비밀번호가 틀렸습니다.");
				System.out.println();
			}
			while(true);
		}
	
	//탈퇴
	public void userDel(String id) {
		do {
			String inputPwd = inData("본인 확인을 위해 비밀번호를 다시 입력해주세요");
			if(inputPwd.equals(UserDataSet.userList.get(id).getUserPwd())) {
				UserDataSet.userList.remove(id);
				System.out.println("탈퇴가 완료되었습니다!");
				System.out.println();
				break;
			}
			System.out.println("비밀번호가 틀렸습니다.");
			System.out.println();
			}
		while(true);
	}
	
	
	
	//책 목록
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
