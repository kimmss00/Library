 package bitedu.bipa.tiles.vo;

public class UserVO {
	private int no;
	private String id;
	private String pwd;



	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "UserVO [no=" + no + ", id=" + id + ", pwd=" + pwd + "]";
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

	public UserVO() {
		
	}	
	
	public UserVO(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}
	
	
	
	
}
