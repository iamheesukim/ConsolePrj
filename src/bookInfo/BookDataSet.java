package bookInfo;

import java.util.HashMap;

public class BookDataSet {
	public static HashMap<String, BookVO> bookList = new HashMap<String,BookVO>();

	public BookDataSet() {
	}
	
	//å �⺻ ������
	public static void basicBookSet() {
		//���� �۰� ���� ��¥ ���� ���
		bookList.put("11673",new BookVO("������ �ູ","������",15800,"2021-06-08","11673",0));
		bookList.put("11913",new BookVO("�Ÿ��� ���","�ں�â",18000,"2021-05-14","11913",2));
		bookList.put("89349",new BookVO("�׷��� �׷�","������",14500,"2021-04-12","89349",3));
		bookList.put("89012",new BookVO("ģ���� ����","������",14000,"2021-06-16","89012",4));
		bookList.put("89324",new BookVO("������ �̷�","������",16000,"2021-04-25","89324",5));
	
	}
}