package bitedu.bipa.tiles.vo;

import java.sql.Date;

public class BoardVO {
	private int no;
	private String title;
	private String content;
	private String writer;
	private int count;
	private Date date;
	
	@Override
	public String toString() {
		return "boardVO [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer + ", count="
				+ count + ", date=" + date + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}
