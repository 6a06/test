package model;

import java.util.List;

public class LoginLogic {
	private List<User> ul;

	public User checkLogin(String name, String pass) {
		User u = new User();
		if (name.equals("error")) {
			u.setMsg("その名前は使えません");
			return u;}else {
		for (User y : ul) {
				if (name.equals(y.getName())) {
					if (pass.equals(y.getPass())) {
						return y;
					} else {

						u.setMsg("パスワードが違います");
						return u;
					}
				}

			}
			u.setMsg("その名前は使えません");
			return u;
		}
	}

	public boolean checkName(String u) {
		for (User y : ul) {
			if (u.equals(y.getName())) {
				return true;
			}
		}
		return false;
	}

	public boolean checkUser(User u) {
		nameMatch nm = new nameMatch();
		if (nm.nameMatching(u.getName())) {
			for (User y : ul) {
				if (u.getName().equals(y.getName())) {
					u.setMsg("この名前はもう登録されています<br>");
					return false;
				}
			}
			if (this.checkPass(u)) {
				return true;
			}
			return false;
		}
		u.setMsg("名前を半角英数字で入力してください<br>");
		return false;
	}

	public User getUser(String u) {

		for (User y : ul) {
			if (u.equals(y.getName())) {
				return y;
			}
		}
		return new User();
	}

	public boolean checkPass(User u) {
		nameMatch nm = new nameMatch();
		if (nm.nameMatching(u.getPass())) {
			return true;
		}
		u.setMsg("passを半角英数字で入力してください<br>");
		return false;
	}

	public LoginLogic(UserList ul) {
		this.ul = ul.getUl();
	}

	public User idCheck(int id) {
		for (User u : ul) {
			int i = u.getId();
			if (i == id) {
				return u;
			}
		}
		User e =new User();
		return e;
	}

}
