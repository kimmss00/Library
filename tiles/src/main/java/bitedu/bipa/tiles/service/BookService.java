package bitedu.bipa.tiles.service;

import java.io.File;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import bitedu.bipa.tiles.dao.BookDAO;
import bitedu.bipa.tiles.vo.BookVO;

@Service("BookService")
public class BookService implements IBookService{

	@Autowired
	private BookDAO dao;
	
	public boolean registBook(BookVO copy) {
		boolean flag = false;
		flag = dao.insertBook(copy);
		return flag;
	}
	public ArrayList<BookVO> searchBookAll(){
		ArrayList<BookVO> list = null;
		list = dao.selectBookAll();
		return list;
	}
	public boolean removeBook(String bookSeq) {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = dao.deleteBook(Integer.parseInt(bookSeq));
		return flag;
	}
	public BookVO findBook(String bookSeq) {
		BookVO copy = null;
		copy = dao.selectBook(Integer.parseInt(bookSeq));
		System.out.println(copy);
		return copy;
	}
	public boolean modifyBook(BookVO copy) {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = dao.updateBook(copy);
		return flag;
	}
	
	public BookVO upload(List<FileItem> items) throws Exception {
		// TODO Auto-generated method stub
		BookVO copy = null;
		copy = new BookVO();
		for(FileItem item : items) {
			if(item!=null&item.isFormField()) {
				//일반적인 Form값 추출
				String fieldName = item.getFieldName();
				if(fieldName.equals("isbn")) {
					copy.setIsbn(item.getString("UTF-8"));
				} else if(fieldName.equals("book_title")) {
					copy.setTitle(item.getString("UTF-8"));
				} else if(fieldName.equals("author")) {
					copy.setAuthor(item.getString("UTF-8"));
				} else if(fieldName.equals("publish_date")) {
					String date = item.getString("UTF-8");
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					try {
						Date now = df.parse(date);
						copy.setPublishDate(new Timestamp(now.getTime()));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				// uplode할 데이터 정보 추출(binary파일 업로드시 해당 else문 사용)
				String fieldName = item.getFieldName();
				if(fieldName.equals("book_image")) {
					String temp = item.getName();
					System.out.println("book_image "+temp);
					int index = temp.lastIndexOf("\\");
					String fileName = temp.substring(index+1);
					copy.setBookImage(fileName);
					//upload가 이루어지는부분
					File uploadFile = new File("C:\\Users\\금정산2_PC08\\Downloads\\sample\\src\\main\\webapp\\resources"+fileName);
					item.write(uploadFile);
				}
			}
		}
		dao.insertBook(copy);
		return copy;
	}
}







