package model;

import java.io.Serializable;

import model.dao.DAOFollow;

public class User implements Serializable {
	private String name;
	private String pass;
	private String msg;
	private int id;
	private FollowList follow;
	private FollowList follower;


	public User(int id,String name,String pass) {
		this.name=name;
		this.pass=pass;
		this.id=id;
		DAOFollow daof=new DAOFollow();
		this.follow=daof.findFollow(this);
		this.follower=daof.findFollower(this);
	}
	public void findFF() {

		DAOFollow daof=new DAOFollow();
		this.follow=daof.findFollow(this);
		this.follower=daof.findFollower(this);
	}
	private boolean error=false;

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public User() {
	this.name="error";
	this.error=true;
	}

	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public FollowList getFollow() {
		return follow;
	}

	public void setFollow(FollowList follow) {
		this.follow = follow;
	}

	public FollowList getFollower() {
		return follower;
	}

	public void setFollower(FollowList follower) {
		this.follower = follower;
	}
}
