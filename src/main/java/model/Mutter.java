package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Mutter implements Serializable {
	private String userName;
	private String tweet;
	private String time;
	private int userId;
	private int mutterId;

	public Mutter() {
	}

	public Mutter(String userName,String tweet, String time, int userId, int mutterId) {
		super();
		this.userName=userName;
		this.tweet = tweet;
		this.time = time;
		this.userId = userId;
		this.mutterId = mutterId;
	}

	public Mutter(User user, String tweet) {
		this.tweet = tweet;
		LocalDateTime t = LocalDateTime.now();
		String s = DateFormat.sdf(t);
		this.time = s;
		int i=user.getId();
		this.userId=i;


	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMutterId() {
		return mutterId;
	}

	public void setMutterId(int mutterId) {
		this.mutterId = mutterId;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}


	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


}
