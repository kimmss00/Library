 package bitedu.bipa.tilesKMS.vo;

import java.sql.Date;

public class UserVO {
	private int seq;
	private String id;
	private String pwd;
	private int number;
	private String status;
	private String grade;
	private int max;
	private Date stop;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public Date getStop() {
		return stop;
	}
	public void setStop(Date stop) {
		this.stop = stop;
	}
	@Override
	public String toString() {
		return "UserVO [seq=" + seq + ", id=" + id + ", pwd=" + pwd + ", number=" + number + ", status=" + status
				+ ", grade=" + grade + ", max=" + max + ", stop=" + stop + "]";
	}


	
	
	
}
