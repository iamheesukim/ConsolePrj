package bookInfo;

import java.util.HashMap;

public class BookDataSet {
	public static HashMap<String, BookVO> bookList = new HashMap<String,BookVO>();

	public BookDataSet() {
	}
	
	//책 기본 데이터
	public static void basicBookSet() {
		//제목 작가 가격 날짜 숫자 재고
		bookList.put("11673",new BookVO("완전한 행복","정유정",15800,"2021-06-08","11673",0));
		bookList.put("11913",new BookVO("매매의 기술","박병창",18000,"2021-05-14","11913",2));
		bookList.put("89349",new BookVO("그러라 그래","양희은",14500,"2021-04-12","89349",3));
		bookList.put("89012",new BookVO("친구의 전설","이지은",14000,"2021-06-16","89012",4));
		bookList.put("89324",new BookVO("공간의 미래","유현준",16000,"2021-04-25","89324",5));
	
	}
}