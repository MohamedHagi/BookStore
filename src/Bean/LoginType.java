package Bean;

public class LoginType {
	
	private String email;
	private String password;
	private boolean isLocked;
	public LoginType() {
		
	}
	
	public LoginType(String email, String password) {
		this.email = email;
		this.password = password;
		this.isLocked = true;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
}
