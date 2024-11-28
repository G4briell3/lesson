package testData.classes;

import Utils.Reader;

public class Users 
{
	private String userName;
	private String password;
	
	public  Users(String name)
	{
		this.userName=Reader.json(name).get("userName").toString();
		this.password=Reader.json(name).get("password").toString();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
