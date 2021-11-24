package bookInfo;

public class BookVO {
	private String bookName; //제목
	private String bookWri; //작가
	private int bookPri; //가격
	private String bookDate; //출간일
	private String bookNum; //ISBN
	private int bookSt; //재고

	public BookVO() {
	}
	
	public BookVO(String name, String wri, int pri, String date, String num, int st) {
		bookName = name;
		bookWri = wri;
		bookPri = pri;
		bookDate = date;
		bookNum = num;
		bookSt = st;
	}
	
	
	public static void titlePrint() {
		System.out.printf("%-11s %-7s %-10s %-10s %s %10s %5s\n","책 이름","작가","가격","ISBN", "출판일", "재고", "상태");
		System.out.println("=============================================================================");
	}
	
	public void bookPrint() {
		String stock;
		if(bookSt>0) stock="구입 가능";
		else stock="매진";
		
		System.out.printf("%-10s %-7s %d원 %9s %15s %4d %8s\n",bookName,bookWri,bookPri,bookNum, bookDate,bookSt,stock);
	}
	
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookWri() {
		return bookWri;
	}

	public void setBookWri(String bookWri) {
		this.bookWri = bookWri;
	}

	public int getBookPri() {
		return bookPri;
	}

	public void setBookPri(int bookPri) {
		this.bookPri = bookPri;
	}

	public String getBookDate() {
		return bookDate;
	}

	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}

	public String getBookNum() {
		return bookNum;
	}

	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}

	public int getBookStock() {
		return bookSt;
	}

	public void setBookStock(int bookSt) {
		this.bookSt = bookSt;
	}
	

}