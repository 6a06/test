package model;

import java.util.ArrayList;
import java.util.List;

import model.dao.DAOTweet;

public class MutterList {
	private List<Mutter> mL;

	//ビーンズ
	public MutterList() {
		List<Mutter> ll = new ArrayList<>();
		this.mL = ll;
	}

	public MutterList(List<Mutter> l) {
		this.mL = l;
	}

	public List<Mutter> getmL() {
		return mL;
	}

	public void setmL(List<Mutter> mL) {
		this.mL = mL;
	}

	//メソッド
	public boolean add(Mutter m) {
		DAOTweet daot=new DAOTweet();
		boolean check=daot.add(this, m);
		return check;

	}
	public String open() {
		MutterOpen mo=new MutterOpen();
		return mo.mutterOpen(this);

	}
	public String open(User u) {
		MutterOpen mo=new MutterOpen();
		return mo.mutterOpen(this,u);
	}

}
