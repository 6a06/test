package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserList implements Serializable {
	private List<User> ul = new ArrayList<>();

	public UserList() {
	}

	public List<User> getUl() {
		return this.ul;
	}

	public void setUl(List<User> ul) {
		this.ul = ul;
	}

	public void add(User u) {
	//	LoginLogic ll = new LoginLogic(this);
	//	if (ll.checkUser(u)) {
			if(u.isError()) {
				System.out.println("エラーです");
			}else {
			this.ul.add(u);}
		//	return true;
	//	}
	//	return false;
	}

}
