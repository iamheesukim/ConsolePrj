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
	
	//시작 : 회원 구분
	public void start() {
		UserDataSet.basicUserSet();
		BookDataSet.basicBookSet();
		do {
			System.out.println("YES24에 오신걸 환영합니다!");
			System.out.println("[1] 회원 모드");
			System.out.println("[2] 관리자 모드");
			System.out.println("[3] 종료");
			System.out.println("");
			String option = inData("모드를 선택해주세요");
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
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
			else { System.out.println("[1] ~ [3] 중에 선택하세요!");
			System.out.println("-----------------------------------");
			}
		}
		
		while(true);
	}
	
	//[1]회원모드
	public void enterUser() {
		do {
			System.out.println("[1] 기존 회원");
			System.out.println("[2] 신규 회원");
			String option = inData("회원 종류를 선택해주세요.");
			
			if (option.equals("1")) {
				userLogin();
				break;
			}
			else if (option.equals("2")) {
				insertUser();
				System.out.println("회원가입이 완료되었습니다!");
				System.out.println("-----------------------------------");
				System.out.println("");
				break;
			}
			else System.out.printf("[1] 또는 [2]를 선택하세요.\n\n");
			}
		while(true);
	}
	
	//회원가입
	public void insertUser() {
		System.out.println();
		System.out.println("-----------------------------------");
		System.out.println("회원가입을 진행합니다.");
		UserVO vo = new UserVO();
		vo.setUserName(inData("이름"));
		vo.setUserTel(inData("연락처"));
		vo.setUserNum(inData("주민등록번호"));
		vo.setUserId(checkId());

		
		vo.setUserPwd(inData("비밀번호"));
		UserDataSet.userList.put(vo.getUserId(),vo);
	}
	
	public String checkId() {
		do {
			String inputid = inData("아이디");
			if(!UserDataSet.userList.containsKey(inputid)) {
				return inputid;
				}
			else System.out.println("아이디가 중복입니다.");
		}
		while(true);
	}
	
	//회원 로그인
	public void userLogin() {
		System.out.println();
		System.out.println("-----------------------------------");
		System.out.println("YES24에 로그인해주세요!");
		System.out.println();
		boolean loginResult;
		String id, pwd;
		do {
			id = inData("아이디");
			pwd = inData("비밀번호");
			UserLogin lg = new UserLogin();
			loginResult = lg.loginCheck(id, pwd);
		} //do 끝
		
		while(!loginResult);
		
		um.userMenu(id);
	}
	
	//==============================================================================================================
	
	//관리자 모드 접속
	public void adminLogin() {
		System.out.println("'[2] 관리자 모드'를 선택했습니다.");
		System.out.println();
		boolean loginResult;
		do { 
			String id = inData("아이디");
			String pwd = inData("비밀번호");
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
