package mdmUtil.model;

public class User {
	private String userName, password,orsid;



	public String getOrsid() {
		return orsid;
	}

	public void setOrsid(String orsid) {
		this.orsid = orsid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", orsid=" + orsid + "]";
	}

	



}
