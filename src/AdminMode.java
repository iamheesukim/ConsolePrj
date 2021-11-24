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
	
	//관리자 모드
	public void adminMenu() {
		do {
			System.out.println("[1] 회원 관리");
			System.out.println("[2] 도서 관리");
			System.out.println("[3] 로그아웃");
			System.out.println("[4] 종료");
			String option = inData("관리자 메뉴를 선택하세요");
			
			if (option.equals("1")) {
				// 1번 누르면 실행
				System.out.println("'회원 관리'를 선택했습니다");
				System.out.println("-----------------------------------");
				System.out.println();
				allUserList();
				System.out.println();
				userManage();
			}
			else if(option.equals("2")) {
				// 2번 누르면 실행
				System.out.println("'도서 관리'를 선택했습니다");
				System.out.println("-----------------------------------");
				System.out.println();
				allBookList();
				System.out.println();
				bookManage();
			}
			else if(option.equals("3")) {
				// 3번 누르면 실행
				System.out.println("로그아웃 되었습니다.");
				System.out.println();
				break;
			}
			
			else if(option.equals("4")) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
			else {
				System.out.println("[1] ~ [3] 중에 선택하세요!");
				System.out.println("-----------------------------------");
			}
		}
		
		while(true);
	}
	
	//도서관리 메뉴
	public void bookManage() {
		do {
			System.out.println("[1]도서 수정, [2]도서 삭제, [3]도서 추가, [4]도서 목록, [5]이전 화면");
			String option = inData("도서 관리 메뉴를 선택하세요");
			System.out.println();
			
			if(option.equals("1")) { //도서 수정
				bookUpdate();
				System.out.println("-----------------------------------");
				allBookList();
			}
			
			else if(option.equals("2")) { //도서 삭제
				bookDelete();
				allBookList();
			}
			
			else if(option.equals("3")) { //도서 추가
				insertBook();
				allBookList();
			}
			
			else if(option.equals("4")) { //책 목록
				allBookList();
			}
			
			else if(option.equals("5")) { //이전화면
				break;
			}
		}
		
		while(true);
	}
	
	//도서 추가
	public void insertBook() {
		System.out.println("'도서 추가'를 선택했습니다.");
		System.out.println("-----------------------------------");
		System.out.println();
		BookVO vo = new BookVO();
		vo.setBookName(inData("책 이름"));
		vo.setBookWri(inData("작가"));
		vo.setBookPri(Integer.parseInt(inData("가격")));
		vo.setBookNum(inData("ISBN"));
		vo.setBookDate(inData("출판일"));
		vo.setBookStock(Integer.parseInt(inData("재고")));
		BookDataSet.bookList.put(vo.getBookNum(),vo);
	}
	
	//책 삭제
	public void bookDelete() {
		System.out.println("'도서 삭제'를 선택했습니다.");
		System.out.println("-----------------------------------");
		System.out.println();
		
		String delNum = inData("삭제할 책의 ISBN");
		BookDataSet.bookList.remove(delNum);
		System.out.println("삭제가 완료되었습니다!");
		System.out.println();
	}
	
	
	//책 정보 수정
	public void bookUpdate() {
		
		String editNum = inData("수정할 책의 ISBN 입력");
		String option = inData("[1]가격, [2]재고 추가");
		
		if(option.equals("1")) {
			bookPriUpdate(editNum);
		}
		else if (option.equals("2")) {
			bookStockUpdate(editNum);
		}
		else System.out.println("[1] 또는 [2]를 선택하세요.");
	}
	
	//가격 수정
	public void bookPriUpdate(String id) {
		System.out.println("'가격 수정'을 선택했습니다.");
		int pri = Integer.parseInt(inData("변경된 가격 입력"));
		BookVO vo = BookDataSet.bookList.get(id);
		vo.setBookPri(pri);
		System.out.println();
		System.out.println("수정이 완료되었습니다!");
		System.out.println();
	}
	
	//재고 수정
	public void bookStockUpdate(String id) {
		System.out.println("'재고 추가'를 선택했습니다.");
		int stock = Integer.parseInt(inData("추가된 재고 물량"));
		BookVO vo = BookDataSet.bookList.get(id);
		vo.setBookStock(vo.getBookStock()+stock);
		System.out.println();
		System.out.println("수정이 완료되었습니다!");
		System.out.println();
	}

	
	//도서 목록 출력
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
	
	//관리자모드 회원 목록 출력
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
	
	//관리자모드 회원 관리 메뉴
	public void userManage() {
		do {
			System.out.println("[1]회원 수정, [2]회원 삭제, [3]회원 목록, [4]이전 화면");
			String option = inData("회원 관리 메뉴를 선택하세요");
			System.out.println("-----------------------------------");
			System.out.println();
			
			if (option.equals("1")) {
				//회원 수정 선택
				userUpdate();
				allUserList();
			}
			else if (option.equals("2")) {
				// 회원 삭제 선택
				userDelete();
				allUserList();
			}
			else if (option.equals("3")) {
				//회원 목록 출력
				System.out.println();
				allUserList();
			}
			
			else if (option.equals("4")) {
				break;
			}
			else System.out.println("[1] ~ [4] 중에 선택하세요!");
			System.out.println("-----------------------------------");
		}
		
		while (true);
	}
	
	//관리자모드 정보 수정
	public void userUpdate() {
		
		String editId = inData("수정할 회원의 아이디 입력");
		String option = inData("[1]회원명, [2]연락처");
		
		if(option.equals("1")) {
			userNameUpdate(editId);
		}
		else if (option.equals("2")) {
			userTelUpdate(editId);
		}
		else System.out.println("[1] 또는 [2]를 선택하세요.");
	}
	
	//회원명 수정
	public void userNameUpdate(String id) {
		System.out.println("'회원명 수정'을 선택했습니다.");
		String name = inData("변경된 회원명 입력");
		UserVO vo = UserDataSet.userList.get(id);
		vo.setUserName(name);
		System.out.println();
		System.out.println("수정이 완료되었습니다!");
		System.out.println();
	}
	
	//연락처 수정
	public void userTelUpdate(String id) {
		System.out.println("'연락처 수정'을 선택했습니다.");
		String tel = inData("변경된 연락처 입력");
		UserVO vo = UserDataSet.userList.get(id);
		vo.setUserTel(tel);
		System.out.println();
		System.out.println("수정이 완료되었습니다!");
		System.out.println();
	}
	
	//회원 삭제
	public void userDelete() {
		String delId = inData("삭제할 회원의 아이디");
		UserDataSet.userList.remove(delId);
		System.out.println("삭제가 완료되었습니다!");
		System.out.println();
	}
	
	public String inData(String st) {
		System.out.print(st+" : ");
		return s.nextLine();
	}
}
