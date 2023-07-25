package bitedu.bipa.tilesKMS.vo;

import java.sql.Date;

public class BoardVO {
	private int seq;
	private String title;
	private String content;
	private String writer;
	private int read_count;
	private Date create_date;
	private String password;
	private String attatch_data;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAttatch_data() {
		return attatch_data;
	}
	public void setAttatch_data(String attatch_data) {
		this.attatch_data = attatch_data;
	}
	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", read_count=" + read_count + ", create_date=" + create_date + ", password=" + password
				+ ", attatch_data=" + attatch_data + "]";
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
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
	public int getRead_count() {
		return read_count;
	}
	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
	
	
	

}
